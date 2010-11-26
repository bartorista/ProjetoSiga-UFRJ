package controller;

import java.util.Calendar;

import junit.framework.Assert;

import model.Student;

import org.junit.Test;


public class SigaTest extends Assert {
	
	Integer year = Calendar.getInstance().get(Calendar.YEAR)%100;
	Integer semester = Calendar.getInstance().get(Calendar.MONTH) > 6 ? 2 : 1;
	
	@Test
	public void createSigaWithTerm(){
		String academicTerm = Calendar.getInstance().get(Calendar.YEAR)+"-"+semester;
		
		Siga siga = Siga.getInstance();
		assertEquals(academicTerm, siga.getTerm());
		
	}
	
	@Test
	public void setTerm(){
		Siga siga = Siga.getInstance();
		try {
			siga.setTerm("20"+year+"-1");
			assertTrue(true);
		} catch (WrongTermFormat e) {
			assertTrue(false);
		}
	}
	
	
	@Test
	public void setTermWithWrongFormat(){
		Siga siga = Siga.getInstance();
		try {
			siga.setTerm(year+"-1");
			assertTrue("A exception was expected", false);
		} catch (WrongTermFormat e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void generatedDre() {
		Student student = new Student("1"+year+semester+"00001","Victor Lima Campos", "Ciencia da Computação");
		Siga siga = Siga.getInstance();
		siga.registerStudent("Victor Lima Campos", "Ciencia da Computação");
		assertEquals(student, siga.getStudent("1"+year+semester+"00001"));
	}
	
	@Test
	public void generatedTwoDres() throws WrongTermFormat {
		Student student = new Student("1"+year+semester+"00001","Victor Lima Campos", "Ciencia da Computação");
		Student student2 = new Student("1"+year+semester+"00002","Victor Lima Campos", "Ciencia da Computação");
		Siga siga = Siga.getInstance();
		siga.registerStudent("Victor Lima Campos", "Ciencia da Computação");
		siga.registerStudent("Júlio", "Ciencia da Computação");
		assertEquals(student, siga.getStudent("1"+year+semester+"00001"));
		assertEquals(student2, siga.getStudent("1"+year+semester+"00002"));
	}	
}
