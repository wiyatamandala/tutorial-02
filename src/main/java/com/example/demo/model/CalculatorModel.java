package com.example.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CalculatorModel {
	private int angka_satu;
	private int angka_dua;

	String[] nomina = { "", 
						"Satu", 
						"Dua", 
						"Tiga", 
						"Empat", 
						"Lima", 
						"Enam", 
						"Tujuh", 
						"Delapan", 
						"Sembilan", 
						"Sepuluh", 
						"Sebelas" 
						};

	public CalculatorModel() {
		super();
	}

	public int getAngka_satu() {
		return angka_satu;
	}

	public void setAngka_satu(int angka_satu) {
		this.angka_satu = angka_satu;
	}

	public int getAngka_dua() {
		return angka_dua;
	}

	public void setAngka_dua(int angka_dua) {
		this.angka_dua = angka_dua;
	}

	public int proses(int a, int b) {
		int hasil = a + b;
		return hasil;
	}

	public String terbilang(int hasil) {
		if (hasil < 12) {
			return nomina[(int) hasil];
		}

		if (hasil >= 12 && hasil <= 19) {
			return nomina[(int) hasil % 10] + " Belas ";
		}

		if (hasil >= 20 && hasil <= 99) {
			return nomina[(int) hasil / 10] + " Puluh " + nomina[(int) hasil % 10];
		}

		if (hasil >= 100 && hasil <= 199) {
			return "Seratus " + terbilang(hasil % 100);
		}

		if (hasil >= 200 && hasil <= 999) {
			return nomina[(int) hasil / 100] + " Ratus " + terbilang(hasil % 100);
		}

		if (hasil >= 1000 && hasil <= 1999) {
			return "Seribu " + terbilang(hasil % 1000);
		}

		if (hasil >= 2000 && hasil <= 999999) {
			return terbilang((int) hasil / 1000) + " Ribu " + terbilang(hasil % 1000);
		}

		if (hasil >= 1000000 && hasil <= 999999999) {
			return terbilang((int) hasil / 1000000) + " Juta " + terbilang(hasil % 1000000);
		}

		return "";
	}
}
