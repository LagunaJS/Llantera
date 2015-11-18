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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import org.hibernate.Transaction;


/**
 * @author LagunaJS
 *
 */
@Entity
public class Cliente {
	private int id;
	private String nombre;
	private String direccion;
	private Contacto contacto;
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
	 * @return the direccion
	 */
	@Basic
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the contacto
	 */
	@OneToOne
	@JoinColumn (name="idContacto")
	public Contacto getContacto() {
		return contacto;
	}
	/**
	 * @param contacto the contacto to set
	 */
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> obtenerTodos() {
		Session sesion = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			clientes = (List<Cliente>) sesion.createQuery("from Cliente").list();
			sesion.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return clientes;
	}
	
	public Cliente obtenerPorId(int id) {
		Cliente cliente = new Cliente();
		try {
		    Session session = HibernateUtil.getSessionFactory().openSession();
		    Transaction transaction = null;
	        transaction = session.beginTransaction();
	        cliente = (Cliente) session.get(Cliente.class.getName(), id);
	        transaction.commit();
	        session.close();
	        return cliente;
		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}
		return cliente;
	}
	
	/**
	 * Agregar un nuevo cliente a la base de datos
	 */
	public Integer crearCliente(String nombre,String direccion, Contacto contacto) {
		Cliente cliente = new Cliente();
		int id = 0;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			cliente.setNombre(nombre);
			cliente.setDireccion(direccion);
			cliente.setContacto(contacto);
			session.save(cliente);
			id = cliente.getId();
			transaction.commit();
		}catch(Exception ex){
			System.out.println("Ocurrio un error " + ex);
		}
		return id;
	}
}
