/**
 * @autor DylanYool
 */
package com.guatex.sacod_reporteguias.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GuiaF {

	private String Fecha, CodCob, Noguia, Cod_valorACobrar, Valor_Servicio, ValorACreditar, Porcentaje, FacturaCOD,
			SerieCOD, ReciboCOD, Liquidado, IdReporte, FACE_SERIE, FACE_PREIMPRESO, fpreautoriza, fautoriza, facredita,
			ffacturagtx, ffacturagua, upreautoriza, uautoriza, uacredita, ufacturagtx, ufacturagua, liquidadorag,
			liquidadoag, nocuadrecaja, fechacuadre, nombreliqui, nombreusuli, ubicacionliqui, ubicacionusuli,banco,noCuenta,FEmision,TIPO_COBRO;

	public GuiaF() {

	}

	private String notNull(String var) {
		return var != null ? var.trim() : "";
	}

	private String replace(String var) {
		var = notNull(var);
		switch (var) {
		case "A":
			return "ENTREGADA";
		case "G":
			return "EN AGENCIA";
		case "D":
			return "DEVOLUCION";
		case "R":
			return "EN RUTA";
		case "O":
			return "REC. EN OFICINA";
		case "T":
			return "TRASBORDO";
		case "V":
			return "DEVOLUCION";
		case "F":
			return "FISCALIZADO";
		case "L":
			return "RECOLECTADA";
		case "P":
			return "PROBLEMA/REC OF";
		case "Q":
			return "PROBLEMA/RUTA";
		case "Z":
			return "ANULADA DEV";
		case "B":
			return "RECEPCION";
		case "E":
			return "BODEGA-AGENCIA";
		case "S":
			return "SI";
		case "N":
			return "NO";
		default:
			return "RECOLECTADA";
		}
	}

	private String castFecha(String fecha) {
		fecha = notNull(fecha);
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			return (format2.format(format.parse(fecha)));
		} catch (ParseException ex) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				fecha=(format2.format(format.parse(fecha)));
			} catch (ParseException e) {
			}
		}
		return fecha;
	}

	// -----GETTERS AND SETTERS----------//
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return notNull(Fecha);
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		Fecha = notNull(fecha);
	}

	/**
	 * @return the codCob
	 */
	public String getCodCob() {
		return notNull(CodCob);
	}

	/**
	 * @param codCob the codCob to set
	 */
	public void setCodCob(String codCob) {
		CodCob = notNull(codCob);
	}

	/**
	 * @return the cod_valorACobrar
	 */
	public String getCod_valorACobrar() {
		return notNull(Cod_valorACobrar);
	}

	/**
	 * @param cod_valorACobrar the cod_valorACobrar to set
	 */
	public void setCod_valorACobrar(String cod_valorACobrar) {
		Cod_valorACobrar = notNull(cod_valorACobrar);
	}

	/**
	 * @return the facturaCOD
	 */
	public String getFacturaCOD() {
		return notNull(FacturaCOD);
	}

	/**
	 * @param facturaCOD the facturaCOD to set
	 */
	public void setFacturaCOD(String facturaCOD) {
		FacturaCOD = notNull(facturaCOD);
	}

	/**
	 * @return the serieCOD
	 */
	public String getSerieCOD() {
		return notNull(SerieCOD);
	}

	/**
	 * @param serieCOD the serieCOD to set
	 */
	public void setSerieCOD(String serieCOD) {
		SerieCOD = notNull(serieCOD);
	}

	/**
	 * @return the reciboCOD
	 */
	public String getReciboCOD() {
		return notNull(ReciboCOD);
	}

	/**
	 * @param reciboCOD the reciboCOD to set
	 */
	public void setReciboCOD(String reciboCOD) {
		ReciboCOD = notNull(reciboCOD);
	}

	/**
	 * @return the liquidado
	 */
	public String getLiquidado() {
		return notNull(Liquidado);
	}

	/**
	 * @param liquidado the liquidado to set
	 */
	public void setLiquidado(String liquidado) {
		Liquidado = replace(liquidado);
	}

	/**
	 * @return the noguia
	 */
	public String getNoguia() {
		return notNull(Noguia);
	}

	/**
	 * @param noguia the noguia to set
	 */
	public void setNoguia(String noguia) {
		Noguia = notNull(noguia);
	}

	/**
	 * @return the valor_Servicio
	 */
	public String getValor_Servicio() {
		return notNull(Valor_Servicio);
	}

	/**
	 * @param valor_Servicio the valor_Servicio to set
	 */
	public void setValor_Servicio(String valor_Servicio) {
		Valor_Servicio = notNull(valor_Servicio);
	}

	/**
	 * @return the valorACreditar
	 */
	public String getValorACreditar() {
		return notNull(ValorACreditar);
	}

	/**
	 * @param valorACreditar the valorACreditar to set
	 */
	public void setValorACreditar(String valorACreditar) {
		ValorACreditar = notNull(valorACreditar);
	}

	/**
	 * @return the porcentaje
	 */
	public String getPorcentaje() {
		return notNull(Porcentaje);
	}

	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(String porcentaje) {
		porcentaje = notNull(porcentaje);
		if (porcentaje.length() >= 6) {
			porcentaje = porcentaje.substring(0, porcentaje.length() - 2)+ "%";
		}
		Porcentaje = porcentaje ;
	}

	/**
	 * 
	 * @return
	 */
	public String getIdReporte() {
		return notNull(IdReporte);
	}

	/**
	 * 
	 * @param idReporte
	 */
	public void setIdReporte(String idReporte) {
		IdReporte = notNull(idReporte);
	}

	/**
	 * @return the fACE_SERIE
	 */
	public String getFACE_SERIE() {
		return notNull(FACE_SERIE);
	}

	/**
	 * @return the fACE_PREIMPRESO
	 */
	public String getFACE_PREIMPRESO() {
		return notNull(FACE_PREIMPRESO);
	}

	/**
	 * @param fACE_SERIE the fACE_SERIE to set
	 */
	public void setFACE_SERIE(String fACE_SERIE) {
		FACE_SERIE = notNull(fACE_SERIE);
	}

	/**
	 * @param fACE_PREIMPRESO the fACE_PREIMPRESO to set
	 */
	public void setFACE_PREIMPRESO(String fACE_PREIMPRESO) {
		FACE_PREIMPRESO = notNull(fACE_PREIMPRESO);
	}

	/**
	 * @return the fpreautoriza
	 */
	public String getFpreautoriza() {
		return notNull(fpreautoriza);
	}

	/**
	 * @return the fautoriza
	 */
	public String getFautoriza() {
		return notNull(fautoriza);
	}

	/**
	 * @return the facredita
	 */
	public String getFacredita() {
		return notNull(facredita);
	}

	/**
	 * @return the ffacturagtx
	 */
	public String getFfacturagtx() {
		return notNull(ffacturagtx);
	}

	/**
	 * @return the ffacturagua
	 */
	public String getFfacturagua() {
		return notNull(ffacturagua);
	}

	/**
	 * @return the upreautoriza
	 */
	public String getUpreautoriza() {
		return notNull(upreautoriza);
	}

	/**
	 * @return the uautoriza
	 */
	public String getUautoriza() {
		return notNull(uautoriza);
	}

	/**
	 * @return the uacredita
	 */
	public String getUacredita() {
		return notNull(uacredita);
	}

	/**
	 * @return the ufacturagtx
	 */
	public String getUfacturagtx() {
		return notNull(ufacturagtx);
	}

	/**
	 * @return the ufacturagua
	 */
	public String getUfacturagua() {
		return notNull(ufacturagua);
	}

	/**
	 * @return the liquidadorag
	 */
	public String getLiquidadorag() {
		return notNull(liquidadorag);
	}

	/**
	 * @return the liquidadoag
	 */
	public String getLiquidadoag() {
		return notNull(liquidadoag);
	}

	/**
	 * @return the nocuadrecaja
	 */
	public String getNocuadrecaja() {
		return notNull(nocuadrecaja);
	}

	/**
	 * @return the fechacuadre
	 */
	public String getFechacuadre() {
		return notNull(fechacuadre);
	}

	/**
	 * @return the nombreliqui
	 */
	public String getNombreliqui() {
		return notNull(nombreliqui);
	}

	/**
	 * @return the nombreusuli
	 */
	public String getNombreusuli() {
		return notNull(nombreusuli);
	}

	/**
	 * @return the ubicacionliqui
	 */
	public String getUbicacionliqui() {
		return notNull(ubicacionliqui);
	}

	/**
	 * @return the ubicacionusuli
	 */
	public String getUbicacionusuli() {
		return notNull(ubicacionusuli);
	}

	/**
	 * @param fpreautoriza the fpreautoriza to set
	 */
	public void setFpreautoriza(String fpreautoriza) {
		this.fpreautoriza = castFecha(fpreautoriza);
	}

	/**
	 * @param fautoriza the fautoriza to set
	 */
	public void setFautoriza(String fautoriza) {
		this.fautoriza = castFecha(fautoriza);
	}

	/**
	 * @param facredita the facredita to set
	 */
	public void setFacredita(String facredita) {
		this.facredita = castFecha(facredita);
	}

	/**
	 * @param ffacturagtx the ffacturagtx to set
	 */
	public void setFfacturagtx(String ffacturagtx) {
		this.ffacturagtx = castFecha(ffacturagtx);
	}

	/**
	 * @param ffacturagua the ffacturagua to set
	 */
	public void setFfacturagua(String ffacturagua) {
		this.ffacturagua = castFecha(ffacturagua);
	}

	/**
	 * @param upreautoriza the upreautoriza to set
	 */
	public void setUpreautoriza(String upreautoriza) {
		this.upreautoriza = notNull(upreautoriza);
	}

	/**
	 * @param uautoriza the uautoriza to set
	 */
	public void setUautoriza(String uautoriza) {
		this.uautoriza = notNull(uautoriza);
	}

	/**
	 * @param uacredita the uacredita to set
	 */
	public void setUacredita(String uacredita) {
		this.uacredita = notNull(uacredita);
	}

	/**
	 * @param ufacturagtx the ufacturagtx to set
	 */
	public void setUfacturagtx(String ufacturagtx) {
		this.ufacturagtx = notNull(ufacturagtx);
	}

	/**
	 * @param ufacturagua the ufacturagua to set
	 */
	public void setUfacturagua(String ufacturagua) {
		this.ufacturagua = notNull(ufacturagua);
	}

	/**
	 * @param liquidadorag the liquidadorag to set
	 */
	public void setLiquidadorag(String liquidadorag) {
		this.liquidadorag = notNull(liquidadorag);
	}

	/**
	 * @param liquidadoag the liquidadoag to set
	 */
	public void setLiquidadoag(String liquidadoag) {
		this.liquidadoag = notNull(liquidadoag);
	}

	/**
	 * @param nocuadrecaja the nocuadrecaja to set
	 */
	public void setNocuadrecaja(String nocuadrecaja) {
		this.nocuadrecaja = notNull(nocuadrecaja);
	}

	/**
	 * @param fechacuadre the fechacuadre to set
	 */
	public void setFechacuadre(String fechacuadre) {
		this.fechacuadre = castFecha(fechacuadre);
	}

	/**
	 * @param nombreliqui the nombreliqui to set
	 */
	public void setNombreliqui(String nombreliqui) {
		this.nombreliqui = notNull(nombreliqui);
	}

	/**
	 * @param nombreusuli the nombreusuli to set
	 */
	public void setNombreusuli(String nombreusuli) {
		this.nombreusuli = notNull(nombreusuli);
	}

	/**
	 * @param ubicacionliqui the ubicacionliqui to set
	 */
	public void setUbicacionliqui(String ubicacionliqui) {
		this.ubicacionliqui = notNull(ubicacionliqui);
	}

	/**
	 * @param ubicacionusuli the ubicacionusuli to set
	 */
	public void setUbicacionusuli(String ubicacionusuli) {
		this.ubicacionusuli = notNull(ubicacionusuli);
	}

	/**
	 * @return the banco
	 */
	public String getBanco() {
		return notNull(banco);
	}

	/**
	 * @return the noCuenta
	 */
	public String getNoCuenta() {
		return notNull(noCuenta);
	}

	/**
	 * @param banco the banco to set
	 */
	public void setBanco(String banco) {
		this.banco = notNull(banco);
	}

	/**
	 * @param noCuenta the noCuenta to set
	 */
	public void setNoCuenta(String noCuenta) {
		this.noCuenta = notNull(noCuenta);
	}

	/**
	 * @return the fEMISION
	 */
	public String getFEmision() {
		return notNull(FEmision);
	}


	/**
	 * @param fEMISION the fEMISION to set
	 */
	public void setFEMISION(String fEMISION) {
		FEmision = notNull(fEMISION);
	}

	/**
	 * @return the tIPO_COBRO
	 */
	public String getTIPO_COBRO() {
		return notNull(TIPO_COBRO);
	}


	/**
	 * @param tIPO_COBRO the tIPO_COBRO to set
	 */
	public void setTIPO_COBRO(String tIPO_COBRO) {
		TIPO_COBRO = notNull(tIPO_COBRO);
	}
}
