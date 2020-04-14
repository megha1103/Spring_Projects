package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.IDeptDao;
import com.cg.dao.IEmpDao;
import com.cg.entity.Dept;
import com.cg.entity.Emp;
import com.cg.exceptions.EmpIdException;
import com.cg.exceptions.EmpNotFoundException;

@RestController
public class EmpRestController {

	@Autowired
	private IEmpDao dao;
    
	@Autowired
	private IDeptDao deptDao;
	
	@CrossOrigin(origins= {"http://localhost:4200"})
	@GetMapping(value="/viewbyid/{empid}")
	public Emp getEmployeeById(@PathVariable("empid") int eid) throws EmpNotFoundException {
		Emp emp = dao.findById(eid).get();
		if (emp == null)
			throw new EmpNotFoundException();
		return emp;
	}
	
	@CrossOrigin(origins= {"http://localhost:4200"})
	@GetMapping("/viewall")
	public List<Emp> getAllEmployee() {
		//return dao.findAll();//generate extra queries
		return dao.viewEmp();
	}
	
	@CrossOrigin
	@GetMapping("/viewbydept/{dept}")
	public List<Emp> getEmployeeByDept(@PathVariable("dept") String dept) {
		return dao.viewEmp(dept);
	}
	
	@CrossOrigin
	@GetMapping("/viewdepts")
	public List<Dept> getDepartments(){
		return deptDao.findAll();
	} 
	
	@CrossOrigin()
	@PostMapping("/add")
	public String addEmployee(@RequestBody Emp emp) throws EmpIdException {
		try {
			dao.save(emp);
			return "Successfully Added";
		} catch (DataIntegrityViolationException ex) {
			ex.printStackTrace();
			throw new EmpIdException();
		}
	}
	
	@CrossOrigin
	@PutMapping(value="/edit")
	public String EditEmployee(@RequestBody Emp emp) throws EmpIdException {
		dao.save(emp);
		return "Successfully Edited";
	}
	
    @CrossOrigin
	@DeleteMapping("/remove/{empid}")
	public String removeEmployee(@PathVariable("empid") int eid) throws EmpIdException {
		dao.deleteById(eid);
		return "Successfully Removed";
	}
    
   
   
}






