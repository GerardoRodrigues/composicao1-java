package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String name;
	private String email;
	private Date niver;
	
	public Cliente() {
	}

	public Cliente(String name, String email, Date niver) {
		this.name = name;
		this.email = email;
		this.niver = niver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNiver() {
		return niver;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" (" + sdf.format(niver) + ")");
		sb.append(" - " + email);
		
		return sb.toString();
	}
}
