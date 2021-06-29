
package com.guatex.sacod_reporteguias.dao;

import java.sql.CallableStatement;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.guatex.sacod_reporteguias.entities.*;

/**
 * @autor DylanYool
 */
public class Guias_Querys extends Conexion {
	public static final Logger logger = LogManager.getLogger(Guias_Querys.class);
	private Connection con;
	private ResultSet rs;
	private CallableStatement cs;
	private PreparedStatement ps;

	// REPORTE GUIASCOD GENERAL
	public List<Guia> getGuiasCOD_General(String fechaIni, String fechaFin) throws SQLException {
		List<Guia> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_General(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			rs = cs.executeQuery();
			guias = new LinkedList<Guia>();
			while (rs.next()) {
				Guia guia = new Guia();
				guia.setCODCOB(rs.getString("CODCOB"));
				guia.setFECHA(rs.getString("FECHA"));
				guia.setNOGUIA(rs.getString("NOGUIA"));
				guia.setP_ESTATUS(rs.getString("P_ESTATUS"));
				guia.setCOD_VALORACOBRAR(rs.getString("COD_VALORACOBRAR"));
				guia.setCOD_RECIBO(rs.getString("RECIBOCOD"));
				guia.setSERIECOD(rs.getString("SERIECOD"));
				guia.setFACTURACOD(rs.getString("FACTURACOD"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setLIQUIDADO(rs.getString("LIQUIDADO"));
				guia.setNOMREM(rs.getString("NOMREM"));
				guia.setDIRREM1(rs.getString("DIRREM1"));
				guia.setTELREM(rs.getString("TELREM"));
				guia.setNOMDES(rs.getString("NOMDES"));
				guia.setDIRDES1(rs.getString("DIRDES1"));
				guia.setP_RECIBIO(rs.getString("P_RECIBIO"));

				guia.setPFECHA(rs.getString("P_FECHA"));
				guia.setTELDES(rs.getString("TELDES"));
				guia.setPTOORI(rs.getString("PTOORI"));
				guia.setPTODES(rs.getString("PTODES"));
				guia.setLLAVECLIENTE(rs.getString("LLAVECLIENTE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setFPREAUTORIZA(rs.getString("FPREAUTORIZA"));
				guia.setFAUTORIZA(rs.getString("FAUTORIZA"));
				guia.setFACREDITA(rs.getString("FACREDITA"));
				guia.setFFACTURAGTX(rs.getString("FFACTURAGTX"));
				guia.setFFACTURAGUA(rs.getString("FFACTURAGUA"));
				guia.setUPREAUTORIZA(rs.getString("UPREAUTORIZA"));
				guia.setUAUTORIZA(rs.getString("UAUTORIZA"));
				guia.setUACREDITA(rs.getString("UACREDITA"));
				guia.setUFACTURAGTX(rs.getString("UFACTURAGTX"));
				guia.setUFACTURAGUA(rs.getString("UFACTURAGUA"));
				guia.setLIQUIDADORAG(rs.getString("LIQUIDADORAG"));
				guia.setLIQUIDADOAG(rs.getString("LIQUIDADOAG"));
				guia.setNOCUADRECAJA(rs.getString("NOCUADRECAJA"));
				guia.setESTADO(rs.getString("ESTADO"));
				guia.setFECHACUADRE(rs.getString("FECHACUADRE"));
				guia.setNOMBRELIQUI(rs.getString("NOMBRELIQUI"));
				guia.setNOMBREUSULI(rs.getString("NOMBREUSULI"));
				guia.setUBICACIONLIQUI(rs.getString("UBICACIONLIQUI"));
				guia.setUBICACIONUSULI(rs.getString("UBICACIONUSULI"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	// REPORTE GUIASCOD GENERAL X CLIENTE
	public List<Guia> getGuiasCOD_GeneralXCliente(String fechaIni, String fechaFin, String CodCob) throws SQLException {
		List<Guia> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_GeneralXCliente(?,?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			cs.setString(3, CodCob);
			rs = cs.executeQuery();
			guias = new LinkedList<Guia>();
			while (rs.next()) {
				Guia guia = new Guia();
				guia.setCODCOB(rs.getString("CODCOB"));
				guia.setFECHA(rs.getString("FECHA"));
				guia.setNOGUIA(rs.getString("NOGUIA"));
				guia.setP_ESTATUS(rs.getString("P_ESTATUS"));
				guia.setCOD_VALORACOBRAR(rs.getString("COD_VALORACOBRAR"));
				guia.setCOD_RECIBO(rs.getString("RECIBOCOD"));
				guia.setNOMREM(rs.getString("NOMREM"));
				guia.setDIRREM1(rs.getString("DIRREM1"));
				guia.setTELREM(rs.getString("TELREM"));
				guia.setNOMDES(rs.getString("NOMDES"));
				guia.setDIRDES1(rs.getString("DIRDES1"));
				guia.setP_RECIBIO(rs.getString("P_RECIBIO"));
				guia.setPFECHA(rs.getString("P_FECHA"));
				guia.setTELDES(rs.getString("TELDES"));
				guia.setPTOORI(rs.getString("PTOORI"));
				guia.setPTODES(rs.getString("PTODES"));
				guia.setLLAVECLIENTE(rs.getString("LLAVECLIENTE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setSERIECOD(rs.getString("SERIECOD"));
				guia.setFACTURACOD(rs.getString("FACTURACOD"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setLIQUIDADO(rs.getString("LIQUIDADO"));
				guia.setFPREAUTORIZA(rs.getString("FPREAUTORIZA"));
				guia.setFAUTORIZA(rs.getString("FAUTORIZA"));
				guia.setFACREDITA(rs.getString("FACREDITA"));
				guia.setFFACTURAGTX(rs.getString("FFACTURAGTX"));
				guia.setFFACTURAGUA(rs.getString("FFACTURAGUA"));
				guia.setUPREAUTORIZA(rs.getString("UPREAUTORIZA"));
				guia.setUAUTORIZA(rs.getString("UAUTORIZA"));
				guia.setUACREDITA(rs.getString("UACREDITA"));
				guia.setUFACTURAGTX(rs.getString("UFACTURAGTX"));
				guia.setUFACTURAGUA(rs.getString("UFACTURAGUA"));
				guia.setLIQUIDADORAG(rs.getString("LIQUIDADORAG"));
				guia.setLIQUIDADOAG(rs.getString("LIQUIDADOAG"));
				guia.setNOCUADRECAJA(rs.getString("NOCUADRECAJA"));
				guia.setESTADO(rs.getString("ESTADO"));
				guia.setFECHACUADRE(rs.getString("FECHACUADRE"));
				guia.setNOMBRELIQUI(rs.getString("NOMBRELIQUI"));
				guia.setNOMBREUSULI(rs.getString("NOMBREUSULI"));
				guia.setUBICACIONLIQUI(rs.getString("UBICACIONLIQUI"));
				guia.setUBICACIONUSULI(rs.getString("UBICACIONUSULI"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));

				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	// REPORTE GUIASCOD ENTREGADAS
	public List<Guia> getGuiasCOD_Entregadas(String fechaIni, String fechaFin) throws SQLException {
		List<Guia> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_Entregadas(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			rs = cs.executeQuery();
			guias = new LinkedList<Guia>();
			while (rs.next()) {
				Guia guia = new Guia();
				guia.setCODCOB(rs.getString("CODCOB"));
				guia.setFECHA(rs.getString("FECHA"));
				guia.setNOGUIA(rs.getString("NOGUIA"));
				guia.setCOD_VALORACOBRAR(rs.getString("COD_VALORACOBRAR"));
				guia.setCOD_RECIBO(rs.getString("RECIBOCOD"));
				guia.setNOMREM(rs.getString("NOMREM"));
				guia.setDIRREM1(rs.getString("DIRREM1"));
				guia.setTELREM(rs.getString("TELREM"));
				guia.setNOMDES(rs.getString("NOMDES"));
				guia.setDIRDES1(rs.getString("DIRDES1"));
				guia.setP_RECIBIO(rs.getString("P_RECIBIO"));
				guia.setPFECHA(rs.getString("P_FECHA"));
				guia.setTELDES(rs.getString("TELDES"));
				guia.setPTOORI(rs.getString("PTOORI"));
				guia.setPTODES(rs.getString("PTODES"));
				guia.setLLAVECLIENTE(rs.getString("LLAVECLIENTE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setSERIECOD(rs.getString("SERIECOD"));
				guia.setFACTURACOD(rs.getString("FACTURACOD"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setLIQUIDADO(rs.getString("LIQUIDADO"));
				guia.setFPREAUTORIZA(rs.getString("FPREAUTORIZA"));
				guia.setFAUTORIZA(rs.getString("FAUTORIZA"));
				guia.setFACREDITA(rs.getString("FACREDITA"));
				guia.setFFACTURAGTX(rs.getString("FFACTURAGTX"));
				guia.setFFACTURAGUA(rs.getString("FFACTURAGUA"));
				guia.setUPREAUTORIZA(rs.getString("UPREAUTORIZA"));
				guia.setUAUTORIZA(rs.getString("UAUTORIZA"));
				guia.setUACREDITA(rs.getString("UACREDITA"));
				guia.setUFACTURAGTX(rs.getString("UFACTURAGTX"));
				guia.setUFACTURAGUA(rs.getString("UFACTURAGUA"));
				guia.setLIQUIDADORAG(rs.getString("LIQUIDADORAG"));
				guia.setLIQUIDADOAG(rs.getString("LIQUIDADOAG"));
				guia.setNOCUADRECAJA(rs.getString("NOCUADRECAJA"));
				guia.setESTADO(rs.getString("ESTADO"));
				guia.setFECHACUADRE(rs.getString("FECHACUADRE"));
				guia.setNOMBRELIQUI(rs.getString("NOMBRELIQUI"));
				guia.setNOMBREUSULI(rs.getString("NOMBREUSULI"));
				guia.setUBICACIONLIQUI(rs.getString("UBICACIONLIQUI"));
				guia.setUBICACIONUSULI(rs.getString("UBICACIONUSULI"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	// REPORTE GUIASCOD ENTREGADAS X CLIENTES
	public List<Guia> getGuiasCOD_EntregadasXCliente(String fechaIni, String fechaFin, String CodCob)
			throws SQLException {
		List<Guia> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_EntregadasXCliente(?,?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			cs.setString(3, CodCob);
			rs = cs.executeQuery();
			guias = new LinkedList<Guia>();
			while (rs.next()) {
				Guia guia = new Guia();
				guia.setCODCOB(rs.getString("CODCOB"));
				guia.setFECHA(rs.getString("FECHA"));
				guia.setNOGUIA(rs.getString("NOGUIA"));
				guia.setCOD_VALORACOBRAR(rs.getString("COD_VALORACOBRAR"));
				guia.setCOD_RECIBO(rs.getString("RECIBOCOD"));
				guia.setNOMREM(rs.getString("NOMREM"));
				guia.setDIRREM1(rs.getString("DIRREM1"));
				guia.setTELREM(rs.getString("TELREM"));
				guia.setNOMDES(rs.getString("NOMDES"));
				guia.setDIRDES1(rs.getString("DIRDES1"));
				guia.setP_RECIBIO(rs.getString("P_RECIBIO"));
				guia.setPFECHA(rs.getString("P_FECHA"));
				guia.setTELDES(rs.getString("TELDES"));
				guia.setPTOORI(rs.getString("PTOORI"));
				guia.setPTODES(rs.getString("PTODES"));
				guia.setLLAVECLIENTE(rs.getString("LLAVECLIENTE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setSERIECOD(rs.getString("SERIECOD"));
				guia.setFACTURACOD(rs.getString("FACTURACOD"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setLIQUIDADO(rs.getString("LIQUIDADO"));
				guia.setFPREAUTORIZA(rs.getString("FPREAUTORIZA"));
				guia.setFAUTORIZA(rs.getString("FAUTORIZA"));
				guia.setFACREDITA(rs.getString("FACREDITA"));
				guia.setFFACTURAGTX(rs.getString("FFACTURAGTX"));
				guia.setFFACTURAGUA(rs.getString("FFACTURAGUA"));
				guia.setUPREAUTORIZA(rs.getString("UPREAUTORIZA"));
				guia.setUAUTORIZA(rs.getString("UAUTORIZA"));
				guia.setUACREDITA(rs.getString("UACREDITA"));
				guia.setUFACTURAGTX(rs.getString("UFACTURAGTX"));
				guia.setUFACTURAGUA(rs.getString("UFACTURAGUA"));
				guia.setLIQUIDADORAG(rs.getString("LIQUIDADORAG"));
				guia.setLIQUIDADOAG(rs.getString("LIQUIDADOAG"));
				guia.setNOCUADRECAJA(rs.getString("NOCUADRECAJA"));
				guia.setESTADO(rs.getString("ESTADO"));
				guia.setFECHACUADRE(rs.getString("FECHACUADRE"));
				guia.setNOMBRELIQUI(rs.getString("NOMBRELIQUI"));
				guia.setNOMBREUSULI(rs.getString("NOMBREUSULI"));
				guia.setUBICACIONLIQUI(rs.getString("UBICACIONLIQUI"));
				guia.setUBICACIONUSULI(rs.getString("UBICACIONUSULI"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	// REPORTE GUIASCOD NO ENTREGADAS
	public List<Guia> getGuiasCOD_Recolectadas(String fechaIni, String fechaFin) throws SQLException {
		List<Guia> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_Recolectadas(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			rs = cs.executeQuery();
			guias = new LinkedList<Guia>();
			while (rs.next()) {
				Guia guia = new Guia();
				guia.setCODCOB(rs.getString("CODCOB"));
				guia.setFECHA(rs.getString("FECHA"));
				guia.setNOGUIA(rs.getString("NOGUIA"));
				guia.setCOD_VALORACOBRAR(rs.getString("COD_VALORACOBRAR"));
				guia.setCOD_RECIBO(rs.getString("RECIBOCOD"));
				guia.setNOMREM(rs.getString("NOMREM"));
				guia.setDIRREM1(rs.getString("DIRREM1"));
				guia.setTELREM(rs.getString("TELREM"));
				guia.setNOMDES(rs.getString("NOMDES"));
				guia.setDIRDES1(rs.getString("DIRDES1"));
				guia.setP_RECIBIO(rs.getString("P_RECIBIO"));
				guia.setPFECHA(rs.getString("P_FECHA"));
				guia.setTELDES(rs.getString("TELDES"));
				guia.setPTOORI(rs.getString("PTOORI"));
				guia.setPTODES(rs.getString("PTODES"));
				guia.setLLAVECLIENTE(rs.getString("LLAVECLIENTE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setSERIECOD(rs.getString("SERIECOD"));
				guia.setFACTURACOD(rs.getString("FACTURACOD"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setLIQUIDADO(rs.getString("LIQUIDADO"));
				guia.setFPREAUTORIZA(rs.getString("FPREAUTORIZA"));
				guia.setFAUTORIZA(rs.getString("FAUTORIZA"));
				guia.setFACREDITA(rs.getString("FACREDITA"));
				guia.setFFACTURAGTX(rs.getString("FFACTURAGTX"));
				guia.setFFACTURAGUA(rs.getString("FFACTURAGUA"));
				guia.setUPREAUTORIZA(rs.getString("UPREAUTORIZA"));
				guia.setUAUTORIZA(rs.getString("UAUTORIZA"));
				guia.setUACREDITA(rs.getString("UACREDITA"));
				guia.setUFACTURAGTX(rs.getString("UFACTURAGTX"));
				guia.setUFACTURAGUA(rs.getString("UFACTURAGUA"));
				guia.setLIQUIDADORAG(rs.getString("LIQUIDADORAG"));
				guia.setLIQUIDADOAG(rs.getString("LIQUIDADOAG"));
				guia.setNOCUADRECAJA(rs.getString("NOCUADRECAJA"));
				guia.setESTADO(rs.getString("ESTADO"));
				guia.setFECHACUADRE(rs.getString("FECHACUADRE"));
				guia.setNOMBRELIQUI(rs.getString("NOMBRELIQUI"));
				guia.setNOMBREUSULI(rs.getString("NOMBREUSULI"));
				guia.setUBICACIONLIQUI(rs.getString("UBICACIONLIQUI"));
				guia.setUBICACIONUSULI(rs.getString("UBICACIONUSULI"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				guia.setRUTA(rs.getString("RUTA"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	// REPORTE GUIASCOD NO ENTREGADAS X CLIENTE
	public List<Guia> getGuiasCOD_RecolectadasXCliente(String fechaIni, String fechaFin, String CodCob)
			throws SQLException {
		List<Guia> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_RecolectadasXCliente(?,?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			cs.setString(3, CodCob);
			rs = cs.executeQuery();
			guias = new LinkedList<Guia>();
			while (rs.next()) {
				Guia guia = new Guia();
				guia.setCODCOB(rs.getString("CODCOB"));
				guia.setFECHA(rs.getString("FECHA"));
				guia.setNOGUIA(rs.getString("NOGUIA"));
				guia.setCOD_VALORACOBRAR(rs.getString("COD_VALORACOBRAR"));
				guia.setCOD_RECIBO(rs.getString("RECIBOCOD"));
				guia.setNOMREM(rs.getString("NOMREM"));
				guia.setDIRREM1(rs.getString("DIRREM1"));
				guia.setTELREM(rs.getString("TELREM"));
				guia.setNOMDES(rs.getString("NOMDES"));
				guia.setDIRDES1(rs.getString("DIRDES1"));
				guia.setP_RECIBIO(rs.getString("P_RECIBIO"));
				guia.setPFECHA(rs.getString("P_FECHA"));
				guia.setTELDES(rs.getString("TELDES"));
				guia.setPTOORI(rs.getString("PTOORI"));
				guia.setPTODES(rs.getString("PTODES"));
				guia.setLLAVECLIENTE(rs.getString("LLAVECLIENTE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setSERIECOD(rs.getString("SERIECOD"));
				guia.setFACTURACOD(rs.getString("FACTURACOD"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setLIQUIDADO(rs.getString("LIQUIDADO"));
				guia.setFPREAUTORIZA(rs.getString("FPREAUTORIZA"));
				guia.setFAUTORIZA(rs.getString("FAUTORIZA"));
				guia.setFACREDITA(rs.getString("FACREDITA"));
				guia.setFFACTURAGTX(rs.getString("FFACTURAGTX"));
				guia.setFFACTURAGUA(rs.getString("FFACTURAGUA"));
				guia.setUPREAUTORIZA(rs.getString("UPREAUTORIZA"));
				guia.setUAUTORIZA(rs.getString("UAUTORIZA"));
				guia.setUACREDITA(rs.getString("UACREDITA"));
				guia.setUFACTURAGTX(rs.getString("UFACTURAGTX"));
				guia.setUFACTURAGUA(rs.getString("UFACTURAGUA"));
				guia.setLIQUIDADORAG(rs.getString("LIQUIDADORAG"));
				guia.setLIQUIDADOAG(rs.getString("LIQUIDADOAG"));
				guia.setNOCUADRECAJA(rs.getString("NOCUADRECAJA"));
				guia.setESTADO(rs.getString("ESTADO"));
				guia.setFECHACUADRE(rs.getString("FECHACUADRE"));
				guia.setNOMBRELIQUI(rs.getString("NOMBRELIQUI"));
				guia.setNOMBREUSULI(rs.getString("NOMBREUSULI"));
				guia.setUBICACIONLIQUI(rs.getString("UBICACIONLIQUI"));
				guia.setUBICACIONUSULI(rs.getString("UBICACIONUSULI"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				guia.setRUTA(rs.getString("RUTA"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

//----------------------------- SOBRE GUIAS FACTURADAS ---------------------------------//
	public List<GuiaF> getGuiasCOD_Facturadas(String fechaIni, String fechaFin) throws SQLException {
		List<GuiaF> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_Facturadas(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			rs = cs.executeQuery();
			guias = new LinkedList<GuiaF>();
			while (rs.next()) {
				GuiaF guia = new GuiaF();
				guia.setCodCob(rs.getString("CODCOB"));
				guia.setFecha(rs.getString("FECHA"));
				guia.setNoguia(rs.getString("NOGUIA"));
				guia.setCod_valorACobrar(rs.getString("COD_VALORACOBRAR"));
				guia.setFacturaCOD(rs.getString("FACTURACOD"));
				guia.setSerieCOD(rs.getString("SERIECOD"));
				guia.setReciboCOD(rs.getString("RECIBOCOD"));
				guia.setLiquidado(rs.getString("LIQUIDADO"));
				guia.setValor_Servicio(rs.getString("VALORSERVICIO"));
				guia.setValorACreditar(rs.getString("VALORACREDITAR"));
				guia.setPorcentaje(rs.getString("PORCENTAJE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setFpreautoriza(rs.getString("FPREAUTORIZA"));
				guia.setFautoriza(rs.getString("FAUTORIZA"));
				guia.setFacredita(rs.getString("FACREDITA"));
				guia.setFfacturagtx(rs.getString("FFACTURAGTX"));
				guia.setFfacturagua(rs.getString("FFACTURAGUA"));
				guia.setUpreautoriza(rs.getString("UPREAUTORIZA"));
				guia.setUautoriza(rs.getString("UAUTORIZA"));
				guia.setUacredita(rs.getString("UACREDITA"));
				guia.setUfacturagtx(rs.getString("UFACTURAGTX"));
				guia.setUfacturagua(rs.getString("UFACTURAGUA"));
				guia.setLiquidadorag(rs.getString("LIQUIDADORAG"));
				guia.setLiquidadoag(rs.getString("LIQUIDADOAG"));
				guia.setNocuadrecaja(rs.getString("NOCUADRECAJA"));
				guia.setFechacuadre(rs.getString("FECHACUADRE"));
				guia.setNombreliqui(rs.getString("NOMBRELIQUI"));
				guia.setNombreusuli(rs.getString("NOMBREUSULI"));
				guia.setUbicacionliqui(rs.getString("UBICACIONLIQUI"));
				guia.setUbicacionusuli(rs.getString("UBICACIONUSULI"));
				guia.setFEMISION(rs.getString("FEMISION"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				// guia.setBanco(rs.getString("BANCO"));
				// guia.setNoCuenta(rs.getString("NOCUENTA"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("\nAlgo malió sal, err:" + e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	public List<GuiaF> getGuiasCOD_FacturadasXCliente(String fechaIni, String fechaFin, String CodCob)
			throws SQLException {
		List<GuiaF> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_FacturadasXCliente(?,?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			cs.setString(3, CodCob);
			rs = cs.executeQuery();
			guias = new LinkedList<GuiaF>();
			while (rs.next()) {
				GuiaF guia = new GuiaF();
				guia.setCodCob(rs.getString("CODCOB"));
				guia.setFecha(rs.getString("FECHA"));
				guia.setNoguia(rs.getString("NOGUIA"));
				guia.setCod_valorACobrar(rs.getString("COD_VALORACOBRAR"));
				guia.setFacturaCOD(rs.getString("FACTURACOD"));
				guia.setSerieCOD(rs.getString("SERIECOD"));
				guia.setReciboCOD(rs.getString("RECIBOCOD"));
				guia.setLiquidado(rs.getString("LIQUIDADO"));
				guia.setValor_Servicio(rs.getString("VALORSERVICIO"));
				guia.setValorACreditar(rs.getString("VALORACREDITAR"));
				guia.setPorcentaje(rs.getString("PORCENTAJE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setFpreautoriza(rs.getString("FPREAUTORIZA"));
				guia.setFautoriza(rs.getString("FAUTORIZA"));
				guia.setFacredita(rs.getString("FACREDITA"));
				guia.setFfacturagtx(rs.getString("FFACTURAGTX"));
				guia.setFfacturagua(rs.getString("FFACTURAGUA"));
				guia.setUpreautoriza(rs.getString("UPREAUTORIZA"));
				guia.setUautoriza(rs.getString("UAUTORIZA"));
				guia.setUacredita(rs.getString("UACREDITA"));
				guia.setUfacturagtx(rs.getString("UFACTURAGTX"));
				guia.setUfacturagua(rs.getString("UFACTURAGUA"));
				guia.setLiquidadorag(rs.getString("LIQUIDADORAG"));
				guia.setLiquidadoag(rs.getString("LIQUIDADOAG"));
				guia.setNocuadrecaja(rs.getString("NOCUADRECAJA"));
				guia.setFechacuadre(rs.getString("FECHACUADRE"));
				guia.setNombreliqui(rs.getString("NOMBRELIQUI"));
				guia.setNombreusuli(rs.getString("NOMBREUSULI"));
				guia.setUbicacionliqui(rs.getString("UBICACIONLIQUI"));
				guia.setUbicacionusuli(rs.getString("UBICACIONUSULI"));
				guia.setFEMISION(rs.getString("FEMISION"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				// guia.setBanco(rs.getString("BANCO"));
				// guia.setNoCuenta(rs.getString("NOCUENTA"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("\nAlgo malió sal, err:" + e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	public List<GuiaF> getGuiasCOD_NoFacturadas(String fechaIni, String fechaFin) throws SQLException {
		List<GuiaF> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_NoFacturadas(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			rs = cs.executeQuery();
			guias = new LinkedList<GuiaF>();
			while (rs.next()) {
				GuiaF guia = new GuiaF();
				guia.setCodCob(rs.getString("CODCOB"));
				guia.setFecha(rs.getString("FECHA"));
				guia.setNoguia(rs.getString("NOGUIA"));
				guia.setCod_valorACobrar(rs.getString("COD_VALORACOBRAR"));
				guia.setFacturaCOD(rs.getString("FACTURACOD"));
				guia.setSerieCOD(rs.getString("SERIECOD"));
				guia.setReciboCOD(rs.getString("RECIBOCOD"));
				guia.setLiquidado(rs.getString("LIQUIDADO"));
				guia.setValor_Servicio(rs.getString("VALORSERVICIO"));
				guia.setValorACreditar(rs.getString("VALORACREDITAR"));
				guia.setPorcentaje(rs.getString("PORCENTAJE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setFpreautoriza(rs.getString("FPREAUTORIZA"));
				guia.setFautoriza(rs.getString("FAUTORIZA"));
				guia.setFacredita(rs.getString("FACREDITA"));
				guia.setFfacturagtx(rs.getString("FFACTURAGTX"));
				guia.setFfacturagua(rs.getString("FFACTURAGUA"));
				guia.setUpreautoriza(rs.getString("UPREAUTORIZA"));
				guia.setUautoriza(rs.getString("UAUTORIZA"));
				guia.setUacredita(rs.getString("UACREDITA"));
				guia.setUfacturagtx(rs.getString("UFACTURAGTX"));
				guia.setUfacturagua(rs.getString("UFACTURAGUA"));
				guia.setLiquidadorag(rs.getString("LIQUIDADORAG"));
				guia.setLiquidadoag(rs.getString("LIQUIDADOAG"));
				guia.setNocuadrecaja(rs.getString("NOCUADRECAJA"));
				guia.setFechacuadre(rs.getString("FECHACUADRE"));
				guia.setNombreliqui(rs.getString("NOMBRELIQUI"));
				guia.setNombreusuli(rs.getString("NOMBREUSULI"));
				guia.setUbicacionliqui(rs.getString("UBICACIONLIQUI"));
				guia.setUbicacionusuli(rs.getString("UBICACIONUSULI"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				// guia.setBanco(rs.getString("BANCO"));
				// guia.setNoCuenta(rs.getString("NOCUENTA"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("\nAlgo malió sal, err:" + e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	public List<GuiaF> getGuiasCOD_NoFacturadasXCliente(String fechaIni, String fechaFin, String CodCob)
			throws SQLException {
		List<GuiaF> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_NoFacturadasXCliente(?,?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			cs.setString(3, CodCob);
			rs = cs.executeQuery();
			guias = new LinkedList<GuiaF>();
			while (rs.next()) {
				GuiaF guia = new GuiaF();
				guia.setCodCob(rs.getString("CODCOB"));
				guia.setFecha(rs.getString("FECHA"));
				guia.setNoguia(rs.getString("NOGUIA"));
				guia.setCod_valorACobrar(rs.getString("COD_VALORACOBRAR"));
				guia.setFacturaCOD(rs.getString("FACTURACOD"));
				guia.setSerieCOD(rs.getString("SERIECOD"));
				guia.setReciboCOD(rs.getString("RECIBOCOD"));
				guia.setLiquidado(rs.getString("LIQUIDADO"));
				guia.setValor_Servicio(rs.getString("VALORSERVICIO"));
				guia.setValorACreditar(rs.getString("VALORACREDITAR"));
				guia.setPorcentaje(rs.getString("PORCENTAJE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setFpreautoriza(rs.getString("FPREAUTORIZA"));
				guia.setFautoriza(rs.getString("FAUTORIZA"));
				guia.setFacredita(rs.getString("FACREDITA"));
				guia.setFfacturagtx(rs.getString("FFACTURAGTX"));
				guia.setFfacturagua(rs.getString("FFACTURAGUA"));
				guia.setUpreautoriza(rs.getString("UPREAUTORIZA"));
				guia.setUautoriza(rs.getString("UAUTORIZA"));
				guia.setUacredita(rs.getString("UACREDITA"));
				guia.setUfacturagtx(rs.getString("UFACTURAGTX"));
				guia.setUfacturagua(rs.getString("UFACTURAGUA"));
				guia.setLiquidadorag(rs.getString("LIQUIDADORAG"));
				guia.setLiquidadoag(rs.getString("LIQUIDADOAG"));
				guia.setNocuadrecaja(rs.getString("NOCUADRECAJA"));
				guia.setFechacuadre(rs.getString("FECHACUADRE"));
				guia.setNombreliqui(rs.getString("NOMBRELIQUI"));
				guia.setNombreusuli(rs.getString("NOMBREUSULI"));
				guia.setUbicacionliqui(rs.getString("UBICACIONLIQUI"));
				guia.setUbicacionusuli(rs.getString("UBICACIONUSULI"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				// guia.setBanco(rs.getString("BANCO"));
				// guia.setNoCuenta(rs.getString("NOCUENTA"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("\nAlgo malió sal, err:" + e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

//---------------------------------- SOBRE GUIAS ACREDITADAS ----------------------------------------------//	
	public List<GuiaF> getGuiasCOD_Liquidadas(String fechaIni, String fechaFin) throws SQLException {
		List<GuiaF> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_Liquidadas(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			rs = cs.executeQuery();
			guias = new LinkedList<GuiaF>();
			while (rs.next()) {
				GuiaF guia = new GuiaF();
				guia.setCodCob(rs.getString("CODCOB"));
				guia.setFecha(rs.getString("FECHA"));
				guia.setNoguia(rs.getString("NOGUIA"));
				guia.setCod_valorACobrar(rs.getString("COD_VALORACOBRAR"));
				guia.setFacturaCOD(rs.getString("FACTURACOD"));
				guia.setSerieCOD(rs.getString("SERIECOD"));
				guia.setReciboCOD(rs.getString("RECIBOCOD"));
				guia.setLiquidado(rs.getString("LIQUIDADO"));
				guia.setValor_Servicio(rs.getString("VALORSERVICIO"));
				guia.setValorACreditar(rs.getString("VALORACREDITAR"));
				guia.setPorcentaje(rs.getString("PORCENTAJE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setFpreautoriza(rs.getString("FPREAUTORIZA"));
				guia.setFautoriza(rs.getString("FAUTORIZA"));
				guia.setFacredita(rs.getString("FACREDITA"));
				guia.setFfacturagtx(rs.getString("FFACTURAGTX"));
				guia.setFfacturagua(rs.getString("FFACTURAGUA"));
				guia.setUpreautoriza(rs.getString("UPREAUTORIZA"));
				guia.setUautoriza(rs.getString("UAUTORIZA"));
				guia.setUacredita(rs.getString("UACREDITA"));
				guia.setUfacturagtx(rs.getString("UFACTURAGTX"));
				guia.setUfacturagua(rs.getString("UFACTURAGUA"));
				guia.setLiquidadorag(rs.getString("LIQUIDADORAG"));
				guia.setLiquidadoag(rs.getString("LIQUIDADOAG"));
				guia.setNocuadrecaja(rs.getString("NOCUADRECAJA"));
				guia.setFechacuadre(rs.getString("FECHACUADRE"));
				guia.setNombreliqui(rs.getString("NOMBRELIQUI"));
				guia.setNombreusuli(rs.getString("NOMBREUSULI"));
				guia.setUbicacionliqui(rs.getString("UBICACIONLIQUI"));
				guia.setUbicacionusuli(rs.getString("UBICACIONUSULI"));
				guia.setBanco(rs.getString("BANCO"));
				guia.setNoCuenta(rs.getString("NOCUENTA"));
				guia.setFEMISION(rs.getString("FEMISION"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(
					"\nAlgo malió sal con el metodo: \"List<Guia> getGuiasCOD_Liquidadas()\" err:" + e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	public List<GuiaF> getGuiasCOD_LiquidadasXCliente(String fechaIni, String fechaFin, String CodCob)
			throws SQLException {
		List<GuiaF> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_LiquidadasXCliente(?,?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			cs.setString(3, CodCob);
			rs = cs.executeQuery();
			guias = new LinkedList<GuiaF>();
			while (rs.next()) {
				GuiaF guia = new GuiaF();
				guia.setCodCob(rs.getString("CODCOB"));
				guia.setFecha(rs.getString("FECHA"));
				guia.setNoguia(rs.getString("NOGUIA"));
				guia.setCod_valorACobrar(rs.getString("COD_VALORACOBRAR"));
				guia.setFacturaCOD(rs.getString("FACTURACOD"));
				guia.setSerieCOD(rs.getString("SERIECOD"));
				guia.setReciboCOD(rs.getString("RECIBOCOD"));
				guia.setLiquidado(rs.getString("LIQUIDADO"));
				guia.setValor_Servicio(rs.getString("VALORSERVICIO"));
				guia.setValorACreditar(rs.getString("VALORACREDITAR"));
				guia.setPorcentaje(rs.getString("PORCENTAJE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setFpreautoriza(rs.getString("FPREAUTORIZA"));
				guia.setFautoriza(rs.getString("FAUTORIZA"));
				guia.setFacredita(rs.getString("FACREDITA"));
				guia.setFfacturagtx(rs.getString("FFACTURAGTX"));
				guia.setFfacturagua(rs.getString("FFACTURAGUA"));
				guia.setUpreautoriza(rs.getString("UPREAUTORIZA"));
				guia.setUautoriza(rs.getString("UAUTORIZA"));
				guia.setUacredita(rs.getString("UACREDITA"));
				guia.setUfacturagtx(rs.getString("UFACTURAGTX"));
				guia.setUfacturagua(rs.getString("UFACTURAGUA"));
				guia.setLiquidadorag(rs.getString("LIQUIDADORAG"));
				guia.setLiquidadoag(rs.getString("LIQUIDADOAG"));
				guia.setNocuadrecaja(rs.getString("NOCUADRECAJA"));
				guia.setFechacuadre(rs.getString("FECHACUADRE"));
				guia.setNombreliqui(rs.getString("NOMBRELIQUI"));
				guia.setNombreusuli(rs.getString("NOMBREUSULI"));
				guia.setUbicacionliqui(rs.getString("UBICACIONLIQUI"));
				guia.setUbicacionusuli(rs.getString("UBICACIONUSULI"));
				guia.setBanco(rs.getString("BANCO"));
				guia.setNoCuenta(rs.getString("NOCUENTA"));
				guia.setFEMISION(rs.getString("FEMISION"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("\nAlgo malió sal con el metodo: \"List<Guia> getGuiasCOD_LiquidadasXCliente()\" err:"
					+ e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	public List<GuiaF> getGuiasCOD_NoLiquidadas(String fechaIni, String fechaFin) throws SQLException {
		List<GuiaF> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_NoLiquidadas(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			rs = cs.executeQuery();
			guias = new LinkedList<GuiaF>();
			while (rs.next()) {
				GuiaF guia = new GuiaF();
				guia.setCodCob(rs.getString("CODCOB"));
				guia.setFecha(rs.getString("FECHA"));
				guia.setNoguia(rs.getString("NOGUIA"));
				guia.setCod_valorACobrar(rs.getString("COD_VALORACOBRAR"));
				guia.setFacturaCOD(rs.getString("FACTURACOD"));
				guia.setSerieCOD(rs.getString("SERIECOD"));
				guia.setReciboCOD(rs.getString("RECIBOCOD"));
				guia.setLiquidado(rs.getString("LIQUIDADO"));
				guia.setValor_Servicio(rs.getString("VALORSERVICIO"));
				guia.setValorACreditar(rs.getString("VALORACREDITAR"));
				guia.setPorcentaje(rs.getString("PORCENTAJE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setFpreautoriza(rs.getString("FPREAUTORIZA"));
				guia.setFautoriza(rs.getString("FAUTORIZA"));
				guia.setFacredita(rs.getString("FACREDITA"));
				guia.setFfacturagtx(rs.getString("FFACTURAGTX"));
				guia.setFfacturagua(rs.getString("FFACTURAGUA"));
				guia.setUpreautoriza(rs.getString("UPREAUTORIZA"));
				guia.setUautoriza(rs.getString("UAUTORIZA"));
				guia.setUacredita(rs.getString("UACREDITA"));
				guia.setUfacturagtx(rs.getString("UFACTURAGTX"));
				guia.setUfacturagua(rs.getString("UFACTURAGUA"));
				guia.setLiquidadorag(rs.getString("LIQUIDADORAG"));
				guia.setLiquidadoag(rs.getString("LIQUIDADOAG"));
				guia.setNocuadrecaja(rs.getString("NOCUADRECAJA"));
				guia.setFechacuadre(rs.getString("FECHACUADRE"));
				guia.setNombreliqui(rs.getString("NOMBRELIQUI"));
				guia.setNombreusuli(rs.getString("NOMBREUSULI"));
				guia.setUbicacionliqui(rs.getString("UBICACIONLIQUI"));
				guia.setUbicacionusuli(rs.getString("UBICACIONUSULI"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				// guia.setBanco(rs.getString("BANCO"));
				// guia.setNoCuenta(rs.getString("NOCUENTA"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(
					"\nAlgo malió sal con el metodo: \"List<Guia> getGuiasCOD_NoLiquidadas()\" err:" + e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	public List<GuiaF> getGuiasCOD_NoLiquidadasXCliente(String fechaIni, String fechaFin, String CodCob)
			throws SQLException {
		List<GuiaF> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuias_NoLiquidadasXCliente(?,?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			cs.setString(3, CodCob);
			rs = cs.executeQuery();
			guias = new LinkedList<GuiaF>();
			while (rs.next()) {
				GuiaF guia = new GuiaF();
				guia.setCodCob(rs.getString("CODCOB"));
				guia.setFecha(rs.getString("FECHA"));
				guia.setNoguia(rs.getString("NOGUIA"));
				guia.setCod_valorACobrar(rs.getString("COD_VALORACOBRAR"));
				guia.setFacturaCOD(rs.getString("FACTURACOD"));
				guia.setSerieCOD(rs.getString("SERIECOD"));
				guia.setReciboCOD(rs.getString("RECIBOCOD"));
				guia.setLiquidado(rs.getString("LIQUIDADO"));
				guia.setValor_Servicio(rs.getString("VALORSERVICIO"));
				guia.setValorACreditar(rs.getString("VALORACREDITAR"));
				guia.setPorcentaje(rs.getString("PORCENTAJE"));
				guia.setIdReporte(rs.getString("IDREPORTE"));
				guia.setFACE_SERIE(rs.getString("FACE_SERIE"));
				guia.setFACE_PREIMPRESO(rs.getString("FACE_PREIMPRESO"));
				guia.setFpreautoriza(rs.getString("FPREAUTORIZA"));
				guia.setFautoriza(rs.getString("FAUTORIZA"));
				guia.setFacredita(rs.getString("FACREDITA"));
				guia.setFfacturagtx(rs.getString("FFACTURAGTX"));
				guia.setFfacturagua(rs.getString("FFACTURAGUA"));
				guia.setUpreautoriza(rs.getString("UPREAUTORIZA"));
				guia.setUautoriza(rs.getString("UAUTORIZA"));
				guia.setUacredita(rs.getString("UACREDITA"));
				guia.setUfacturagtx(rs.getString("UFACTURAGTX"));
				guia.setUfacturagua(rs.getString("UFACTURAGUA"));
				guia.setLiquidadorag(rs.getString("LIQUIDADORAG"));
				guia.setLiquidadoag(rs.getString("LIQUIDADOAG"));
				guia.setNocuadrecaja(rs.getString("NOCUADRECAJA"));
				guia.setFechacuadre(rs.getString("FECHACUADRE"));
				guia.setNombreliqui(rs.getString("NOMBRELIQUI"));
				guia.setNombreusuli(rs.getString("NOMBREUSULI"));
				guia.setUbicacionliqui(rs.getString("UBICACIONLIQUI"));
				guia.setUbicacionusuli(rs.getString("UBICACIONUSULI"));
				guia.setTIPO_COBRO(rs.getString("TIPO_COBRO"));
				// guia.setBanco(rs.getString("BANCO"));
				// guia.setNoCuenta(rs.getString("NOCUENTA"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("\nAlgo malió sal con el metodo: \"List<Guia>  getGuiasCOD_NoLiquidadasXCliente()\" err:"
					+ e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

//--------------------------------------- TOTAL PENDIENTE A ACREDITAR --------------------------------------//

	public List<ClienteXAcreditacion> getClientesPendientesXAcrediatar(String fechaIni, String fechaFin)
			throws SQLException {
		List<ClienteXAcreditacion> pendientes = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getTotalPendientexAcreditar(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			rs = cs.executeQuery();
			pendientes = new LinkedList<ClienteXAcreditacion>();
			while (rs.next()) {
				ClienteXAcreditacion clienteP = new ClienteXAcreditacion();
				clienteP.setFechaIni(dateFormatChange(fechaIni));
				clienteP.setFechaFin(dateFormatChange(fechaFin));
				clienteP.setCodigo(rs.getString("CODIGO"));
				clienteP.setNombre(rs.getString("NOMBRE"));
				clienteP.setCantidadGuias(rs.getString("CANTGUIAS"));
				clienteP.setTotalAcreditar(rs.getString("TOTALACR"));
				clienteP.setAcreditado("NO");
				pendientes.add(clienteP);
			}
			return pendientes;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(
					"\nAlgo malió sal con el metodo: \"List<ClienteXAcreditacion>  getClientesPendientesXAcrediatar()\" err:"
							+ e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	public List<ResumenAcreditacion> getClientesAcreditados(String fechaIni, String fechaFin) throws SQLException {
		List<ResumenAcreditacion> pendientes = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getClientesAcreditados(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			rs = cs.executeQuery();
			pendientes = new LinkedList<ResumenAcreditacion>();
			while (rs.next()) {
				ResumenAcreditacion resumenAcr = new ResumenAcreditacion();
				resumenAcr.setFechaIni(dateFormatChange(fechaIni));
				resumenAcr.setFechaFin(dateFormatChange(fechaFin));
				resumenAcr.setCodigo(rs.getString("CODIGO"));
				resumenAcr.setNombre(rs.getString("NOMBRE"));
				resumenAcr.setCantidadGuias(rs.getString("CANTGUIAS"));
				resumenAcr.setAcreditado("SI");
				resumenAcr.setRazonSocial(rs.getString("RAZONSOCIAL"));
				resumenAcr.setTotalCOD(rs.getString("TOTALCOD"));
				resumenAcr.setTotalServ(rs.getString("TOTALSERV"));
				resumenAcr.setTotalAcr(rs.getString("TOTALACR"));
				resumenAcr.setPorcentajeCOD(rs.getString("COD_PORCENTAJE"));
				resumenAcr.setUsuarioPreAu(rs.getString("UPREAUTORIZA"));
				resumenAcr.setUsuarioAu(rs.getString("UAUTORIZA"));
				resumenAcr.setAutorizacion(rs.getString("IDREPORTE"));
				resumenAcr.setBanco(rs.getString("BANNOMBRE"));
				resumenAcr.setNoCuenta(rs.getString("NOCUENTA"));
				pendientes.add(resumenAcr);
			}
			return pendientes;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(
					"\nAlgo malió sal con el metodo: \"List<ClienteXAcreditacion>  getClientesPendientesXAcrediatar()\" err:"
							+ e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	public List<ResumenAcreditacion> getResumenAcreditacion(String fechaIni, String fechaFin) throws SQLException {
		List<ResumenAcreditacion> pendientes = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getResumenxAcreditar(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			rs = cs.executeQuery();
			pendientes = new LinkedList<ResumenAcreditacion>();
			while (rs.next()) {
				ResumenAcreditacion resumenAcr = new ResumenAcreditacion();
				resumenAcr.setFechaIni(dateFormatChange(fechaIni));
				resumenAcr.setFechaFin(dateFormatChange(fechaFin));
				resumenAcr.setCodigo(rs.getString("CODIGO"));
				resumenAcr.setNombre(rs.getString("NOMBRE"));
				resumenAcr.setCantidadGuias(rs.getString("CANTGUIAS"));
				resumenAcr.setAcreditado("NO");
				resumenAcr.setRazonSocial(rs.getString("RAZONSOCIAL"));
				resumenAcr.setTotalCOD(rs.getString("TOTALCOD"));
				resumenAcr.setTotalServ(rs.getString("TOTALSERV"));
				resumenAcr.setTotalAcr(rs.getString("TOTALACR"));
				resumenAcr.setPorcentajeCOD(rs.getString("COD_PORCENTAJE"));
				resumenAcr.setUsuarioPreAu(rs.getString("UPREAUTORIZA"));
				resumenAcr.setUsuarioAu(rs.getString("UAUTORIZA"));
				resumenAcr.setAutorizacion(rs.getString("IDREPORTE"));
				resumenAcr.setBanco(rs.getString("BANNOMBRE"));
				resumenAcr.setNoCuenta(rs.getString("NOCUENTA"));
				pendientes.add(resumenAcr);
			}
			return pendientes;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Algo malió sal con el metodo: \"List<ResumenAcreditacion> getResumenAcreditacion()\" err:"
					+ e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	public List<ResumenAcreditacion> getResumenAcreditacionAU(String autorizacion) throws SQLException {
		List<ResumenAcreditacion> pendientes = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getResumenxAcreditarAU(?)}";
			cs = con.prepareCall(query);
			cs.setString(1, autorizacion);
			rs = cs.executeQuery();
			pendientes = new LinkedList<ResumenAcreditacion>();
			while (rs.next()) {
				ResumenAcreditacion resumenAcr = new ResumenAcreditacion();
				resumenAcr.setFechaIni(rs.getString("MINFECHA"));
				resumenAcr.setFechaFin(rs.getString("MAXFECHA"));
				resumenAcr.setCodigo(rs.getString("CODIGO"));
				resumenAcr.setNombre(rs.getString("NOMBRE"));
				resumenAcr.setCantidadGuias(rs.getString("CANTGUIAS"));
				resumenAcr.setAcreditado("NO");
				resumenAcr.setRazonSocial(rs.getString("RAZONSOCIAL"));
				resumenAcr.setTotalCOD(rs.getString("TOTALCOD"));
				resumenAcr.setTotalServ(rs.getString("TOTALSERV"));
				resumenAcr.setTotalAcr(rs.getString("TOTALACR"));
				resumenAcr.setPorcentajeCOD(rs.getString("COD_PORCENTAJE"));
				resumenAcr.setUsuarioPreAu(rs.getString("UPREAUTORIZA"));
				resumenAcr.setUsuarioAu(rs.getString("UAUTORIZA"));
				resumenAcr.setAutorizacion(rs.getString("IDREPORTE"));
				resumenAcr.setBanco(rs.getString("BANNOMBRE"));
				resumenAcr.setNoCuenta(rs.getString("NOCUENTA"));
				resumenAcr.setTipoCuenta(rs.getString("TIPOCUENTA"));
				pendientes.add(resumenAcr);
			}
			return pendientes;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Algo malió sal con el metodo: \"List<ResumenAcreditacion> getResumenAcreditacion()\" err:"
					+ e.getMessage());
			return null;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	public List<GuiaxAcreditar> getGuiasXAcreditar_xCliente(String autorizacion, String codcob) {
		List<GuiaxAcreditar> lista = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuiasXAcreditar_xCliente(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, autorizacion);
			cs.setString(2, codcob);
			rs = cs.executeQuery();
			lista = new LinkedList<GuiaxAcreditar>();
			while (rs.next()) {
				GuiaxAcreditar guia = new GuiaxAcreditar();
				guia.setNoguia(rs.getString("NOGUIA"));
				guia.setFecha(rs.getString("FECHA"));
				guia.setValorCOD(rs.getString("VALORCOD"));
				guia.setValorServicio(rs.getString("VALORSERVICIO"));
				guia.setValorAcreditar(rs.getString("VALORACREDITAR"));
				guia.setPorcentaje(rs.getString("PORCENTAJE"));
				guia.setReciboCOD(rs.getString("RECIBOCOD"));
				guia.setIDReporte(rs.getString("IDREPORTE"));
				guia.setUPreAutoriza(rs.getString("UPREAUTORIZA"));
				guia.setUAutoriza(rs.getString("UAUTORIZA"));
				lista.add(guia);
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Algo malió sal con el metodo: \"List<ResumenAcreditacion> getResumenAcreditacion()\" err:"
					+ e.getMessage());
			return lista;
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	public Guia getDataGuiaCOD(String noguia) {
		Guia guia = new Guia();
		try {
			con = getConnection();
			String query = " Select convert(varchar(10),FECHA_GUIA,103) as FECHA_GUIA,PTOORI,PTODES,CODCOB,VALORCOD,VALORSERVICIO,VALORACREDITAR,"
					+ "DESTINATARIO,RECIBOCOD,convert(varchar(10),FECHA_ENTREGA,103)as  FECHA_ENTREGA "
					+ " from GUIASCOD where noguia=? ";
			ps = con.prepareStatement(query);
			ps.setString(1, noguia);

			rs = ps.executeQuery();

			if (rs.next()) {
				guia.setFECHA(rs.getString("FECHA_GUIA"));
				guia.setPTOORI(rs.getString("PTOORI"));
				guia.setPTODES(rs.getString("PTODES"));
				guia.setCODCOB(rs.getString("CODCOB"));
				guia.setCOD_VALORACOBRAR(rs.getString("VALORCOD"));
				guia.setVALORSERVICIO(rs.getString("VALORSERVICIO"));
				guia.setVALORACREDITAR(rs.getString("VALORACREDITAR"));
				guia.setNOMDES(rs.getString("DESTINATARIO"));
				guia.setCOD_RECIBO(rs.getString("RECIBOCOD"));
				guia.setPFECHA(rs.getString("FECHA_ENTREGA"));
				guia.setNOGUIA(noguia);
			}
		} catch (Exception e) {
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			e.printStackTrace();
		} finally {
			CloseAll(con, cs, rs);
		}
		return guia;
	}

	// ---------------------------- UTILS
	// -----------------------------------------//
	private String dateFormatChange(String yyyyMMdd) throws Exception {
		yyyyMMdd = quitaNulo(yyyyMMdd);
		try {
			if (yyyyMMdd != null && !yyyyMMdd.equalsIgnoreCase("null") && !yyyyMMdd.equalsIgnoreCase("")) {
				// System.out.println("date: " + date);
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
				return format2.format(format.parse(yyyyMMdd));
			}
			return yyyyMMdd;
		} catch (NullPointerException e) {
			System.out.println("no se pudo castear la fecha: " + yyyyMMdd);
		} catch (ParseException ex) {
			System.out.println("Error parseando " + yyyyMMdd + " debe tener formato: yyyyMMdd");
		}
		return yyyyMMdd;
	}

}
