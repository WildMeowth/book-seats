package cn.wildMeowth.bookSeats.entity;

import java.io.Serializable;

public class User2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String seatId;
	private String seatTime;
	private String status;
	public User2() {
		super();
	}
	public User2(String id, String name, String seatId, String seatTime, String status) {
		super();
		this.id = id;
		this.name = name;
		this.seatId = seatId;
		this.seatTime = seatTime;
		this.status = status;
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
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getSeatTime() {
		return seatTime;
	}
	public void setSeatTime(String seatTime) {
		this.seatTime = seatTime;
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
		User2 other = (User2) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User2 [id=" + id + ", name=" + name + ", seatId=" + seatId + ", seatTime=" + seatTime + ", status="
				+ status + "]";
	}
	
	
	
}
