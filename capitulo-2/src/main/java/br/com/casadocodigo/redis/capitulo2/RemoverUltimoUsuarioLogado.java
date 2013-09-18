package br.com.casadocodigo.redis.capitulo2;

import redis.clients.jedis.Jedis;

public class RemoverUltimoUsuarioLogado {

	public static void main(String[] args) {

		Jedis jedis = new Jedis("localhost");
		String valor = jedis.get("ultimo_usuario_logado");

		System.out.println(valor);
	}
}
