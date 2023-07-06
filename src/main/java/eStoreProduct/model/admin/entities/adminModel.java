package eStoreProduct.model.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import eStoreProduct.externalServices.passwordHashing;

@Entity
@Table(name = "slam_ausr")
public class adminModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ausr_id")
	private Integer id;

	@Column(name = "ausr_title", length = 100)
	private String title;

	@Column(name = "ausr_desg", length = 100)
	private String designation;

	@Column(name = "ausr_email", length = 100)
	private String email;

	@Column(name = "ausr_pwd", length = 20)
	private String password;

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {

		this.password = passwordHashing.hashString(password);
	}

}
