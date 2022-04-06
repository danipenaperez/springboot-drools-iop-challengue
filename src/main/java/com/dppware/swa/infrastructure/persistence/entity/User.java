package com.dppware.swa.infrastructure.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter@Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
@Table(name = "users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@Column(unique=true)
	private String email;
	private String password;
    private String name;
    
    private String hobbies;
    
    @ManyToMany()
    @JoinTable(name = "user_role", 
      joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "user_id", 
      referencedColumnName = "id"))
    private List<Role> roles;
}
