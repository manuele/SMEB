/**
 * 
 */
package br.ufal.ic.sscd.resolver;

/**
 * @author priscylla
 *
 */
public interface Identidades {
	
	public Character identidade(Character t1, Character t2);
	
	public Character nulidade(Character t1, Character t2);
	
	public Character idempotencia(Character t1, Character t2);
	
	public Character inversao(Character t1, Character t2);
	
	public Character associativa();
	
	public Character distributiva();
	
	public Character absorcao();
	
	public Character deMorgan();

}
