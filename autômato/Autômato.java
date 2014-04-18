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
		
		Estado estadoAtual = estadoInicial;
		boolean estáNoEstadoFinal = false;
		
		for (char símbolo : símbolos) {
			estadoAtual = estadoAtual.próximoEstado(símbolo);
			
			if (estadoAtual == null) {
				throw new Exception("Estado sem ligação para o símbolo " + símbolo);
			}					
			
			for (Estado estadoFinal : estadosFinais) {
				estáNoEstadoFinal = (estadoAtual == estadoFinal);
			}						
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
		
		Estado estadoAtual = estadoInicial;
		
		for (char símbolo : símbolos) {
			estadoAtual = estadoAtual.próximoEstado(símbolo);
			
			if (estadoAtual == null) {
				throw new Exception("Estado sem ligação para o símbolo " + símbolo);
			}				
		}
		return estadoAtual;
	}
}
