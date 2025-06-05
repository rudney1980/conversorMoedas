package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static final String NOME_ARQUIVO = "historico_conversoes.txt";

    public void registrar(String baseCode, String targetCode, double valorOriginal, double valorConvertido) {
        try (FileWriter writer = new FileWriter(NOME_ARQUIVO, true)) {
            String dataHora = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String linha = String.format("[%s] %.2f %s -> %.2f %s\n",
                    dataHora, valorOriginal, baseCode, valorConvertido, targetCode);
            writer.write(linha);
        } catch (IOException e) {
            System.out.println("Erro ao gravar histórico: " + e.getMessage());
        }
    }

    public void exibirHistorico() {
        System.out.println("=== Histórico de Conversões ===");

        try (BufferedReader leitor = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            boolean vazio = true;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
                vazio = false;
            }

            if (vazio) {
                System.out.println("Nenhuma conversão registrada até o momento.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o histórico: " + e.getMessage());
        }
    }
}
