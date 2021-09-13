package cl.edutecno.service;

import org.springframework.stereotype.Service;

import cl.edutecno.VO.LibroVO;
import cl.edutecno.modelo.Libro;


public interface LibroService {
	
	public LibroVO getAllLibros();
	
	public LibroVO findByAutorAndTitulo(String autor, String titulo);
	
	public LibroVO findById(int id);
	
	public LibroVO login(String autor, String titulo);
	
	public LibroVO add(Libro libro);
	
	public LibroVO update(Libro libro);
	
	public LibroVO delete(Libro libro);
	
	

}
