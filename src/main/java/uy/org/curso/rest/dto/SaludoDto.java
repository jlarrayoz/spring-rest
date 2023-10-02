package uy.org.curso.rest.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SaludoDto {
	
	private String nombre;
	
	public SaludoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaludoDto(String nombre) {
		super();
		this.nombre = nombre;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
