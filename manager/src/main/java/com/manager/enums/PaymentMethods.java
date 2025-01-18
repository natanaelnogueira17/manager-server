package com.manager.enums;

public enum PaymentMethods {

	ESPECIES(0, "especies"),
	CARD(1, "cartao"),
	PIX(2, "pix"),
	SITE(3, "site");

    private final int number;
    private final String name;

    // Construtor do Enum
    PaymentMethods(int numero, String nome) {
        this.number = numero;
        this.name = nome;
    }

    // Métodos para acessar os dados
    public int getNumero() {
        return number;
    }

    public String getNome() {
        return name;
    }

	 

}
