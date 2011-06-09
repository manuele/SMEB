/**
 * 
 */
package br.ufal.ic.sscd.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author priscylla
 *
 */
public class Resolver {
	
	private Stack<Character> pilha;
	private List<Character> saida;
	private List<Stack> passos; //teste
	private String entrada;
	private Operacoes op;
	
	public Resolver(String entrada){
		this.pilha = new Stack<Character>();
		this.saida = new ArrayList<Character>();
		this.passos = new ArrayList<Stack>(); //teste
		this.entrada = entrada;
		this.op = new Operacoes();
		
	}
	
	
	public Stack<Character> Resul(){
		Stack<Character> tempPilha = new Stack<Character>();
		Character t1;
		Character t2;
		Character t3;
		
		for(int i=0; i<this.saida.size(); i++){
			//Se for operando: empilhe
			if(Character.isLetter(this.saida.get(i)) || this.saida.get(i)=='0' || this.saida.get(i)=='1'){
				tempPilha.push(this.saida.get(i));
				System.out.println("Empilhandi operando: "+this.saida.get(i));
			}
			else { //Se for um operador
				if(this.saida.get(i)=='/'){ //Porta not
					if(this.op.not(tempPilha.peek())!=null){
						tempPilha.push(this.op.not(tempPilha.pop()));
					} else
						tempPilha.push('/');
					
				} else {
					if(this.saida.get(i)=='.'){ //Porta and
						
						t1 = tempPilha.pop();
						t2 = tempPilha.pop();
						
						if((Character.isLetter(t1) || t1=='0' || t1=='1') && (Character.isLetter(t2) || t2=='0' || t2=='1')){
							
							if(this.op.and(t1, t2)!=null)
								tempPilha.push(this.op.and(t1, t2));
							else {
								tempPilha.push(t2);
								tempPilha.push(t1);
								tempPilha.push('.');
							}
								
						} else {
							if(t2=='/'){
								t3 = tempPilha.pop();
								if(this.op.and(t1, t2, t3)!=null)
									tempPilha.push(this.op.and(t1, t2, t3));
								else {
									tempPilha.push(t3);
									tempPilha.push(t2);
									tempPilha.push(t1);
									tempPilha.push('.');
								}
							} else {
								tempPilha.push(t2);
								tempPilha.push(t1);
								if(this.op.and(tempPilha)!=null)
									tempPilha=this.op.and(tempPilha);
								else
									tempPilha.push('.');
								
							}
						}
						//teste de idempotencia e identidade
						if(this.op.and(tempPilha)!=null)
							tempPilha=this.op.and(tempPilha);
						
						
					} else {
						if(this.saida.get(i)=='+'){ // Porta or
							t1 = tempPilha.pop();
							t2 = tempPilha.pop();
							
							if((Character.isLetter(t1) || t1=='0' || t1=='1') && (Character.isLetter(t2) || t2=='0' || t2=='1')){
								if(this.op.or(t1, t2)!=null)
									tempPilha.push(this.op.or(t1, t2));
								else {
									tempPilha.push(t2);
									tempPilha.push(t1);
									tempPilha.push('+');
								}
							} else {
								if(t2=='/'){
									t3 = tempPilha.pop();
									if(this.op.or(t1, t2, t3)!=null)
										tempPilha.push(this.op.or(t1, t2, t3));
									else {
										tempPilha.push(t3);
										tempPilha.push(t2);
										tempPilha.push(t1);
										tempPilha.push('+');
									}
								} else {
									tempPilha.push(t2);
									tempPilha.push(t1);
									if(this.op.or(tempPilha)!=null)
										tempPilha=this.op.or(tempPilha);
									else
										tempPilha.push('+');
									
								}
							}
							//teste de idempotencia e identidade
							if(this.op.or(tempPilha)!=null)
								tempPilha=this.op.or(tempPilha);
						}
					}
				}
			}
		}
		return tempPilha;
	}
	
	/**
	 * Transformar a expressão para a forma Posfixa
	 */
	public void ParserStack(){
		for(int i=0; i<this.entrada.length(); i++){
			
			//Caso um operando seja encontrado: inserir diretamente na saída
			if(Character.isLetter(this.entrada.charAt(i)) || this.entrada.charAt(i)=='0' || this.entrada.charAt(i)=='1')
				this.saida.add(this.entrada.charAt(i));
			else {
				if(this.entrada.charAt(i)=='(')
					this.pilha.push(this.entrada.charAt(i));
				else {
					if(this.entrada.charAt(i)==')'){
						while(this.pilha.peek()!='('){
							this.saida.add(this.pilha.pop());
						}
						this.pilha.pop();
					} else {
						while(this.pilha.empty()==false && Prio(this.pilha.peek())>=Prio(this.entrada.charAt(i)))
							this.saida.add(this.pilha.pop());
						this.pilha.push(this.entrada.charAt(i));
					}
				}
			}
		}
		
		while(!this.pilha.empty())
			this.saida.add(this.pilha.pop());
			
	}
	
	/**
	 * 
	 * @param operador
	 * @return
	 */
	public int Prio(Character operador){
		if(operador=='(')
			return 1;
		if(operador=='+')
			return 2;
		if(operador=='.')
			return 3;
		if(operador=='/')
			return 4;
		return 0;
	}

	/**
	 * @return the pilha
	 */
	public Stack<Character> getPilha() {
		return pilha;
	}

	/**
	 * @return the saida
	 */
	public List<Character> getSaida() {
		return saida;
	}
	
	

}
