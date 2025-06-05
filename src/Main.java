import service.CurrencyConverter;
import service.Log;
import util.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        CurrencyConverter converter = new CurrencyConverter();
        Log log = new Log();
        String continuar= "";

        do {
            int opcao = menu.exibirMenuOpcoes();
            if (opcao == 7) {
                log.exibirHistorico();
            } else {
                String[] moedas = menu.obterCodigosMoeda(opcao);
                if (moedas == null) {
                    System.out.println("Opção inválida.");
                    continue;
                }
                double valor = menu.lerValor();
                double resultado = converter.converter(moedas[0], moedas[1], valor);
                System.out.printf("Valor convertido: %.2f %s\n", resultado, moedas[1]);
                log.registrar(moedas[0], moedas[1], valor, resultado);
            }
            continuar = menu.desejaContinuar();

        } while (continuar.equalsIgnoreCase("SIM"));
        System.out.println("Programa encerrado.");
    }
}