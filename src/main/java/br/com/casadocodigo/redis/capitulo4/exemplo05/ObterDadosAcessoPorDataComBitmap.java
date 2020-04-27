package br.com.casadocodigo.redis.capitulo4.exemplo05;

import redis.clients.jedis.Jedis;

import java.util.Arrays;

public class ObterDadosAcessoPorDataComBitmap {

    public long acessosPorPeriodo(String... datas) {
        Jedis jedis = new Jedis("localhost");
        long total = 0;

        for (String data : datas) {
            String chave = String.format("acesso:%s", data);
            total += jedis.bitcount(chave);
        }

        return total;
    }

    public static void main(String[] args) {
        ObterDadosAcessoPorDataComBitmap dadosDeAcesso =
                new ObterDadosAcessoPorDataComBitmap();

        String[] diario = {"05/11/2013"};

        String[] semanal = {
                "16/11/2013",
                "17/11/2013",
                "18/11/2013",
                "19/11/2013",
                "20/11/2013",
                "21/11/2013",
                "22/11/2013"
        };

        long totalDiario = dadosDeAcesso.acessosPorPeriodo(diario);
        long totalSemanal = dadosDeAcesso.acessosPorPeriodo(semanal);

        System.out.println(
                String.format(
                        "Total de usuários únicos no dia %s: %d",
                        Arrays.asList(diario),
                        totalDiario
                )
        );

        System.out.println(
                String.format(
                        "Total de usuários únicos entre os dias [%s] e [%s]: %d",
                        semanal[0],
                        semanal[6],
                        totalSemanal
                )
        );
    }

}
