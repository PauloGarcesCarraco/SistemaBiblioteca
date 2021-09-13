package cl.edutecno.DAO;

import java.util.List;

import cl.edutecno.modelo.Libro;



public interface LibroDAO {

	/*
	 * Métodos del CRUD que ya existían
	 */
	public List<Libro> getAllLibros();
	public Libro findByAutorAndTitulo(String autor, String titulo);
	public Libro findById(int id);
	
	/*
	 * Nuevos métodos del CRUD
	 */
	public int add(Libro libro);
	public int update(Libro libro);
	public int delete(Libro libro);
	
}