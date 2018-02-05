package com.BFS.BFSweb.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BFS.BFSweb.controller.LoginController;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {

	/** The Constant INDEX_VIEW. */
	public static final String INDEX_VIEW = "index";
	
	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(LoginController.class);

	/**
	 * Show login form.
	 *
	 * @param model the model
	 * @param error the error
	 * @param logout the logout
	 * @return the string
	 */
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name = "error", required=false) String error,
			@RequestParam(name = "logout", required=false) String logout) {
		LOG.info("METHOD: showLoginForm() -- PARAMS: error= " + error + ", logout: " + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Returning to login view");
		return INDEX_VIEW;
	}
	
	/**
	 * Login check.
	 *
	 * @return the string
	 */
	@GetMapping("/loginsuccess")
	public String loginCheck() {
		LOG.info("METHOD: loginCheck()");
		LOG.info("Return to list view");
		return "redirect:/CRUD/listarproductos";
	}

}
