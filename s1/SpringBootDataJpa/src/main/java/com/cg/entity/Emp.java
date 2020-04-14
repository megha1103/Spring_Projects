package com.cg.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "lpu_emp")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Emp {
	
	@Id
	@Column(name = "eid")
	private int empId;
	
	@Column(name = "ename" , length = 25)
	private String empName;
	
	@Column(name = "emp_sal")
	private double empSal;
		
	
	@ManyToOne
	@JoinColumn(name = "dept_id", referencedColumnName = "did")
	private Dept dept = new Dept();
	
	@DateTimeFormat(pattern="yyyy-M-d")
	private LocalDate doj;
	
	@Transient // this field is used to display the date in d-MMM-yyyy format
	private String strDoj;
	
	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		/*System.out.println("DOJ " + strdoj);
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy-M-d");
		doj = LocalDate.parse(strdoj, dtFormatter);*/
		this.doj=doj;
	}
	
	public String getStrDoj() {
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		this.strDoj = doj.format(dtFormatter);
		return this.strDoj;
	}
	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public Dept getDept() {
		return dept;
	}
	
	public void setEmpId(int empId) {
		System.out.println("EmpID " + empId);
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		System.out.println("EmpNAme " + empName);
		this.empName = empName;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

			
	@Override
	public String toString() {
		return empId + " " + empName + " " + empSal + " " + dept + " " + doj;
	}
	
	
	
	
}
