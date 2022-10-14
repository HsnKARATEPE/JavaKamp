package kodlamaIODemo;

import kodlamaIODemo.business.CategoryManager;
import kodlamaIODemo.business.CourseManager;
import kodlamaIODemo.business.InstructorManager;
import kodlamaIODemo.core.logging.DatabaseLogger;
import kodlamaIODemo.core.logging.EmailLogger;
import kodlamaIODemo.core.logging.FileLogger;
import kodlamaIODemo.core.logging.ILogger;
import kodlamaIODemo.dataAccess.HibernateInstructorDao;
import kodlamaIODemo.dataAccess.JdbcCategoryDao;
import kodlamaIODemo.dataAccess.JdbcCourseDao;
import kodlamaIODemo.entities.Category;
import kodlamaIODemo.entities.Course;
import kodlamaIODemo.entities.Instructor;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		Category category1=new Category(1,"Kodlama");
		
		CategoryManager categoryManager=new CategoryManager
				(new JdbcCategoryDao(),new ILogger[]
						{new DatabaseLogger(),new FileLogger(),new EmailLogger()});
					
		categoryManager.add(category1);
		
		
		
		Course course1=new Course(1,"Java",1000);
		
		CourseManager courseManager=new CourseManager(new JdbcCourseDao(),new ILogger[]
				{new DatabaseLogger(),new FileLogger(),new EmailLogger()});

		courseManager.add(course1);
		
		
		
		
		Instructor instructor1=new Instructor(1,"Engin DEMİROĞ");
		
		
		InstructorManager instructorManager=new InstructorManager(new HibernateInstructorDao(),new ILogger[]
				{new DatabaseLogger(),new FileLogger(),new EmailLogger()});
		instructorManager.add(instructor1);
		
		
		

	}

}
