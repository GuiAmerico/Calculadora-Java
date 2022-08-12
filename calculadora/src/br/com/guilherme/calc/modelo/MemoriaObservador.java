package br.com.guilherme.calc.modelo;

@FunctionalInterface
public interface MemoriaObservador {
	public void valorAlterado(String novoValor);
}
