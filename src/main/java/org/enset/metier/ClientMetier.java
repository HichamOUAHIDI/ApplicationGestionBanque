package org.enset.metier;

import java.util.List;

import org.enset.entities.Client;

public interface ClientMetier {
	public Client saveClient(Client client);
	public List<Client> listClient();
	
}
