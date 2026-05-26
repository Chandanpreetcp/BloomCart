package in.cp.BloomCartMain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="UserInfo")
public class User {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String role;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long id, Long userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
