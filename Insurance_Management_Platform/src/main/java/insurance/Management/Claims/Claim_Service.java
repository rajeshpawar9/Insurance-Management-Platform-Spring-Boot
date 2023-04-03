package insurance.Management.Claims;

import org.springframework.beans.factory.annotation.Autowired;

public class Claim_Service {
	@Autowired
	static Claim_Repo claim_Repo;

	public static boolean Update_Client(Claim claim, int id) {
		java.util.List<Claim> claims = claim_Repo.findAll();
		for (Claim c : claims) {
			if (c.getClaim_number()==id) {
				c.setClaim_date(claim.getClaim_date());
				c.setClaim_status(claim.getClaim_status());
				c.setDescription(claim.getDescription());
				return true;
			}
		}
		return false;
	}
}
