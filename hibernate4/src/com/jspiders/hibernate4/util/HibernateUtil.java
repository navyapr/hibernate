package com.jspiders.hibernate4.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil 
{
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory()
	{
		StandardServiceRegistryBuilder serviceRegistryBuilder=new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.configure("hibernate.cfg.xml");
		StandardServiceRegistry serviceRegistry =serviceRegistryBuilder.build();
	
		MetadataSources metaDataSources = new MetadataSources(serviceRegistry);
		MetadataBuilder metaDataBuilder = metaDataSources.getMetadataBuilder();
		Metadata metadata = metaDataBuilder.build();
		
		SessionFactoryBuilder factoryBuilder = metadata.getSessionFactoryBuilder();
		SessionFactory sessionFactory = factoryBuilder.build();
		return sessionFactory;
	
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	
}
