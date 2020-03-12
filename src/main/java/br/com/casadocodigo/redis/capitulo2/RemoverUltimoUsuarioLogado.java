package br.com.casadocodigo.redis.capitulo2;

import redis.clients.jedis.Jedis;

public class RemoverUltimoUsuarioLogado {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        Long resultado = jedis.del("ultimo_usuario_logado");

        System.out.println(resultado);
    }
}
