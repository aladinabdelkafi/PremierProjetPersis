package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entities.Groupe;

public class GroupeDAO {
	public void addGroupe(Groupe objGroupe) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(objGroupe);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public List<Groupe> getAllGroupe() {
		List<Groupe> users = new ArrayList<Groupe>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			users = session.createQuery("from Groupe").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return users;
	}

	public List<Groupe> getGroupeById(String id) {
		List<Groupe> etud = new ArrayList<Groupe>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			etud = session.createQuery(
					"from Groupe where groupId="+id+"").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return etud;
	}
}
