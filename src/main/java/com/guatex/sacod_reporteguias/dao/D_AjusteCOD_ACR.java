package com.guatex.sacod_reporteguias.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.guatex.sacod_reporteguias.entities.Guia;

public class D_AjusteCOD_ACR extends Conexion {
	public static final Logger logger = LogManager.getLogger(Guias_Querys.class);
	private Connection con;
	private ResultSet rs;
	private CallableStatement cs;
	private PreparedStatement ps;

	public boolean InsertAjusteAcr_Debito(String noguia, String descripcion) {
		try {
			con = getConnection();
			Guia guia = new Guias_Querys().getDataGuiaCOD(noguia);
			
			String query = "INSERT INTO AJUSTESCOD_ACR(NOGUIA,TIPO,CODCOB,APLICADO,DESCRIPCION,MONTO) VALUES (?,?,?,?,?,?)";
			
			ps = con.prepareStatement(query);
			ps.setString(1, noguia);
			ps.setString(2, "D");
			ps.setString(3, guia.getCODCOB());
			ps.setString(4, "N");
			ps.setString(5, descripcion);
			ps.setString(6, guia.getVALORACREDITAR());

			boolean insertAjuste1 = ps.executeUpdate() > 0;
			
			ps.setString(6, guia.getVALORSERVICIO());
			
			boolean insertAjuste2 = ps.executeUpdate() > 0;
			
			return insertAjuste1 && insertAjuste2;

		} catch (Exception e) {
			logger.info("\nAlgo malió sal,err:" + e.getMessage());
			e.printStackTrace();
		} finally {
			CloseAll(con, ps, rs);
		}
		return false;
	}

	public boolean InsertAjusteAcr_Credito(String codcob, String monto, String descripcion) {
		try {
			con = getConnection();			
			String query = "INSERT INTO AJUSTESCOD_ACR(NOGUIA,TIPO,CODCOB,APLICADO,DESCRIPCION,MONTO) VALUES (?,?,?,?,?,?)";
			
			ps = con.prepareStatement(query);
			ps.setString(1, "");
			ps.setString(2, "C");
			ps.setString(3, codcob);
			ps.setString(4, "N");
			ps.setString(5, descripcion);
			ps.setString(6, monto);

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
}
