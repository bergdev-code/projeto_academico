import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cadastro_aluno {

    private static int id_matricula = 0;

    public static void relatorioAlunosPorCurso() {

        

    if (alunos.isEmpty()) {
        System.out.println("Nenhum aluno cadastrado.");
        return;
    }

    System.out.println("\n--- RELATÓRIO: Alunos por Curso ---");

    // Mapa curso -> lista de alunos
    HashMap<String, ArrayList<String>> mapa = new HashMap<>();

    for (Aluno a : alunos) {
        // verifica se o curso já existe no mapa
        if (!mapa.containsKey(a.getCurso())) {
            mapa.put(a.getCurso(), new ArrayList<>()); // cria lista vazia se não existir
        }
        // adiciona o aluno à lista do curso
        mapa.get(a.getCurso()).add(a.getNome());
    }

    // imprimir
    for (String curso : mapa.keySet()) {
        System.out.println("\nCurso: " + curso);
        for (String nomeAluno : mapa.get(curso)) {
            System.out.println(" - " + nomeAluno);
        }
    }
}


     // Getter para listar todos os cursos escolhidos pelos alunos
    public static ArrayList<String> getCursoAluno() {
        ArrayList<String> listaCurso = new ArrayList<>();

        for (Aluno a : alunos) {
            listaCurso.add(a.getCurso());
        }

        return listaCurso;
    }

    // Lista com todos os alunos cadastrados
    private static ArrayList<Aluno> alunos = new ArrayList<>();

    public static class Aluno {
        private String nome;
        private String curso;
        private int matricula;

        public Aluno(String nome, String curso, int matricula) {
            this.nome = nome;
            this.curso = curso;
            this.matricula = matricula;
        }

        public String getNome() { return nome; }
        public String getCurso() { return curso; }
        public int getMatricula() { return matricula; }
    }

    public static void cadastrar_aluno() {
        Scanner scam_aluno = new Scanner(System.in);

        System.out.print("Insira seu nome completo: ");
        String nome = scam_aluno.nextLine();

        System.out.print("Insira o curso que deseja: ");
        String curso = scam_aluno.nextLine();

        if (!nome.isEmpty() && !curso.isEmpty()) {

            id_matricula++;

            // adiciona o aluno na lista
            alunos.add(new Aluno(nome, curso, id_matricula));

            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Preencha os campos corretamente.");
        }
    }

    // MÉTODO QUE RETORNA TODOS OS NOMES
    public static ArrayList<String> getListaNomes() {
        if (alunos.isEmpty()) {
            System.out.println("NENHUM ALUNO CADASTRADO!\nRetornando...");
            
        }

        ArrayList<String> lista = new ArrayList<>();

        for (Aluno a : alunos) {
            lista.add(a.getNome());
        }

        return lista;
    }

    public static String getCursoPorNome(String nome) {
    for (Aluno a : alunos) {
        if (a.getNome().equalsIgnoreCase(nome)) {
            return a.getCurso();
        }
    }
    return null;
}
}
