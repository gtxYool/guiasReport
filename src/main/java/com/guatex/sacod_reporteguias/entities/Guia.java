/**
 * @autor DylanYool
 */
package com.guatex.sacod_reporteguias.entities;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.guatex.sacod_reporteguias.utilities.Gtools;

public class Guia {

	private String CODCOB, FECHA, NOGUIA, P_ESTATUS, COD_VALORACOBRAR, COD_RECIBO, NOMREM, DIRREM1, TELREM, NOMDES,
			DIRDES1, P_RECIBIO, PFECHA, TELDES, PTOORI, PTODES, LLAVECLIENTE, IdReporte, FACE_SERIE, FACE_PREIMPRESO,
			SERIECOD, FACTURACOD, LIQUIDADO, FPREAUTORIZA, FAUTORIZA, FACREDITA, FFACTURAGTX, FFACTURAGUA, UPREAUTORIZA,
			UAUTORIZA, UACREDITA, UFACTURAGTX, UFACTURAGUA, LIQUIDADORAG, LIQUIDADOAG, NOCUADRECAJA, FECHACUADRE,
			NOMBRELIQUI, NOMBREUSULI, UBICACIONLIQUI, UBICACIONUSULI, ESTADO, FEMISION, TIPO_COBRO, RUTA, VALORSERVICIO,
			VALORACREDITAR;

	public Guia() {
	}


