package com.guatex.sacod_reporteguias.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.guatex.sacod_reporteguias.entities.GuiaXLiquidacion;
import com.guatex.sacod_reporteguias.entities.PuntoLiquidacion;
import com.guatex.sacod_reporteguias.entities.ReciboCaja;

public class Liquidacion_Querys extends Conexion {
	public static final Logger logger = LogManager.getLogger(Guias_Querys.class);

	private Connection con;
	private ResultSet rs;
	private CallableStatement cs;
	private PreparedStatement ps;

	public List<GuiaXLiquidacion> getGuiasXLiquidacion(String CODIGOLIQUIDACION) throws SQLException {
		List<GuiaXLiquidacion> guias = null;
		try {
			con = getConnection();
			String query = "{call SACOD_getGuiasXLiquidacion(?)}";
			cs = con.prepareCall(query);
			cs.setString(1, CODIGOLIQUIDACION);
			rs = cs.executeQuery();
			guias = new LinkedList<GuiaXLiquidacion>();
			while (rs.next()) {
				GuiaXLiquidacion guia = new GuiaXLiquidacion();
				guia.setCodigo(rs.getString("CODIGO_LIQUIDACION"));
				guia.setSerie(rs.getString("F_SERIE"));
				guia.setNumero(rs.getString("F_NUMERO"));
				guia.setNoguia(rs.getString("F_NOGUIA"));
				guia.setTotal(rs.getString("F_TOTAL"));
				guias.add(guia);
			}
			return guias;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(
					"\nAlgo malió sal con el metodo: \"List<Guia> getGuiasCOD_Liquidadas()\" err:" + e.getMessage());
			return null;
		}
	}

	public String getCodigoLiquidacion(String serie, String numero) throws SQLException {
		try {
			con = getConnection();
			String query = "SELECT CODIGO_LIQUIDACION FROM CDC_RECIBOCOD_LIQUIDADO WHERE"
					+ " F_SERIE = ? AND F_NUMERO = ? ";
			ps = con.prepareStatement(query);
			ps.setString(1, serie);
			ps.setString(2, numero);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("CODIGO_LIQUIDACION");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(
					"\nAlgo malió sal con el metodo: \"List<Guia> getGuiasCOD_Liquidadas()\" err:" + e.getMessage());
			return "";
		} finally {
			ps.close();
			ps = null;
			CloseAll(con, cs, rs);
		}
		return "";
	}

	public String getCodigoLiquidacion(String guia) throws SQLException {
		try {
			con = getConnection();
			String query = "SELECT CODIGO_LIQUIDACION FROM CDC_RECIBOCOD_LIQUIDADO A"
					+ " INNER JOIN RECIBOCOD B ON A.F_SERIE=B.F_SERIE AND A.F_NUMERO=B.F_NUMERO"
					+ " WHERE B.F_NOGUIA = ? ";
			ps = con.prepareStatement(query);
			ps.setString(1, guia);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("CODIGO_LIQUIDACION");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(
					"\nAlgo malió sal con el metodo: \"List<Guia> getGuiasCOD_Liquidadas()\" err:" + e.getMessage());
			return "";
		} finally {
			ps.close();
			ps = null;
			CloseAll(con, cs, rs);
		}
		return "";
	}

	public List<ReciboCaja> getRecibosCajaxCliente(String fechaIni, String fechaFin, String codigo) {
		List<ReciboCaja> recibos = new LinkedList<ReciboCaja>();
		try {
			con = getConnection();
			String query = "{call SACOD_getRecibosxCliente(?,?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			cs.setString(3, codigo);
			rs = cs.executeQuery();
			while (rs.next()) {
				ReciboCaja rbc = new ReciboCaja();
				rbc.setAgencia(rs.getString("AGENCIA"));
				rbc.setCliente(rs.getString("CLIENTE"));
				rbc.setCodigo(rs.getString("CODIGO"));
				rbc.setFecha(rs.getString("FECHA"));
				rbc.setFecha_liquidacion(rs.getString("FECHA_LIQUIDACION"));
				rbc.setLiquidado(rs.getString("LIQUIDADO"));
				rbc.setLiquidador(rs.getString("LIQUIDADOR"));
				rbc.setRecibo(rs.getString("RECIBO"));
				rbc.setTotal(rs.getString("TOTAL"));

				recibos.add(rbc);
			}
		} catch (Exception e) {
			logger.info("\nAlgo malió sal con el metodo: \"List<Guia> getGuiasCOD_Liquidadas()\" err:" + e);
		} finally {

		}
		return recibos;

	}

	public List<PuntoLiquidacion> getPuntosLiquidacion() {
		List<PuntoLiquidacion> puntos = new LinkedList<PuntoLiquidacion>();
		try {
			con = getConnection();
			String query = "select codigo_punto_liquidacion as CODIGO, nombre_punto_liquidacion as NOMBRE "
					+ "from cdc_punto_liquidacion";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				PuntoLiquidacion pliquidacion = new PuntoLiquidacion();
				pliquidacion.setCodigo(rs.getString("CODIGO"));
				pliquidacion.setNombre(rs.getString("NOMBRE"));
				puntos.add(pliquidacion);
			}
		} catch (Exception e) {
			logger.info("\nAlgo malió sal con el metodo: \"List<Guia> getGuiasCOD_Liquidadas()\" err:" + e);
		} finally {
			CloseAll(con, ps, rs);
		}
		return puntos;
	}
}
