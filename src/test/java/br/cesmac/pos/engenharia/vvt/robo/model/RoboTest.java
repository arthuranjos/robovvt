package br.cesmac.pos.engenharia.vvt.robo.model;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RoboTest {
	
	private Robo robo;
	private Robo robo2;
	
	@Before
	public void criaObjetos() {
		this.robo = new Robo("Arthur", 5, 5, 1, 1);
		this.robo2 = new Robo("BOT", 10, 10, 1, 1);
		//teste
	}
	
	@Test
	public void andarParaDireitaTest() throws IOException {
		robo.andarParaDireita(3);
		Assert.assertEquals(4, robo.getCoordenadaX());		
	}
	
	@Test(expected=LimiteExcedidoException.class)
	public void andarParaDireitaLimiteExcedidoTest() throws IOException {
		robo = new Robo("Teste", 5, 5, 5, 1);
		robo.andarParaDireita(1);
		Assert.assertEquals(2, robo.getCoordenadaX());		
	}
	
	@Test
	public void andarParaEsquerdaTest() throws IOException {
		robo = new Robo("Teste", 5, 5, 3, 1);
		robo.andarParaEsquerda(1);
		Assert.assertEquals(2, robo.getCoordenadaX());	
	}
	
	@Test(expected=LimiteExcedidoException.class)
	public void andarParaEsquerdaLimiteExcedidoTest() throws IOException {
		robo = new Robo("Teste", 5, 5, 1, 1);
		robo.andarParaEsquerda(1);
		Assert.assertEquals(2, robo.getCoordenadaX());	
	}
	
	@Test
	public void andarParaBaixoTest() throws IOException {
		robo = new Robo("Teste", 5, 5, 1, 3);
		robo.andarParaBaixo(1);
		Assert.assertEquals(2, robo.getCoordenadaY());	
	}
	
	@Test(expected=LimiteExcedidoException.class)
	public void andarParaBaixoLimiteExcedidoTest() throws IOException {
		robo = new Robo("Teste", 5, 5, 1, 1);
		robo.andarParaBaixo(1);
		Assert.assertEquals(2, robo.getCoordenadaY());	
	}
	
	@Test
	public void andarParaCimaTest() throws IOException {
		robo = new Robo("Teste", 5, 5, 1, 3);
		robo.andarParaCima(1);
		Assert.assertEquals(4, robo.getCoordenadaY());			
	}
	
	@Test(expected=LimiteExcedidoException.class)
	public void andarParaCimaLimiteExcedidoTest() throws IOException {
		robo = new Robo("Teste", 5, 5, 1, 5);
		robo.andarParaCima(2);
		Assert.assertEquals(5, robo.getCoordenadaY());			
	}
	
	@Test
	public void andarParaCimaEparaEsquerdaTest() throws IOException {
		robo = new Robo("Teste", 5, 5, 3, 4);
		robo.andarParaCima(1);
		robo.andarParaEsquerda(1);
		Assert.assertEquals(5, robo.getCoordenadaY());
		Assert.assertEquals(2, robo.getCoordenadaX());	
	}
	
	@Test
	public void andarParaCimaEparaDireitaTest() throws IOException {
		robo = new Robo("Teste", 5, 5, 3, 4);
		robo.andarParaCima(1);
		robo.andarParaDireita(1);
		Assert.assertEquals(5, robo.getCoordenadaY());
		Assert.assertEquals(4, robo.getCoordenadaX());	
	}
	
	@Test
	public void andarParaVariosLadosTest() throws IOException {
		robo2.andarParaCima(4);
		//y=5
		robo2.andarParaDireita(4);
		//x=5
		robo2.andarParaEsquerda(2);
		//x=3
		robo2.andarParaBaixo(2);
		//y=3
		robo2.andarParaCima(1);
		//y=4
		robo2.andarParaDireita(2);
		//x=5
		robo2.andarParaEsquerda(1);
		//x=4
		robo2.andarParaDireita(1);
		//x=5
		Assert.assertEquals(5, robo2.getCoordenadaX());
		Assert.assertEquals(4, robo2.getCoordenadaY());	
	}
	
	@Test
	public void movimentaRoboESalvaLogTest() throws IOException {
		robo = new Robo("Teste", 10, 10, 3, 4);
		robo.andarParaDireita(1);
		robo.andarParaBaixo(3);
		Assert.assertEquals(4, robo.getCoordenadaX());
		Assert.assertEquals(1, robo.getCoordenadaY());
	}

}
