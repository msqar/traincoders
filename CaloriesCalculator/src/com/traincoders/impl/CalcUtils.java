package com.traincoders.impl;

import android.annotation.SuppressLint;

@SuppressLint("DefaultLocale")
public class CalcUtils
{
    public static final String MALE_EN = "Male";
	public static final String FEMALE_EN = "Female";
	
    public static final String MALE_ES = "Hombre";
	public static final String FEMALE_ES = "Mujer";
	
	public static final String WEIGHT_REQ_ERROR_EN = "Weight is required";
	public static final String HEIGHT_REQ_ERROR_EN = "Height is required";
	public static final String AGE_REQ_ERROR_EN = "Age is required"; 
	public static final String CMKG_MEASURE_EN = "Centimeters-Kilograms";
	
	public static final String WEIGHT_REQ_ERROR_ES = "Peso es requerido";
	public static final String HEIGHT_REQ_ERROR_ES = "Altura es requerida";
	public static final String AGE_REQ_ERROR_ES = "Edad es requerida"; 
	public static final String CMKG_MEASURE_ES = "Centímetros-Kilogramos";
	
	
	public static String convertCentimeterToInches(String value) {
		Float val = Float.valueOf(value) * 0.393701f;
		return String.format("%.0f", val);
	}
	
	public static String convertKilogramsToPounds(String value) {
		Float val = Float.valueOf(value) * 2.20462f;
		return String.format("%.0f", val);
	}
}
