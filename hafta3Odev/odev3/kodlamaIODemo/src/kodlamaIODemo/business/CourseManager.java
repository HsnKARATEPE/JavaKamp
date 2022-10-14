package kodlamaIODemo.business;

import java.util.ArrayList;
import java.util.List;

import kodlamaIODemo.core.logging.ILogger;
import kodlamaIODemo.dataAccess.ICourseDao;
import kodlamaIODemo.dataAccess.JdbcCourseDao;
import kodlamaIODemo.entities.Course;

public class CourseManager {
	
	private ICourseDao courseDao;
	private ILogger[] loggers;

	
	
	
	public CourseManager(ICourseDao courseDao,ILogger[] loggers) {
		this.courseDao=courseDao;
		this.loggers=loggers;
		
	}
	
	public void add(Course course) throws Exception {
		
		if(course.getPrice()<0) {
			throw new Exception("Kursun Fiyatı 0'dan küçük olamaz");
			
		}
		
		if(false) {
			throw new Exception("Aynı isimde iki tane kurs olamaz");
		}

		courseDao.add(course);
		
		for(ILogger logger:loggers) {
			logger.log(course.getName());
		}
	}
}
