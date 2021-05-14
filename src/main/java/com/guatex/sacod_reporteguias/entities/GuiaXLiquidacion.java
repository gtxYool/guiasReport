package com.guatex.sacod_reporteguias.entities;

public class GuiaXLiquidacion {

	private String codigo;
	private String serie;
	private String numero;
	private String noguia;
	private String total;
	private String estado;

	public GuiaXLiquidacion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return notNull(codigo);
	}

	/**
	 * @return the serie
	 */
	public String getSerie() {
		return notNull(serie);
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return notNull(numero);
	}

	/**
	 * @return the noguia
	 */
	public String getNoguia() {
		return notNull(noguia);
	}

	/**
	 * @return the total
	 */
	public String getTotal() {
		return notNull(total);
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = notNull(codigo);
	}

	/**
	 * @param serie the serie to set
	 */
	public void setSerie(String serie) {
		this.serie = notNull(serie);
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = notNull(numero);
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = notNull(total);
	}

	/**
	 * @param noguia the noguia to set
	 */
	public void setNoguia(String noguia) {
		this.noguia = notNull(noguia);
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return notNull(estado);
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String eSTADO) {
		eSTADO = notNull(eSTADO);
		switch (eSTADO) {
		case "N":
			this.estado = "PENDIENTE";
			break;
		case "A":
			this.estado = "ANULADA";
			break;
		case "V":
			this.estado = "CONSOLIDADA";
			break;
		default:
			this.estado = "";
			break;
		}
	}

	private String notNull(String var) {
		return var != null ? var.trim() : "";
	}
}
