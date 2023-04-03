package insurance.Management.clients;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import insurance.Management.Policies.Policy;

@Table(name = "clients")
@Entity
public class Client {
	@Id
	@Column(name = "client_id")
	int Client_id;
	@Column(name = "name")
	String Name;
	@Column(name = "date_of_birth")
	Date Date_of_birth;
	@Column(name = "address")
	String Address;
	@OneToOne
	Contact_information Contact_information;
	@OneToMany
	List<Policy> policy;

	public Client() {

	}

	public Client(int client_id, String name, Date date_of_birth, String address,
			insurance.Management.clients.Contact_information contact_information, List<Policy> policy) {
		super();
		Client_id = client_id;
		Name = name;
		Date_of_birth = date_of_birth;
		Address = address;
		Contact_information = contact_information;
		this.policy =  policy;
	}

	public int getClient_id() {
		return Client_id;
	}

	public void setClient_id(int client_id) {
		Client_id = client_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDate_of_birth() {
		return Date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		Date_of_birth = date_of_birth;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Contact_information getContact_information() {
		return Contact_information;
	}

	public void setContact_information(Contact_information contact_information) {
		Contact_information = contact_information;
	}

	public List<Policy> getPolicy() {
		return policy;
	}

	public void setPolicy(List<Policy> policy) {
		this.policy = policy;
	}

}
