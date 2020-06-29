package com.jspiders.hibernate4.entity;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Actor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="a_id")
	private int id;
	
	@Column(name="a_name")
	private String name;
	
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Actor_Movie",joinColumns =  {@JoinColumn(name = "a_id")},inverseJoinColumns = {@JoinColumn(name = "m_id")})
    //@JoinColumn(name = "m_id")
    private Set<Movie> movies = new HashSet<Movie>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

}
