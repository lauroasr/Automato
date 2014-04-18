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
		
		Estado estadoAtual = estadoInicial;
		boolean est�NoEstadoFinal = false;
		
		for (char s�mbolo : s�mbolos) {
			estadoAtual = estadoAtual.pr�ximoEstado(s�mbolo);
			
			if (estadoAtual == null) {
				throw new Exception("Estado sem liga��o para o s�mbolo " + s�mbolo);
			}					
			
			for (Estado estadoFinal : estadosFinais) {
				est�NoEstadoFinal = (estadoAtual == estadoFinal);
			}						
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
		
		Estado estadoAtual = estadoInicial;
		
		for (char s�mbolo : s�mbolos) {
			estadoAtual = estadoAtual.pr�ximoEstado(s�mbolo);
			
			if (estadoAtual == null) {
				throw new Exception("Estado sem liga��o para o s�mbolo " + s�mbolo);
			}				
		}
		return estadoAtual;
	}
}
