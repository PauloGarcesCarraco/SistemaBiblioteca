package cl.edutecno.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LibroMapper implements RowMapper<Libro> {

	@Override
	public Libro mapRow(ResultSet rs, int i) throws SQLException {
		Libro libro = new Libro();
		libro.setIdLibro(rs.getInt("id_libro"));
		libro.setTitulo(rs.getString("titulo"));
		libro.setAno(rs.getInt("ano"));
		libro.setAutor(rs.getString("autor"));
		libro.setImprenta(rs.getString("imprenta"));
		libro.setDisponible(rs.getInt("disponible"));

		return libro;
	}

}
