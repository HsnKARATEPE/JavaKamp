package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageTechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguageTechnology.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguageTechnology.DeleteProgrammingLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguageTechnology.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguageTechnology.GetAllProgrammingLanguageTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguageTechnology.GetByIdProgrammingLanguageTechnologiesResponse;

@RestController
@RequestMapping("/api/programminglanguagetechnology")
public class ProgrammingLanguageTechnologiesController {
	private ProgrammingLanguageTechnologyService languageTechnologyService;
	
	
	@Autowired
	public ProgrammingLanguageTechnologiesController(ProgrammingLanguageTechnologyService languageTechnologyService) {
		this.languageTechnologyService = languageTechnologyService;
	}

	@GetMapping("/getall")
	public List<GetAllProgrammingLanguageTechnologiesResponse> getAll(){
		return languageTechnologyService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception {
	languageTechnologyService.add(createProgrammingLanguageTechnologyRequest);	
	}
	
	@GetMapping("/getbyid")
	public GetByIdProgrammingLanguageTechnologiesResponse getById(int id) throws Exception {
		return languageTechnologyService.getById(id);
	}
	
	@DeleteMapping("/del")
	public void del(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest) throws Exception {
		languageTechnologyService.del(deleteProgrammingLanguageTechnologyRequest);	
	}
	
	@PutMapping("/update")
	public void update(UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) throws Exception {
		languageTechnologyService.update(updateProgrammingLanguageTechnologyRequest);
	}
	
}
