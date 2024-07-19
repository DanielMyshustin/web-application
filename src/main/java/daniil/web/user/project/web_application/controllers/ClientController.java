package daniil.web.user.project.web_application.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import daniil.web.user.project.web_application.model.Client;
import daniil.web.user.project.web_application.service.ClientService;

@Controller
public class ClientController {

	@Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String getAllClients(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "clients";  
    }

    @GetMapping("/clients/new")
    public String showNewClientForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "client_form";  
    }

    @PostMapping("/clients/new")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.createClient(client);
        return "redirect:/clients";  
    }

    @GetMapping("/clients/edit/{id}")
    public String showEditClientForm(@PathVariable("id") Integer id, Model model) {
        Optional<Client> client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "client_form";  // Return the view name (e.g., client_form.html) to display the client form
    }

    @GetMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
        return "redirect:/clients";  // Redirect to the list of clients after deletion
    }
}

