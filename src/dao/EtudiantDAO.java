package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Etudiant;
import entities.Etudiant;
import entities.Groupe;

import util.HibernateUtil;

public class EtudiantDAO {

	public void addEtudiant(Etudiant objEtudiant) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(objEtudiant);
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

	public void deleteEtudiant(String cin) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Etudiant objetudiant = (Etudiant) session.load(Etudiant.class,
					new String(cin));
			session.delete(objetudiant);
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

	public List<Etudiant> getAllEtudiants() {
		List<Etudiant> users = new ArrayList<Etudiant>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			users = session.createQuery("from Etudiant").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return users;
	}
	public List<Etudiant> getEtudiantByGroupe(String grp) {
		List<Etudiant> etud = new ArrayList<Etudiant>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			etud = session.createQuery(
					"from Etudiant where GROUPE_ID="+grp+"").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return etud;
	}
	public List<Etudiant> getEtudiantByCin(String cin) {
		List<Etudiant> etud = new ArrayList<Etudiant>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			etud = session.createQuery(
					"from Etudiant where cin="+cin+"").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return etud;
	}
}
