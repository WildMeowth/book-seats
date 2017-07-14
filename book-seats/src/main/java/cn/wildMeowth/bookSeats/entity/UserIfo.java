package cn.wildMeowth.bookSeats.entity;

import java.io.Serializable;

public class UserIfo implements Serializable {
private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String password;
	private String token;
	private String title;
	
	public UserIfo() {
		super();
	}

	public UserIfo(String id, String name, String password, String token, String title) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.token = token;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserIfo other = (UserIfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserIfo [id=" + id + ", name=" + name + ", password=" + password + ", token=" + token + ", title="
				+ title + "]";
	}
	
	
	
}
