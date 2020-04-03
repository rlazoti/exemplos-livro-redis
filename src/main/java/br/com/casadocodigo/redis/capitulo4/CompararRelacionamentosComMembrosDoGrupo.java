package br.com.casadocodigo.redis.capitulo4;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class CompararRelacionamentosComMembrosDoGrupo {

    public void verAmigosDoGrupo(String pessoa, String grupo) {
        String chavePessoa = String.format(
                "pessoas:%s:relacionamentos", pessoa
        );

        String chaveGrupo = String.format(
                "grupos:%s:membros", grupo
        );

        Jedis jedis = new Jedis("localhost");
        Set<String> pessoas = jedis.sinter(chavePessoa, chaveGrupo);


        System.out.println(
                String.format(
                        "%s são amigos de %s " +
                                "e fazem também parte do grupo que gosta de %s",
                        pessoas.toString(),
                        pessoa,
                        grupo
                )
        );
    }

    public static void main(String[] args) {
        CompararRelacionamentosComMembrosDoGrupo relacionamentos = new
                CompararRelacionamentosComMembrosDoGrupo();

        relacionamentos.verAmigosDoGrupo("rafael", "cachorro");
        relacionamentos.verAmigosDoGrupo("rodrigo", "video-game");
        relacionamentos.verAmigosDoGrupo("andressa", "novela");
    }

}
