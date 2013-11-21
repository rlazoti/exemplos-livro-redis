package br.com.casadocodigo.redis.capitulo3;

import redis.clients.jedis.Jedis;

public class ObterDadosDaMegaSena {

	public static void main(String[] args) {
		String chave = "resultado:09-11-2013:megasena";
		Jedis jedis = new Jedis("localhost");

		String ganhadores = jedis.hget(chave, "ganhadores");
		String numeros = jedis.hget(chave, "numeros");
		
		String mensagem = String.format(
				"Ganhadores = %s, Numeros = [%s]",
				ganhadores, 
				numeros
		);

		System.out.println(mensagem);
	}
}