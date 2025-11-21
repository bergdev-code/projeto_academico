import java.util.Scanner;

import funcoes.Certificado;
import menus.Menu_da_main;
import menus.Menu_relatorio;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scam_main = new Scanner(System.in);

        boolean ficar_main = true;

        System.out.println("-/-/-SEJA BEM VINDO!/-/-/-\n");

        while (ficar_main) {
            System.out.print(
                    "-/-/-/MENU/-/-/-\n1 - MENU DE CADASTROS\n2 - GERAR RELATÓRIO\n3 - EMITIR CERTIFICADO\n4 - SAIR DO PROGRAMA\nDigite: ");
            int valor_main = scam_main.nextInt();

            switch (valor_main) {

                case 1:
                    System.out.println("AGUARDE...");
                    Thread.sleep(1000);
                    Menu_da_main.Menu_main();
                    break;

                case 2:
                    System.out.println("AGUARDE...");
                    Thread.sleep(1000);
                    Menu_relatorio.gerar_relatorio();
                    break;

                case 3:
                    System.out.println("AGUARDE...");
                    Thread.sleep(1000);
                    Certificado.emitirCertificado();
                    break;

                case 4:
                    System.out.println("SAINDO...");
                    Thread.sleep(1000);
                    ficar_main = false;
                    break;

                default:
                    System.out.println("INSIRA ALGUM VALOR VÁLIDO!!");
                    Thread.sleep(1000);
                    break;
            }
        }
    }
}
