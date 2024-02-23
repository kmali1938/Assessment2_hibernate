package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import domain.Book;

import util.HibernateUtil;

public class BookDaoImplementation implements BookDao{
	

	@Override
	public void create(Book book) {
		// TODO Auto-generated method stub
	    Session session = HibernateUtil.buildSessionFactory().openSession();
	    Transaction txn = session.getTransaction();
	    txn.begin();

	    session.persist(book);

	    txn.commit();
	    session.close();
	}
	
	@Override
	public Book readById(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.buildSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		txn.begin();
		
		Book book = session.get(Book.class, id);
		session.close();
		return book;
	}

	@Override
	public List<Book> readAll() {
		// TODO Auto-generated method stub
		List<Book> books = null;
		Session session = HibernateUtil.buildSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		txn.begin();
		
		books = session.createQuery("FROM Book", Book.class).list();
		session.close();
		return books;
		
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.buildSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		txn.begin();
		session.merge(book);
		txn.commit();
		session.close();
		
	}

	@Override
	public void delete(Book book) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.buildSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		txn.begin();
		session.delete(book);
		txn.commit();
		session.close();
		
	}
	

}
