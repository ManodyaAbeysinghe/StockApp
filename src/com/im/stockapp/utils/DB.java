package com.im.stockapp.utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DB {
	
	public static SessionFactory sf = buildSessionFactory();
	
	public static SessionFactory buildSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
	
	
	
	public static void save(Object obj) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
	}
	
	
	public static void delete(Object obj) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		
	}
	
	public static List list(Object className) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		return session.createQuery("from "+className).list();
		
	}
	
	
	
	
	

}
