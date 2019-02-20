package com.cg.ui;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.dto.Department;
import com.cg.dto.Employee;
import com.cg.util.JPAUtil;

public class Main {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntManager();
		EntityTransaction et = em.getTransaction();
		
		Department d1 = new Department();
		d1.setDeptCode(10);
		d1.setDeptName("Admin");
		
		Department d2 = new Department();
		d2.setDeptCode(20);
		d2.setDeptName("Sales");
		
		Employee e1 = new Employee();
		e1.setEmpName("Shubham");
		e1.setEmpId(111);
		e1.setEmpSal(1200);
		e1.setEmpDept(d1);
		
		Employee e2 = new Employee();
		e2.setEmpName("Rahul");
		e2.setEmpId(115);
		e2.setEmpSal(1100);
		e2.setEmpDept(d2);
		
		Employee e3 = new Employee();
		e3.setEmpName("Yanshu");
		e3.setEmpId(118);
		e3.setEmpSal(1300);
		e3.setEmpDept(d1);
		
		Employee e4 = new Employee();
		e4.setEmpName("Birju");
		e4.setEmpId(120);
		e4.setEmpSal(1200);
		e4.setEmpDept(d2);
		
		HashSet<Employee> adminEmpSet = new HashSet<>();
		adminEmpSet.add(e1);
		adminEmpSet.add(e3);

		HashSet<Employee> sellsEmpSet = new HashSet<>();
		sellsEmpSet.add(e2);
		sellsEmpSet.add(e4);
		
		d1.setEmpSet(adminEmpSet);
		d2.setEmpSet(sellsEmpSet);
		et.begin();
		em.persist(d1);
		em.persist(d2);
//		em.persist(e3);
//		em.persist(e4);
		et.commit();
		
		System.out.println("Inserted...\n");

		System.out.println("-------------Fetch------------");
	}

}
