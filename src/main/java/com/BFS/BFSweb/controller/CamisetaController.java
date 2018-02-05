package com.BFS.BFSweb.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.BFS.BFSweb.converter.CamisetaConverter;
import com.BFS.BFSweb.entity.Camiseta;
import com.BFS.BFSweb.model.CamisetaModel;
import com.BFS.BFSweb.service.CamisetaService;

// TODO: Auto-generated Javadoc
/**
 * The Class CamisetaController.
 */
@Controller
@RequestMapping("/CRUD")
public class CamisetaController {
	
	/** The agregarmodificar. */
	public String agregarmodificar = "AGREGAR";
	
	/** The idrecogido. */
	public int IDRECOGIDO;
	
	/** The src imagen actual. */
	public String srcImagenActual;
	
	/** The Constant CRUD_VIEW. */
	public static final String CRUD_VIEW = "AgregarModificar";
	
	/** The Constant LIST_VIEW. */
	public static final String LIST_VIEW = "Listado";
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(CamisetaController.class);
	
	/** The convertidor. */
	public CamisetaConverter convertidor = new CamisetaConverter();
	
	/** The camiseta service. */
	@Autowired
	private CamisetaService camisetaService;

	/**
	 * Mostrar HTML.
	 *
	 * @return the model and view
	 */
	@GetMapping("/agregarmodificar")
	public ModelAndView mostrarHTML() {
		srcImagenActual = asignarImagenAleatoria();
		ModelAndView mav = new ModelAndView(CRUD_VIEW);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", "Bienvenido: " + user.getUsername());
		mav.addObject("camiseta", new Camiseta());
		return mav;
	}

	/**
	 * Listar camisetas.
	 *
	 * @return the model and view
	 */
	@GetMapping("/listarproductos")
	public ModelAndView listarCamisetas() {
		ModelAndView mav = new ModelAndView(LIST_VIEW);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", "Bienvenido: " + user.getUsername());
		mav.addObject("camisetas", camisetaService.listAllCamisetas());
		return mav;
	}

	/**
	 * A anadir camiseta.
	 *
	 * @return the string
	 */
	@GetMapping("/redireccionAnadir")
	public String aAnadirCamiseta() {
		agregarmodificar = "AGREGAR";
		srcImagenActual = asignarImagenAleatoria();
		return "redirect:/CRUD/agregarmodificar";
	}

	/**
	 * A modificar camiseta.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/redireccionModificar")
	public String aModificarCamiseta(@RequestParam(name = "id", required = true) int id, Model model) {
		agregarmodificar = "MODIFICAR";
		IDRECOGIDO = id;
		srcImagenActual = asignarImagenAleatoria();
		Camiseta camiseta = camisetaService.findCamisetaById(id);
		CamisetaModel camisetaModel = convertidor.entity2model(camiseta);
		LOG.info("RECOGIDO: " + camisetaModel.toString() + ".");
		model.addAttribute("camiseta", camisetaModel);
		return CRUD_VIEW;
	}

	/**
	 * Accion realizar.
	 *
	 * @param camiseta the camiseta
	 * @param bindingResult the binding result
	 * @return the string
	 */
	@PostMapping("/addupdate")
	public String accionRealizar(@Valid @ModelAttribute("camiseta") Camiseta camiseta, BindingResult bindingResult){
		String devolver = "";
		if(bindingResult.hasErrors()) {
			if(agregarmodificar.equals("AGREGAR")) {
				devolver = "redirect:/CRUD/redireccionAnadir";
			}
			else if(agregarmodificar.equals("MODIFICAR")){
				devolver = "redirect:/CRUD/redireccionModificar?id=" + IDRECOGIDO;
			}
		}
		else {
			if(agregarmodificar.equals("AGREGAR")) {
				camiseta.setSrcimagen(srcImagenActual);
				camisetaService.addCamiseta(camiseta);
				devolver = "redirect:/CRUD/agregarmodificar";
			}
			else if(agregarmodificar.equals("MODIFICAR")) {
				camiseta.setId(IDRECOGIDO);
				camiseta.setSrcimagen(srcImagenActual);
				camisetaService.updateCamiseta(camiseta);
				devolver = "redirect:/CRUD/listarproductos";
			}
		}
		return devolver;
	}

	/**
	 * Removecamiseta.
	 *
	 * @param id the id
	 * @return the string
	 */
	@GetMapping("/removecamiseta")
	public String removecamiseta(@RequestParam(name = "id", required = true) int id) {
		camisetaService.removecamiseta(id);
		return "redirect:/CRUD/listarproductos";
	}
	
	/**
	 * Asignar imagen aleatoria.
	 *
	 * @return the string
	 */
	public String asignarImagenAleatoria() {
		String srcNueva="";
		int aleatorio = (int)(Math.random() * 4 + 1);
		if(aleatorio == 1) {
			srcNueva="https://i.pinimg.com/564x/4e/bd/57/4ebd57954f23bdcab5fbc9c9f4751b54.jpg";
		}
		else if(aleatorio == 2) {
			srcNueva="https://cdn.qwertee.com/images/designs/mens/47289.jpg";
		}
		else if(aleatorio == 3) {
			srcNueva="https://i.pinimg.com/736x/db/8d/5e/db8d5ef527709f2dffaa60c4c0b9f039--funny-tee-shirts-iron-throne.jpg";
		}
		else if(aleatorio == 4) {
			srcNueva="https://i.pinimg.com/736x/9e/3e/69/9e3e6936b378977f963aaacc4df38818.jpg";
		}
		srcImagenActual=srcNueva;
		return srcNueva;
	}

}