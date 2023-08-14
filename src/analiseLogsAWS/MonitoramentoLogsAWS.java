package analiseLogsAWS;

import java.util.*;

public class MonitoramentoLogsAWS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeLogs = scanner.nextInt();
        scanner.nextLine(); // Limpando o buffer do scanner

        Map<String, Long> eventosPorServico = new HashMap<>();
        for (int i = 0; i < quantidadeLogs; i++) {
            String[] parts = scanner.nextLine().split(",");
            String servico = parts[1];

            // Utilizando o mapa para registrar/incrementar o serviço
            eventosPorServico.put(servico, eventosPorServico.getOrDefault(servico, 0L) + 1);
        }

        // Identificando no mapa os serviços com maior e menor quantidade de logs com .entrySet()
        Map.Entry<String, Long> servicoMaiorQuantidade = Collections.max(eventosPorServico.entrySet(), Map.Entry.comparingByValue());
        Map.Entry<String, Long> servicoMenorQuantidade = Collections.min(eventosPorServico.entrySet(), Map.Entry.comparingByValue());

        // Saída livre de informações desnecessárias para o usuário
        System.out.println("Eventos por servico:");
        for (Map.Entry<String, Long> entry : eventosPorServico.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("Maior:" + servicoMaiorQuantidade.getKey());
        System.out.println("Menor:" + servicoMenorQuantidade.getKey());
    }
}

