package com.jspiders.hibernate4.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jspiders.hibernate4.entity.Actor;
import com.jspiders.hibernate4.entity.Movie;
import com.jspiders.hibernate4.util.HibernateUtil;

public class HibernateClient {

	public static void main(String[] args) {
		
		Session session = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    session = sessionFactory.openSession();
		
	    Transaction tx = session.getTransaction();
	    tx.begin();
		
	    Movie movie = new Movie();
	    movie.setName("KGF");
	    
	    Movie movie1 = new Movie();
	    movie1.setName("Googly");
	    
	    Actor actor = new Actor();
	    actor.setName("Yash");
       
	    Actor actor2 = new Actor();
	    actor2.setName("Srinidhi");
		
	    Set<Movie> movies = new HashSet<Movie>();
	    movies.add(movie1);
	    movies.add(movie);
	    
	    actor.setMovies(movies);
	    actor2.setMovies(movies);
	    
	    session.persist(actor);
	    session.persist(actor2);
	    
        tx.commit();
	    
	    if(session!=null)
	    {
	    	session.close();
	    }
	    
	}

}
