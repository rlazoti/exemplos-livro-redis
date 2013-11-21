package br.com.casadocodigo.redis.capitulo4;

import redis.clients.jedis.Jedis;

public class ArmazenarVitoriasDoJogador {

	private long definirNovaPontuacao(int codigoJogador, int ponto) {
		String chave = String.format("jogador:%04d:codigo", codigoJogador);
		Jedis jedis = new Jedis("localhost");
		
		return jedis.hincrBy(chave, "pontuacao", ponto);
	}

	public long adicionarVitoria(int codigoJogador) {
		return definirNovaPontuacao(codigoJogador, 1);
	}
	
	public long adicionarDerrota(int codigoJogador) {
		return definirNovaPontuacao(codigoJogador, -1);
	}

	public static void main(String[] args) {
		int codigoJogador = 1;
		String nomeJogador = "Rafael";
		String hash = String.format("jogador:%04d:codigo", codigoJogador);

		Jedis jedis = new Jedis("localhost");
		long resultado1 = jedis.hset(hash, "nome", nomeJogador);
		long resultado2 = jedis.hset(hash, "pontuacao", "0");
		
		String mensagem = String.format(
				"Resultado 1 = %d, Resultado 2 = %d",
				resultado1,
				resultado2
		);

		System.out.println(mensagem);
	}

}
