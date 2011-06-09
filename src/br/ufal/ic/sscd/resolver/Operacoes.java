/**
 * 
 */
package br.ufal.ic.sscd.resolver;

import java.util.Stack;

/**
 * @author priscylla
 *
 */
public class Operacoes {
	
	private IdAnd idAnd;
	private IdOr idOr;
	
	

	public Operacoes() {
		this.idAnd = new IdAnd();
		this.idOr = new IdOr();
	}

	/**
	 * 
	 * @param termo
	 * @return
	 */
	public Character not(Character termo){
		if(termo=='0')
			return '1';
		if(termo=='1')
			return '0';
		return null;
	}
	
	/**
	 * 
	 * @param termo1
	 * @param termo2
	 * @return
	 */
	public Character and(Character termo1, Character termo2){
		if(termo1=='0' || termo2=='0') //Lei da nulidade Função AND
			return idAnd.nulidade(termo1, termo2);
		if(termo1=='1' || termo2=='1') //Lei da Identidade Função AND
			return idAnd.identidade(termo1, termo2);
		if(termo1.equals(termo2)) //Lei da Idempotência Função AND
			return idAnd.idempotencia(termo1, termo2);
		return null;
	}
	
	/**
	 * 
	 * @param pilha
	 * @return
	 */
	public Stack<Character> and(Stack<Character> pilha) {
		if(idAnd.nulidade(pilha)!=null){
			return idAnd.nulidade(pilha);
		}
		if(idAnd.idempotencia(pilha)!=null)
			return idAnd.idempotencia(pilha);
		if(idAnd.identidade(pilha)!=null)//////////////
			return idAnd.identidade(pilha);///////////
		
		return null;
	}
	
	/**
	 * 
	 * @param termo1
	 * @param termo2
	 * @param termo3
	 * @return
	 */
	public Character and(Character termo1, Character termo2, Character termo3){
		if(termo2=='/' && termo1.equals(termo3))
			return idAnd.inversao(termo1, termo3);
		return null;
	}
	
	
	/**
	 * 
	 * @param termo1
	 * @param termo2
	 * @return
	 */
	public Character or(Character termo1, Character termo2){
		if(termo1=='1' || termo2=='1') //Lei da nulidade Função OR
			return idOr.nulidade(termo1, termo2);
		if(termo1=='0' || termo2=='0') //Lei da Identidade Função OR
			return idOr.identidade(termo1, termo2);
		if(termo1.equals(termo2)) //Lei da Idempotência Função OR
			return idOr.idempotencia(termo1, termo2);
		return null;
	}
	
	/**
	 * 
	 * @param termo1
	 * @param termo2
	 * @param termo3
	 * @return
	 */
	public Character or(Character termo1, Character termo2, Character termo3){
		if(termo2=='/' && termo1.equals(termo3))
			return idOr.inversao(termo1, termo3);
		return null;
	}
	
	public Stack<Character> or(Stack<Character> pilha) {
		if(idOr.nulidade(pilha)!=null){
			return idOr.nulidade(pilha);
		}
		if(idOr.idempotencia(pilha)!=null)
			return idOr.idempotencia(pilha);
		if(idOr.identidade(pilha)!=null)//////////////
			return idOr.identidade(pilha);///////////
		
		return null;
	}
}
