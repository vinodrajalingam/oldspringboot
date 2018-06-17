package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "emp_detail")
@Component
public class Physician {
		
		@Id
		//@GeneratedValue(strategy=GenerationType.AUTO)
		long id;
		String name;
		String dept;
		
		public long getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public Physician(int id, String name, String dept) {
			super();
			this.id = id;
			this.name = name;
			this.dept = dept;
		}
		public Physician() {
		}
}