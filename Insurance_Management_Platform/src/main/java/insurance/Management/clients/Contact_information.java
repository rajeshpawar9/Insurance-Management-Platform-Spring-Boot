package insurance.Management.clients;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name = "contact_information")
public class Contact_information {
	@Id
	@Column(name="mobile_No")
	String M_NO;
	@Column(name="email")
	String Email;
	public Contact_information() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact_information(String m_NO, String email) {
		super();
		M_NO = m_NO;
		Email = email;
	}
	public String getM_NO() {
		return M_NO;
	}
	public void setM_NO(String m_NO) {
		M_NO = m_NO;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
