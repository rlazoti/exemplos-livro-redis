package br.com.casadocodigo.redis.capitulo4.sortedset;

import redis.clients.jedis.Jedis;

public class GerarNovoJogador {

	public void adicionarNovoJogador(String jogador) {
		String chave = "scores2";
		double pontuacaoInicial = 50;
		Jedis jedis = new Jedis("localhost");
		long resultado = jedis.zadd(chave, pontuacaoInicial, jogador);
		
		System.out.println(
			String.format(
				"Novo Jogador: %s com %.0f pontos iniciais. Resultado: %d", 
				jogador, 
				pontuacaoInicial, 
				resultado
			)
		);
	}
	
	public static void main(String[] args) {
		GerarNovoJogador novoJogo = new GerarNovoJogador();

		novoJogo.adicionarNovoJogador("AragornBB");
		novoJogo.adicionarNovoJogador("GandalfBB");
		novoJogo.adicionarNovoJogador("LegolasBB");
		novoJogo.adicionarNovoJogador("GandalfBB");
		novoJogo.adicionarNovoJogador("FrodoBB");
		novoJogo.adicionarNovoJogador("BilboBB");
		novoJogo.adicionarNovoJogador("GimliBB");
		novoJogo.adicionarNovoJogador("SamBB");
		novoJogo.adicionarNovoJogador("BoromirBB");
	 	novoJogo.adicionarNovoJogador("GollumBB");
	}

}
