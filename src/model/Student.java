package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(exclude={"name", "courseName"})
public @Data class Student {
	private String dre;
	private String name;
	private String courseName;
	
	
}
