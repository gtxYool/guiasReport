package com.guatex.sacod_reporteguias.entities;

public class ReciboCaja {
	private String recibo, fecha, codigo, cliente, total, liquidado, liquidador, fecha_liquidacion, agencia;
	private String entrega, nRecibe, direccion, telefono, ptoDes,piezas, noguia, bancoBoletaMonto, boletaTransporte;
	private String boletaDepElec,acreditado,valorAcreditar;

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

	/**
	 * 
	 * @return
	 */
	public String getBancoBoletaMonto() {
		return notNull(bancoBoletaMonto);
	}

	/**
	 * 
	 * @param bancoBoletaMonto
	 */
	public void setBancoBoletaMonto(String bancoBoletaMonto) {
		this.bancoBoletaMonto = notNull(bancoBoletaMonto);
	}

	/**
	 * 
	 * @param bancoBoletaMonto
	 */
	public void concatBancoBoletaMonto(String bancoBoletaMonto) {
		bancoBoletaMonto = notNull(bancoBoletaMonto);
		if (!this.getBancoBoletaMonto().contains(bancoBoletaMonto)) {
			this.bancoBoletaMonto += " / " + bancoBoletaMonto;
		}
	}

	/**
	 * @return the boletaTransporte
	 */
	public String getBoletaTransporte() {
		return notNull(boletaTransporte);
	}

	/**
	 * @param boletaTransporte the boletaTransporte to set
	 */
	public void setBoletaTransporte(String boletaTransporte) {
		this.boletaTransporte = notNull(boletaTransporte);
	}

	/**
	 * @param boletaTransporte the boletaTransporte to set
	 */
	public void concatBoletaTransporte(String boletaTransporte) {
		boletaTransporte = notNull(boletaTransporte);
		if (!this.getBoletaTransporte().contains(boletaTransporte)) {
			this.boletaTransporte += ", " + boletaTransporte;
		}
	}

	/**
	 * @return the acreditado
	 */
	public String getAcreditado() {
		return mapAcreditado(acreditado);
	}

	/**
	 * @param acreditado the acreditado to set
	 */
	public void setAcreditado(String Acreditado) {
		this.acreditado = mapAcreditado(Acreditado);
	}

	private String mapAcreditado(String var) {
		return notNull(var).contains("S") ? "SI" : "NO";
	}

	/**
	 * @return the boletaDepElec
	 */
	public String getBoletaDepElec() {
		return notNull(boletaDepElec);
	}

	/**
	 * @param boletaDepElec the boletaDepElec to set
	 */
	public void setBoletaDepElec(String boletaDepElec) {
		this.boletaDepElec = notNull(boletaDepElec);
	}
	
	/**
	 * @param boletaDepElec the boletaDepElec to set
	 */
	public void concatBoletaDepElec(String boletaDepElec) {
		boletaDepElec = notNull(boletaDepElec);
		if (!this.getBoletaDepElec().contains(boletaDepElec)) {
			this.boletaDepElec += ", " + boletaDepElec;
		}
	}

	/**
	 * @return the valorAcreditar
	 */
	public String getValorAcreditar() {
		return notNull(valorAcreditar);
	}

	/**
	 * @param valorAcreditar the valorAcreditar to set
	 */
	public void setValorAcreditar(String valorAcreditar) {
		this.valorAcreditar = notNull(valorAcreditar);
	}

	/**
	 * @return the ptoDes
	 */
	public String getPtoDes() {
		return notNull(ptoDes);
	}

	/**
	 * @param ptoDes the ptoDes to set
	 */
	public void setPtoDes(String ptoDes) {
		this.ptoDes = notNull(ptoDes);
	}
}
