import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//classe para representar um professor
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
    
    // função para armazenar os valores de uc e puxar para outro arquivo através
    // dos getters
    public static ArrayList<String> getUcProfessor() {
        ArrayList<String> listaUc = new ArrayList<>();

        for (Professor p : professores.values()) {
            listaUc.add(p.uc);
        }

        return listaUc; 
    }

    // função para armazenar os valores de curso e puxar para outro arquivo através
    // dos getters
    public static ArrayList<String> getCursosProfessores() {
        ArrayList<String> listaCursos = new ArrayList<>();

        for (Professor p : professores.values()) {
            listaCursos.add(p.curso);
        }

        return listaCursos;
    }

    // Função para armazenar os valores de nome e puxar para outro arquivo atráves
    // dos getters
    public static java.util.ArrayList<String> getNomesProfessores() {
        java.util.ArrayList<String> listaNomes = new java.util.ArrayList<>();

        for (Professor p : professores.values()) {
            listaNomes.add(p.nome);
        }

        return listaNomes;
    }

    private static Map<Integer, Professor> professores = new HashMap<>();

    public static void cadastrar_professor() {
        Scanner scam_prof = new Scanner(System.in);

        int vinculacao = 0;

        // Menu
        int op;
        do {
            System.out.println("\n==={CADASTRO DE PROFESSORES}===");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Listar Professores");
            System.out.println("0 - Sair");
            System.out.println("================================");
            System.out.print("Escolha uma opção: ");
            op = scam_prof.nextInt();
            scam_prof.nextLine();

            switch (op) {

                // cadastro de Professor
                case 1:
                    System.out.print("Informe o nome do Professor: ");
                    String nome = scam_prof.nextLine();
                    System.out.print("Informe o curso de Lecionação do Professor: ");
                    String curso = scam_prof.nextLine();
                    System.out.print("Informe a UC: ");
                    String uc = scam_prof.nextLine();

                    if (nome.isEmpty() == false && curso.isEmpty() == false && uc.isEmpty() == false) {
                        vinculacao++;
                    }

                    Professor prof = new Professor(nome, curso, uc);
                    professores.put(vinculacao, prof);

                    System.out.println("professor cadastrado com sucesso!");

                    String opcao_aluno = Confirmar_saida.saida();

                    if (opcao_aluno.equalsIgnoreCase("n")) {
                    } else if (opcao_aluno.equalsIgnoreCase("s")) {
                        op = 0;
                    } else {
                        System.out.println("Insira um caractere válido!");
                    }

                    break;

                // pesquisa de professor
                case 2:
                    System.out.println("\n==={LISTA DE PROFESSORES}===");
                    if (professores.isEmpty()) {
                        System.out.println("Nenhum Professor cadastrado.");
                    } else {
                        for (Map.Entry<Integer, Professor> entry : professores.entrySet()) {
                            int codigo = entry.getKey();
                            Professor p = entry.getValue();
                            System.out.println("================================");
                            System.out.println("Cod. de Vinculação: " + codigo);
                            System.out.println("Nome: " + p.nome);
                            System.out.println("Curso: " + p.curso);
                            System.out.println("UC: " + p.uc);
                        }
                        System.out.println("===============================");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 0);

    }
}
