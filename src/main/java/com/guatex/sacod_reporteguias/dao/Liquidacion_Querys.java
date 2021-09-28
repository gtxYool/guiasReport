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

import com.guatex.sacod_reporteguias.entities.E_BoletaxRecibo;
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
				guia.setEstado(rs.getString("estado"));
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
				String recibo = notNull(rs.getString("RECIBO"));
				String monto = notNull(rs.getString("MONTODEPOSITADO"));
				ReciboCaja rbc = recibos.stream().filter(r -> r.getRecibo().equalsIgnoreCase(recibo)).findFirst()
						.orElse(null);
				if (rbc == null) {
					rbc = new ReciboCaja();
					rbc.setAgencia(rs.getString("AGENCIA"));
					rbc.setCliente(rs.getString("CLIENTE"));
					rbc.setCodigo(rs.getString("CODIGO"));
					rbc.setFecha(rs.getString("FECHA"));
					rbc.setFecha_liquidacion(rs.getString("FECHA_LIQUIDACION"));
					rbc.setLiquidado(rs.getString("LIQUIDADO"));
					rbc.setLiquidador(rs.getString("LIQUIDADOR"));
					rbc.setRecibo(recibo);
					rbc.setTotal(rs.getString("TOTAL"));
					rbc.setNoguia(rs.getString("NOGUIA"));
					rbc.setPtoDes(rs.getString("PTODES"));
					// solicitaron mostrar la informacion de esta manera. Esta feo, lo se.
					rbc.setBancoBoletaMonto(!monto.equalsIgnoreCase("0") ? mapBanco(rs.getString("BANCO")) + " - "
							+ notNull(rs.getString("BOLETADB")) + " - " + "Q " + monto : "");
					rbc.setBoletaTransporte(rs.getString("BOLETATR"));
					rbc.setAcreditado(rs.getString("ACREDITADO"));
					rbc.setBoletaDepElec(rs.getString("BOLETADE"));
					rbc.setValorAcreditar(rs.getString("VALORACREDITAR"));
					recibos.add(rbc);
				} else {
					rbc.concatBancoBoletaMonto(!monto.equalsIgnoreCase("0") ? mapBanco(rs.getString("BANCO")) + " - "
							+ notNull(rs.getString("BOLETADB")) + " - " + "Q " + monto : "");
					rbc.concatBoletaTransporte(rs.getString("BOLETATR"));
					rbc.concatBoletaDepElec(rs.getString("BOLETADE"));
				}
			}
		} catch (Exception e) {
			logger.info("\nAlgo malió sal con el metodo: \"List<Guia> getGuiasCOD_Liquidadas()\" err:" + e);
		} finally {
			CloseAll(con, cs, rs);
		}
		return recibos;

	}

	public List<ReciboCaja> getRecibosCaja(String fechaIni, String fechaFin) {
		List<ReciboCaja> recibos = new LinkedList<ReciboCaja>();
		try {
			con = getConnection();
			String query = "{call SACOD_getRecibosCaja(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			rs = cs.executeQuery();
			while (rs.next()) {
				String recibo = notNull(rs.getString("RECIBO"));
				String monto = notNull(rs.getString("MONTODEPOSITADO"));
				ReciboCaja rbc = recibos.stream().filter(r -> r.getRecibo().equalsIgnoreCase(recibo)).findFirst()
						.orElse(null);
				if (rbc == null) {
					rbc = new ReciboCaja();
					rbc.setAgencia(rs.getString("AGENCIA"));
					rbc.setCliente(rs.getString("CLIENTE"));
					rbc.setCodigo(rs.getString("CODIGO"));
					rbc.setFecha(rs.getString("FECHA"));
					rbc.setFecha_liquidacion(rs.getString("FECHA_LIQUIDACION"));
					rbc.setLiquidado(rs.getString("LIQUIDADO"));
					rbc.setLiquidador(rs.getString("LIQUIDADOR"));
					rbc.setRecibo(recibo);
					rbc.setTotal(rs.getString("TOTAL"));
					rbc.setNoguia(rs.getString("NOGUIA"));
					rbc.setPtoDes(rs.getString("PTODES"));
					// solicitaron mostrar la informacion de esta manera. Esta feo, lo se.

					rbc.setBancoBoletaMonto(!monto.equalsIgnoreCase("0") ? mapBanco(rs.getString("BANCO")) + " - "
							+ notNull(rs.getString("BOLETADB")) + " - " + "Q " + monto : "");
					rbc.setBoletaTransporte(rs.getString("BOLETATR"));
					rbc.setAcreditado(rs.getString("ACREDITADO"));
					rbc.setBoletaDepElec(rs.getString("BOLETADE"));
					rbc.setValorAcreditar(rs.getString("VALORACREDITAR"));
					recibos.add(rbc);
				} else {
					rbc.concatBancoBoletaMonto(!monto.equalsIgnoreCase("0") ? mapBanco(rs.getString("BANCO")) + " - "
							+ notNull(rs.getString("BOLETADB")) + " - " + "Q " + monto : "");
					rbc.concatBoletaTransporte(rs.getString("BOLETATR"));
					rbc.concatBoletaDepElec(rs.getString("BOLETADE"));
				}

			}
		} catch (Exception e) {
			logger.info("\nAlgo malió sal con el metodo: \"List<ReciboCaja> getRecibosCaja\" err:" + e);
			e.printStackTrace();
		} finally {
			CloseAll(con, cs, rs);
		}
		return recibos;

	}

	public List<ReciboCaja> getRecibosCajaxAgencia(String fechaIni, String fechaFin, String codigo) {
		List<ReciboCaja> recibos = new LinkedList<ReciboCaja>();
		try {
			con = getConnection();
			String query = "{call SACOD_getRecibosxAgencia(?,?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, fechaIni);
			cs.setString(2, fechaFin);
			cs.setString(3, codigo);
			rs = cs.executeQuery();
			while (rs.next()) {
				String recibo = notNull(rs.getString("RECIBO"));
				String monto = notNull(rs.getString("MONTODEPOSITADO"));
				ReciboCaja rbc = recibos.stream().filter(r -> r.getRecibo().equalsIgnoreCase(recibo)).findFirst()
						.orElse(null);
				if (rbc == null) {
					rbc = new ReciboCaja();
					rbc.setAgencia(rs.getString("AGENCIA"));
					rbc.setCliente(rs.getString("CLIENTE"));
					rbc.setCodigo(rs.getString("CODIGO"));
					rbc.setFecha(rs.getString("FECHA"));
					rbc.setFecha_liquidacion(rs.getString("FECHA_LIQUIDACION"));
					rbc.setLiquidado(rs.getString("LIQUIDADO"));
					rbc.setLiquidador(rs.getString("LIQUIDADOR"));
					rbc.setRecibo(recibo);
					rbc.setTotal(rs.getString("TOTAL"));
					rbc.setNoguia(rs.getString("NOGUIA"));
					rbc.setPtoDes(rs.getString("PTODES"));
					// solicitaron mostrar la informacion de esta manera. Esta feo, lo se.

					rbc.setBancoBoletaMonto(!monto.equalsIgnoreCase("0") ? mapBanco(rs.getString("BANCO")) + " - "
							+ notNull(rs.getString("BOLETADB")) + " - " + "Q " + monto : "");
					rbc.setBoletaTransporte(rs.getString("BOLETATR"));
					rbc.setAcreditado(rs.getString("ACREDITADO"));
					rbc.setBoletaDepElec(rs.getString("BOLETADE"));
					rbc.setValorAcreditar(rs.getString("VALORACREDITAR"));
					recibos.add(rbc);
				} else {
					rbc.concatBancoBoletaMonto(!monto.equalsIgnoreCase("0") ? mapBanco(rs.getString("BANCO")) + " - "
							+ notNull(rs.getString("BOLETADB")) + " - " + "Q " + monto : "");
					rbc.concatBoletaTransporte(rs.getString("BOLETATR"));
					rbc.concatBoletaDepElec(rs.getString("BOLETADE"));
				}
			}
		} catch (Exception e) {
			logger.info("\nAlgo malió sal con el metodo: \"List<Guia> getGuiasCOD_Liquidadas()\" err:" + e);
		} finally {
			CloseAll(con, cs, rs);
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

	/**
	 * 
	 * @param noguia
	 * @return
	 */
	public String getNumRecibo(String noguia) {
		String recibo = "";
		try {
			con = getConnection();
			String query = "select F_SERIE+'-'+F_NUMERO as RECIBO from RECIBOCOD where F_NOGUIA=?";
			ps = con.prepareStatement(query);
			ps.setString(1, noguia);
			rs = ps.executeQuery();
			if (rs.next()) {
				recibo = rs.getString("RECIBO");
			}
		} catch (Exception e) {
			logger.info("\nAlgo malió sal con el metodo: \"List<Guia> getGuiasCOD_Liquidadas()\" err:" + e);
		} finally {
			CloseAll(con, ps, rs);
		}
		return recibo;
	}

	/**
	 * select * from BOLETAS_COD where cast(fecha as DATE) between CAST(? as DATE)
	 * and CAST(? as DATE)
	 */

	public List<E_BoletaxRecibo> getBoletasEscaneadas(String fechaIni, String fechaFin) {
		List<E_BoletaxRecibo> boletas = new LinkedList<>();
		try {
			con = getConnection();
			String query = "SELECT " + 
					"    CONVERT(VARCHAR(10), B.FECHA, 103) as FECHA, " + 
					"    G.NOGUIA, " + 
					"    B.RECIBOCOD, " + 
					"    B.NOBOLETA, " + 
					" 	 B.USUARIO, " + 
					"	 P.NOMBRE, " + 
					" 	 B.RUTA, "+
					"    O.NOMBRE AS NOMBRE_RUTA, " + 
					"    B.PLACA " + 
					"FROM " + 
					"    BOLETAS_COD B " + 
					"    INNER JOIN OPERUTAS O ON O.CODIGO = B.RUTA " + 
					"    INNER JOIN OPEPERSONAL P ON P.CODIGO = B.USUARIO "+
					"    INNER JOIN GUIASCOD G ON G.RECIBOCOD = B.RECIBOCOD " + 
					"WHERE " + 
					"    cast(fecha as DATE) between CAST(? as DATE) " + 
					"    and CAST(? as DATE) " + 
					"ORDER BY " + 
					"    B.FECHA ASC ";
			ps = con.prepareStatement(query);
			ps.setString(1, fechaIni);
			ps.setString(2, fechaFin);
			rs = ps.executeQuery();
			while (rs.next()) {
				E_BoletaxRecibo boleta = new E_BoletaxRecibo();
				boleta.setFecha(rs.getString("FECHA"));
				boleta.setNoBoleta(rs.getString("NOBOLETA"));
				boleta.setPlaca(rs.getString("PLACA"));
				boleta.setReciboCOD(rs.getString("RECIBOCOD"));
				boleta.setRuta(rs.getString("RUTA"));
				boleta.setUsuario(rs.getString("USUARIO"));
				boleta.setNombre_Usuario(rs.getString("NOMBRE"));
				boleta.setNoguia(rs.getString("NOGUIA"));
				boleta.setNombre_Ruta(rs.getString("NOMBRE_RUTA"));
				boletas.add(boleta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			CloseAll(con, ps, rs);
		}
		return boletas;
	}

	/**
	 * 
	 * @param serie
	 * @param numero
	 * @return
	 */
	public ReciboCaja getRecibo(String serie, String numero) {

		try {
			con = getConnection();
			String query = "{call SACOD_getRecibo(?,?)}";
			cs = con.prepareCall(query);
			cs.setString(1, serie);
			cs.setString(2, numero);
			rs = cs.executeQuery();
			if (rs.next()) {
				ReciboCaja rbc = new ReciboCaja();
				rbc.setRecibo(rs.getString("RECIBOCOD"));
				rbc.setFecha(rs.getString("FECHA"));
				rbc.setEntrega(rs.getString("ENTREGA"));
				rbc.setnRecibe(rs.getString("RECIBE"));
				rbc.setDireccion(rs.getString("DIRECCION"));
				rbc.setTelefono(rs.getString("TELEFONO"));
				rbc.setNoguia(rs.getString("NOGUIA"));
				rbc.setPiezas(rs.getString("F_PIEZAS"));
				rbc.setTotal(rs.getString("F_TOTAL"));
				return rbc;
			}
		} catch (Exception e) {
			logger.info("\nAlgo malió sal con el metodo: \"List<Guia> getGuiasCOD_Liquidadas()\" err:" + e);
		} finally {
			CloseAll(con, cs, rs);
		}
		return null;

	}

	/**
	 * Metodo para
	 * 
	 * @param banco
	 * @return
	 */
	private String mapBanco(String banco) {
		banco = notNull(banco).toUpperCase();
		return banco.isEmpty() ? "" : banco.contains("B") ? "BANRURAL" : "GYT CONTINENTAL";
	}

	private String notNull(String var) {
		return var != null ? var.trim() : "";
	}
}
