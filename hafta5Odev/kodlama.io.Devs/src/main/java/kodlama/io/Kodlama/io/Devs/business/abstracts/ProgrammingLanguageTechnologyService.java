package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguageTechnology.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguageTechnology.DeleteProgrammingLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguageTechnology.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguageTechnology.GetAllProgrammingLanguageTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguageTechnology.GetByIdProgrammingLanguageTechnologiesResponse;

public interface ProgrammingLanguageTechnologyService {
	
	List<GetAllProgrammingLanguageTechnologiesResponse> getAll();
	
	GetByIdProgrammingLanguageTechnologiesResponse getById(int id) throws Exception;
	
	void add(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception;
	
	void del(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest) throws Exception;
	
	void update(UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) throws Exception;
	
	
}
