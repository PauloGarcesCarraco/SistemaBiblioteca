package cl.edutecno.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.edutecno.VO.LibroVO;
import cl.edutecno.modelo.Libro;
import cl.edutecno.service.LibroService;

@Controller
@RequestMapping(value = "/home", method = RequestMethod.GET)
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	LibroService libroService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(ModelMap model) {

		LibroVO libroVO = libroService.getAllLibros(); // viene de LibroService
		model.put("libroVO", libroVO);
		return "index";
	}

	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {

		return "agregar";// llama al mapping /agregar correspondiente al metodo agregar
	}

	@PostMapping("/agregar")
	public ModelAndView agregarSubmit(@ModelAttribute Libro libro, RedirectAttributes ra) {

		LibroVO respuestaServicio = libroService.add(libro);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home/");
		} else {
			return new ModelAndView("redirect:/agregarForm");
		}
	}

	@GetMapping("/eliminar")
	public ModelAndView eliminar(Model model, @RequestParam String idLibro, RedirectAttributes ra) {

		LibroVO respuestaServicio = new LibroVO();
		respuestaServicio.setMensaje("No se pudo eliminar el libro, intente nuevamente.");
		try {
			Libro eliminado = new Libro();
			eliminado.setIdLibro(Integer.parseInt(idLibro));
			respuestaServicio = libroService.delete(eliminado);
			ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
			return new ModelAndView("redirect:/home/");
		} catch (Exception e) {
			log.error("Error en UsuarioController eliminar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = libroService.getAllLibros();
		ra.addAttribute("LibroVO", respuestaServicio);
		return new ModelAndView("redirect:/home/");
	}

	@GetMapping("/editarForm")
	public ModelAndView editarForm(Model model, @RequestParam String idLibro, RedirectAttributes ra) {

		LibroVO respuestaServicio = new LibroVO();
		respuestaServicio.setMensaje("No se pudo cargar la vista de edición, intente nuevamente.");
		try {
			Integer id = (Integer.parseInt(idLibro));
			respuestaServicio = libroService.findById(id);
			model.addAttribute("mensaje", respuestaServicio.getMensaje());
			model.addAttribute("LibroVO", respuestaServicio.getLibros().get(0));
			return new ModelAndView("editar");
		} catch (Exception e) {
			log.error("Error en HomeController editar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = libroService.getAllLibros();
		return new ModelAndView("redirect:/home/");
	}

	@PostMapping("/editar")
	public ModelAndView editar(@ModelAttribute Libro libro, RedirectAttributes ra) {
	
		LibroVO respuestaServicio = libroService.update(libro);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home/");
		} else {
			return new ModelAndView("redirect:/editarForm");
		}
	}


	@GetMapping("/buscar")
	public ModelAndView buscarForm(Model model, @RequestParam String autor, String titulo, RedirectAttributes ra) {
		LibroVO respuestaServicio=new LibroVO();
		respuestaServicio.setMensaje("No se encontro titulo o autor, intente nuevamente");
		try {
			respuestaServicio= libroService.findByAutorAndTitulo(autor, titulo);
			model.addAttribute("mensaje", respuestaServicio.getMensaje());
			model.addAttribute("LibroVO", respuestaServicio.getLibros().get(0));
			return new ModelAndView("buscar");
		} catch (Exception e) {
			log.error("Error en HomeController buscarByAutorAndTitulo", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio=libroService.getAllLibros();
		return new ModelAndView("redirect:/home/");

		
	}

}
