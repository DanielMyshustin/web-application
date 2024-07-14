package daniil.web.user.project.web_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daniil.web.user.project.web_application.dao.ClientRepository;
import daniil.web.user.project.web_application.model.Client;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
	
	public Optional<Client> getClientById(Integer clientId) {
		return clientRepository.findById(clientId);
	}
	
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}
	
	public Client updateClient(Integer clientId, Client updatedClient) {
		Optional<Client> existingClient = clientRepository.findById(clientId);
		if(existingClient.isPresent()) {
			updatedClient.setId(clientId);
			return clientRepository.save(updatedClient);
		} else {
			return null;
		}
	}
	
	public void deleteClient(Integer clientId) {
		clientRepository.deleteById(clientId);
	}
}

