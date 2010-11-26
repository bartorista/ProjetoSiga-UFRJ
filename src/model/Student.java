package model;

import controller.DreFormatError;

public class Student {
	private String dre;
	private String name;
	
	public Student(String dre) throws DreFormatError{
		setDre(dre);		
	};
	
	public Student(){};
	
	public void setName(String name) {
		this.name = name;	
	}

	public String getName() {
		return "O nome do aluno é: " + name;
	}

	public void setDre(String dre) throws DreFormatError {
		if(dre.length() != 9)
			throw new DreFormatError();
		if(!dre.startsWith("1"))
			throw new DreFormatError();
		this.dre = dre;
	};
	
	public String getDre(){
		return dre;	
	}
}
