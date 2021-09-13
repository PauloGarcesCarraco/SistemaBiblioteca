package cl.edutecno.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.edutecno.modelo.Libro;
import cl.edutecno.modelo.LibroMapper;

@Repository
public class LibroDAOImpl implements LibroDAO {

	JdbcTemplate jdbcTemplate;
	DataSource dataSource;

	@Autowired // UsuarioDAOImpl usuariDao =
	public LibroDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Libro> getAllLibros() {
		return jdbcTemplate.query("select * from LIBROS ORDER BY id_libro ASC", new LibroMapper());
	}

	@Override
	public Libro findByAutorAndTitulo(String autor, String titulo) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from LIBROS where autor=? and titulo=?", new LibroMapper(),
				new Object[] { autor, titulo });
	}

	@Override
	public Libro findById(int id) {
		return jdbcTemplate.queryForObject("select * from LIBROS where id_libro = ?", new LibroMapper(),
				new Object[] { id });
	}

	@Override
	public int add(Libro libro) {

		return jdbcTemplate.update("insert into LIBROS values(SQ_LIBROS.nextval,?,?,?,?,?)", libro.getTitulo(),
				libro.getAno(), libro.getAutor(), libro.getImprenta(), libro.getDisponible());
	}

	@Override
	public int update(Libro libro) {

		return jdbcTemplate.update(
				"update LIBROS set titulo = ?, ano = ?, autor = ?, imprenta = ?, disponible = ? where id_libro = ?",
				libro.getTitulo(), libro.getAno(), libro.getAutor(), libro.getImprenta(), libro.getDisponible(),
				libro.getIdLibro());
	}

	@Override
	public int delete(Libro libro) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("delete from LIBROS where id_libro = ?", libro.getIdLibro());
	}

}
