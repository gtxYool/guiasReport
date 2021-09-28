package com.guatex.sacod_reporteguias.entities;

public class E_BoletaxRecibo {
	String ReciboCOD, NoBoleta, Fecha, Usuario, Ruta, Placa, nombre_Ruta, noguia,nombre_Usuario;

	/**
	 * @return the reciboCOD
	 */
	public String getReciboCOD() {
		return notNull(ReciboCOD);
	}

	/**
	 * @return the noBoleta
	 */
	public String getNoBoleta() {
		return notNull(NoBoleta);
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return notNull(Fecha);
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return notNull(Usuario);
	}

	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return notNull(Ruta);
	}

	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return notNull(Placa);
	}

	/**
	 * @param reciboCOD the reciboCOD to set
	 */
	public void setReciboCOD(String reciboCOD) {
		ReciboCOD = notNull(reciboCOD);
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
	public void setNoguia(String Noguia) {
		noguia = notNull(Noguia);
	}

	/**
	 * @return the nombre_Ruta
	 */
	public String getNombre_Ruta() {
		return notNull(nombre_Ruta);
	}

	/**
	 * @param nombre_Ruta the nombre_Ruta to set
	 */
	public void setNombre_Ruta(String nombreRuta) {
		nombre_Ruta = notNull(nombreRuta);
	}
	/**
	 * @return the nombre_Usuario
	 */
	public String getNombre_Usuario() {
		return notNull(nombre_Usuario);
	}

	/**
	 * @param nombre_Ruta the nombre_Ruta to set
	 */
	public void setNombre_Usuario(String nombreUsuario) {
		nombre_Usuario = notNull(nombreUsuario);
	}
	/**
	 * @param noBoleta the noBoleta to set
	 */
	public void setNoBoleta(String noBoleta) {
		NoBoleta = notNull(noBoleta);
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		Fecha = notNull(fecha);
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		Usuario = notNull(usuario);
	}

	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		Ruta = notNull(ruta);
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		Placa = notNull(placa);
	}

	private String notNull(String var) {
		return var != null ? var.trim() : "";
	}
}
