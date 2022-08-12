package br.com.guilherme.calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	private static final Memoria instancia = new Memoria();
	
	private String textoAtual = "";
	private final List<MemoriaObservador> observadores = new ArrayList<>();
	
	private Memoria() {
		}

	public static Memoria getInstacia() {
		return instancia;
	}
	public void adicionarObservadores(MemoriaObservador observador) {
		observadores.add(observador);		
	}

	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual;
	}
	
	
	public void processarComando(String valor) {
		if(valor.equalsIgnoreCase("AC")) {
			textoAtual = "0";
		}else {
			
			textoAtual += valor;
		}
		
		
		observadores.forEach(o -> o.valorAlterado(textoAtual));
	}
	
}
