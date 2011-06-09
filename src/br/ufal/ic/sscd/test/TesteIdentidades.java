/**
 * 
 */
package br.ufal.ic.sscd.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufal.ic.sscd.resolver.Resolver;

/**
 * @author priscylla
 *
 */
public class TesteIdentidades {
	
	@Test
	public void teste1() throws Exception {
		Resolver r = new Resolver("/(A.B)");
		r.ParserStack();
		assertEquals("[A, B, ., /]",r.Resul().toString());//resultado
	}
	
	@Test
	public void teste2() throws Exception {
		Resolver r = new Resolver("/(A.B)+C)");
		r.ParserStack();
		assertEquals("[A, B, ., /, C, +]",r.getSaida().toString());//saida
	}
	
	@Test
	public void teste3() throws Exception {
		Resolver r = new Resolver("/(A.B).C)");
		r.ParserStack();
		assertEquals("[A, B, ., /, C, .]",r.getSaida().toString());//saida
	}

}
