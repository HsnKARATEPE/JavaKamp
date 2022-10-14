package kodlamaIODemo.business;

import kodlamaIODemo.core.logging.ILogger;
import kodlamaIODemo.dataAccess.HibernateCategoryDao;
import kodlamaIODemo.dataAccess.ICategoryDao;
import kodlamaIODemo.dataAccess.JdbcCategoryDao;
import kodlamaIODemo.entities.Category;

public class CategoryManager {
	
	private ICategoryDao categoryDao;
	private ILogger[] loggers;
	
	
	public CategoryManager(ICategoryDao categoryDao,ILogger[] loggers) {
		this.categoryDao=categoryDao;
		this.loggers=loggers;
	}
	
	
	public void add(Category category) throws Exception {	
		if(false) {
			throw new Exception("Aynı isimde ikitane kategori olamaz");
		}
		categoryDao.add(category);
		
		for (ILogger logger:loggers) {
			logger.log(category.getName());
		}
	}

}
