import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cadastro_aluno {

    // Lista com todos os alunos cadastrados
    private static ArrayList<Aluno> alunos = new ArrayList<>();

    // retorna a lista completa de alunos (objetos Aluno)
    public static ArrayList<Aluno> getListaAlunos() {
        return new ArrayList<>(alunos);
    }

    public static void relatorioAlunosPorCurso() {

        if (alunos.isEmpty()) {
            return;
        }

        System.out.println("\n--- RELATÓRIO: Alunos por Curso ---");

        HashMap<String, ArrayList<String>> mapa = new HashMap<>();

        for (Aluno a : alunos) {
            String curso = a.getCurso();

            if (!mapa.containsKey(curso)) {
                mapa.put(curso, new ArrayList<>());
            }
            mapa.get(curso).add(a.getNome());
        }

        for (String curso : mapa.keySet()) {
            System.out.println("\nCurso: " + curso);
            for (String nomeAluno : mapa.get(curso)) {
                System.out.println(" - " + nomeAluno);
            }
        }
    }

    // Getter de cursos
    public static ArrayList<String> getCursoAluno() {
        ArrayList<String> listaCurso = new ArrayList<>();

        for (Aluno a : alunos) {
            listaCurso.add(a.getCurso());
        }

        return listaCurso;
    }

    // === CLASSE ALUNO ===
    public static class Aluno {
        private String nome;
        private String curso;
        private int matricula;

        public Aluno(String nome, String curso, int matricula) {
            this.nome = nome;
            this.curso = curso;
            this.matricula = matricula;
        }

        public String getNome() {
            return nome;
        }

        public String getCurso() {
            return curso;
        }

        public int getMatricula() {
            return matricula;
        }

        public void setMatricula(int matricula) {
            this.matricula = matricula;
        }
    }

    public static void cadastrar_aluno() throws InterruptedException {
        Scanner scam_aluno = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {

            System.out.print(
                    "\n==={ MENU DO ALUNO }===\n1 - Cadastrar Aluno\n2 - Listar Aluno\n3 - Apagar Aluno\n4 - Sair\nDigite: ");
            int valor_Aluno = scam_aluno.nextInt();
            scam_aluno.nextLine();

            switch (valor_Aluno) {

                case 1: // Cadastrar Aluno
                    System.out.println("Abrindo cadastro de alunos...\n");
                    Thread.sleep(1000);
                    System.out.print("Insira o nome completo do aluno: ");
                    String nome = scam_aluno.nextLine();

                    System.out.print("Insira o curso do aluno: ");
                    String curso = scam_aluno.nextLine();

                    if (!nome.isEmpty() && !curso.isEmpty()) {
                        int novoId = alunos.size() + 1; // função pra começar em 1
                        alunos.add(new Aluno(nome, curso, novoId));
                        System.out.println("Aluno cadastrado com sucesso! ID: " + novoId);
                        System.out.println("\nRetornando ao menu...");
                        Thread.sleep(1000);
                    } else {
                        System.out.println("Preencha todos os campos corretamente.");
                        Thread.sleep(1000);
                    }
                    break;

                case 2: // Listar Alunos
                    System.out.println("Buscando alunos...");
                    Thread.sleep(1000);
                    if (alunos.isEmpty()) {
                        System.out.println("\nNenhum aluno cadastrado.");
                    } else {
                        System.out.println("\n--- LISTA DE ALUNOS ---");
                        for (Aluno a : alunos) {
                            System.out.println("ID: " + a.getMatricula() +
                                    " | Nome: " + a.getNome() +
                                    " | Curso: " + a.getCurso());
                        }
                    }
                    Thread.sleep(1000);
                    break;

                case 3: // Apagar Aluno
                    System.out.println("Abrindo menu de exclusão...");
                    Thread.sleep(1000);
                    if (alunos.isEmpty()) {
                        System.out.println("\nNenhum aluno cadastrado.");
                        break;
                    }

                    System.out.println("\nDeseja remover o aluno por:");
                    System.out.println("1 - Nome");
                    System.out.println("2 - ID");
                    System.out.print("Escolha: ");
                    int opcaoRemover = scam_aluno.nextInt();
                    scam_aluno.nextLine();

                    Aluno alunoRemover = null;

                    if (opcaoRemover == 1) {
                        System.out.print("Digite o nome do aluno que deseja apagar: ");
                        String nomeApagar = scam_aluno.nextLine();
                        System.out.println("Lendo nome...");
                        Thread.sleep(1000);
                        for (Aluno a : alunos) {
                            if (a.getNome().equalsIgnoreCase(nomeApagar)) {
                                alunoRemover = a;
                                break;
                            }
                        }
                    } else if (opcaoRemover == 2) {
                        System.out.print("Digite o ID do aluno que deseja apagar: ");
                        int idApagar = scam_aluno.nextInt();
                        System.out.println("lendo ID...");
                        Thread.sleep(1000);
                        for (Aluno a : alunos) {
                            if (a.getMatricula() == idApagar) {
                                alunoRemover = a;
                                break;
                            }
                        }
                    } else {
                        System.out.println("Opção inválida.");
                        Thread.sleep(1000);
                        break;
                    }

                    if (alunoRemover != null) {
                        alunos.remove(alunoRemover);

                        // Reordenar IDs começando em 1
                        for (int i = 0; i < alunos.size(); i++) {
                            alunos.get(i).setMatricula(i + 1);
                        }

                        System.out.println("Aluno removido com sucesso!");
                        Thread.sleep(1000);
                    } else {
                        System.out.println("Aluno não encontrado.");
                        Thread.sleep(1000);
                    }
                    break;

                case 4:
                    System.out.println("Saindo do menu de alunos...");
                    Thread.sleep(1000);
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    Thread.sleep(1000);
                    break;
            }
        }
    }

    public static ArrayList<String> getListaNomes() {
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
