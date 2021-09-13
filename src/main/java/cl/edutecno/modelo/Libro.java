package cl.edutecno.modelo;

import org.springframework.stereotype.Component;

@Component("libro")
public class Libro {
	private int idLibro;
	private String titulo;
	private int ano;
	private String autor;
	private String imprenta;
	private int disponible;

	public Libro() {
		super();
	}

	public Libro(int idLibro, String titulo, int ano, String autor, String imprenta, int disponible) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.ano = ano;
		this.autor = autor;
		this.imprenta = imprenta;
		this.disponible = disponible;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImprenta() {
		return imprenta;
	}

	public void setImprenta(String imprenta) {
		this.imprenta = imprenta;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", ano=" + ano + ", autor=" + autor + ", imprenta="
				+ imprenta + ", disponible=" + disponible + "]";
	}
	
	
}
