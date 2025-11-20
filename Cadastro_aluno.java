import java.util.ArrayList;
import java.util.Scanner;

public class Cadastro_aluno {

    private static int id_matricula = 0;

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
}
