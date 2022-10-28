package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	void add(ProgrammingLanguage programingLanguage) throws Exception;
	void del(int id);
	void update(ProgrammingLanguage programingLanguage) throws Exception;


}
