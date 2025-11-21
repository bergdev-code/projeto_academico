package menus;
import java.util.Scanner;

import bancos.BancoAluno;
import bancos.BancoCursos;
import bancos.BancoProfessores;
import bancos.BancoUc;
import cadastros.Cadastro_aluno;
import cadastros.Cadastro_notas;
import funcoes.Relatorio;

public class Menu_relatorio {
    public static void gerar_relatorio() throws InterruptedException {
        Scanner scam_relatorio = new Scanner(System.in);

        boolean ficar_relatorio = true;

        while (ficar_relatorio) {

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
                    Cadastro_aluno.relatorioAlunosPorCurso();
                    Cadastro_notas.relatorioAlunosPorUC();
                    break;
                case 3:
                    System.out.println("Buscando...");
                    Thread.sleep(1000);
                    Relatorio.gerarRelatorioPorAluno();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    Thread.sleep(1000);
                    ficar_relatorio = false; // aqui encerra o loop
                    break;
                default:
                    System.out.println("Insira um valor válido.");
                    Thread.sleep(1000);
                    break; // volta ao while sem criar nova chamada
            }
        }

    }
}