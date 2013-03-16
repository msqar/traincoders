package com.traincoders.impl;

import android.annotation.SuppressLint;

@SuppressLint("DefaultLocale")
public class CalcUtils
{
    public static final String MALE = "Male";
	public static final String FEMALE = "Female";
	
	public static String convertCentimeterToInches(String value) {
		Float val = Float.valueOf(value) * 0.393701f;
		return String.format("%.0f", val);
	}

	
	public static String convertKilogramsToPounds(String value) {
		Float val = Float.valueOf(value) * 2.20462f;
		return String.format("%.0f", val);
	}
}
