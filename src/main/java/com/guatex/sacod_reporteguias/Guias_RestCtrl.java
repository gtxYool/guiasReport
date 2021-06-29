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
@RequestMapping("/GuiaCOD")
public class Guias_RestCtrl {

	public static void main(String[] args) {
		SpringApplication.run(Guias_RestCtrl.class, args);
	}

	public static final Logger logger = LogManager.getLogger(Guias_RestCtrl.class);

	@GetMapping("/General")
	public List<Guia> getGuiasCOD_General(@RequestParam String fechaIni, @RequestParam String fechaFin) {
		List<Guia> guias = new LinkedList<Guia>();
		try {
			guias = new Guias_Querys().getGuiasCOD_General(fechaIni, fechaFin);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/GeneralXCliente")
	public List<Guia> getGuiasCOD_GeneralXCliente(@RequestParam String fechaIni, @RequestParam String fechaFin,
			@RequestParam String codigo) {
		List<Guia> guias = new LinkedList<Guia>();
		try {
			guias = new Guias_Querys().getGuiasCOD_GeneralXCliente(fechaIni, fechaFin, codigo);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/Entregadas")
	public List<Guia> getGuiasCOD_Entregadas(@RequestParam String fechaIni, @RequestParam String fechaFin) {
		List<Guia> guias = new LinkedList<Guia>();
		try {
			guias = new Guias_Querys().getGuiasCOD_Entregadas(fechaIni, fechaFin);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/EntregadasXCliente")
	public List<Guia> getGuiasCOD_EntregadasXCliente(@RequestParam String fechaIni, @RequestParam String fechaFin,
			@RequestParam String codigo) {
		List<Guia> guias = new LinkedList<Guia>();
		try {
			guias = new Guias_Querys().getGuiasCOD_EntregadasXCliente(fechaIni, fechaFin, codigo);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/Recolectadas")
	public List<Guia> getGuiasCOD_Recolectadas(@RequestParam String fechaIni, @RequestParam String fechaFin) {
		List<Guia> guias = new LinkedList<Guia>();
		try {
			guias = new Guias_Querys().getGuiasCOD_Recolectadas(fechaIni, fechaFin);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/RecolectadasXCliente")
	public List<Guia> getGuiasCOD_RecolectadasXCliente(@RequestParam String fechaIni, @RequestParam String fechaFin,
			@RequestParam String codigo) {
		List<Guia> guias = new LinkedList<Guia>();
		try {
			guias = new Guias_Querys().getGuiasCOD_RecolectadasXCliente(fechaIni, fechaFin, codigo);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/Liquidadas")
	public List<GuiaF> getGuiasCOD_Liquidadas(@RequestParam String fechaIni, @RequestParam String fechaFin) {
		List<GuiaF> guias = new LinkedList<GuiaF>();
		try {
			guias = new Guias_Querys().getGuiasCOD_Liquidadas(fechaIni, fechaFin);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/LiquidadasXCliente")
	public List<GuiaF> getGuiasCOD_LiquidadasXCliente(@RequestParam String fechaIni, @RequestParam String fechaFin,
			@RequestParam String codigo) {
		List<GuiaF> guias = new LinkedList<GuiaF>();
		try {
			guias = new Guias_Querys().getGuiasCOD_LiquidadasXCliente(fechaIni, fechaFin, codigo);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/NoLiquidadas")
	public List<GuiaF> getGuiasCOD_NoLiquidadas(@RequestParam String fechaIni, @RequestParam String fechaFin) {
		List<GuiaF> guias = new LinkedList<GuiaF>();
		try {
			guias = new Guias_Querys().getGuiasCOD_NoLiquidadas(fechaIni, fechaFin);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/NoLiquidadasXCliente")
	public List<GuiaF> getGuiasCOD_NoLiquidadasXCliente(@RequestParam String fechaIni, @RequestParam String fechaFin,
			@RequestParam String codigo) {
		List<GuiaF> guias = new LinkedList<GuiaF>();
		try {
			guias = new Guias_Querys().getGuiasCOD_NoLiquidadasXCliente(fechaIni, fechaFin, codigo);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/getGuiasXLiquidacion")
	public List<GuiaXLiquidacion> getGuiasXLiquidacion(@RequestParam String codigo) {
		List<GuiaXLiquidacion> guias = new LinkedList<GuiaXLiquidacion>();
		try {
			guias = new Liquidacion_Querys().getGuiasXLiquidacion(codigo);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/searchGuiasXLiquidacionR")
	public List<GuiaXLiquidacion> searchGuiasXLiquidacionR(@RequestParam String serie, @RequestParam String numero) {
		List<GuiaXLiquidacion> guias = new LinkedList<GuiaXLiquidacion>();
		try {
			String codigo = new Liquidacion_Querys().getCodigoLiquidacion(serie, numero);
			guias = new Liquidacion_Querys().getGuiasXLiquidacion(codigo);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/searchGuiasXLiquidacionG")
	public List<GuiaXLiquidacion> searchGuiasXLiquidacionG(@RequestParam String guia) {
		List<GuiaXLiquidacion> guias = new LinkedList<GuiaXLiquidacion>();
		try {
			String codigo = new Liquidacion_Querys().getCodigoLiquidacion(guia);
			guias = new Liquidacion_Querys().getGuiasXLiquidacion(codigo);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/Facturadas")
	public List<GuiaF> getGuiasCOD_Facturadas(@RequestParam String fechaIni, @RequestParam String fechaFin) {
		List<GuiaF> guias = new LinkedList<GuiaF>();
		try {
			guias = new Guias_Querys().getGuiasCOD_Facturadas(fechaIni, fechaFin);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/FacturadasXCliente")
	public List<GuiaF> getGuiasCOD_FacturadasXCliente(@RequestParam String fechaIni, @RequestParam String fechaFin,
			@RequestParam String codigo) {
		List<GuiaF> guias = new LinkedList<GuiaF>();
		try {
			guias = new Guias_Querys().getGuiasCOD_FacturadasXCliente(fechaIni, fechaFin, codigo);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/NoFacturadas")
	public List<GuiaF> getGuiasCOD_NoFacturadas(@RequestParam String fechaIni, @RequestParam String fechaFin) {
		List<GuiaF> guias = new LinkedList<GuiaF>();
		try {
			guias = new Guias_Querys().getGuiasCOD_NoFacturadas(fechaIni, fechaFin);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}

	@GetMapping("/NoFacturadasXCliente")
	public List<GuiaF> getGuiasCOD_NoFacturadasXCliente(@RequestParam String fechaIni, @RequestParam String fechaFin,
			@RequestParam String codigo) {
		List<GuiaF> guias = new LinkedList<GuiaF>();
		try {
			guias = new Guias_Querys().getGuiasCOD_NoFacturadasXCliente(fechaIni, fechaFin, codigo);
		} catch (Exception e) {
			logger.info("Algo malio sal... err: " + e.getMessage());
			e.printStackTrace();
		}
		return guias;
	}
	@GetMapping("/getDataGuiaCOD")
	public Guia getDataGuiaCOD(@RequestParam String noguia) {
		return new Guias_Querys().getDataGuiaCOD(noguia);
	}

}
