package br.com.casadocodigo.redis.capitulo3;

import redis.clients.jedis.Jedis;

public class ObterDadosDaMegaSena {

	public static void main(String[] args) {
		String hash = "resultado:megasena";
		Jedis jedis = new Jedis("localhost");

		String ganhadores = jedis.hget(hash, "ganhadores");
		String dataSorteio = jedis.hget(hash, "dataSorteio");
		String numeros = jedis.hget(hash, "numeros");
		
		String mensagem = String.format(
				"Ganhadores = %s, Data do Sorteio = %s, Numeros = [%s]",
				ganhadores,
				dataSorteio, 
				numeros
		);

		System.out.println(mensagem);
	}
}