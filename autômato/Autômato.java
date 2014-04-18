package aut�mato;

public class Aut�mato {
	private Estado[] estadosFinais;
	private Estado estadoInicial;
	
	public Aut�mato() {
		
	}
	
	public Aut�mato(Estado estadoInicial, Estado... estadosFinais) {
		this.estadoInicial = estadoInicial;
		this.estadosFinais = estadosFinais;
	}
		 
	public void definirEstadosFinais(Estado... estados) {
		estadosFinais = estados;
	}
	
	public void definirEstadoInicial(Estado estado) {
		estadoInicial = estado;
	}
	
	public boolean validarS�mbolos(char... s�mbolos) throws Exception {
		if (estadoInicial == null) {
			throw new Exception("Estado inicial n�o definido");
		}
		if (estadosFinais == null || estadosFinais.length == 0) {
			throw new Exception("Estados finais n�o definidos");
		}
		
		Estado estadoAtual = estadoInicial.pr�ximoEstado(s�mbolos[0]);
		boolean est�NoEstadoFinal = false;
		
		for (int i = 1;; i++) {			
			if (estadoAtual == null) {
				throw new Exception("Estado sem liga��o para o s�mbolo " + s�mbolos[i - 1]);
			}			
			
			estadoAtual = estadoAtual.pr�ximoEstado(s�mbolos[i]);
			
			for (Estado estadoFinal : estadosFinais) {
				est�NoEstadoFinal = (estadoAtual == estadoFinal);
			}
			
			if (i == s�mbolos.length - 1) break;
		}
		return est�NoEstadoFinal;
	}
	
	public Estado estadoAtualAp�sS�mbolos(char... s�mbolos) throws Exception {
		if (estadoInicial == null) {
			throw new Exception("Estado inicial n�o definido");
		}
		if (estadosFinais == null || estadosFinais.length == 0) {
			throw new Exception("Estados finais n�o definidos");
		}
		
		Estado estadoAtual = estadoInicial.pr�ximoEstado(s�mbolos[0]);
		
		for (int i = 1;; i++) {
			if (estadoAtual == null) {
				throw new Exception("Estado sem liga��o para o s�mbolo " + s�mbolos[i]);
			}
			if (i == s�mbolos.length - 1) break;
			
			estadoAtual = estadoAtual.pr�ximoEstado(s�mbolos[i]);
		}		
		return estadoAtual;
	}
}
