package security.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.Length;


@Entity
@NamedQuery(name="LoginUser.findAll", query="SELECT u FROM LoginUser u")
public class LoginUser {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;

	@Column(nullable=false)
	private String password;

	@Length(min=3, max=64, message="Username value must contain 3 to 64 characters.")
	@Column(length=64, unique=true, nullable=false)
	private String username;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="LoginUserGroup"
		, joinColumns={
			@JoinColumn(name="userid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="groupid")
			}
		)
	
	private List<LoginGroup> groups = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<LoginGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<LoginGroup> groups) {
		this.groups = groups;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
