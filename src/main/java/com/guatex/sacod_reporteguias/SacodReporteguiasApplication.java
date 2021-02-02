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

@SpringBootApplication
public class SacodReporteguiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SacodReporteguiasApplication.class, args);
	}

}
