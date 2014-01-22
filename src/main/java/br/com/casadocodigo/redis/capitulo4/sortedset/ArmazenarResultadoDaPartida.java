package br.com.casadocodigo.redis.capitulo4.sortedset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import redis.clients.jedis.Jedis;

public class ArmazenarResultadoDaPartida {

	public void realizarPartida(
			final String jogador1, final String jogador2) {

		List<String> jogadores = new ArrayList<String>() {{
			add(jogador1);
			add(jogador2);
		}};

		Collections.shuffle(jogadores);
		String vencedor = jogadores.get(0);
		String perdedor = jogadores.get(1);
		
		
		String chave = "scores";
		double pontosVencedor = 10;
		double pontosPerdedor = -5;
		
		Jedis jedis = new Jedis("localhost");
		
		double scoreVencedor = 
				jedis.zincrby(chave, pontosVencedor, vencedor);

		double scorePerdedor = 
				jedis.zincrby(chave, pontosPerdedor, perdedor);
		
		System.out.println(
			String.format(
				"%s venceu (score: %.0f) | %s perdeu (score: %.0f)", 
				vencedor, 
				scoreVencedor,
				perdedor,
				scorePerdedor
			)
		);
	}

	public static void main(String[] args) {
		ArmazenarResultadoDaPartida partidas = 
				new ArmazenarResultadoDaPartida();
		
		partidas.realizarPartida("Aragorn", "Gandalf");
		partidas.realizarPartida("Aragorn", "Legolas");
		partidas.realizarPartida("Gandalf", "Legolas");		
	}

}
