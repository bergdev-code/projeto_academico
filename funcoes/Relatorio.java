package funcoes;
import java.util.ArrayList;
import java.util.Scanner;

import cadastros.Cadastro_notas;

public class Relatorio {

    public static void gerarRelatorioPorAluno() throws InterruptedException {

        Scanner scan_relatorio = new Scanner(System.in);
        System.out.print("Digite o nome do aluno para gerar o relatório: ");
        String nomeAluno = scan_relatorio.nextLine();
        System.out.println("\nLendo nome...");
        Thread.sleep(1000);

        ArrayList<Cadastro_notas.Aluno> alunos = Cadastro_notas.getAlunos();

        Cadastro_notas.Aluno alunoEncontrado = null;

        // Procurar aluno
        for (Cadastro_notas.Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nomeAluno)) {
                alunoEncontrado = a;
                break;
            }
        }

        if (alunoEncontrado == null) {
            System.out.println("\nNenhum registro encontrado para: " + nomeAluno);
            Thread.sleep(1000);
            return;
        }

        System.out.println("\n=== RELATÓRIO DO ALUNO ===");
        System.out.println("Aluno: " + alunoEncontrado.getNome());
        System.out.println("Curso: " + alunoEncontrado.getCurso());
        System.out.println("-----------------------------------\n");

        // Percorrer todas as disciplinas
        for (Cadastro_notas.Disciplina d : alunoEncontrado.getDisciplinas()) {

            System.out.println("Disciplina: " + d.getNome());

            // Percorrer todas as notas
            for (Double nota : d.getNotas()) {
                System.out.println("Nota: " + nota);
            }

            System.out.println("-----------------------------------");
        }
    }
}