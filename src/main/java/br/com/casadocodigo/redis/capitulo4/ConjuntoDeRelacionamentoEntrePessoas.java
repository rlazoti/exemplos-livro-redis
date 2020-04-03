package br.com.casadocodigo.redis.capitulo4;

import redis.clients.jedis.Jedis;

import java.util.Arrays;

public class ConjuntoDeRelacionamentoEntrePessoas {

    public void adicionaAmigos(String pessoa, String[] amigos) {
        String chave = String.format("pessoas:%s:relacionamentos", pessoa);
        Jedis jedis = new Jedis("localhost");
        long resultado = jedis.sadd(chave, amigos);

        System.out.println(
                String.format(
                        "%s tem %d amigos %s",
                        pessoa,
                        resultado,
                        Arrays.toString(amigos)
                )
        );
    }

    public static void main(String[] args) {
        ConjuntoDeRelacionamentoEntrePessoas relacionamentos =
                new ConjuntoDeRelacionamentoEntrePessoas();

        relacionamentos.adicionaAmigos(
                "rafael",
                new String[]{"gustavo", "andressa", "rodrigo", "tereza"}
        );

        relacionamentos.adicionaAmigos(
                "andressa",
                new String[]{"cristiane", "rodrigo", "gustavo", "rafael"}
        );

        relacionamentos.adicionaAmigos(
                "gustavo",
                new String[]{"carlos", "tereza", "rafael", "andressa"}
        );

        relacionamentos.adicionaAmigos(
                "cristiane",
                new String[]{"tereza", "andressa", "carlos"}
        );

        relacionamentos.adicionaAmigos(
                "carlos",
                new String[]{"cristiane", "rodrigo", "gustavo"}
        );

        relacionamentos.adicionaAmigos(
                "rodrigo",
                new String[]{"andressa", "rafael", "carlos"}
        );

        relacionamentos.adicionaAmigos(
                "tereza",
                new String[]{"gustavo", "rafael", "cristiane"}
        );
    }

}
