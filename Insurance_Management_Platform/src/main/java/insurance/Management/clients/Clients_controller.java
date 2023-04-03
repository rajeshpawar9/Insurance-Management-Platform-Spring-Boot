package insurance.Management.clients;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Clients_controller {
	@Autowired
	Client_Repo client_Repo;

	@GetMapping("/api/clients")
	ResponseEntity<ArrayList<Client>> Get_All() {
		ArrayList<Client> clients = (ArrayList<Client>) client_Repo.findAll();
		if (clients.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(clients));
	}

	@GetMapping("/api/clients/{id}")
	ResponseEntity<Optional<Client>> Get_Client(@PathVariable int id) {
		Optional<Client> client = client_Repo.findById(id);
		if (client.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(client));
	}

	@PostMapping("/api/clients")
	ResponseEntity<Client> Add_client(Client client) {
		try {
			this.client_Repo.save(client);
			return ResponseEntity.of(Optional.of(client));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/api/clients/{id}")
	ResponseEntity<Client> Update_Client(@RequestBody Client client, @PathVariable int id) {
		if (Client_Service.Update_Client(client, id)) {
			return ResponseEntity.ok().build();
		}
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/api/clients/{id}")
	ResponseEntity<Client> Delete_Client(@PathVariable int id) {
		try {
			this.client_Repo.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}
