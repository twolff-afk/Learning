package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import firstJavaSpring.StudentBean;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml"); 
		StudentBean studentBean = (StudentBean) applicationContext.getBean("studentbean"); 
		studentBean.displayInfo(); 
		
	}
	
}