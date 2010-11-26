package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Class {
	private String code;
	private Course course;
	private String academicTerm;
}
