package daniil.web.user.project.web_application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import daniil.web.user.project.web_application.service.ClientService;

@Controller
public class ClientController {
	
	private final ClientService clientService;

	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	} 
	
	@GetMapping("/clients")
	public String showClients(Model model) {
		model.addAttribute("clients", clientService.getAllClients());
		return "clients";
	}
}

