package eStoreProduct.model.admin.input;

import eStoreProduct.externalServices.passwordHashing;

public class adminLogin {
	private String email;
	private String password;
	private int id;
	private String title;

	private String Designation;

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
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
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
		password = passwordHashing.hashString(password);
		this.password = password;
	}

}
