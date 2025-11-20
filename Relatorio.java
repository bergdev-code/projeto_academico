import java.util.Scanner;

public class Relatorio {
    public static void gerar_relatorio() throws InterruptedException {
        Scanner scam_relatorio = new Scanner(System.in);

        System.out.print(
                "\n======/ RELATÓRIO /======\n1 - Relatório com todos os cadastros\n2 - Relatório com alunos de acordo com os cursos cadastrados\n3 - Relatório Boletim\n4 - Sair\nDigite: ");
        int valor_relatorio = scam_relatorio.nextInt();
        scam_relatorio.nextLine();

        switch (valor_relatorio) {
            case 1:
                System.out.println("Buscando...");
                Thread.sleep(1000);
                BancoAluno.bancodoaluno();
                BancoProfessores.gerar_profesores();
                BancoCursos.gerar_cursos();
                BancoUc.gerar_uc();
                break;
            case 2:
                System.out.println("Buscando...");
                Thread.sleep(1000);

            case 3:
                System.out.println("Buscando...");
                Thread.sleep(1000);

            case 4:
                System.out.println("Saindo...");
                Thread.sleep(1000);
                return;

            default:
                System.out.println("Insira um valor válido.");
                Thread.sleep(1000);
                Relatorio.gerar_relatorio();
                break;
        }
    }
}