package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entities.Examen;
import entities.Matiere;

public class MatiereDAO {
	public void addMatiere(Matiere objMatiere) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(objMatiere);
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

	public List<Matiere> getAllMatiere() {
		List<Matiere> users = new ArrayList<Matiere>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			users = session.createQuery("from Matiere").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return users;
	}
	public List<Matiere> getMatiereById(String id) {
		List<Matiere> etud = new ArrayList<Matiere>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			etud = session.createQuery(
					"from Matiere where matiereId="+id+"").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return etud;
	}
}
