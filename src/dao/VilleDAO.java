package dao;

import java.util.*;

import org.hibernate.*;

import util.HibernateUtil;
import entities.Groupe;
import entities.Ville;

public class VilleDAO {

	public void addVille(Ville objVille) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(objVille);
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

	public List<Ville> getAllVille() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		List<Ville> users = new ArrayList<Ville>();
		try {
			users = session.createQuery("from Ville").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return users;
	}
	
	public List<Ville> getVilleById(String id) {
		List<Ville> etud = new ArrayList<Ville>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			etud = session.createQuery(
					"from Ville where codeVille="+id+"").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return etud;
	}
}
