package autômato;

public class Autômato {
	private Estado[] estadosFinais;
	private Estado estadoInicial;
	
	public Autômato() {
		
	}
	
	public Autômato(Estado estadoInicial, Estado... estadosFinais) {
		this.estadoInicial = estadoInicial;
		this.estadosFinais = estadosFinais;
	}
		 
	public void definirEstadosFinais(Estado... estados) {
		estadosFinais = estados;
	}
	
	public void definirEstadoInicial(Estado estado) {
		estadoInicial = estado;
	}
	
	public boolean validarSímbolos(char... símbolos) throws Exception {
		if (estadoInicial == null) {
			throw new Exception("Estado inicial não definido");
		}
		if (estadosFinais == null || estadosFinais.length == 0) {
			throw new Exception("Estados finais não definidos");
		}
		
		Estado estadoAtual = estadoInicial.próximoEstado(símbolos[0]);
		boolean estáNoEstadoFinal = false;
		
		for (int i = 1;; i++) {			
			if (estadoAtual == null) {
				throw new Exception("Estado sem ligação para o símbolo " + símbolos[i - 1]);
			}			
			
			estadoAtual = estadoAtual.próximoEstado(símbolos[i]);
			
			for (Estado estadoFinal : estadosFinais) {
				estáNoEstadoFinal = (estadoAtual == estadoFinal);
			}
			
			if (i == símbolos.length - 1) break;
		}
		return estáNoEstadoFinal;
	}
	
	public Estado estadoAtualApósSímbolos(char... símbolos) throws Exception {
		if (estadoInicial == null) {
			throw new Exception("Estado inicial não definido");
		}
		if (estadosFinais == null || estadosFinais.length == 0) {
			throw new Exception("Estados finais não definidos");
		}
		
		Estado estadoAtual = estadoInicial.próximoEstado(símbolos[0]);
		
		for (int i = 1;; i++) {
			if (estadoAtual == null) {
				throw new Exception("Estado sem ligação para o símbolo " + símbolos[i]);
			}
			if (i == símbolos.length - 1) break;
			
			estadoAtual = estadoAtual.próximoEstado(símbolos[i]);
		}		
		return estadoAtual;
	}
}
