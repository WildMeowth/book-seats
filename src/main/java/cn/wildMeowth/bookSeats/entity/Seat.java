package cn.wildMeowth.bookSeats.entity;

import java.io.Serializable;

public class Seat implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String userId;
	private String time;
	private String status;
	public Seat() {
	}
	
	public Seat(String id, String userId, String time, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.time = time;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		Seat other = (Seat) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", userId=" + userId + ", time=" + time + ", status=" + status + "]";
	}


	
	
	
}
