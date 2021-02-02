package com.guatex.sacod_reporteguias.entities;

public class ResumenAcreditacion {
	String fechaIni, fechaFin, codigo, nombre, acreditado, cantidadGuias, razonSocial, totalCOD, totalServ, totalAcr,
			PorcentajeCOD, usuarioPreAu, usuarioAu, autorizacion, noCuenta, Banco;

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
	 * @return the acreditado
	 */
	public String getAcreditado() {
		return notNull(acreditado);
	}

	/**
	 * @return the cantidadGuias
	 */
	public String getCantidadGuias() {
		return notNull(cantidadGuias);
	}

	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return notNull(razonSocial);
	}

	/**
	 * @return the totalCOD
	 */
	public String getTotalCOD() {
		return notNull(totalCOD);
	}

	/**
	 * @return the totalServ
	 */
	public String getTotalServ() {
		return notNull(totalServ);
	}

	/**
	 * @return the totalAcr
	 */
	public String getTotalAcr() {
		return notNull(totalAcr);
	}

	/**
	 * @return the porcentajeCOD
	 */
	public String getPorcentajeCOD() {
		return notNull(PorcentajeCOD);
	}

	/**
	 * @return the usuarioPreAu
	 */
	public String getUsuarioPreAu() {
		return notNull(usuarioPreAu);
	}

	/**
	 * @return the usuarioAu
	 */
	public String getUsuarioAu() {
		return notNull(usuarioAu);
	}

	/**
	 * @return the autorizacion
	 */
	public String getAutorizacion() {
		return notNull(autorizacion);
	}

	/**
	 * @return the noCuenta
	 */
	public String getNoCuenta() {
		return notNull(noCuenta);
	}

	/**
	 * @return the banco
	 */
	public String getBanco() {
		return notNull(Banco);
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
	 * @param acreditado the acreditado to set
	 */
	public void setAcreditado(String acreditado) {
		this.acreditado = notNull(acreditado);
	}

	/**
	 * @param cantidadGuias the cantidadGuias to set
	 */
	public void setCantidadGuias(String cantidadGuias) {
		this.cantidadGuias = notNull(cantidadGuias);
	}

	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = notNull(razonSocial);
	}

	/**
	 * @param totalCOD the totalCOD to set
	 */
	public void setTotalCOD(String totalCOD) {
		this.totalCOD = notNull(totalCOD);
	}

	/**
	 * @param totalServ the totalServ to set
	 */
	public void setTotalServ(String totalServ) {
		this.totalServ = notNull(totalServ);
	}

	/**
	 * @param totalAcr the totalAcr to set
	 */
	public void setTotalAcr(String totalAcr) {
		this.totalAcr = notNull(totalAcr);
	}

	/**
	 * @param porcentajeCOD the porcentajeCOD to set
	 */
	public void setPorcentajeCOD(String porcentajeCOD) {
		PorcentajeCOD = notNull(porcentajeCOD);
	}

	/**
	 * @param usuarioPreAu the usuarioPreAu to set
	 */
	public void setUsuarioPreAu(String usuarioPreAu) {
		this.usuarioPreAu = notNull(usuarioPreAu);
	}

	/**
	 * @param usuarioAu the usuarioAu to set
	 */
	public void setUsuarioAu(String usuarioAu) {
		this.usuarioAu = notNull(usuarioAu);
	}

	/**
	 * @param autorizacion the autorizacion to set
	 */
	public void setAutorizacion(String autorizacion) {
		this.autorizacion = notNull(autorizacion);
	}

	/**
	 * @param noCuenta the noCuenta to set
	 */
	public void setNoCuenta(String noCuenta) {
		this.noCuenta = notNull(noCuenta);
	}

	/**
	 * @param banco the banco to set
	 */
	public void setBanco(String banco) {
		Banco = notNull(banco);
	}

	private String notNull(String var) {
		return var != null ? var.trim() : "";
	}
}
