package insurance.Management.Claims;

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

import insurance.Management.clients.Client;

public class Claim_Controller {
	@Autowired
	Claim_Repo claim_Repo;

	@GetMapping("/api/claims")
	ResponseEntity<List<Claim>> Get_All() {
		List<Claim> claims = claim_Repo.findAll();
		if (claims.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(claims));
	}

	@GetMapping("/api/claims/{id}")
	ResponseEntity<Optional<Claim>> Get_Policy(@PathVariable int id) {
		Optional<Claim> claims = claim_Repo.findById(id);
		if (claims.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(claims));
	}

	@PostMapping("/api/claims")
	ResponseEntity<Claim> Add_policy(@RequestBody Claim claim) {
		try {
			this.claim_Repo.save(claim);
			return ResponseEntity.of(Optional.of(claim));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/api/claims/{id}")
	ResponseEntity<Claim> Update_Client(@RequestBody Claim claim, @PathVariable int id) {
		if (Claim_Service.Update_Client(claim, id)) {
			return ResponseEntity.ok().build();
		}
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/api/claims/{id}")
	ResponseEntity<Client> Delete_Client(@PathVariable int id) {
		try {
			this.claim_Repo.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
}
