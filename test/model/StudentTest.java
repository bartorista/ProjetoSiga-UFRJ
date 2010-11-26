package model;

import java.sql.Date;
import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

import controller.DreFormatError;


public class StudentTest extends Assert{
	Calendar calendar = Calendar.getInstance();
	Integer year = calendar.get(Calendar.YEAR)%100;
	
	@Test
	public void testGetName(){
		Student student = new Student();
		student.setName("Victor Lima Campos");	
		assertEquals("O nome do aluno é: Victor Lima Campos", student.getName());
	}
	
	@Test
	public void dreHasNineDigits() throws DreFormatError{
		Student student = new Student("1"+year+"456789");
		assertEquals(9, student.getDre().length());		
	}
	
	@Test(expected = DreFormatError.class)
	public void dreDoesNotHavaNineDigits() throws DreFormatError{
		Student student = new Student("1"+year+"4567890");
	}
	
	@Test
	public void setDre() throws DreFormatError{
		Student student = new Student();
		student.setDre("1"+year+"456789");
		assertEquals("1"+year+"456789", student.getDre());
	}
	
	@Test
	public void setDreWithNineDigits() throws DreFormatError{
		Student student = new Student();
		student.setDre("1"+year+"456789");
		assertEquals(9, student.getDre().length());
	}
	
	@Test(expected = DreFormatError.class)
	public void setDreWithSizeError() throws DreFormatError{
		Student student = new Student();
		student.setDre("1"+year+"4567890");
	}
	
	@Test(expected = DreFormatError.class)
	public void setDreWithoutOneOnTheFirstDigit() throws DreFormatError{
		Student student = new Student();
		student.setDre("2"+year+"567890");
	}
	
	@Test(expected = DreFormatError.class)
	public void createStudentWithDreWithoutOneOnTheFirstDigit() throws DreFormatError{
		Student student = new Student("2"+year+"567890");
	}
	
	@Test
	public void setDreWithYear() throws DreFormatError{
		Student student = new Student("1"+year+"567890");
	}
	
	@Test(expected = DreFormatError.class)
	public void setDreWithoutYear() throws DreFormatError{
		Student student = new Student("134567890");
	}
}
