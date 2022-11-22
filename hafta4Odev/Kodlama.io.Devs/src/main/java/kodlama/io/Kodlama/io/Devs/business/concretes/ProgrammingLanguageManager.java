package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
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
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		if(programmingLanguage.getName()!=null) {
			for(ProgrammingLanguage language:programmingLanguageRepository.getAll()) {
				if(language.getName()==programmingLanguage.getName()) {
					throw new Exception("Programlama Dili Mevcut");
				}
			}
			programmingLanguageRepository.add(programmingLanguage);
		}else {
			throw new Exception("Programlama Dili Adı Boş Geçilemez");
		}
	}

	@Override
	public void delete(int id) throws Exception {
		if(isIdExist(id)) {
			programmingLanguageRepository.delete(id);
		}else {
			throw new Exception("Böyle bir id numarası yok");
		}
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		if(isIdExist(programmingLanguage.getId())) {
			if(isNameExist(programmingLanguage)) {
				throw new Exception("Programlama Dili Mevcut");
			}else {
				programmingLanguageRepository.update(programmingLanguage);
			}
		}else {
			throw new Exception("Böyle bir id numarası yok");			
		}		
	}
	
	
	private boolean isIdExist(int id) {
		for(ProgrammingLanguage language:programmingLanguageRepository.getAll()) {
			if(language.getId()==id) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNameExist(ProgrammingLanguage programmingLanguage) {
		for(ProgrammingLanguage language:programmingLanguageRepository.getAll()) {
			if(language.getName()==programmingLanguage.getName()) {
				return true;
			}
		}
		return false;
	}

}
