package com.guatex.sacod_reporteguias.entities;

public class ReciboCaja {
	private String recibo, fecha, codigo, cliente, total, liquidado, liquidador, fecha_liquidacion, agencia;
	private String entrega, nRecibe, direccion, telefono,piezas,noguia;

	private String notNull(String var) {
		return var != null ? var.trim() : "";
	}

//--------------------- GETTERS AND SETTERS ------------------------///
	/**
	 * @return the recibo
	 */
	public String getRecibo() {
		return notNull(recibo);
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return notNull(fecha);
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return notNull(codigo);
	}

	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return notNull(cliente);
	}

	/**
	 * @return the total
	 */
	public String getTotal() {
		return notNull(total);
	}

	/**
	 * @return the liquidado
	 */
	public String getLiquidado() {
		return notNull(liquidado);
	}

	/**
	 * @return the liquidador
	 */
	public String getLiquidador() {
		return notNull(liquidador);
	}

	/**
	 * @return the fecha_liquidacion
	 */
	public String getFecha_liquidacion() {
		return notNull(fecha_liquidacion);
	}

	/**
	 * @return the agencia
	 */
	public String getAgencia() {
		return notNull(agencia);
	}

	/**
	 * @return the entrega
	 */
	public String getEntrega() {
		return notNull(entrega);
	}

	/**
	 * @return the recibe
	 */
	public String getnRecibe() {
		return notNull(nRecibe);
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return notNull(direccion);
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return notNull(telefono);
	}

	/**
	 * @param recibo the recibo to set
	 */
	public void setRecibo(String recibo) {
		this.recibo = notNull(recibo);
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = notNull(fecha);
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = notNull(codigo);
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = notNull(cliente);
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = notNull(total);
	}

	/**
	 * @param liquidado the liquidado to set
	 */
	public void setLiquidado(String liquidado) {
		this.liquidado = notNull(liquidado);
	}

	/**
	 * @param liquidador the liquidador to set
	 */
	public void setLiquidador(String liquidador) {
		this.liquidador = notNull(liquidador);
	}

	/**
	 * @param fecha_liquidacion the fecha_liquidacion to set
	 */
	public void setFecha_liquidacion(String fecha_liquidacion) {
		this.fecha_liquidacion = notNull(fecha_liquidacion);
	}

	/**
	 * @param agencia the agencia to set
	 */
	public void setAgencia(String agencia) {
		this.agencia = notNull(agencia);
	}

	/**
	 * @param entrega the entrega to set
	 */
	public void setEntrega(String entrega) {
		this.entrega = notNull(entrega);
	}

	/**
	 * @param recibe the recibe to set
	 */
	public void setnRecibe(String recibe) {
		this.nRecibe = notNull(recibe);
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = notNull(direccion);
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = notNull(telefono);
	}

	/**
	 * @return the piezas
	 */
	public String getPiezas() {
		return notNull(piezas);
	}

	/**
	 * @param piezas the piezas to set
	 */
	public void setPiezas(String piezas) {
		this.piezas = notNull(piezas);
	}

	/**
	 * @return the noguia
	 */
	public String getNoguia() {
		return notNull(noguia);
	}

	/**
	 * @param noguia the noguia to set
	 */
	public void setNoguia(String noguia) {
		this.noguia = notNull(noguia);
	}
}
