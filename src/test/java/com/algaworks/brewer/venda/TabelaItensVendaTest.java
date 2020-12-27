package com.algaworks.brewer.venda;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class TabelaItensVendaTest {
	
	private TabelaItensVenda tabelaItensVenda;

	@Before
	public void setUp(){
		this.tabelaItensVenda = new TabelaItensVenda();
	}
	
	@Test
	public void deveCalcularValorTotalSemItens() throws Exception {
		//no assertEquals o primeiro valor é o valor esperado e o segundo é o valor a ser testado
		assertEquals(BigDecimal.ZERO, tabelaItensVenda.getValorTotal()); 
	}

}
