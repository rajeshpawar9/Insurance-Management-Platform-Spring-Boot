package insurance.Management.clients;

import org.springframework.beans.factory.annotation.Autowired;

public class Client_Service {
	@Autowired
	static Client_Repo client_Repo;

	public static boolean Update_Client(Client client, int id) {
		java.util.List<Client> clients = client_Repo.findAll();
		for (Client c : clients) {
			if (c.getClient_id() == id) {
				c.setAddress(client.getAddress());
				c.setClient_id(client.getClient_id());
				c.setContact_information(client.getContact_information());
				c.setDate_of_birth(client.getDate_of_birth());
				c.setName(client.getName());
				return true;
			}
		}
		return false;
	}



}
