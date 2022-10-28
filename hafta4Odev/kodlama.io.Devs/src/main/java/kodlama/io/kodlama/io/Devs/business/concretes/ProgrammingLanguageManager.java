package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service// 
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired//Constructor de belirtilen (ProgrammingLanguageRepository)
	//interface sini implement eden classların new'lenmiş halini oluşturur.
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {

		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguageRepository.getAll();
		
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		return programmingLanguageRepository.getById(id);
		
	}
	@Override
	public void add(ProgrammingLanguage programingLanguage) throws Exception {
		if(programingLanguage.getName().isEmpty()) {
			throw new Exception("Programlama dili boş geçilemez");
		}else {
			for(ProgrammingLanguage language:programmingLanguageRepository.getAll()) {
				if(language.getName().equals(programingLanguage.getName())) {
					throw new Exception("Aynı isimde programmlama dili mevcut");
				}
			}
			programmingLanguageRepository.add(programingLanguage);	
		}
	}
	@Override
	public void del(int id) {
		programmingLanguageRepository.del(id);
	}
	@Override
	public void update(ProgrammingLanguage programingLanguage) throws Exception {
		for(ProgrammingLanguage language:programmingLanguageRepository.getAll()) {
			if(language.getName().equals(programingLanguage.getName())) {
				throw new Exception("Aynı isimde programmlama dili mevcut");
			}
		}
		programmingLanguageRepository.update(programingLanguage);
		
	}
	

}
