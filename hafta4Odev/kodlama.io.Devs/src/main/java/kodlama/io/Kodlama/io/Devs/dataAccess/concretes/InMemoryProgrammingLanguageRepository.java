package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{
	List<ProgrammingLanguage> programmingLanguages;
	
	

	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages=new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1, "Java"));
		programmingLanguages.add(new ProgrammingLanguage(2, "Python"));
		programmingLanguages.add(new ProgrammingLanguage(3, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(4, "Sql"));
		programmingLanguages.add(new ProgrammingLanguage(5, "Ruby"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		// TODO Auto-generated method stub
		return programmingLanguages;
	}
	
	@Override
	public ProgrammingLanguage getById(int id) {
		for(ProgrammingLanguage language:programmingLanguages) {
			if(language.getId()==id) {
				return language;
			}
		}
		return null;
	}


	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);		
	}

	@Override
	public void del(int id) {
		ProgrammingLanguage delLanguage=getById(id);
		programmingLanguages.remove(delLanguage);	
	}


	@Override
	public void update(ProgrammingLanguage updateLanguage) {
		for(ProgrammingLanguage programmingLanguage:programmingLanguages) {
			if(programmingLanguage.getId()==updateLanguage.getId()) {
				programmingLanguage.setName(updateLanguage.getName());
			}
		}	
	}
	
	
	
}
