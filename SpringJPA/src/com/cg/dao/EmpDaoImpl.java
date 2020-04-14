package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Emp;

@Repository("mydao")
@Transactional
public class EmpDaoImpl implements IEmpDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean addEmp(Emp emp) {
		em.persist(emp);
		return true;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean editEmp(Emp emp) {
		em.merge(emp);
		return true;
	}

	@Override
	public boolean deleteEmp(int eid) {
		Emp emp = em.find(Emp.class, eid);
		if (emp == null)
			return false;
		em.remove(emp);
		return true; 
	}

	@Override
	@Transactional(readOnly = true)
	public Emp viewEmp(int eid) {
		return em.find(Emp.class, eid);
	}

	@Override
	public List<Emp> viewEmps(String dept) {
		String jpql = "from Emp where empDept=:dname";
		TypedQuery<Emp> qry = em.createQuery(jpql, Emp.class);
		qry.setParameter("dname", dept);
		return qry.getResultList();
	}

}
