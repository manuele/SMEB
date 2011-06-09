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
public class TesteOr {
	
	@Test
	public void teste1() throws Exception {
		Resolver r = new Resolver("A+A");
		r.ParserStack();
		assertEquals("[A]",r.Resul().toString());
	}
	
	@Test
	public void teste2() throws Exception {
		Resolver r = new Resolver("/A+/A");
		r.ParserStack();
		assertEquals("[A, /]",r.Resul().toString());
	}
	
	@Test
	public void teste3() throws Exception {
		Resolver r = new Resolver("/A+A");
		r.ParserStack();
		assertEquals("[1]",r.Resul().toString());
	}
	
	@Test
	public void teste4() throws Exception {
		Resolver r = new Resolver("A+/A");
		r.ParserStack();
		assertEquals("[1]",r.Resul().toString());
	}
	
	@Test
	public void teste5() throws Exception {
		Resolver r = new Resolver("A+0");
		r.ParserStack();
		assertEquals("[A]",r.Resul().toString());
	}
	
	@Test
	public void teste6() throws Exception {
		Resolver r = new Resolver("0+A");
		r.ParserStack();
		assertEquals("[A]",r.Resul().toString());
	}
	
	@Test
	public void teste7() throws Exception {
		Resolver r = new Resolver("A+0+A");
		r.ParserStack();
		assertEquals("[A]",r.Resul().toString());
	}
	
	public void teste8() throws Exception {
		Resolver r = new Resolver("A+1");
		r.ParserStack();
		assertEquals("[1]",r.Resul().toString());
	}
	
	@Test
	public void teste9() throws Exception {
		Resolver r = new Resolver("1+A");
		r.ParserStack();
		assertEquals("[1]",r.Resul().toString());
	}
	
	@Test
	public void teste10() throws Exception {
		Resolver r = new Resolver("A+1+A");
		r.ParserStack();
		assertEquals("[1]",r.Resul().toString());
	}
	
	@Test
	public void teste11() throws Exception {
		Resolver r = new Resolver("A+A+A+A+B+C+1");
		r.ParserStack();
		assertEquals("[1]",r.Resul().toString());
	}
	
	@Test
	public void teste12() throws Exception {
		Resolver r = new Resolver("A+B+/A");
		r.ParserStack();
		assertEquals("[1]",r.Resul().toString());
	}
	
	@Test
	public void teste13() throws Exception {
		Resolver r = new Resolver("/A+B+A");
		r.ParserStack();
		assertEquals("[1]",r.Resul().toString());
	}
	
	@Test
	public void teste14() throws Exception {
		Resolver r = new Resolver("A+B+C+A");
		r.ParserStack();
		assertEquals("[A, B, +, C, +]", r.Resul().toString());
	}
	
	@Test
	public void teste15() throws Exception {
		Resolver r = new Resolver("A+B+C+/A+D");
		r.ParserStack();
		assertEquals("[1]", r.Resul().toString());
	}
	
	@Test
	public void teste16() throws Exception {
		Resolver r = new Resolver("A+B+C+A+D+C");
		r.ParserStack();
		assertEquals("[A, B, +, C, +, D, +]", r.Resul().toString());
	}
	
	@Test
	public void teste17() throws Exception {
		Resolver r = new Resolver("1+/A");
		r.ParserStack();
		assertEquals("[1]", r.Resul().toString());
	}
	
	@Test
	public void teste18() throws Exception {
		Resolver r = new Resolver("/A+1");
		r.ParserStack();
		assertEquals("[1]", r.Resul().toString());
	}
	
	@Test
	public void teste19() throws Exception {
		Resolver r = new Resolver("/A+1+/A");
		r.ParserStack();
		assertEquals("[1]", r.Resul().toString());
	}
	
	@Test
	public void teste20() throws Exception {
		Resolver r = new Resolver("A+/B");
		r.ParserStack();
		assertEquals("[A, B, /, +]", r.Resul().toString());
	}
	
	@Test
	public void teste21() throws Exception {
		Resolver r = new Resolver("A+/B+0+C");
		r.ParserStack();
		assertEquals("[A, B, /, +, C, +]", r.Resul().toString());
	}
	
	@Test
	public void teste22() throws Exception {
		Resolver r = new Resolver("0+A+B+0+C");
		r.ParserStack();
		assertEquals("[A, B, +, C, +]", r.Resul().toString());
	}
	
	@Test
	public void teste23() throws Exception {
		Resolver r = new Resolver("A+B");
		r.ParserStack();
		assertEquals("[A, B, +]", r.Resul().toString());
	}
	

}
