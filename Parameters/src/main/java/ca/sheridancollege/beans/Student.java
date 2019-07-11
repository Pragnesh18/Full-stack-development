package ca.sheridancollege.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class Student {
	private int id;
	private String name;
		public Student(String name) {
		super();
		this.name = name;
	}
		
		
		
		
		// TODO Auto-generated constructor stub
	}

