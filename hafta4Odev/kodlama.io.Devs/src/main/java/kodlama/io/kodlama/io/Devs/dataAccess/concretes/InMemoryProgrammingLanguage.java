package kodlama.io.kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguage implements ProgrammingLanguageRepository{
	
	List<ProgrammingLanguage> programmingLanguagesList;
	
	
	public InMemoryProgrammingLanguage() {
		programmingLanguagesList=new ArrayList<ProgrammingLanguage>();//Boş liste
		programmingLanguagesList.add(new ProgrammingLanguage(1, "Python"));
		programmingLanguagesList.add(new ProgrammingLanguage(2, "Java"));
		programmingLanguagesList.add(new ProgrammingLanguage(3, "C#"));
		programmingLanguagesList.add(new ProgrammingLanguage(4, "Java Script"));
				
		
	}


	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguagesList;
	}


	@Override
	public ProgrammingLanguage getById(int id) {
		for(ProgrammingLanguage language:programmingLanguagesList) {
			if (language.getId()==id) {
				return language;
			}
		}
		return null;
	}
	


	@Override
	public void add(ProgrammingLanguage programmingLanguage){

		programmingLanguagesList.add(new ProgrammingLanguage(
				programmingLanguage.getId(),programmingLanguage.getName()));		
	}


	@Override
	public void del(int id) {
		programmingLanguagesList.remove(id);
		
	}


	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage language:programmingLanguagesList) {
			if(language.getId()==programmingLanguage.getId()) {
				language.setName(programmingLanguage.getName());
			}
		}
		
	}
}
