package winterspring.example.winterspring.service;

import java.util.List;

import winterspring.example.winterspring.model.Client;

public interface ClientService {

	Client createClient(Client client);
	Client updateClient(Client client);
	List<Client> getAllClient();
	Client getClientById(long ClientId);
	void deleteClient(long ClientId);
}
