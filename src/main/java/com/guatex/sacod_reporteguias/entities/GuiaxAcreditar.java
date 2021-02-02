/**
 * 
 */
package com.guatex.sacod_reporteguias.entities;

/**
 * @author DYOOL
 *
 */
public class GuiaxAcreditar {
	String noguia, fecha, valorCOD, valorServicio, valorAcreditar, porcentaje, reciboCOD, IDReporte, FPreAutoriza,
			FAutoriza, UPreAutoriza, UAutoriza;

	// ------------- GETTERS AND SETTERS ---------------------------- //
	/**
	 * @return the noguia
	 */
	public String getNoguia() {
		return notNull(noguia);
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return notNull(fecha);
	}

	/**
	 * @return the valorCOD
	 */
	public String getValorCOD() {
		return notNull(valorCOD);
	}

	/**
	 * @return the valorServicio
	 */
	public String getValorServicio() {
		return notNull(valorServicio);
	}

	/**
	 * @return the valorAcreditar
	 */
	public String getValorAcreditar() {
		return notNull(valorAcreditar);
	}

	/**
	 * @return the porcentaje
	 */
	public String getPorcentaje() {
		return notNull(porcentaje);
	}

	/**
	 * @return the reciboCOD
	 */
	public String getReciboCOD() {
		return notNull(reciboCOD);
	}

	/**
	 * @return the iDReporte
	 */
	public String getIDReporte() {
		return notNull(IDReporte);
	}

	/**
	 * @return the fPreAutoriza
	 */
	public String getFPreAutoriza() {
		return notNull(FPreAutoriza);
	}

	/**
	 * @return the fAutoriza
	 */
	public String getFAutoriza() {
		return notNull(FAutoriza);
	}

	/**
	 * @return the uAutoriza
	 */
	public String getUAutoriza() {
		return notNull(UAutoriza);
	}

	/**
	 * @return the uPreAutoriza
	 */
	public String getUPreAutoriza() {
		return notNull(UPreAutoriza);
	}

	/**
	 * @param noguia the noguia to set
	 */
	public void setNoguia(String noguia) {
		this.noguia = notNull(noguia);
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = notNull(fecha);
	}

	/**
	 * @param valorCOD the valorCOD to set
	 */
	public void setValorCOD(String valorCOD) {
		this.valorCOD = notNull(valorCOD);
	}

	/**
	 * @param valorServicio the valorServicio to set
	 */
	public void setValorServicio(String valorServicio) {
		this.valorServicio = notNull(valorServicio);
	}

	/**
	 * @param valorAcreditar the valorAcreditar to set
	 */
	public void setValorAcreditar(String valorAcreditar) {
		this.valorAcreditar = notNull(valorAcreditar);
	}

	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(String porcentaje) {
		this.porcentaje = notNull(porcentaje);
	}

	/**
	 * @param reciboCOD the reciboCOD to set
	 */
	public void setReciboCOD(String reciboCOD) {
		this.reciboCOD = notNull(reciboCOD);
	}

	/**
	 * @param iDReporte the iDReporte to set
	 */
	public void setIDReporte(String iDReporte) {
		IDReporte = notNull(iDReporte);
	}

	/**
	 * @param fPreAutoriza the fPreAutoriza to set
	 */
	public void setFPreAutoriza(String fPreAutoriza) {
		FPreAutoriza = notNull(fPreAutoriza);
	}

	/**
	 * @param fAutoriza the fAutoriza to set
	 */
	public void setFAutoriza(String fAutoriza) {
		FAutoriza = notNull(fAutoriza);
	}

	/**
	 * @param uAutoriza the uAutoriza to set
	 */
	public void setUAutoriza(String uAutoriza) {
		UAutoriza = notNull(uAutoriza);
	}

	/**
	 * @param uPreAutoriza the uPreAutoriza to set
	 */
	public void setUPreAutoriza(String uPreAutoriza) {
		UPreAutoriza = notNull(uPreAutoriza);
	}

	private String notNull(String var) {
		return var != null ? var.trim() : "";
	}

}
