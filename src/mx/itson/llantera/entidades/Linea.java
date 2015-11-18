/**
 * 
 */
package mx.itson.llantera.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * @author LagunaJS
 *
 */
@Entity
public class Linea {
	private int id;
	private String nombre;
	private String encargado;
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	@Basic
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the encargado
	 */
	@Basic
	public String getEncargado() {
		return encargado;
	}
	/**
	 * @param encargado the encargado to set
	 */
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	
	@SuppressWarnings("unchecked")
	public List<Linea> obtenerTodos() {
		Session sesion = null;
		List<Linea> lineas = new ArrayList<Linea>();
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			lineas = (List<Linea>) sesion.createQuery("from Linea").list();
			sesion.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lineas;
	}
	
	public Linea obtenerPorId(int id) {
		Linea linea = new Linea();
		try {
		    Session session = HibernateUtil.getSessionFactory().openSession();
		    Transaction transaction = null;
	        transaction = session.beginTransaction();
	        linea = (Linea) session.get(Linea.class.getName(), id);
	        transaction.commit();
	        session.close();
	        return linea;
		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}
		return linea;
	}
	/**
	 * Agregar un nuevo Linea a la base de datos
	 */
	public Integer crearLinea(String nombre,String encargado) {
		Linea linea = new Linea();
		int id = 0;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			linea.setNombre(nombre);
			linea.setEncargado(encargado);
			session.save(linea);
			id = linea.getId();
			transaction.commit();
		}catch(Exception ex){
			System.out.println("Ocurrio un error " + ex);
		}
		return id;
	}
	
	 public boolean eliminar(Linea linea) {
	        boolean notificacion;
	        try {
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            Transaction transaction = null;
	            transaction = session.beginTransaction();
	            session.delete(linea);
	            transaction.commit();
	            session.close();
	            notificacion = true;
	        } catch (HibernateException e) {
	            System.out.println(e.getMessage());
	            notificacion = false;
	        }
	        return notificacion;
	 }
	
}
