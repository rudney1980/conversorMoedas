package util;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    //Aqui as opções a serem mostradas deverão estar compatíveis com as da função obterCodigosMoeda()
    public int exibirMenuOpcoes() {
        System.out.println("\n=== Conversor de Moedas ===");
        System.out.println("1 - USD -> BRL");
        System.out.println("2 - BRL -> BOB");
        System.out.println("3 - CAD -> EUR");
        System.out.println("4 - EUR -> USD");
        System.out.println("5 - USD -> JPY");
        System.out.println("6 - JPY -> USD");
        System.out.println("7 - Ver histórico de conversões");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    //Para alterar as moedas a serem escolhidas basta mudar neste SWITCH e na função exibirMenuOpcoes()
    public String[] obterCodigosMoeda(int opcao) {
        return switch (opcao) {
            case 1 -> new String[]{"USD", "BRL"};
            case 2 -> new String[]{"BRL", "BOB"};
            case 3 -> new String[]{"CAD", "EUR"};
            case 4 -> new String[]{"EUR", "USD"};
            case 5 -> new String[]{"USD", "JPY"};
            case 6 -> new String[]{"JPY", "USD"};
            default -> null;
        };
    }

    public double lerValor() {
        System.out.print("Digite o valor a ser convertido: ");
        return scanner.nextDouble();
    }

    public String desejaContinuar() {
        System.out.print("Deseja realizar outra conversão? (SIM/NÃO): ");
        scanner.nextLine(); // Limpa o buffer
        return scanner.nextLine();
    }
}
