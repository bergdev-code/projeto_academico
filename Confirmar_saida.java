import java.util.Scanner;

public class Confirmar_saida {

    public static String saida() {
        Scanner scam_verificar = new Scanner(System.in);

        while (true) { // repete até o usuário digitar algo válido
            System.out.print("Deseja retornar ao menu de cadastros? (s/n).\nDigite: ");
            String sair_verificar = scam_verificar.nextLine();

            if (sair_verificar.equalsIgnoreCase("s")) {
                System.out.println("Saindo para o menu de cadastros...");
                return "s"; // retorna para quem chamou
            } else if (sair_verificar.equalsIgnoreCase("n")) {
                System.out.println("Voltando...");
                return "n";
            } else {
                System.out.println("Insira um caractere válido!");
            }
        }
    }
}
