package insurance.Management.Policies;
import java.util.List;
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

import insurance.Management.clients.Client;

@RestController
public class Policy_Controller {
	@Autowired
	Policy_Repo Policy_Repo;

	@GetMapping("/api/policies")
	ResponseEntity<List<Policy>> Get_All() {
		List<Policy> policy =  Policy_Repo.findAll();
		if (policy.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(policy));
	}

	@GetMapping("/api/policies/{id}")
	ResponseEntity<Optional<Policy>> Get_Policy(@PathVariable int id) {
		Optional<Policy> policy = Policy_Repo.findById(id);
		if (policy.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(policy));
	}

	@PostMapping("/api/policies")
	ResponseEntity<Policy> Add_policy(@RequestBody Policy policy) {
		try {
			this.Policy_Repo.save(policy);
			return ResponseEntity.of(Optional.of(policy));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/api/policies/{id}")
	ResponseEntity<Policy> Update_Client(@RequestBody Policy policy, @PathVariable int id) {
		if(Policy_Service.Update_Client(policy, id))
		{
			return ResponseEntity.ok().build();
		}
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/api/policies/{id}")
	ResponseEntity<Client> Delete_Client(@PathVariable int id) {
		try {
			this.Policy_Repo.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}
