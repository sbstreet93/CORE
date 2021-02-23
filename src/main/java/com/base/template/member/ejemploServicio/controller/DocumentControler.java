package com.base.template.member.ejemploServicio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.base.template.member.ejemploServicio.model.Document;
import com.base.template.member.ejemploServicio.model.DocumentType;
import com.base.template.member.ejemploServicio.model.User;
import com.base.template.member.ejemploServicio.service.IDocumentService;
import com.base.template.member.ejemploServicio.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/document")
@SessionAttributes({ "document" })
public class DocumentControler {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private IDocumentService documentService;

	@Autowired
	private IUserService userService;

	@Autowired
	private DocumentEditor documentEditor;
	
	@Autowired
	private S3BucketClient bucket;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(DocumentType.class, "documentType", documentEditor);
	}

	@RequestMapping({ "/list", "/", "" })
	public String list(Model model) {
		model.addAttribute("documents", documentService.findAllWithUser());
		return "document/list";
	}

	@ModelAttribute("documentTypes")
	public List<DocumentType> documentTypes() {
		return documentService.findAllDocumentTypes();
	}

	@GetMapping(value = "/list-documents", produces = { "application/json" })
	public @ResponseBody List<Document> loadRegions() {
		return documentService.findAllWithUser();
	}

	@GetMapping(value = "/user-by-rut/{rut}", produces = { "application/json" })
	public @ResponseBody
	User getUserByRut(@PathVariable String rut) {
		return userService.findByRut(rut);
	}

	@GetMapping("/form")
	public String form(Model model) {
		Document document = new Document();
		model.addAttribute("document", document);
		return "document/form";
	}

	@PostMapping("/form")
	public String save(Document document, BindingResult result, Model model, @RequestParam String rut,
			@RequestPart("file") MultipartFile documentFile, RedirectAttributes flash, SessionStatus status) {

		log.info("Validar rut");
		if (!Utils.rutValid(rut)) {
			flash.addFlashAttribute("errorRut", "El RUT no es valido");
			return "redirect:/document/form";
		}

		log.info("validar Usuario");
		User user = userService.findByRut(rut);
		if (user == null) {
			flash.addFlashAttribute("errorRut", "El usuario no existe.");
			return "redirect:/document/form";
		}

		log.info("validar objecto");
		if (result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				log.info(err.getField() + " - " + err.getDefaultMessage());
			});

			return "document/form";
		}

		log.info("validar version");
		document.setVersion(
				documentService.findByDocumentTypeByUserId(document.getDocumentType().getId(), user.getId()));

		log.info("validar archivo");
		if (!documentFile.isEmpty()) {
			try {
				document.setState(0);
				// subo archivo
				String pathS3 = bucket.uploadSingleFile(documentFile.getResource());
				document.setFilePath(pathS3);
			} catch (Exception e) {
				log.error(e.getMessage(),e);
			}
		} else {
			document.setState(1);
		}

		document.setUser(user);
		documentService.save(document);
		status.setComplete();

		return "redirect:/document/list";
	}
	
	

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes flash) {
		Document doc = documentService.findById(id);
		if (doc == null) {
			flash.addFlashAttribute("error", "El Documento no existe.");
			return "redirect:/document/list";
		}
		bucket.deleteFile(doc.getFilePath());
		documentService.delete(id);
		flash.addFlashAttribute("success", "Documento eliminado.");

		return "redirect:/document/list";
	}
}
