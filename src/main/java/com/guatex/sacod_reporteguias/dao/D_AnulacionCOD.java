package com.guatex.sacod_reporteguias.dao;

import com.guatex.sacod_reporteguias.entities.E_AjusteCOD_ACR;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class D_AnulacionCOD extends Conexion {
	public static final Logger logger = LogManager.getLogger(D_AnulacionCOD.class);
	private Connection con;
	private ResultSet rs;
	private CallableStatement cs;
	private PreparedStatement ps;

	/**
	 * Método para la anulación COD utilizando el procedimiento almacenado
	 * SACOD_ANULACIONCOD
	 * 
	 * @param noguia:      número de guía
	 * @param descripcion: descripción de la anulación de la guía COD
	 * @param Usuario:     Usuario que generó la anulacion COD
	 * @return S = cuando el procedimiento se realizó correctamente. N = cuando
	 *         ocurrió excepcion en microservicio. cadena string = mensaje de error
	 *         de DB.
	 */
	public String AnulacionCOD(String noguia, String descripcion, String Usuario) {
		try {
			con = getConnection();
			String respuestaAnulacionCOD = "";
			cs = con.prepareCall("{call SACOD_ANULACIONCOD(?,?,?)}");
			cs.setString(1, noguia);
			cs.setString(2, descripcion);
			cs.setString(3, Usuario);
			rs = cs.executeQuery();
			while (rs.next()) {
				respuestaAnulacionCOD = quitaNulo(rs.getString(1));
			}
			return respuestaAnulacionCOD;
		} catch (Exception e) {
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			e.printStackTrace();
			return "N";
		} finally {
			CloseAll(con, cs, rs);
		}
	}

	/**
	 * Obtiene las anulaciones en un rango de fecha y que exista el cliente de la
	 * anulacion en la autorizacion
	 * 
	 * @param aut      autorizacion
	 * @param fechaIni fecha inicio
	 * @param fechaFin fecha fin
	 * @return listado de ajustes o anulaciones
	 */
	public List<E_AjusteCOD_ACR> getAnulacionesCOD(String aut, String fechaIni, String fechaFin) {
		List<E_AjusteCOD_ACR> ajustes = new LinkedList<>();
		con = getConnection();
		try {
			String query = "SELECT   " + "    DISTINCT CODCOB,   " + "    NOGUIA,   " + "    VALORCOD,   "
					+ "    DESCRIPCION   " + "FROM   " + "    ANULACIONCOD_BT   " + "WHERE   " + "    CODCOB IN (   "
					+ "        SELECT   " + "            distinct CODCOB   " + "        FROM   "
					+ "            GUIASCOD   " + "        WHERE   " + "            ISNULL(IDREPORTE, '') = ?   "
					+ "    )   " + "    AND CAST(F_ENTREGA AS date) BETWEEN CAST(? AS date)   "
					+ "    AND CAST(? AS date)";

			ps = con.prepareStatement(query);

			ps.setString(1, aut);
			ps.setString(2, fechaIni);
			ps.setString(3, fechaFin);

			rs = ps.executeQuery();
			while (rs.next()) {
				E_AjusteCOD_ACR ajuste = new E_AjusteCOD_ACR();
				ajuste.setAplicado("NOAPLICA");
				ajuste.setAutorizacion("NOAPLICA");
				ajuste.setCodCob(rs.getString("CODCOB"));
				ajuste.setDescripcion(rs.getString("DESCRIPCION"));
				ajuste.setMonto(rs.getString("VALORCOD"));
				ajuste.setNoguia(rs.getString("NOGUIA"));
				ajuste.setTipo("A");// A DE ANULACION
				ajustes.add(ajuste);
			}

		} catch (Exception e) {
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			e.printStackTrace();
		} finally {
			CloseAll(con, ps, rs);
		}
		return ajustes;
	}

	/**
	 * Obtiene las anulaciones de una autorizacion
	 * @param aut autorizacion
	 * @return listado de ajustes o anulaciones
	 */
	public List<E_AjusteCOD_ACR> getAnulacionesCOD(String aut) {
		List<E_AjusteCOD_ACR> ajustes = new LinkedList<>();
		con = getConnection();
		try {
			String query = "SELECT   " + "    DISTINCT CODCOB,   " + "    NOGUIA,   " + "    VALORCOD,   "
					+ "    DESCRIPCION   " + "FROM   " + "    ANULACIONCOD_BT A   " + "WHERE   "
					+ "    A.AUTORIZACION = ?";

			ps = con.prepareStatement(query);

			ps.setString(1, aut);
			rs = ps.executeQuery();
			while (rs.next()) {
				E_AjusteCOD_ACR ajuste = new E_AjusteCOD_ACR();
				ajuste.setAplicado("NOAPLICA");
				ajuste.setAutorizacion("NOAPLICA");
				ajuste.setCodCob(rs.getString("CODCOB"));
				ajuste.setDescripcion(rs.getString("DESCRIPCION"));
				ajuste.setMonto(rs.getString("VALORCOD"));
				ajuste.setNoguia(rs.getString("NOGUIA"));
				ajuste.setTipo("A");// A DE ANULACION
				ajustes.add(ajuste);
			}

		} catch (Exception e) {
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			e.printStackTrace();
		} finally {
			CloseAll(con, ps, rs);
		}
		return ajustes;
	}

	/**
	 * enlaza las anulaciones a la autorizacion en la que se imprimieron
	 * 
	 * @param aut numero de autorizacion o IDEREPORTE
	 * @param fechaIni fecha inicio
	 * @param fechaFin fecha fin
	 * @return numero de filas actualizadas
	 */
	public int updateAnulacionesCOD(String aut, String fechaIni, String fechaFin) {
		con = getConnection();
		try {
			String query = "UPDATE   " + "    ANULACIONCOD_BT   " + "SET   " + "    AUTORIZACION = ?   " + "WHERE   "
					+ "    CODCOB IN (   " + "        SELECT   " + "            distinct CODCOB   " + "        FROM   "
					+ "            GUIASCOD   " + "        WHERE   " + "            ISNULL(IDREPORTE, '') = ?   "
					+ "    )   " + "    AND CAST(F_ENTREGA AS date) BETWEEN CAST(? AS date)   "
					+ "    AND CAST(? AS date)";

			ps = con.prepareStatement(query);

			ps.setString(1, aut);
			ps.setString(2, aut);
			ps.setString(3, fechaIni);
			ps.setString(4, fechaFin);

			return ps.executeUpdate();

		} catch (Exception e) {
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			e.printStackTrace();
		} finally {
			CloseAll(con, ps, rs);
		}
		return 0;
	}

}
