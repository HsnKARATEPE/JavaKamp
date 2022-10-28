package kodlama.io.kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController//annotation bilgilendirme Bu sınıfın erişim noktası olduğunu berlirtir.
@RequestMapping("/api/programinglanguage")//kontrolee nasıl ulaşılacağını tanımlıyor.
//tarayıcıdaki adresin sonunda /api/programinglanguage dersek bu kontrolörü kastediyor demektir.
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	
	@Autowired//Constructor de belirtilen (ProgrammingLanguageService)
	//interface sini implement eden classların new'lenmiş halini oluşturur.
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {

		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(int id) {	
		return programmingLanguageService.getById(id);
		
	}	
	@GetMapping("/add")
	public void add(ProgrammingLanguage programingLanguage) throws Exception {
		programmingLanguageService.add(programingLanguage);
		
	}
	@GetMapping("/del")
	public void del(int id) {
		programmingLanguageService.del(id);
	}
	
	@GetMapping("/update")
	public void update(ProgrammingLanguage programingLanguage) throws Exception {
		programmingLanguageService.update(programingLanguage);
	}
}
