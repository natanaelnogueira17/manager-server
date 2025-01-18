package com.manager.enums;

public enum OrderStatus {

	WAITING_PAYMENT(0, "aguardando pagamento"),
	PAYMENT_CONFIRMED(1, "pagamento confirmado"),
	SENT(2, "enviado"),
	DELIVERED(3, "entregue"),
	WITHDRAWAL(4, "retirada");

    private final int number;
    private final String name;

    // Construtor do Enum
    OrderStatus(int numero, String nome) {
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
