package com.guatex.sacod_reporteguias;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guatex.sacod_reporteguias.dao.*;
import com.guatex.sacod_reporteguias.entities.*;


@RestController
@RequestMapping("/AcrCOD")
public class Acr_RestCtrl {

	public static void main(String[] args) {
		SpringApplication.run(Acr_RestCtrl.class, args);
	}

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
			@RequestParam String codigos) {
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
		return recibos;
	}

	@GetMapping("/RecibosCaja")
	public List<ReciboCaja> getRecibosCaja(@RequestParam String fechaIni, @RequestParam String fechaFin) {
		List<ReciboCaja> recibos = new LinkedList<ReciboCaja>();
		try {
			for (PuntoLiquidacion p : new Liquidacion_Querys().getPuntosLiquidacion()) {
				recibos.addAll(new Liquidacion_Querys().getRecibosCajaxCliente(fechaIni, fechaFin, p.getCodigo()));
			}
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e);
			e.printStackTrace();
		}
		return recibos;
	}

	@GetMapping("/ReciboCOD")
	public ReciboCaja getReciboCOD(@RequestParam String recibo) {
		String[] tmp = recibo.split("-");
		System.out.println("recibo: "+recibo+" "+tmp.length);
		if (tmp.length > 1) {
			String serie = tmp[0];
			String numero = tmp[1];
			System.out.println(serie+"-"+numero);
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
}
