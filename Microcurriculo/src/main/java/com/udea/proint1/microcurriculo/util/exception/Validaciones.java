package com.udea.proint1.microcurriculo.util.exception;

public class Validaciones {
	
	public static boolean isTextoVacio(String texto) {
		if (null == texto)
			return true;
		texto = texto.trim();
		if ("".equals(texto)) {
			return true;
		}
		return false;
	}
	
	public static boolean validarSoloNumeros(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!(text.charAt(i) > 47 && text.charAt(i) < 58)) {
				return false;
			}
		}
		return true;
	}

}
