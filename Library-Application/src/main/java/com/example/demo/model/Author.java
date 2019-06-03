package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="author")
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(name="name",length=100,unique=true)
	private String name;
	
	@Column(name="about",length=300)
	private String about;
	
	@NotNull
	@Column(name="surname",length=100)
	private String surname;
	
	@Column(name="email",length=100,unique = true)
	private String email;
	
	@Column(name="phone",length=100)
	private String phone;


}
