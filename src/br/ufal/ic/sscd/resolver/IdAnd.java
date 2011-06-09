/**
 * 
 */
package br.ufal.ic.sscd.resolver;

import java.util.Stack;

/**
 * @author priscylla
 *
 */
public class IdAnd implements Identidades{

	@Override
	public Character identidade(Character t1, Character t2) {
		// TODO Auto-generated method stub
		if(t1=='1' && (Character.isLetter(t2) || t2=='0' || t2=='1'))
			return t2;
		else
			if(t2=='1' && (Character.isLetter(t1) || t1=='0' || t1=='1'))
				return t1;
			else
				return null;
	}
	
	public Stack<Character> identidade(Stack<Character> pilha_){
		boolean isIdentidade = false;
		Stack<Character> pilha = (Stack) pilha_.clone();
		if(pilha.pop()=='.' && pilha.peek()=='1'){
			pilha.pop();
			isIdentidade = true;
		} else {
			pilha.push('.');
		}
		if(isIdentidade)
			return pilha;
		else
			return null;
	}
	

	@Override
	public Character nulidade(Character t1, Character t2) {
		// TODO Auto-generated method stub
		return '0';
	}
	
	public Stack<Character> nulidade(Stack<Character> pilha_){
		
		Stack<Character> pilha = (Stack)pilha_.clone();
		Character t = pilha.pop();
		boolean barra = false;
		Character t1;
		boolean isnulidade = false;
		if(t=='/') {
			t = pilha.pop();
			barra = true;
		}
		
		while(!pilha.empty() && pilha.peek()!='+'){ 
			t1 = pilha.pop();
			if(t1=='0') //Lei da nulidade Função AND
				isnulidade=true;
			if(barra==false && t1=='/'){
				if(pilha.peek()==t)
					isnulidade=true; //Lei da nulidade Função AND
			}
			if(barra==true && t1=='/' && pilha.peek()==t)
				pilha.pop();
			if(barra==true && t1==t)
				isnulidade=true; //Lei da nulidade Função AND
		}
		if(isnulidade) {
			if(pilha.empty()){
				pilha.push('0');
			}
			return pilha;
		}
		if(isnulidade==false && t=='0'){
			pilha.push(t);
			return pilha;
		}
		return null;
	}

	@Override
	public Character idempotencia(Character t1, Character t2) {
		// TODO Auto-generated method stub
		return t1;
	}
	
	public Stack<Character> idempotencia(Stack<Character> pilha_) {
		// TODO Auto-generated method stub
		Character t;
		Character t1;
		boolean isIdempotencia = false;
		boolean barra = false;
		Stack<Character> pilha = (Stack)pilha_.clone();
		Stack<Character> pilha2 = (Stack)pilha_.clone();
		if(pilha.pop()!='.')
			return null;
		else {
			t = pilha.pop();
			if(t=='/') {
				t = pilha.pop();
				barra = true;
			}
			while(!pilha.empty() && pilha.peek()!='+'){ 
				t1 = pilha.pop();
				if(barra==false && t1=='/'){
					if(pilha.peek()==t)
						pilha.pop();
				}
				if(barra==false && t1==t){
					isIdempotencia=true;
				}
				if(barra==true && t1=='/' && pilha.peek()==t)
					isIdempotencia=true;
				
			}
			if(isIdempotencia){
				pilha2.pop();
				pilha2.pop();
				if(barra)
					pilha2.pop();
				return pilha2;
			}
		}
		return null;
	}

	@Override
	public Character inversao(Character t1, Character t2) {
		// TODO Auto-generated method stub
		return '0';
	}

	@Override
	public Character associativa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Character distributiva() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Character absorcao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Character deMorgan() {
		// TODO Auto-generated method stub
		return null;
	}	
	

}
