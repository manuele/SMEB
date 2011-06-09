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
public class TestesNot {
	
	@Test
	public void teste1() throws Exception {
		Resolver r = new Resolver("/0");
		r.ParserStack();
		assertEquals("[1]",r.Resul().toString());
	}
	
	@Test
	public void teste2() throws Exception {
		Resolver r = new Resolver("/1");
		r.ParserStack();
		assertEquals("[0]",r.Resul().toString());
	}
	
	@Test
	public void teste3() throws Exception {
		Resolver r = new Resolver("/A");
		r.ParserStack();
		assertEquals("[A, /]",r.Resul().toString());
	}


}
