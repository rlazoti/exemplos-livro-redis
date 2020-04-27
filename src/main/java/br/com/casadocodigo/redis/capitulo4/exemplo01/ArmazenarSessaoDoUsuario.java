package br.com.casadocodigo.redis.capitulo4.exemplo01;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class ArmazenarSessaoDoUsuario {

    public static void main(String[] args) {
        final String codigoDoUsuario = "1962";
        final String nomeDoUsuario = "Peter Parker";
        final String emailDoUsuario = "spidey@marvel.com";

        String chave = "usuario:" + codigoDoUsuario + ":sessao";

        Map<String, String> campos = new HashMap<String, String>() {{
            put("codigo", codigoDoUsuario);
            put("nome", nomeDoUsuario);
            put("email", emailDoUsuario);
        }};

        Jedis jedis = new Jedis("localhost");

        String resultado = jedis.hmset(chave, campos);
        System.out.println(resultado);
    }

}
