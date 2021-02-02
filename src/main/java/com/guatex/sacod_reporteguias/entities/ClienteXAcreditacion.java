package com.guatex.sacod_reporteguias.entities;

public class ClienteXAcreditacion {
	String fechaIni, fechaFin, codigo, nombre, acreditado, cantidadGuias, totalAcreditar;

	/**
	 * @return the fechaIni
	 */
	public String getFechaIni() {
		return notNull(fechaIni);
	}

	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return notNull(fechaFin);
	}

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
	 * @return the cantidadGuias
	 */
	public String getCantidadGuias() {
		return notNull(cantidadGuias);
	}

	/**
	 * @return the totalAcreditar
	 */
	public String getTotalAcreditar() {
		return notNull(totalAcreditar);
	}

	/**
	 * @param fechaIni the fechaIni to set
	 */
	public void setFechaIni(String fechaIni) {
		this.fechaIni = notNull(fechaIni);
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = notNull(fechaFin);
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

	/**
	 * @param cantidadGuias the cantidadGuias to set
	 */
	public void setCantidadGuias(String cantidadGuias) {
		this.cantidadGuias = notNull(cantidadGuias);
	}

	/**
	 * @param totalAcreditar the totalAcreditar to set
	 */
	public void setTotalAcreditar(String totalAcreditar) {
		this.totalAcreditar = notNull(totalAcreditar);
	}

	/**
	 * @return the acreditado
	 */
	public String getAcreditado() {
		return notNull(acreditado);
	}

	/**
	 * @param acreditado the acreditado to set
	 */
	public void setAcreditado(String acreditado) {
		this.acreditado = notNull(acreditado);
	}

	private String notNull(String var) {
		return var != null ? var.trim() : "";
	}
}
