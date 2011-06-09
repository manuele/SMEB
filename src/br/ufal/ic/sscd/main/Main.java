/**
 * 
 */
package br.ufal.ic.sscd.main;

import br.ufal.ic.sscd.resolver.Resolver;

/**
 * @author priscylla
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Resolver r = new Resolver("/(A.B)");
		r.ParserStack();
		
		System.out.println("Saida: "+r.getSaida());
		System.out.println("Pilha Resultado: "+r.Resul());
		
		
		r = new Resolver("/(A.B.C)");
		r.ParserStack();
		
		System.out.println("\n\nSaida: "+r.getSaida());
		System.out.println("Pilha Resultado: "+r.Resul());
		
		r = new Resolver("/(A+B)");
		r.ParserStack();
		
		System.out.println("\n\nSaida: "+r.getSaida());
		System.out.println("Pilha Resultado: "+r.Resul());

		r = new Resolver("/(A+B+C)");
		r.ParserStack();
		
		System.out.println("\n\nSaida: "+r.getSaida());
		System.out.println("Pilha Resultado: "+r.Resul());
		
	}

}
