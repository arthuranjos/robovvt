package br.cesmac.pos.engenharia.vvt.robo.model;

import java.io.IOException;

public class Robo {

	private String nome;
	private int coordenadaX;
	private int coordenadaY;
	private int limiteX;
	private int limiteY;

	public Robo(String nome, int limiteX, int limiteY, int coordenadaX, int coordenadaY) {
		this.nome = nome;
		this.limiteX = limiteX;
		this.limiteY = limiteY;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

	public void andarParaDireita(int numeroDePassos) throws IOException {	
		if(coordenadaX < limiteX) {
			if(limiteX - coordenadaX >= numeroDePassos) {
				this.coordenadaX = coordenadaX + numeroDePassos;
				new LogRobo(this, numeroDePassos, LogRobo.DIREITA).salvarLogEmArquivo();
			}
		} else 
			throw new LimiteExcedidoException();
	}
	
	public void andarParaEsquerda(int numeroDePassos) throws IOException {	
		if(coordenadaX > 1) {
			if(coordenadaX - numeroDePassos >= 1) {
				this.coordenadaX = coordenadaX - numeroDePassos;
				new LogRobo(this, numeroDePassos, LogRobo.ESQUERDA).salvarLogEmArquivo();
			}
		} else 
			throw new LimiteExcedidoException();
	}
	
	public void andarParaCima(int numeroDePassos) throws IOException {	
		if(coordenadaY < limiteY) {
			if(limiteY - coordenadaY >= numeroDePassos) {
					this.coordenadaY = coordenadaY + numeroDePassos;
					new LogRobo(this, numeroDePassos, LogRobo.CIMA).salvarLogEmArquivo();
			}
		} else 
			throw new LimiteExcedidoException();
	}
	
	public void andarParaBaixo(int numeroDePassos) throws IOException {	
		if(coordenadaY > 1) {
			if(coordenadaY - numeroDePassos >= 1) {
				this.coordenadaY = coordenadaY - numeroDePassos;
				new LogRobo(this, numeroDePassos, LogRobo.BAIXO).salvarLogEmArquivo();
			}
		} else 
			throw new LimiteExcedidoException();
	}
	
	public int getCoordenadaX(){
		return this.coordenadaX;
	}
	
	public int getCoordenadaY(){
		return this.coordenadaY;
	}
	
	public void setPosicaoInicial(int x, int y) {
		this.coordenadaX = x;
		this.coordenadaY = y;
	}
	
	public String mostrarCoordenadas() {
		return "A posição atual do Robô: "+ nome +" é: (" + coordenadaX + ","+ coordenadaY + ")";
	}
	
	public String getNome() {
		return this.nome;
	}

}
