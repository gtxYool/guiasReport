package com.guatex.sacod_reporteguias;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guatex.sacod_reporteguias.dao.*;
import com.guatex.sacod_reporteguias.entities.*;

@RestController
@RequestMapping("/AcrCOD")
public class Acr_RestCtrl {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(Acr_RestCtrl.class, args); }
	 */

	public static final Logger logger = LogManager.getLogger(Acr_RestCtrl.class);

	@GetMapping("/TotalXAcreditar")
	public List<ClienteXAcreditacion> getClientesPendientesXAcreditar(@RequestParam String fechaIni,
			@RequestParam String fechaFin) throws SQLException {
		List<ClienteXAcreditacion> pendientes = null;
		try {
			pendientes = new Guias_Querys().getClientesPendientesXAcrediatar(fechaIni, fechaFin);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return pendientes;

	}

	@GetMapping("/TotalAcreditado")
	public List<ResumenAcreditacion> getClientesAcreditados(@RequestParam String fechaIni,
			@RequestParam String fechaFin) throws SQLException {
		List<ResumenAcreditacion> pendientes = null;
		try {
			pendientes = new Guias_Querys().getClientesAcreditados(fechaIni, fechaFin);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return pendientes;

	}

	@GetMapping("/ResumenAcreditacion")
	public List<ResumenAcreditacion> getResumenAcreditacion(@RequestParam String fechaIni,
			@RequestParam String fechaFin) throws SQLException {
		List<ResumenAcreditacion> pendientes = null;
		try {
			pendientes = new Guias_Querys().getResumenAcreditacion(fechaIni, fechaFin);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return pendientes;

	}

	@GetMapping("/ResumenAcreditacionAU")
	public List<ResumenAcreditacion> getResumenAcreditacionAU(@RequestParam String autorizacion) throws SQLException {
		List<ResumenAcreditacion> pendientes = new LinkedList<ResumenAcreditacion>();
		try {
			for (String s : autorizacion.split(",")) {
				pendientes.addAll(new Guias_Querys().getResumenAcreditacionAU(s.trim()));
			}

		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return pendientes;

	}

	@GetMapping("/GuiasXAcreditarxCliente")
	public List<GuiaxAcreditar> getGuiasXAcreditar_xCliente(@RequestParam String autorizacion,
			@RequestParam String codcob) throws SQLException {
		List<GuiaxAcreditar> pendientes = new LinkedList<GuiaxAcreditar>();
		try {
			for (String s : autorizacion.split(",")) {
				pendientes.addAll(new Guias_Querys().getGuiasXAcreditar_xCliente(autorizacion, codcob));
			}
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e);
			e.printStackTrace();
		}
		return pendientes;

	}

	@GetMapping("/RecibosCajaxCliente")
	public List<ReciboCaja> getRecibosCajaxCliente(@RequestParam String fechaIni, @RequestParam String fechaFin,
			@RequestParam String codigos, @RequestParam String acr) {
		List<ReciboCaja> recibos = new LinkedList<ReciboCaja>();
		try {
			for (String s : codigos.split(",")) {
				recibos.addAll(new Liquidacion_Querys().getRecibosCajaxCliente(fechaIni, fechaFin, s));
				System.out.println(s);
			}
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e);
			e.printStackTrace();
		}
		// filtro por acreditado o no, segun el valor de acr
		if (acr.isEmpty()) {
			return recibos;
		} else if (acr.equalsIgnoreCase("S")) {
			return recibos.stream().filter(recibo -> recibo.getAcreditado().equalsIgnoreCase("SI"))
					.collect(Collectors.toList());
		} else {
			return recibos.stream().filter(recibo -> recibo.getAcreditado().equalsIgnoreCase("NO"))
					.collect(Collectors.toList());
		}
	}

	@GetMapping("/RecibosCajaxAgencia")
	public List<ReciboCaja> getRecibosCajaxAgencia(@RequestParam String fechaIni, @RequestParam String fechaFin,
			@RequestParam String codigos, @RequestParam String acr) {
		List<ReciboCaja> recibos = new LinkedList<ReciboCaja>();
		try {
			for (String s : codigos.split(",")) {
				recibos.addAll(new Liquidacion_Querys().getRecibosCajaxAgencia(fechaIni, fechaFin, s));
				System.out.println(s);
			}
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e);
			e.printStackTrace();
		}
		// filtro por acreditado o no, segun el valor de acr
		if (acr.isEmpty()) {
			return recibos;
		} else if (acr.equalsIgnoreCase("S")) {
			return recibos.stream().filter(recibo -> recibo.getAcreditado().equalsIgnoreCase("SI"))
					.collect(Collectors.toList());
		} else {
			return recibos.stream().filter(recibo -> recibo.getAcreditado().equalsIgnoreCase("NO"))
					.collect(Collectors.toList());
		}
	}

	@GetMapping("/RecibosCaja")
	public List<ReciboCaja> getRecibosCaja(@RequestParam String fechaIni, @RequestParam String fechaFin,
			@RequestParam String acr) {
		List<ReciboCaja> recibos = new LinkedList<ReciboCaja>();
		try {
			recibos.addAll(new Liquidacion_Querys().getRecibosCaja(fechaIni, fechaFin));
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e);
			e.printStackTrace();
		}
		// filtro por acreditado o no, segun el valor de acr
		if (acr.isEmpty()) {
			return recibos;
		} else if (acr.equalsIgnoreCase("S")) {
			return recibos.stream().filter(recibo -> recibo.getAcreditado().equalsIgnoreCase("SI"))
					.collect(Collectors.toList());
		} else {
			return recibos.stream().filter(recibo -> recibo.getAcreditado().equalsIgnoreCase("NO"))
					.collect(Collectors.toList());
		}

	}

	@GetMapping("/ReciboCOD")
	public ReciboCaja getReciboCOD(@RequestParam String recibo) {
		String[] tmp = recibo.split("-");
		System.out.println("recibo: " + recibo + " " + tmp.length);
		if (tmp.length > 1) {
			String serie = tmp[0];
			String numero = tmp[1];
			System.out.println(serie + "-" + numero);
			if (!serie.isEmpty() && !numero.isEmpty()) {
				try {
					return new Liquidacion_Querys().getRecibo(serie.trim(), numero.trim());
				} catch (Exception e) {
					logger.info("Algo malio sal... err: " + e);
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@GetMapping("/ReciboCODxGuia")
	public ReciboCaja getReciboCODxGuia(@RequestParam String noguia) {
		String temp = new Liquidacion_Querys().getNumRecibo(noguia);
		if (!temp.isEmpty()) {
			String[] tmp = temp.split("-");
			try {
				String serie = tmp[0];
				String numero = tmp[1];
				return new Liquidacion_Querys().getRecibo(serie, numero);
			} catch (Exception e) {
				logger.info("Algo malio sal... err: " + e);
				e.printStackTrace();
			}
		}
		return null;
	}

	@GetMapping("/PuntosLiquidacion")
	public List<PuntoLiquidacion> getPuntosLiquidacion() {
		return new Liquidacion_Querys().getPuntosLiquidacion();
	}

	/**
	 * 
	 * @param noguia
	 * @param descripcion
	 * @return
	 */
	@PutMapping("/InsertAjusteDebito")
	public boolean InsertAjusteDebito(@RequestParam String noguia, @RequestParam String descripcion,
			@RequestParam String usuario) {
		return new D_AjusteCOD_ACR().InsertAjusteAcr_Debito(noguia, descripcion, usuario);
	}

	/**
	 * 
	 * @param codcob
	 * @param monto
	 * @param descripcion
	 * @return
	 */
	@PutMapping("/InsertAjusteCredito")
	public boolean InsertAjusteCredito(@RequestParam String codcob, @RequestParam String monto,
			@RequestParam String descripcion, @RequestParam String usuario) {
		return new D_AjusteCOD_ACR().InsertAjusteAcr_Credito(codcob, monto, descripcion, usuario);
	}

	/**
	 * 
	 * @param codcob
	 * @param monto
	 * @param descripcion
	 * @return
	 */
	@GetMapping("/getAjustesCOD")
	public List<E_AjusteCOD_ACR> getAjustesCOD(@RequestParam String autorizacion, @RequestParam String codcob,
			@RequestParam String noguia, @RequestParam int tipo) {
		D_AjusteCOD_ACR AjusteCOD = new D_AjusteCOD_ACR();
		return tipo == 0 ? AjusteCOD.getAjustesCOD(autorizacion, codcob, noguia)
				: tipo == 1
						? AjusteCOD.getAjustesCOD(autorizacion, codcob, noguia).stream()
								.filter(ajus -> ajus.getTipo().contains("D")).collect(Collectors.toList())
						: AjusteCOD.getAjustesCOD(autorizacion, codcob, noguia).stream()
								.filter(ajus -> ajus.getTipo().contains("C")).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param autorizacion
	 * @return
	 */
	@GetMapping("/getAjustesCODAp")
	public List<E_AjusteCOD_ACR> getAjustesCODAp(@RequestParam String autorizacion) {
		List<E_AjusteCOD_ACR> ajustes = new LinkedList<>();
		ajustes.addAll(new D_AjusteCOD_ACR().getAjustesCOD(autorizacion));
		return ajustes;
	}

	/**
	 * obtiene los ajustes o notas de debito/credito y las anulaciones este metodo
	 * para un rango de fechas y autorizacion, tambien llama al metodo para enlazar
	 * las anulaciones a una autorizacion
	 * 
	 * @param autorizacion numero de autorizacion o IDREPORTE
	 * @param fechaIni     fecha de inicio para el rango de autorizacion
	 * @param fechaFin     fecha de fin para el rango de autorizacion
	 * @return listado de ajustes y anulaciones
	 */
	@GetMapping("/getAjustesYAnulacionesCOD")
	public List<E_AjusteCOD_ACR> getAjustesYAnulacionesCOD(@RequestParam String autorizacion,
			@RequestParam String fechaIni, @RequestParam String fechaFin) {

		List<E_AjusteCOD_ACR> ajustes = new LinkedList<>();
		ajustes.addAll(new D_AjusteCOD_ACR().getAjustesCOD(autorizacion));
		ajustes.addAll(new D_AnulacionCOD().getAnulacionesCOD(autorizacion, fechaIni, fechaFin));
		new D_AnulacionCOD().updateAnulacionesCOD(autorizacion, fechaIni, fechaFin);// enlaza las anulaciones a una
																					// autorizacion
		return ajustes;
	}

	/**
	 * obtiene los ajustes o notas de debito/credito y las anulaciones este metodo
	 * se llamara desde las reimpresiones
	 * 
	 * @param autorizacion numero de autorizacion o IDREPORTE
	 * @return listado de ajustes y anulaciones
	 */
	@GetMapping("/getAjustesYAnulacionesCOD")
	public List<E_AjusteCOD_ACR> getAjustesYAnulacionesCOD(@RequestParam String autorizacion) {
		List<E_AjusteCOD_ACR> ajustes = new LinkedList<>();
		ajustes.addAll(new D_AjusteCOD_ACR().getAjustesCOD(autorizacion));
		ajustes.addAll(new D_AnulacionCOD().getAnulacionesCOD(autorizacion));
		return ajustes;
	}

	/**
	 * Método llamado por el cliente para la anulación COD
	 * 
	 * @param noguia
	 * @param desc
	 * @param usuario
	 * @return
	 */
	@GetMapping("/anulacioncod")
	public String anulacionCOD(@RequestParam String noguia, @RequestParam String desc, @RequestParam String usuario) {
		return new D_AnulacionCOD().AnulacionCOD(noguia, desc, usuario);
	}

	/**
	 * 
	 * @param fechaIni
	 * @param fechaFin
	 * @return
	 * @throws SQLException
	 */
	@GetMapping("/getBoletasEscaneadas")
	public List<E_BoletaxRecibo> getBoletasEscaneadas(@RequestParam String fechaIni, @RequestParam String fechaFin)
			throws SQLException {
		List<E_BoletaxRecibo> pendientes = null;
		try {
			pendientes = new Liquidacion_Querys().getBoletasEscaneadas(fechaIni, fechaFin);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return pendientes;

	}

}
