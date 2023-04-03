package insurance.Management.Policies;

import org.springframework.beans.factory.annotation.Autowired;

public class Policy_Service {
	@Autowired
	static Policy_Repo Policy_Repo;

	public static boolean Update_Client(Policy Policy, int id) {
		java.util.List<Policy> Policies = Policy_Repo.findAll();
		for (Policy p : Policies) {
			if (p.getPolicy_Number() == id) {
				p.setCover_Amount(Policy.getCover_Amount());
				p.setEnd_Date(Policy.getEnd_Date());
				p.setStart_Date(Policy.getStart_Date());
				p.setPremium(Policy.getPremium());
				p.setType(Policy.getType());
				return true;
			}
		}
		return false;
	}
}