	private String replace(String var) {
		var = Gtools.notNull(var);
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
		fecha = Gtools.notNull(fecha);
		if (fecha.isEmpty()) {
			return fecha;
		} else {
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				fecha = (format2.format(format.parse(fecha)));
			} catch (ParseException ex) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				try {
					fecha = (format2.format(format.parse(fecha)));
				} catch (ParseException e) {
				}
			}
			return fecha;
		}
	}
	// -----GETTERS AND SETTERS----------//

	/**
	 * @return the cODCOB
	 */
	public String getCODCOB() {
		return Gtools.notNull(CODCOB);
	}

	/**
	 * @param cODCOB the cODCOB to set
	 */
	public void setCODCOB(String cODCOB) {
		CODCOB = Gtools.notNull(cODCOB);
	}

	/**
	 * @return the fECHA
	 */
	public String getFECHA() {
		return Gtools.notNull(FECHA);
	}

	/**
	 * @param fECHA the fECHA to set
	 */
	public void setFECHA(String fECHA) {
		FECHA = Gtools.notNull(fECHA);
	}

	/**
	 * @return the nOGUIA
	 */
	public String getNOGUIA() {
		return Gtools.notNull(NOGUIA);
	}

	/**
	 * @param nOGUIA the nOGUIA to set
	 */
	public void setNOGUIA(String nOGUIA) {
		NOGUIA = Gtools.notNull(nOGUIA);
	}

	/**
	 * @return the cOD_VALORACOBRAR
	 */
	public String getCOD_VALORACOBRAR() {
		return Gtools.redondearString(COD_VALORACOBRAR);
	}

	/**
	 * @param cOD_VALORACOBRAR the cOD_VALORACOBRAR to set
	 */
	public void setCOD_VALORACOBRAR(String cOD_VALORACOBRAR) {
		COD_VALORACOBRAR = Gtools.redondearString(cOD_VALORACOBRAR);
	}

	/**
	 * @return the cOD_RECIBO
	 */
	public String getCOD_RECIBO() {
		return Gtools.notNull(COD_RECIBO);
	}

	/**
	 * @param cOD_RECIBO the cOD_RECIBO to set
	 */
	public void setCOD_RECIBO(String cOD_RECIBO) {
		COD_RECIBO = Gtools.notNull(cOD_RECIBO);
	}

	/**
	 * @return the nOMREM
	 */
	public String getNOMREM() {
		return Gtools.notNull(NOMREM);
	}

	/**
	 * @param nOMREM the nOMREM to set
	 */
	public void setNOMREM(String nOMREM) {
		NOMREM = Gtools.notNull(nOMREM);
	}

	/**
	 * @return the dIRREM1
	 */
	public String getDIRREM1() {
		return Gtools.notNull(DIRREM1);
	}

	/**
	 * @param dIRREM1 the dIRREM1 to set
	 */
	public void setDIRREM1(String dIRREM1) {
		DIRREM1 = Gtools.notNull(dIRREM1);
	}

	/**
	 * @return the tELREM
	 */
	public String getTELREM() {
		return Gtools.notNull(TELREM);
	}

	/**
	 * @param tELREM the tELREM to set
	 */
	public void setTELREM(String tELREM) {
		TELREM = Gtools.notNull(tELREM);
	}

	/**
	 * @return the nOMDES
	 */
	public String getNOMDES() {
		return Gtools.notNull(NOMDES);
	}

	/**
	 * @param nOMDES the nOMDES to set
	 */
	public void setNOMDES(String nOMDES) {
		NOMDES = Gtools.notNull(nOMDES);
	}

	/**
	 * @return the dIRDES1
	 */
	public String getDIRDES1() {
		return Gtools.notNull(DIRDES1);
	}

	/**
	 * @param dIRDES1 the dIRDES1 to set
	 */
	public void setDIRDES1(String dIRDES1) {
		DIRDES1 = Gtools.notNull(dIRDES1);
	}

	/**
	 * @return the p_RECIBIO
	 */
	public String getP_RECIBIO() {
		return Gtools.notNull(P_RECIBIO);
	}

	/**
	 * @param p_RECIBIO the p_RECIBIO to set
	 */
	public void setP_RECIBIO(String p_RECIBIO) {
		P_RECIBIO = Gtools.notNull(p_RECIBIO);
	}

	/**
	 * @return the hORAPOD
	 */
	public String getPFECHA() {
		return Gtools.notNull(PFECHA);
	}

	/**
	 * @param pFecha the hORAPOD to set
	 */
	public void setPFECHA(String pFecha) {
		PFECHA = Gtools.notNull(pFecha);
	}

	/**
	 * @return the tELDES
	 */
	public String getTELDES() {
		return Gtools.notNull(TELDES);
	}

	/**
	 * @param tELDES the tELDES to set
	 */
	public void setTELDES(String tELDES) {
		TELDES = Gtools.notNull(tELDES);
	}

	/**
	 * @return the pTOORI
	 */
	public String getPTOORI() {
		return Gtools.notNull(PTOORI);
	}

	/**
	 * @param pTOORI the pTOORI to set
	 */
	public void setPTOORI(String pTOORI) {
		PTOORI = Gtools.notNull(pTOORI);
	}

	/**
	 * @return the pTODES
	 */
	public String getPTODES() {
		return Gtools.notNull(PTODES);
	}

	/**
	 * @param pTODES the pTODES to set
	 */
	public void setPTODES(String pTODES) {
		PTODES = Gtools.notNull(pTODES);
	}

	/**
	 * @return the lLAVECLIENTE
	 */
	public String getLLAVECLIENTE() {
		return Gtools.notNull(LLAVECLIENTE);
	}

	/**
	 * @param lLAVECLIENTE the lLAVECLIENTE to set
	 */
	public void setLLAVECLIENTE(String lLAVECLIENTE) {
		LLAVECLIENTE = Gtools.notNull(lLAVECLIENTE);
	}

	/**
	 * @return the p_ESTATUS
	 */
	public String getP_ESTATUS() {
		return Gtools.notNull(P_ESTATUS);
	}

	/**
	 * @param p_ESTATUS the p_ESTATUS to set
	 */
	public void setP_ESTATUS(String p_ESTATUS) {
		P_ESTATUS = replace(p_ESTATUS);
	}

	/**
	 * 
	 * @return
	 */
	public String getIdReporte() {
		return Gtools.notNull(IdReporte);
	}

	/**
	 * 
	 * @param idReporte
	 */
	public void setIdReporte(String idReporte) {
		IdReporte = Gtools.notNull(idReporte);
	}

	/**
	 * @return the fACE_SERIE
	 */
	public String getFACE_SERIE() {
		return Gtools.notNull(FACE_SERIE);
	}

	/**
	 * @return the fACE_PREIMPRESO
	 */
	public String getFACE_PREIMPRESO() {
		return Gtools.notNull(FACE_PREIMPRESO);
	}

	/**
	 * @return the sERIEFACTURA
	 */
	public String getSERIECOD() {
		return Gtools.notNull(SERIECOD);
	}

	/**
	 * @return the fACTURA
	 */
	public String getFACTURACOD() {
		return Gtools.notNull(FACTURACOD);
	}

	/**
	 * @return the lIQUIDADO
	 */
	public String getLIQUIDADO() {
		return Gtools.notNull(LIQUIDADO);
	}

	/**
	 * @param fACE_SERIE the fACE_SERIE to set
	 */
	public void setFACE_SERIE(String fACE_SERIE) {
		FACE_SERIE = Gtools.notNull(fACE_SERIE);
	}

	/**
	 * @param fACE_PREIMPRESO the fACE_PREIMPRESO to set
	 */
	public void setFACE_PREIMPRESO(String fACE_PREIMPRESO) {
		FACE_PREIMPRESO = Gtools.notNull(fACE_PREIMPRESO);
	}

	/**
	 * @param sERIEFACTURA the sERIEFACTURA to set
	 */
	public void setSERIECOD(String sERIECOD) {
		SERIECOD = Gtools.notNull(sERIECOD);
	}

	/**
	 * @param fACTURA the fACTURA to set
	 */
	public void setFACTURACOD(String fACTURACOD) {
		FACTURACOD = Gtools.notNull(fACTURACOD);
	}

	/**
	 * @param lIQUIDADO the lIQUIDADO to set
	 */
	public void setLIQUIDADO(String lIQUIDADO) {
		LIQUIDADO = replace(lIQUIDADO);
	}

	/**
	 * @return the fPREAUTORIZA
	 */
	public String getFPREAUTORIZA() {
		return Gtools.notNull(FPREAUTORIZA);
	}

	/**
	 * @return the fAUTORIZA
	 */
	public String getFAUTORIZA() {
		return Gtools.notNull(FAUTORIZA);
	}

	/**
	 * @return the fACREDITA
	 */
	public String getFACREDITA() {
		return Gtools.notNull(FACREDITA);
	}

	/**
	 * @return the fFACTURAGTX
	 */
	public String getFFACTURAGTX() {
		return Gtools.notNull(FFACTURAGTX);
	}

	/**
	 * @return the fFACTURAGUA
	 */
	public String getFFACTURAGUA() {
		return Gtools.notNull(FFACTURAGUA);
	}

	/**
	 * @return the uPREAUTORIZA
	 */
	public String getUPREAUTORIZA() {
		return Gtools.notNull(UPREAUTORIZA);
	}

	/**
	 * @return the uAUTORIZA
	 */
	public String getUAUTORIZA() {
		return Gtools.notNull(UAUTORIZA);
	}

	/**
	 * @return the uACREDITA
	 */
	public String getUACREDITA() {
		return Gtools.notNull(UACREDITA);
	}

	/**
	 * @return the uFACTURAGTX
	 */
	public String getUFACTURAGTX() {
		return Gtools.notNull(UFACTURAGTX);
	}

	/**
	 * @return the uFACTURAGUA
	 */
	public String getUFACTURAGUA() {
		return Gtools.notNull(UFACTURAGUA);
	}

	/**
	 * @return the lIQUIDADORAG
	 */
	public String getLIQUIDADORAG() {
		return Gtools.notNull(LIQUIDADORAG);
	}

	/**
	 * @return the lIQUIDADOAG
	 */
	public String getLIQUIDADOAG() {
		return Gtools.notNull(LIQUIDADOAG);
	}

	/**
	 * @return the nOCUADRECAJA
	 */
	public String getNOCUADRECAJA() {
		return Gtools.notNull(NOCUADRECAJA);
	}

	/**
	 * @return the fECHACUADRE
	 */
	public String getFECHACUADRE() {
		return Gtools.notNull(FECHACUADRE);
	}

	/**
	 * @return the nOMBRELIQUI
	 */
	public String getNOMBRELIQUI() {
		return Gtools.notNull(NOMBRELIQUI);
	}

	/**
	 * @return the nOMBREUSULI
	 */
	public String getNOMBREUSULI() {
		return Gtools.notNull(NOMBREUSULI);
	}

	/**
	 * @return the uBICACIONLIQUI
	 */
	public String getUBICACIONLIQUI() {
		return Gtools.notNull(UBICACIONLIQUI);
	}

	/**
	 * @return the uBICACIONUSULI
	 */
	public String getUBICACIONUSULI() {
		return Gtools.notNull(UBICACIONUSULI);
	}

	/**
	 * @param fPREAUTORIZA the fPREAUTORIZA to set
	 */
	public void setFPREAUTORIZA(String fPREAUTORIZA) {
		FPREAUTORIZA = castFecha(fPREAUTORIZA);
	}

	/**
	 * @param fAUTORIZA the fAUTORIZA to set
	 */
	public void setFAUTORIZA(String fAUTORIZA) {
		FAUTORIZA = castFecha(fAUTORIZA);
	}

	/**
	 * @param fACREDITA the fACREDITA to set
	 */
	public void setFACREDITA(String fACREDITA) {
		FACREDITA = castFecha(fACREDITA);
	}

	/**
	 * @param fFACTURAGTX the fFACTURAGTX to set
	 */
	public void setFFACTURAGTX(String fFACTURAGTX) {
		FFACTURAGTX = castFecha(fFACTURAGTX);
	}

	/**
	 * @param fFACTURAGUA the fFACTURAGUA to set
	 */
	public void setFFACTURAGUA(String fFACTURAGUA) {
		FFACTURAGUA = castFecha(fFACTURAGUA);
	}

	/**
	 * @param uPREAUTORIZA the uPREAUTORIZA to set
	 */
	public void setUPREAUTORIZA(String uPREAUTORIZA) {
		UPREAUTORIZA = Gtools.notNull(uPREAUTORIZA);
	}

	/**
	 * @param uAUTORIZA the uAUTORIZA to set
	 */
	public void setUAUTORIZA(String uAUTORIZA) {
		UAUTORIZA = Gtools.notNull(uAUTORIZA);
	}

	/**
	 * @param uACREDITA the uACREDITA to set
	 */
	public void setUACREDITA(String uACREDITA) {
		UACREDITA = Gtools.notNull(uACREDITA);
	}

	/**
	 * @param uFACTURAGTX the uFACTURAGTX to set
	 */
	public void setUFACTURAGTX(String uFACTURAGTX) {
		UFACTURAGTX = Gtools.notNull(uFACTURAGTX);
	}

	/**
	 * @param uFACTURAGUA the uFACTURAGUA to set
	 */
	public void setUFACTURAGUA(String uFACTURAGUA) {
		UFACTURAGUA = Gtools.notNull(uFACTURAGUA);
	}

	/**
	 * @param lIQUIDADORAG the lIQUIDADORAG to set
	 */
	public void setLIQUIDADORAG(String lIQUIDADORAG) {
		LIQUIDADORAG = Gtools.notNull(lIQUIDADORAG);
	}

	/**
	 * @param lIQUIDADOAG the lIQUIDADOAG to set
	 */
	public void setLIQUIDADOAG(String lIQUIDADOAG) {
		LIQUIDADOAG = Gtools.notNull(lIQUIDADOAG);
	}

	/**
	 * @param nOCUADRECAJA the nOCUADRECAJA to set
	 */
	public void setNOCUADRECAJA(String nOCUADRECAJA) {
		NOCUADRECAJA = Gtools.notNull(nOCUADRECAJA);
	}

	/**
	 * @param fECHACUADRE the fECHACUADRE to set
	 */
	public void setFECHACUADRE(String fECHACUADRE) {
		FECHACUADRE = castFecha(fECHACUADRE);
	}

	/**
	 * @param nOMBRELIQUI the nOMBRELIQUI to set
	 */
	public void setNOMBRELIQUI(String nOMBRELIQUI) {
		NOMBRELIQUI = Gtools.notNull(nOMBRELIQUI);
	}

	/**
	 * @param nOMBREUSULI the nOMBREUSULI to set
	 */
	public void setNOMBREUSULI(String nOMBREUSULI) {
		NOMBREUSULI = Gtools.notNull(nOMBREUSULI);
	}

	/**
	 * @param uBICACIONLIQUI the uBICACIONLIQUI to set
	 */
	public void setUBICACIONLIQUI(String uBICACIONLIQUI) {
		UBICACIONLIQUI = Gtools.notNull(uBICACIONLIQUI);
	}

	/**
	 * @param uBICACIONUSULI the uBICACIONUSULI to set
	 */
	public void setUBICACIONUSULI(String uBICACIONUSULI) {
		UBICACIONUSULI = Gtools.notNull(uBICACIONUSULI);
	}

	/**
	 * @return the eSTADO
	 */
	public String getESTADO() {
		return Gtools.notNull(ESTADO);
	}

	/**
	 * @return the fEMISION
	 */
	public String getFEMISION() {
		return Gtools.notNull(FEMISION);
	}

	/**
	 * @param fEMISION the fEMISION to set
	 */
	public void setFEMISION(String fEMISION) {
		FEMISION = Gtools.notNull(fEMISION);
	}

	/**
	 * @return the tIPO_COBRO
	 */
	public String getTIPO_COBRO() {
		return Gtools.notNull(TIPO_COBRO);
	}

	/**
	 * @param tIPO_COBRO the tIPO_COBRO to set
	 */
	public void setTIPO_COBRO(String tIPO_COBRO) {
		TIPO_COBRO = Gtools.notNull(tIPO_COBRO);
	}

	/**
	 * @return the RUTA
	 */
	public String getRUTA() {
		return Gtools.notNull(RUTA);
	}

	/**
	 * @param tIPO_COBRO the Ruta to set
	 */
	public void setRUTA(String Ruta) {
		RUTA = Gtools.notNull(Ruta);
	}

	/**
	 * @return the vALORSERVICIO
	 */
	public String getVALORSERVICIO() {
		return Gtools.notNull(VALORSERVICIO);
	}

	/**
	 * @return the vALORACREDITAR
	 */
	public String getVALORACREDITAR() {
		return Gtools.notNull(VALORACREDITAR);
	}

	/**
	 * @param vALORSERVICIO the vALORSERVICIO to set
	 */
	public void setVALORSERVICIO(String vALORSERVICIO) {
		VALORSERVICIO = Gtools.notNull(vALORSERVICIO);
	}

	/**
	 * @param vALORACREDITAR the vALORACREDITAR to set
	 */
	public void setVALORACREDITAR(String vALORACREDITAR) {
		VALORACREDITAR = Gtools.notNull(vALORACREDITAR);
	}

	/**
	 * @param eSTADO the eSTADO to set
	 */
	public void setESTADO(String eSTADO) {
		eSTADO = Gtools.notNull(eSTADO);
		switch (eSTADO) {
		case "N":
			this.ESTADO = "PENDIENTE";
			break;
		case "A":
			this.ESTADO = "ANULADA";
			break;
		case "V":
			this.ESTADO = "CONSOLIDADA";
			break;
		default:
			this.ESTADO = "";
			break;
		}
	}

}
