package com.guatex.sacod_reporteguias.entities;

import com.guatex.sacod_reporteguias.utilities.Gtools;

public class E_AjusteCOD_ACR {

	private String Correlativvo;
	private String Tipo;
	private String CodCob;
	private String Aplicado;
	private String Autorizacion;
	private String Descripcion;
	private String Noguia;
	private String Monto;

	/**
	 * @return the Correlativvo
	 */
	public String getCorrelativvo() {
		return Gtools.notNull(Correlativvo);
	}

	/**
	 * @param Correlativvo the Correlativvo to set
	 */
	public void setCorrelativvo(String Correlativvo) {
		this.Correlativvo = Gtools.notNull(Correlativvo);
	}

	/**
	 * @return the Tipo
	 */
	public String getTipo() {
		return Gtools.notNull(Tipo).equalsIgnoreCase("D") ? "Débito"
				: Gtools.notNull(Tipo).equalsIgnoreCase("C") ? "Crédito" : "Anulación";
	}

	/**
	 * @param Tipo the Tipo to set
	 */
	public void setTipo(String Tipo) {
		this.Tipo = Gtools.notNull(Tipo).equalsIgnoreCase("D") ? "Débito"
				: Gtools.notNull(Tipo).equalsIgnoreCase("C") ? "Crédito" : "Anulación";
	}

	/**
	 * @return the CodCob
	 */
	public String getCodCob() {
		return Gtools.notNull(CodCob);
	}

	/**
	 * @param CodCob the CodCob to set
	 */
	public void setCodCob(String CodCob) {
		this.CodCob = Gtools.notNull(CodCob);
	}

	/**
	 * @return the Aplicado
	 */
	public String getAplicado() {
		return Gtools.notNull(Aplicado).contains("S") ? "Si" : "No";
	}

	/**
	 * @param Aplicado the Aplicado to set
	 */
	public void setAplicado(String Aplicado) {
		this.Aplicado = Gtools.notNull(Aplicado).equalsIgnoreCase("S") ? "Si" : "No";
	}

	/**
	 * @return the Autorizacion
	 */
	public String getAutorizacion() {
		return Gtools.notNull(Autorizacion);
	}

	/**
	 * @param Autorizacion the Autorizacion to set
	 */
	public void setAutorizacion(String Autorizacion) {
		this.Autorizacion = Gtools.notNull(Autorizacion);
	}

	/**
	 * @return the Descripcion
	 */
	public String getDescripcion() {
		return Gtools.notNull(Descripcion);
	}

	/**
	 * @param Descripcion the Descripcion to set
	 */
	public void setDescripcion(String Descripcion) {
		this.Descripcion = Gtools.notNull(Descripcion);
	}

	/**
	 * @return the Noguia
	 */
	public String getNoguia() {
		return Gtools.notNull(Noguia);
	}

	/**
	 * @param Noguia the Noguia to set
	 */
	public void setNoguia(String Noguia) {
		this.Noguia = Gtools.notNull(Noguia);
	}

	/**
	 * @return the Monto
	 */
	public String getMonto() {
		return Gtools.redondearString(Monto);
	}

	/**
	 * @param Monto the Monto to set
	 */
	public void setMonto(String Monto) {
		this.Monto = Gtools.redondearString(Monto);
	}
}