package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	private ProgrammingLanguageRepository languageRepository;
	
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return languageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		return languageRepository.getById(id);
	}
	

	@Override
	public void add(ProgrammingLanguage addLanguage) throws Exception {
		if(addLanguage.getName()!=null) {	
			List<ProgrammingLanguage> languages=languageRepository.getAll();
			for(ProgrammingLanguage Language:languages) {
				if(addLanguage.getName().equals(Language.getName())) {
					throw new Exception("Programlama Dili Mevcut");
					
				}
			}
			languageRepository.add(addLanguage);
			
		}else {
			throw new Exception("Programlama İsmi Boş Brakılamaz");
			
		}

		
	}

	@Override
	public void del(int id) {
		languageRepository.del(id);
		
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		languageRepository.update(programmingLanguage);
		
		
	}

}
