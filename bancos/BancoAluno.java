package bancos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import cadastros.Cadastro_aluno;
import cadastros.Cadastro_notas;

public class BancoAluno {
    public static void bancodoaluno() {

        // nomes cadastrados no Cadastro_aluno
        ArrayList<String> nomes = Cadastro_aluno.getListaNomes();

        // alunos cadastrados no Cadastro_notas
        ArrayList<Cadastro_notas.Aluno> alunosNotas = Cadastro_notas.getAlunos();

        // Hashset pra evitar nomes duplicados.
        Set<String> nomesUnicos = new HashSet<>();

        // Adiciona todos os nomes vindos do cadastro de alunos
        nomesUnicos.addAll(nomes);

        // Adiciona todos os nomes vindos dos objetos Aluno do cadastro de notas
        for (Cadastro_notas.Aluno a : alunosNotas) {
            nomesUnicos.add(a.getNome());
        }

        System.out.println("\n==== ALUNOS CADASTRADOS ====");

        if (nomesUnicos.isEmpty()) {
            System.out.println("\nNENHUM ALUNO CADASTRADO!");
        } else {
            for (String nome : nomesUnicos) {
                System.out.println("- " + nome);
            }
        }
    }
}
