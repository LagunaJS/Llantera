/**
 * 
 */
package mx.itson.llantera.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * @author LagunaJS
 *
 */
@Entity
public class Orden {
	private int id;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaEntrega;
	private Linea linea;
	private Cliente cliente;
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
	 * @return the descripcion
	 */
	@Basic
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the fechaInicio
	 */
	@Basic
	public Date getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaEntrega
	 */
	@Basic
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	/**
	 * @return the linea
	 */
	@OneToOne
	@JoinColumn (name="idLinea")
	public Linea getLinea() {
		return linea;
	}
	/**
	 * @param linea the linea to set
	 */
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	/**
	 * @return the cliente
	 */
	@OneToOne
	@JoinColumn (name="idCliente")
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Orden> obtenerTodos() {
		Session sesion = null;
		List<Orden> orden = new ArrayList<Orden>();
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			orden = (List<Orden>) sesion.createQuery("from Orden").list();
			sesion.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return orden;
	}
	
	public Orden obtenerPorId(int id) {
		Orden orden = new Orden();

		try {
			Session sesion = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = sesion.createCriteria(Contacto.class);
			criteria.add(Restrictions.eq("id", id));
			orden = (Orden) criteria.uniqueResult();
			sesion.close();
		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}
		return orden;
	}
	/**
	 * Agregar un nuevo Orden a la base de datos
	 */
	public Integer crearOrden(String descripcion, Linea linea, Cliente cliente) {
		Orden orden = new Orden();
		int id = 0;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			orden.setDescripcion(descripcion);
			orden.setLinea(linea);
			orden.setCliente(cliente);
			session.save(orden);
			id = orden.getId();
			transaction.commit();
		}catch(Exception ex){
			System.out.println("Ocurrio un error " + ex);
		}
		return id;
	}
	
}
