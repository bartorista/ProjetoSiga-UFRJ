package model;

import junit.framework.Assert;

import org.junit.Test;

import controller.DreFormatError;


public class StudentTest extends Assert{
	@Test
	public void testGetName() throws DreFormatError{
		Student student = new Student("123456789");
		student.setName("Victor Lima Campos");	
		assertEquals("O nome do aluno é: Victor Lima Campos", student.getName());
	}
	
	@Test
	public void dreHasNineDigits() throws DreFormatError{
		Student student = new Student("123456789");
		assertEquals(9, student.getDre().length());		
	}
	
	@Test(expected = DreFormatError.class)
	public void dreDoesNotHavaNineDigits() throws DreFormatError{
		Student student = new Student("1234567890");
	}
	
	@Test
	public void setDre() throws DreFormatError{
		Student student = new Student();
		student.setDre("123456789");
		assertEquals("123456789", student.getDre());
	}
	
	@Test
	public void setDreWithNineDigits() throws DreFormatError{
		Student student = new Student();
		student.setDre("123456789");
		assertEquals(9, student.getDre().length());
	}
	
	@Test(expected = DreFormatError.class)
	public void setDreWithSizeError() throws DreFormatError{
		Student student = new Student();
		student.setDre("1234567890");
	}
	
	@Test(expected = DreFormatError.class)
	public void setDreWithoutOneOnTheFirstDigit() throws DreFormatError{
		Student student = new Student();
		student.setDre("234567890");
	}
}
