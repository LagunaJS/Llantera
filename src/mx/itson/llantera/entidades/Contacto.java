/**
 * 
 */
package mx.itson.llantera.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


import javax.persistence.Entity;

/**
 * @author LagunaJS
 *
 */

@Entity
public class Contacto {
	private int id;
	private String nombre;
	private String telefono;
	private String correo;
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
	 * @return the telefono
	 */
	@Basic
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telfono the telfono to set
	 */
	public void setTelefono(String telfono) {
		this.telefono = telfono;
	}

	
	/**
	 * @return the correo
	 */
	@Basic
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Contacto> obtenerTodos(){
		Session sesion = null;
		List <Contacto> contactos = new ArrayList<Contacto>();
		try{
			sesion = HibernateUtil.getSessionFactory().openSession();
			contactos = (List<Contacto>) sesion.createQuery("from Contacto").list();
			sesion.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return contactos;
	}
	
	/**
	 * Obtiene el registro del contacto con el @Param id
	 */
	public Contacto obtenerPorId(int id){
		Contacto contacto = new Contacto();
		
		try{
			Session sesion = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = sesion.createCriteria(Contacto.class);
			criteria.add(Restrictions.eq("id",id));
			contacto = (Contacto) criteria.uniqueResult();
			sesion.close();
		} catch (Exception ex){
			System.out.println(ex.getCause());
		}
		return contacto;
	}
	
	/**
	 * Agregar un nuevo contacto a la base de datos
	 */
	public Integer crearContacto(String nombre,String telefono, String correo) {
		Contacto contacto = new Contacto();
		int id = 0;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			contacto.setNombre(nombre);
			contacto.setTelefono(telefono);
			contacto.setCorreo(correo);
			session.save(contacto);
			id = contacto.getId();
			transaction.commit();
		}catch(Exception ex){
			System.out.println("Ocurrio un error " + ex);
		}
		return id;
	}
	
	

}
