package com.guatex.sacod_reporteguias.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class Gtools {
	/**
	 * 
	 * @param var
	 * @return
	 */
	public static String notNull(String var) {
		return var != null ? var.trim() : "";
	}

	/**
	 * 
	 * @param var
	 * @return
	 */
	public static Integer notNull(Integer var) {
		return var != null ? var : 0;
	}

	/**
	 * 
	 * @param var
	 * @return
	 */
	public static Double notNull(Double var) {
		return var != null ? var : 0.00;
	}

	/**
	 * 
	 * @param var
	 * @return
	 */
	public static Boolean notNull(Boolean var) {
		return var != null ? var : false;
	}

	/**
	 * 
	 * @param act
	 * @param porSumar
	 * @return
	 */
	public static String sumarDoblesStrings(String act, String porSumar) {
		Double dact = doubleFromString(act);
		Double dporSumar = doubleFromString(porSumar);
		return String.valueOf((dact + dporSumar));
	}

	/**
	 * 
	 * @param act
	 * @param porSumar
	 * @return
	 */
	public static String sumarIntStrings(String act, String porSumar) {
		Integer iact = intFromString(act);
		Integer iporSumar = intFromString(porSumar);
		return String.valueOf((iact + iporSumar));
	}

	/**
	 * 
	 * @param val
	 * @return
	 */
	public static Double doubleFromString(String val) {
		val = notNull(val);
		try {
			BigDecimal big = new BigDecimal(val);
			big = big.setScale(6, RoundingMode.HALF_UP);
			return big.doubleValue();
		} catch (Exception e) {

		}
		return 0.0;
	}

	/**
	 * 
	 * @param val
	 * @return
	 */
	public static Integer intFromString(String val) {
		val = notNull(val);
		Integer valor = 0;
		try {
			valor = Integer.valueOf(val);
		} catch (Exception e) {

		}
		return valor;
	}

	public static Double Redondear(String val) {
		BigDecimal big = new BigDecimal(!notNull(val).isEmpty() ? val : "0.00");
		big = big.setScale(6, RoundingMode.HALF_UP);
		return big.doubleValue();
	}

	public static Double Redondear(Double val) {
		BigDecimal big = new BigDecimal(notNull(val));
		big = big.setScale(6, RoundingMode.HALF_UP);
		return big.doubleValue();
	}

	public static String redondearString(String val) {
		return String.valueOf(Redondear(val));
	}

	public static BigDecimal doubleToBigDecimal(Double val) {
		BigDecimal big = new BigDecimal(notNull(val));
		big = big.setScale(6, RoundingMode.HALF_UP);
		return big;
	}

	public static Double Redondear_NOIVA(Double val, Double IVA) {
		val = notNull(val) / (1 + (IVA / 100));
		BigDecimal big = new BigDecimal(notNull(val));
		big = big.setScale(6, RoundingMode.HALF_UP);
		return big.doubleValue();
	}

	public static BigDecimal doubleToBigDecimal_NOIVA(Double val, Double IVA) {
		val = notNull(val) / (1 + (IVA / 100));
		BigDecimal big = new BigDecimal(notNull(val));
		big = big.setScale(6, RoundingMode.HALF_UP);
		return big;
	}

	public static String redondear2Decimales(String val) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		return nf.format(doubleFromString(val));
	}
}
