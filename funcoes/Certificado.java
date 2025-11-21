package funcoes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import cadastros.Cadastro_aluno;
import cadastros.Cadastro_notas;

public class Certificado {

    // Método para emitir certificado de um aluno cadastrado no sistema
    public static void emitirCertificado() throws InterruptedException {
        Scanner scam_certificado = new Scanner(System.in);
        System.out.print("Insira seu nome para verificação: ");
        String nome_verificar = scam_certificado.nextLine();
        System.out.println("\nLendo nome...");
        Thread.sleep(1000);

        // pega a lista de alunos do Cadastro_notas
        ArrayList<Cadastro_notas.Aluno> alunos = Cadastro_notas.getAlunos();

        // procura aluno pelo nome
        Cadastro_notas.Aluno alunoEncontrado = null;
        for (Cadastro_notas.Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nome_verificar)) {
                alunoEncontrado = a;
                break;
            }
        }

        if (alunoEncontrado == null) {
            System.out.println("\n=== ALUNO NÃO ENCONTRADO ===");
            Thread.sleep(1000);
            return;
        }

        String curso = Cadastro_aluno.getCursoPorNome(alunoEncontrado.getNome());

        if (curso == null) {
            System.out.println("\n=== ERRO: CURSO NÃO ENCONTRADO ===\n");
            Thread.sleep(1000);
            return;
        }

        // contador de disciplinas aprovadas
        int aprovadas = alunoEncontrado.contarDisciplinasAprovadas();

        if (aprovadas >= 10) {
            LocalDate data = LocalDate.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("\n=== CERTIFICADO DE CONCLUSÃO ===");
            System.out.println(" | Aluno: " + alunoEncontrado.getNome());
            System.out.println(" | Curso: " + curso);
            System.out.println(" | Data de emissão: " + data.format(formato));
            System.out.println(" | Situação: APROVADO!");
            System.out.println("===============================");
            Thread.sleep(1000);
        } else {
            System.out.println("\nO aluno " + alunoEncontrado.getNome() +
                    " ainda não possui 10 disciplinas aprovadas.");
            Thread.sleep(1000);
        }
    }
}