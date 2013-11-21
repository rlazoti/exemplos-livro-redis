package br.com.casadocodigo.redis.capitulo4;

import redis.clients.jedis.Jedis;

public class ArmazenarPontuacaoJogador {

	private void definirNovaPontuacao(int codigoJogador, int ponto) {
		String chave = String.format("jogador:%04d:codigo", codigoJogador);
		Jedis jedis = new Jedis("localhost");

		long novaPontuacao = jedis.hincrBy(chave, "pontuacao", ponto);
		System.out.println(
				String.format(
						"A pontuação do jogador %04d é: %d", 
						codigoJogador, 
						novaPontuacao
				)
		);
	}

	public void adicionarVitoria(int codigoJogador) {
		definirNovaPontuacao(codigoJogador, 1);
	}
	
	public void adicionarDerrota(int codigoJogador) {
		definirNovaPontuacao(codigoJogador, -1);
	}

	public static void main(String[] args) {
		int codigoJogador = 1;

		ArmazenarPontuacaoJogador pontuacaoJogador = 
				new ArmazenarPontuacaoJogador();
		
		pontuacaoJogador.adicionarVitoria(codigoJogador);
		pontuacaoJogador.adicionarVitoria(codigoJogador);
		pontuacaoJogador.adicionarDerrota(codigoJogador);
		pontuacaoJogador.adicionarVitoria(codigoJogador);
	}

}
