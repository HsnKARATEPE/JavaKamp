package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("api/programminglanguages")

public class ProgrammingLanguagesController {
	private ProgrammingLanguageService languageService;

	@Autowired 
	public ProgrammingLanguagesController(ProgrammingLanguageService languageService) {
		this.languageService = languageService;
	}
	
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(int id) {
		return languageService.getById(id);
	}
	
	@GetMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		languageService.add(programmingLanguage);
	}
	
	@GetMapping("/del")
	public void del(int id) {
		languageService.del(id);
	}
	
	@GetMapping("/update")
	public void update(ProgrammingLanguage programmingLanguage) {
		languageService.update(programmingLanguage);
	}
	
	
	

}
