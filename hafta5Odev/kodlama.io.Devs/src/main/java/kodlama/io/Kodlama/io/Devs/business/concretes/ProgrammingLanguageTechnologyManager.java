package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageTechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguageTechnology.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguageTechnology.DeleteProgrammingLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguageTechnology.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguageTechnology.GetAllProgrammingLanguageTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguageTechnology.GetByIdProgrammingLanguageTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguageTechnology;
import lombok.NoArgsConstructor;

@Service
public class ProgrammingLanguageTechnologyManager implements ProgrammingLanguageTechnologyService{
	private ProgrammingLanguageTechnologyRepository languageTechnologyRepository;
	
	
	
	public ProgrammingLanguageTechnologyManager(ProgrammingLanguageTechnologyRepository languageTechnologyRepository) {
		this.languageTechnologyRepository = languageTechnologyRepository;
	}


	@Override
	public List<GetAllProgrammingLanguageTechnologiesResponse> getAll() {
		List<ProgrammingLanguageTechnology> languageTechnologies=languageTechnologyRepository.findAll();
		List<GetAllProgrammingLanguageTechnologiesResponse> languageTechnologiesResponses=
				new ArrayList<GetAllProgrammingLanguageTechnologiesResponse>();
		
		for(ProgrammingLanguageTechnology languageTechnology:languageTechnologies) {
			GetAllProgrammingLanguageTechnologiesResponse technologiesResponseItem=
					new GetAllProgrammingLanguageTechnologiesResponse();
			
			technologiesResponseItem.setId(languageTechnology.getId());
			technologiesResponseItem.setName(languageTechnology.getName());
			languageTechnologiesResponses.add(technologiesResponseItem);			
		}
		return languageTechnologiesResponses;
	}

	
	@Override
	public void add(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception {
		if(createProgrammingLanguageTechnologyRequest.getName()!=null) {
			
			if(isNameExist(createProgrammingLanguageTechnologyRequest.getName())) {
				throw new Exception("Aynı isimde teknoloji ismi mevcut");				
			}

			ProgrammingLanguageTechnology languageTechnologyItem=new ProgrammingLanguageTechnology();
			languageTechnologyItem.setName(createProgrammingLanguageTechnologyRequest.getName());
			languageTechnologyRepository.save(languageTechnologyItem);			
		}		
	}
	
	@Override
	public void del(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest) throws Exception {
		if(isIdExist(deleteProgrammingLanguageTechnologyRequest.getId())) {
			ProgrammingLanguageTechnology languageTechnology=languageTechnologyRepository.
					findById(deleteProgrammingLanguageTechnologyRequest.getId()).get();
					
			languageTechnologyRepository.delete(languageTechnology);
		}else {
			throw new Exception("Id Bulunamadı.");				
		}	
	}	
	
	@Override
	public void update(UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) throws Exception {
		if(updateProgrammingLanguageTechnologyRequest.getName()!=null) {
			
			if(isNameExist(updateProgrammingLanguageTechnologyRequest.getName())) {
				throw new Exception("Aynı isimde teknoloji ismi mevcut");				
			}
			
			if(isIdExist(updateProgrammingLanguageTechnologyRequest.getId())) {

				ProgrammingLanguageTechnology programminglanguageTechnology=languageTechnologyRepository.
						findById(updateProgrammingLanguageTechnologyRequest.getId()).get();
				
				programminglanguageTechnology.setId(updateProgrammingLanguageTechnologyRequest.getId());
				programminglanguageTechnology.setName(updateProgrammingLanguageTechnologyRequest.getName());
				languageTechnologyRepository.save(programminglanguageTechnology);
			}else {
				throw new Exception("Aynı id ile programlama teknolojisi kayıtlı");				
				
			}

		}	
	}
	
	@Override
	public GetByIdProgrammingLanguageTechnologiesResponse getById(int id) throws Exception {	
		if (isIdExist(id)) {
			ProgrammingLanguageTechnology languageTechnology=languageTechnologyRepository.findById(id).get();
			GetByIdProgrammingLanguageTechnologiesResponse languageTechnologiesResponse=new GetByIdProgrammingLanguageTechnologiesResponse();
			languageTechnologiesResponse.setName(languageTechnology.getName());
			return languageTechnologiesResponse;
			
		}else {
			throw new Exception("Id mevcut değil");			
		}
	}






	private boolean isIdExist(int id) {
		for(ProgrammingLanguageTechnology languageTechnology:languageTechnologyRepository.findAll()) {
			if(languageTechnology.getId()==id) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNameExist(String name) {
		for(ProgrammingLanguageTechnology languageTechnology:languageTechnologyRepository.findAll()) {
			if(languageTechnology.getName()==name) {
				return true;
			}
		}
		return false;	
	}

	
	
}
