package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Student {
	private String dre;
	private String name;
	private String courseName;
}
