package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Course {
	private String code;
	private String name;
	private Integer credits;
}
