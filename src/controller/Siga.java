package controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import lombok.Data;
import lombok.Getter;
import model.Student;

public @Data class Siga {
	
	private Map<String, Student> students = new HashMap<String, Student>();
	
	private static Siga instance;
	private @Getter String term;
	
	
	public static Siga getInstance() {
		if(instance == null)
			return new Siga();
		else
			return instance;
	}
	
	private Siga(){
		Integer semester = Calendar.getInstance().get(Calendar.MONTH) > 6 ? 2 : 1;
		String academicTerm = Calendar.getInstance().get(Calendar.YEAR)+"-"+semester;
	
		this.term = academicTerm;
	}

	public void createStudent(String name, String courseName) {
		Student student = new Student(generateDre(), name, courseName);
		students.put(student.getDre(), student);
	}

	private String generateDre() {
		return "110100001";
	}

	public Student getStudent(String dre) {
		return students.get(dre);
	}
	
	public void setTerm(String term) throws WrongTermFormat{
		String regex = "\\d\\d\\d\\d-(1|2)";
		if (!Pattern.matches(regex, term)) {
			throw new WrongTermFormat();
		}
		this.term = term;
	}
	
}
