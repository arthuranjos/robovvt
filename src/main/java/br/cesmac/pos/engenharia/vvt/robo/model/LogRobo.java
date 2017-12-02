package br.cesmac.pos.engenharia.vvt.robo.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class LogRobo {
	
	public static final String DIREITA = "DIREITA";
	public static final String ESQUERDA = "ESQUERDA";
	public static final String CIMA = "CIMA";
	public static final String BAIXO = "BAIXO";
	
	private Robo robo;
	private int numeroDePassos;
	private String movimentacao;
	
	public LogRobo (Robo robo, int numeroDePassos, String movimentacao) {
		this.robo = robo;
		this.numeroDePassos = numeroDePassos;
		this.movimentacao = movimentacao;
	}
	
	public void salvarLogEmArquivo() throws IOException {
		FileWriter arq = new FileWriter("C:\\Users\\Arthur\\eclipse-workspace\\robo\\Log"+robo.getNome()+".txt", true);
	    PrintWriter gravarArq = new PrintWriter(arq);
	    
	    gravarArq.println("Log do robô: " + robo.getNome() + " às " + Calendar.getInstance().getTime());
	    gravarArq.println("Número de Passos: " + numeroDePassos);
	    gravarArq.println("Direção do movimento: " + movimentacao);
	    gravarArq.println(robo.mostrarCoordenadas());
	    gravarArq.println("");
	    arq.close();
	}
	
	

}
