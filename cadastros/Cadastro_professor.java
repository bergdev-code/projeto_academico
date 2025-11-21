package cadastros;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Professor {
    String nome;
    String curso;
    String uc;

    Professor(String nome, String curso, String uc) {
        this.nome = nome;
        this.curso = curso;
        this.uc = uc;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Curso: " + curso + " | UC: " + uc;
    }
}

public class Cadastro_professor {

    private static int vinculacao = 1;

    private static Map<Integer, Professor> professores = new HashMap<>();

    // FUNÇÕES GETTERS
    public static ArrayList<String> getUcProfessor() {
        ArrayList<String> listaUc = new ArrayList<>();
        for (Professor p : professores.values()) {
            listaUc.add(p.uc);
        }
        return listaUc;
    }

    public static ArrayList<String> getCursosProfessores() {
        ArrayList<String> listaCursos = new ArrayList<>();
        for (Professor p : professores.values()) {
            listaCursos.add(p.curso);
        }
        return listaCursos;
    }

    public static ArrayList<String> getNomesProfessores() {
        ArrayList<String> listaNomes = new ArrayList<>();
        for (Professor p : professores.values()) {
            listaNomes.add(p.nome);
        }
        return listaNomes;
    }

    // MÉTODO PRINCIPAL
    public static void cadastrar_professor() throws InterruptedException {
        Scanner scam_prof = new Scanner(System.in);

        int op;
        do {
            System.out.println("\n==={ CADASTRO DE PROFESSORES }===");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Listar Professores");
            System.out.println("3 - Apagar Professor");
            System.out.println("4 - Sair");
            System.out.println("================================");
            System.out.print("Escolha uma opção: ");
            op = scam_prof.nextInt();
            scam_prof.nextLine();

            switch (op) {

                case 1:
                    System.out.println("Abrindo cadastro...");
                    Thread.sleep(1000);
                    System.out.print("Informe o nome do Professor: ");
                    String nome = scam_prof.nextLine();
                    System.out.print("Informe o curso do Professor: ");
                    String curso = scam_prof.nextLine();
                    System.out.print("Informe a UC: ");
                    String uc = scam_prof.nextLine();

                    Professor prof = new Professor(nome, curso, uc);

                    professores.put(vinculacao, prof);
                    System.out.println("\n=== PROFESSOR CADASTRADO! | ID: " + vinculacao + " ===");
                    vinculacao++;
                    Thread.sleep(1000);

                    break;

                case 2:
                    System.out.println("Abrindo lista...");
                    Thread.sleep(1000);
                    System.out.println("\n=== LISTA DE PROFESSORES ===");
                    if (professores.isEmpty()) {
                        System.out.println("--- NENHUM PROFESSOR CADASTRADO ---");
                        Thread.sleep(1000);
                    } else {
                        for (Map.Entry<Integer, Professor> entry : professores.entrySet()) {
                            int codigo = entry.getKey();
                            Professor p = entry.getValue();
                            System.out.println("================================");
                            System.out.println(" | Cod. de Vinculação: " + codigo);
                            System.out.println(" | Nome: " + p.nome);
                            System.out.println(" | Curso: " + p.curso);
                            System.out.println(" | UC: " + p.uc);
                        }
                        System.out.println("================================");
                    }
                    break;

                case 3:
                    System.out.println("Abrindo menu de exclusão...");
                    Thread.sleep(1000);
                    System.out.print("\nDigite o ID do professor que deseja excluir: ");
                    int idRemove = scam_prof.nextInt();
                    System.out.println("Lendo ID...");
                    Thread.sleep(1000);

                    if (professores.containsKey(idRemove)) {
                        professores.remove(idRemove);
                        System.out.println("=== PROFESSOR REMOVIDO COM SUCESSO! ===");
                        Thread.sleep(1000);
                    } else {
                        System.out.println("=== ID NÃO ENCONTRADO ===");
                        Thread.sleep(1000);
                    }
                    break;

                case 4:
                    System.out.println("\nENCERRANDO O SISTEMA DE PROFESSORES...");
                    Thread.sleep(1000);
                    op = 0;
                    break;

                default:
                    System.out.println("\n=== OPÇÃO INVÁLIDA ===");
                    Thread.sleep(1000);
                    break;
            }
        } while (op != 0);

    }
}
