package market.domain;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
@Table(name = "user_account")
public class UserAccount implements Serializable {
	private static final long serialVersionUID = -8278943418573848966L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "active", nullable = false)
	private boolean active;

	@OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL)
	private Contacts contacts;

	@OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL)
	private Cart cart;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name = "user_role",
		joinColumns = {
			@JoinColumn(name = "user_id")},
		inverseJoinColumns = {
			@JoinColumn(name = "role_id")})
	private Set<Role> roles = new HashSet<>();

	public UserAccount() {
	}

	public UserAccount(boolean active) {
		this.active = active;
	}

	public UserAccount(String email, String password, String name, boolean active) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
