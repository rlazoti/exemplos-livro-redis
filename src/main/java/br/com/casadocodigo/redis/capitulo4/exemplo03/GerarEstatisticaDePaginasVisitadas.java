package br.com.casadocodigo.redis.capitulo4.exemplo03;

import redis.clients.jedis.Jedis;

public class GerarEstatisticaDePaginasVisitadas {

    public void gerarEstatistica(String pagina, String data) {
        String chave = String.format("pagina:%s:%s", pagina, data);
        Jedis jedis = new Jedis("localhost");
        long resultado = jedis.incr(chave);
        System.out.println(
                String.format(
                        "página %s teve %d acesso(s) em %s",
                        pagina,
                        resultado,
                        data
                )
        );
    }

    public static void main(String[] args) {
        String data = "02/09/2013";
        String[] paginasVisitadas = {
                "/inicio",
                "/contato",
                "/sobre-mim",
                "/todos-os-posts",
                "/armazenando-dados-no-redis"
        };

        GerarEstatisticaDePaginasVisitadas gerador =
                new GerarEstatisticaDePaginasVisitadas();

        gerador.gerarEstatistica(paginasVisitadas[0], data);
        gerador.gerarEstatistica(paginasVisitadas[1], data);
        gerador.gerarEstatistica(paginasVisitadas[2], data);
        gerador.gerarEstatistica(paginasVisitadas[1], data);
        gerador.gerarEstatistica(paginasVisitadas[1], data);
    }
}
