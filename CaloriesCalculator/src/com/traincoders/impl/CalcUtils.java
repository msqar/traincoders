package com.traincoders.impl;

import android.annotation.SuppressLint;

@SuppressLint("DefaultLocale")
public class CalcUtils
{
    public static final String MALE = "Male";
	public static final String FEMALE = "Female";
	public static final String WEIGHT_REQ_ERROR = "Weight is required";
	public static final String HEIGHT_REQ_ERROR = "Height is required";
	public static final String AGE_REQ_ERROR = "Age is required"; 
	public static final String CMKG_MEASURE = "Centimeters-Kilograms";
	
	public static String convertCentimeterToInches(String value) {
		Float val = Float.valueOf(value) * 0.393701f;
		return String.format("%.0f", val);
	}
	
	public static String convertKilogramsToPounds(String value) {
		Float val = Float.valueOf(value) * 2.20462f;
		return String.format("%.0f", val);
	}
}
