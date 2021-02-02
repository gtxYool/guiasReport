/**
 * 
 */
package com.guatex.sacod_reporteguias.entities;

/**
 * @author DYOOL
 *
 */
public class PuntoLiquidacion {
	private String codigo, nombre;

	public String notNull(String var) {
		return var != null ? var.trim() : "";
	}

	// --------------------- GETTERS AND SETTERS ----------------------/
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return notNull(codigo);
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return notNull(nombre);
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = notNull(codigo);
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = notNull(nombre);
	}

}
