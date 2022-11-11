package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;


public interface ProgrammingLanguageService {
	
	List<GetAllProgrammingLanguagesResponse> getAll();
	
	GetByIdProgrammingLanguageResponse getById(int id) throws Exception;	
	
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;

	void del(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception;	

	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
	

}
