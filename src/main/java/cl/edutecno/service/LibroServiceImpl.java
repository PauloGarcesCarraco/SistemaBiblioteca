package cl.edutecno.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.edutecno.DAO.LibroDAO;
import cl.edutecno.VO.LibroVO;
import cl.edutecno.modelo.Libro;

@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	LibroDAO dao;
	
	LibroVO respuesta;

	@Override
	public LibroVO getAllLibros() {
		respuesta=new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "101");
		try {
			respuesta.setLibros(new ArrayList<>(dao.getAllLibros()));
			respuesta.setMensaje(String.format("se ha/n encontrado %d registro/s",respuesta.getLibros().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO findByAutorAndTitulo(String autor, String titulo) {
		respuesta= new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "102");
		try {
			Libro libro= dao.findByAutorAndTitulo(autor, titulo);
			respuesta.getLibros().add(libro);
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", null != libro ? 1:0));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO login(String autor, String titulo) {
		respuesta= new LibroVO(new ArrayList<Libro>(), "credenciales incorrectas", "103");
		if(autor.length()==0 || titulo.length()==0)
			return respuesta;
		respuesta= findByAutorAndTitulo(autor, titulo);
		if(respuesta.getCodigo().equals("0")) {
			respuesta.setMensaje(String.format("Bienvenido %s", respuesta.getLibros().get(0).getAutor()));
		}
		return respuesta;
	}

	@Override
	public LibroVO add(Libro libro) {
		respuesta= new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "104");
		try {
			int registrosActualizados=dao.add(libro);
			respuesta.setMensaje(registrosActualizados == 1 ? "Se ha creado el libro correctamente" : "No se ha podido crear el libro");
			respuesta.setCodigo(registrosActualizados == 1 ? "0" : "104");
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO update(Libro libro) {
		respuesta= new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "105");
		try {
			int registrosActualizados=dao.update(libro);
			respuesta.setMensaje(String.format("Se ha/n actualizado correctamente %d libro/s", registrosActualizados));
			respuesta.setCodigo("0");
			
		} catch (Exception e) {
			System.err.print(e);
		}
		
		return respuesta;
	}

	@Override
	public LibroVO delete(Libro libro) {
		respuesta= new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "106");
		try {
			int registrosActualizados=dao.delete(libro);
			respuesta.setMensaje(String.format("Se ha/n eliminado correctamente a %d libro/s", registrosActualizados));
			respuesta.setCodigo("0");
			
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO findById(int id) {
		respuesta= new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "107");
		try {
			Libro libro= dao.findById(id);
			respuesta.getLibros().add(libro);
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", null != libro ? 1:0));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.print(e);
		}
		return respuesta;
	}
	

}
