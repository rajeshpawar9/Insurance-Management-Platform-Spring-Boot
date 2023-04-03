package insurance.Management.Policies;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import insurance.Management.Claims.Claim;
@Entity
@Table(name = "policies")
public class Policy {
	@Id
	@Column(name = "policy_number")
	int Policy_Number;
	String Type;
	@Column(name = "cover_amount")
	int Cover_Amount;
	@Column(name = "premium")
	int Premium;
	@Column(name = "start_date")
	Date Start_Date;
	@Column(name = "end_date")
	Date End_Date;
	@OneToOne
	Claim claim;

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Policy(int policy_Number, String type, int cover_Amount, int premium, Date start_Date, Date end_Date,
			Claim claim) {
		super();
		Policy_Number = policy_Number;
		Type = type;
		Cover_Amount = cover_Amount;
		Premium = premium;
		Start_Date = start_Date;
		End_Date = end_Date;
		this.claim = claim;
	}

	public int getPolicy_Number() {
		return Policy_Number;
	}

	public void setPolicy_Number(int policy_Number) {
		Policy_Number = policy_Number;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getCover_Amount() {
		return Cover_Amount;
	}

	public void setCover_Amount(int cover_Amount) {
		Cover_Amount = cover_Amount;
	}

	public int getPremium() {
		return Premium;
	}

	public void setPremium(int premium) {
		Premium = premium;
	}

	public Date getStart_Date() {
		return Start_Date;
	}

	public void setStart_Date(Date start_Date) {
		Start_Date = start_Date;
	}

	public Date getEnd_Date() {
		return End_Date;
	}

	public void setEnd_Date(Date end_Date) {
		End_Date = end_Date;
	}
	public Claim getClaim() {
		return claim;
	}
	public void setClaim(Claim claim) {
		this.claim = claim;
	}

}
