package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service

public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	private ProgrammingLanguageRepository languageRepository;
	

	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}


	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> languages=languageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponses=
				new ArrayList<GetAllProgrammingLanguagesResponse>();
		
		for(ProgrammingLanguage language:languages) {
			GetAllProgrammingLanguagesResponse responseItem=
					new GetAllProgrammingLanguagesResponse();
			
			responseItem.setName(language.getName());
			responseItem.setId(language.getId());
			programmingLanguagesResponses.add(responseItem);
			
		}		
		return programmingLanguagesResponses;
	}
	
	
	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		if(createProgrammingLanguageRequest.getName()!=null) {	
			if(isNameExist(createProgrammingLanguageRequest.getName())) {
				throw new Exception("Programlama Dili Mevcut");					
			}

			ProgrammingLanguage programmingLanguage=new ProgrammingLanguage();
			programmingLanguage.setName(createProgrammingLanguageRequest.getName());
			languageRepository.save(programmingLanguage);			
			
		}else {
			throw new Exception("Programlama İsmi Boş Brakılamaz");			
		}		
	}
		

	
	@Override
	public void del(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception {
		if(isIdExist(deleteProgrammingLanguageRequest.getId())) {		
			ProgrammingLanguage language=languageRepository.
					findById(deleteProgrammingLanguageRequest.getId()).get();		
			
			languageRepository.delete(language);
		}else {
			throw new Exception("Id Bulunamadı.");					
		}
	}
	

	
	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		if(updateProgrammingLanguageRequest.getName()!=null) {
			
			if(isNameExist(updateProgrammingLanguageRequest.getName())) {
				throw new Exception("Progrmlama dili mevcut");				
			}
			
			if(isIdExist(updateProgrammingLanguageRequest.getId())) {
				
				ProgrammingLanguage programmingLanguage=languageRepository.
						findById(updateProgrammingLanguageRequest.getId()).get();
				
				programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
				programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
				languageRepository.save(programmingLanguage);
			}else {
				throw new Exception("Aynı id ile programlama dili mevcut");								
			}
		
		}		
	}

	
		@Override
		public GetByIdProgrammingLanguageResponse getById(int id) throws Exception {
			if(isIdExist(id)) {				
				ProgrammingLanguage language=languageRepository.findById(id).get();
				
				GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse=new GetByIdProgrammingLanguageResponse();
				getByIdProgrammingLanguageResponse.setName(language.getName());
				return getByIdProgrammingLanguageResponse;		
			}else {
				throw new Exception("Böyle bir id numarası bulunamadı");						
			}
		}

		private boolean isIdExist(int id) {
			for(ProgrammingLanguage language:languageRepository.findAll()) {
				if(id==language.getId()) {
					return true;
				}
			}
			return false;
		}
		
		private boolean isNameExist(String name) {
			for(ProgrammingLanguage language:languageRepository.findAll()) {
				if(language.getName()==name) {
					return true;
				}
			}
			return false;
		}


}
