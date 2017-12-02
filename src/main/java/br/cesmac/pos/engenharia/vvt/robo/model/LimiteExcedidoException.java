package br.cesmac.pos.engenharia.vvt.robo.model;

public class LimiteExcedidoException extends RuntimeException {
	
	public LimiteExcedidoException() {
		super("O limite do plano foi excedido!");
	}

}
