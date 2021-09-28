package com.guatex.sacod_reporteguias.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.guatex.sacod_reporteguias.entities.E_AjusteCOD_ACR;
import com.guatex.sacod_reporteguias.entities.Guia;

public class D_AjusteCOD_ACR extends Conexion {
	public static final Logger logger = LogManager.getLogger(Guias_Querys.class);
	private Connection con;
	private ResultSet rs;
	private CallableStatement cs;
	private PreparedStatement ps;

	public boolean InsertAjusteAcr_Debito(String noguia, String descripcion, String Usuario) {
		try {
			con = getConnection();
			Guia guia = new Guias_Querys().getDataGuiaCOD(noguia);

			String query = "INSERT INTO AJUSTESCOD_ACR(NOGUIA,TIPO,CODCOB,APLICADO,DESCRIPCION,MONTO,USUARIO,FECHAHORA) VALUES (?,?,?,?,?,?,?,getDate())";

			ps = con.prepareStatement(query);
			ps.setString(1, noguia);
			ps.setString(2, "D");
			ps.setString(3, guia.getCODCOB());
			ps.setString(4, "N");
			ps.setString(5, descripcion);
			ps.setString(6, guia.getCOD_VALORACOBRAR());
			ps.setString(7, Usuario);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			e.printStackTrace();
		} finally {
			CloseAll(con, ps, rs);
		}
		return false;
	}

	public boolean InsertAjusteAcr_Credito(String codcob, String monto, String descripcion, String Usuario) {
		try {
			con = getConnection();
			String query = "INSERT INTO AJUSTESCOD_ACR(NOGUIA,TIPO,CODCOB,APLICADO,DESCRIPCION,MONTO,USUARIO,FECHAHORA) VALUES (?,?,?,?,?,?,?,getDate())";

			ps = con.prepareStatement(query);
			ps.setString(1, "");
			ps.setString(2, "C");
			ps.setString(3, codcob);
			ps.setString(4, "N");
			ps.setString(5, descripcion);
			ps.setString(6, monto);
			ps.setString(7, Usuario);

			boolean insertAjuste = ps.executeUpdate() > 0;
			return insertAjuste;

		} catch (Exception e) {
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			e.printStackTrace();
		} finally {
			CloseAll(con, ps, rs);
		}
		return false;
	}

	public List<E_AjusteCOD_ACR> getAjustesCOD(String aut, String codcob, String noguia) {
		List<E_AjusteCOD_ACR> ajustes = new LinkedList<>();
		try {
			con = getConnection();
			String query = "SELECT NOGUIA,TIPO,CODCOB,APLICADO,DESCRIPCION,MONTO,AUTORIZACION FROM AJUSTESCOD_ACR WHERE ";
			String w1 = " AUTORIZACION = ? ";
			String w2 = " CODCOB = ? ";
			String w3 = " NOGUIA = ? ";
			String and = " AND ";
			if (!aut.isEmpty() && !codcob.isEmpty()) {
				query += w1 + and + w2;
				ps = con.prepareStatement(query);
				ps.setString(1, aut);
				ps.setString(2, codcob);
			} else if (!codcob.isEmpty()) {
				query += w2;
				ps = con.prepareStatement(query);
				ps.setString(1, codcob);
			} else if (!aut.isEmpty()) {
				query += w1;
				ps = con.prepareStatement(query);
				ps.setString(1, aut);
			} else {
				query += w3;
				ps = con.prepareStatement(query);
				ps.setString(1, noguia);
			}
			System.out.println(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				E_AjusteCOD_ACR ajuste = new E_AjusteCOD_ACR();
				ajuste.setAplicado(rs.getString("APLICADO"));
				ajuste.setAutorizacion(rs.getString("AUTORIZACION"));
				ajuste.setCodCob(rs.getString("CODCOB"));
				ajuste.setDescripcion(rs.getString("DESCRIPCION"));
				ajuste.setMonto(rs.getString("MONTO"));
				ajuste.setNoguia(rs.getString("NOGUIA"));
				ajuste.setTipo(rs.getString("TIPO"));
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

	public List<E_AjusteCOD_ACR> getAjustesCOD(String aut, String codcob, Connection con) {
		List<E_AjusteCOD_ACR> ajustes = new LinkedList<>();
		try {
			String query = "SELECT NOGUIA,TIPO,CODCOB,APLICADO,DESCRIPCION,MONTO,AUTORIZACION " + "FROM AJUSTESCOD_ACR "
					+ "WHERE APLICADO=? " + "AND AUTORIZACION = ? " + "AND CODCOB = ? ";

			ps = con.prepareStatement(query);
			ps.setString(1, "S");
			ps.setString(2, aut);
			ps.setString(3, codcob);

			rs = ps.executeQuery();
			while (rs.next()) {
				E_AjusteCOD_ACR ajuste = new E_AjusteCOD_ACR();
				ajuste.setAplicado(rs.getString("APLICADO"));
				ajuste.setAutorizacion(rs.getString("AUTORIZACION"));
				ajuste.setCodCob(rs.getString("CODCOB"));
				ajuste.setDescripcion(rs.getString("DESCRIPCION"));
				ajuste.setMonto(rs.getString("MONTO"));
				ajuste.setNoguia(rs.getString("NOGUIA"));
				ajuste.setTipo(rs.getString("TIPO"));
				ajustes.add(ajuste);
			}

		} catch (Exception e) {
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			e.printStackTrace();
		} finally {
			CloseAll(null, ps, rs);
		}
		return ajustes;
	}

	public List<E_AjusteCOD_ACR> getAjustesCOD(String aut) {
		List<E_AjusteCOD_ACR> ajustes = new LinkedList<>();
		con = getConnection();
		try {
			String query = "SELECT NOGUIA,TIPO,CODCOB,APLICADO,DESCRIPCION,MONTO,AUTORIZACION " + "FROM AJUSTESCOD_ACR "
					+ "WHERE APLICADO=? AND AUTORIZACION = ? ";

			ps = con.prepareStatement(query);
			ps.setString(1, "S");
			ps.setString(2, aut);

			rs = ps.executeQuery();
			while (rs.next()) {
				E_AjusteCOD_ACR ajuste = new E_AjusteCOD_ACR();
				ajuste.setAplicado(rs.getString("APLICADO"));
				ajuste.setAutorizacion(rs.getString("AUTORIZACION"));
				ajuste.setCodCob(rs.getString("CODCOB"));
				ajuste.setDescripcion(rs.getString("DESCRIPCION"));
				ajuste.setMonto(rs.getString("MONTO"));
				ajuste.setNoguia(rs.getString("NOGUIA"));
				ajuste.setTipo(rs.getString("TIPO"));
				ajustes.add(ajuste);
			}

		} catch (Exception e) {
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			e.printStackTrace();
		} finally {
			CloseAll(null, ps, rs);
		}
		return ajustes;
	}

}
