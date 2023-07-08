package edu.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Accounts")
public class Account implements Serializable{
	@Id
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	private String fullname = "";
	@NotBlank
	@Email
	private String email;
	private String photo ="";
	@Column(name = "Activated", nullable = true)
	private boolean activated;
	@Column(name = "Admin", nullable = true)
	private Boolean admin;
	@OneToMany(mappedBy = "account")
	private List<Order> orders;
	@OneToMany(mappedBy = "accountCart")
	private List<Cart> accountCarts;
}
