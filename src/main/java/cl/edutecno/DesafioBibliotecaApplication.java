package cl.edutecno;

import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cl.edutecno.modelo.Libro;
import cl.edutecno.service.LibroService;

@SpringBootApplication
public class DesafioBibliotecaApplication {

	public static void main(String[] args) {
		 SpringApplication.run(DesafioBibliotecaApplication.class, args);

//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		LibroService svc = context.getBean(LibroService.class);
//		Libro auxLibro;
//		
//		
//		printLibros(svc);
//		
////		Obtenemos el primer usuario de la tabla
//		auxLibro = svc.getAllLibros().getLibros().get(0);
//		
////		Lo eliminamos e imprimimos el mensaje del resultado que entrega el servicio
//		System.out.println(svc.delete(auxLibro).getMensaje());
//		
////		Modificamos un poco el usuario para transformarlo en uno nuevo
//		auxLibro.setTitulo("los 3 mosqueteros");
//		auxLibro.setAno(1840);
//		auxLibro.setAutor("A.Dumas");
//		auxLibro.setImprenta("planeta");
//		auxLibro.setDisponible(1);
//		
////		Llamamos al servicio e imprimos el resultado de agregar al usuario a la base de datos
//		System.out.println(svc.add(auxLibro).getMensaje());
//		
////		Imprimimos la lista para verificar cómo va todo en la base de datos
//		printLibros(svc);
//		
////		Modificamos al primer usuario existente en la base de datos e imprimimos el resultado
//		auxLibro = svc.getAllLibros().getLibros().get(0);
//		auxLibro.setImprenta("Puebla");
//		System.out.println(svc.update(auxLibro).getMensaje());
//		
////		Volvemos a imprimir la lista completa.
//		printLibros(svc);
//		
//		context.close();
//
	}
//
//	private static void printLibros(LibroService svc) {
//		System.out.println("Lista de libros------");
//		for (Libro libroTemp : svc.getAllLibros().getLibros()) {
//			System.out.println(libroTemp);
//		}
//		System.out.println("final de lista de libros-------");
//
//	}
}
