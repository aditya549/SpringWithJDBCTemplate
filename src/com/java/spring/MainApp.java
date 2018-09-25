package com.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("resources/spring.xml");
		EmpDAOImpl emp=(EmpDAOImpl)context.getBean("empdaoimp");
		/*//For Insert
		Employee e=new Employee();
		e.setUsername("cubic");
		e.setPassword("cubic1234");
		e.setId(1220);
		emp.insert(e);*/
		
		/*//For Update
		Employee e=new Employee();
		e.setUsername("cubic");
		e.setPassword("12345cubic");
		emp.update(e);*/
		
		/*//For Delete
		Employee e=new Employee();
		e.setUsername("cubic");
		emp.delete(e);*/
		
		/*//for select
		emp.fetch();*/
		
		Employee e=new Employee();
		e.setUsername("AAAAAAA");
		Employee efetch=emp.fetchsinglerecord(e);
		System.out.println(efetch);
		
	}
}
