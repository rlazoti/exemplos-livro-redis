package br.com.casadocodigo.redis.capitulo3;

import redis.clients.jedis.Jedis;

public class DefinirTempoExpiracaoDeSessaoDoUsuario {

	public static void main(String[] args) {
		String codigoDoUsuario = "1962";
		String chave = "sessao:usuario:" + codigoDoUsuario;
		int trintaMinutosEmSegundos = 1800;
		
		Jedis jedis = new Jedis("localhost");

		long resultado = jedis.expire(chave, trintaMinutosEmSegundos);
		System.out.println(resultado);
	}

}
