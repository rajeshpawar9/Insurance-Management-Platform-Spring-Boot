package insurance.Management.Claims;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="claims")
public class Claim {
	@Id
	int claim_number;
	String description;
	Date claim_date;
	boolean claim_status;
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Claim(int claim_number, String description, Date claim_date, boolean claim_status) {
		super();
		this.claim_number = claim_number;
		this.description = description;
		this.claim_date = claim_date;
		this.claim_status = claim_status;
	}
	public int getClaim_number() {
		return claim_number;
	}
	public void setClaim_number(int claim_number) {
		this.claim_number = claim_number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getClaim_date() {
		return claim_date;
	}
	public void setClaim_date(Date claim_date) {
		this.claim_date = claim_date;
	}
	public boolean getClaim_status() {
		return claim_status;
	}
	public void setClaim_status(boolean claim_status) {
		this.claim_status = claim_status;
	}
	
}
