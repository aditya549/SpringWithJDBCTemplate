package com.java.spring;

import java.util.List;

public interface EmpDAO1 {
	public void insert(Employee e);
	public void update(Employee e);
	public void delete(Employee e);
	public List<Employee> fetch();
	
}
