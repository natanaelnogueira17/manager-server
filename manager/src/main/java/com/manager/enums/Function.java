package com.manager.enums;

public enum Function {

	SALES_MANAGER(0, "Gerente Comercial"),
	FINANCIAL_MANAGER(1, "Gerente Financeiro"),
	SELLER(2, "Vendedora"),
	IT_ANALYST(3, "Analista de TI"),
	STOCKHOLDER(4, "Estoquista");

    private final int number;
    private final String name;

    // Construtor do Enum
    Function(int numero, String nome) {
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
