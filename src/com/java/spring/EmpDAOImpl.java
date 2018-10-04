package com.java.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmpDAOImpl implements EmpDAO1 {

	private JdbcTemplate jdbctemplate;
	
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public void insert(Employee e) {
		
		String username=e.getUsername();
		String password=e.getPassword();
		int id=e.getId();
		String query="insert into springjdbc values(?,?,?)";
		System.out.println("insert query working");
		
		System.out.println("object working");
		int i=jdbctemplate.update(query,new Object[] {username,password,id});
		System.out.println("update working");
		if(i==1) {
			System.out.println("Record Inserted Successfully");
		}else
			System.out.println("Record Not Inserted Successfully");
	}

	@Override
	public void update(Employee e) {

		String query="update springjdbc set password=? where username=?";
		int i=jdbctemplate.update(query, new Object[] {e.getPassword(),e.getUsername()});
		if(i==1) {
			System.out.println("Record Updated Successfully");
		}else
			System.out.println("Record NOt Updated");
		
	}

	@Override
	public void delete(Employee e) {
		String query="delete from springjdbc where username=?";
		int i=jdbctemplate.update(query, new Object[] {e.getUsername()});
		if(i==1) {
			System.out.println("Record Deleted Successfully");
		}else
			System.out.println("Record NOt Deleted Updated");
	}

	@Override
	public List<Employee> fetch() {
		String query1="select * from springjdbc";
		ResultSetExtractor<List<Employee>> rse=new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> ls=new ArrayList<>();
				while(rs.next()) {
					Employee e=new Employee();
					e.setUsername(rs.getString("username"));
					e.setPassword(rs.getString("password"));
					e.setId(rs.getInt("id"));
					ls.add(e);
					
				}
				return ls;
			}			
		};
		List<Employee> ls=jdbctemplate.query(query1, rse);
		System.out.println(ls);
		return ls;
	}
	public Employee fetchsinglerecord(Employee e) {
		String query="select * from springjdbc where username=?";
		ResultSetExtractor<Employee> rse=new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				Employee emp=new Employee();
				while(rs.next()) {
					emp.setId(rs.getInt("id"));
					emp.setUsername(rs.getString("username"));
					emp.setPassword(rs.getString("password"));
				}
				return emp;
				
				/*Employee emp=new Employee();
				System.out.println("testing");
				System.out.println(rs.next());
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				String name=rs.getString(1);
				emp.setUsername(name);
				return emp;*/
			}
			
		};
		return jdbctemplate.query(query, new Object[] {e.getUsername()}, rse);
	}
}
