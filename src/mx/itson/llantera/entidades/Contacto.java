/**
 * 
 */
package mx.itson.llantera.entidades;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Entity;

/**
 * @author LagunaJS
 *
 */

@Entity
public class Contacto {
	private int id;
	private String nombre;
	private String telfono;
	private String Correo;
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
	 * @return the telfono
	 */
	@Basic
	public String getTelfono() {
		return telfono;
	}
	/**
	 * @param telfono the telfono to set
	 */
	public void setTelfono(String telfono) {
		this.telfono = telfono;
	}
	/**
	 * @return the correo
	 */
	@Basic
	public String getCorreo() {
		return Correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		Correo = correo;
	}

}
