package cadastros;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import funcoes.Confirmar_saida;

public class Cadastro_curso {

    // Getter para listar todos os cursos cadastrados
    public static ArrayList<String> getCurso() {
        ArrayList<String> listaCurso = new ArrayList<>();

        for (String nomeCurso : cursos.values()) {
            listaCurso.add(nomeCurso);
        }

        return listaCurso;
    }

    private static Map<Integer, String> cursos = new HashMap<>();

    public static void cadastrar_curso() throws InterruptedException {
        Scanner scam_curso = new Scanner(System.in);

        int codigo = 0;

        int opcao;

        boolean ficar_menu = true;
        while (ficar_menu) {
            System.out.println("\n==={ MENU DE CADASTRO DE CURSOS }===");
            System.out.println("1 - Cadastrar curso");
            System.out.println("2 - Listar cursos");
            System.out.println("3 - Apagar cursos");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scam_curso.nextInt();
            scam_curso.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Iniciando...");
                    Thread.sleep(1000);
                    System.out.print("Digite o nome do curso: ");
                    String nome = scam_curso.nextLine();

                    if (nome.isEmpty() == false) {
                        codigo++;
                    }

                    cursos.put(codigo, nome);
                    System.out.println("Curso cadastrado com sucesso!");

                    String opcao_aluno = Confirmar_saida.saida();

                    if (opcao_aluno.equalsIgnoreCase("n")) {
                    } else if (opcao_aluno.equalsIgnoreCase("s")) {
                        ficar_menu = false;
                    } else {
                        System.out.println("Insira um caractere válido!");
                    }
                    Thread.sleep(1000);
                    break;

                case 2:
                    System.out.println("Buscando...");
                    Thread.sleep(1000);
                    System.out.println("\n=== LISTA DE CURSOS ===");
                    if (cursos.isEmpty()) {
                        System.out.println("Nenhum curso cadastrado.");
                    } else {
                        for (Map.Entry<Integer, String> curso : cursos.entrySet()) {
                            System.out.println("Código: " + curso.getKey() + " | Nome: " + curso.getValue());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Carregando...");
                    Thread.sleep(1000);
                    System.out.println("\n=== APAGAR CURSO ===");

                    if (cursos.isEmpty()) {
                        System.out.println("Nenhum curso cadastrado.");
                        break;
                    }

                    // Mostra os cursos atuais
                    for (Map.Entry<Integer, String> curso : cursos.entrySet()) {
                        System.out.println("Código: " + curso.getKey() + " | Nome: " + curso.getValue());
                    }

                    System.out.print("Digite o código do curso que deseja apagar: ");
                    int codigoApagar = scam_curso.nextInt();
                    scam_curso.nextLine();

                    if (cursos.containsKey(codigoApagar)) {
                        cursos.remove(codigoApagar);
                        System.out.println("Curso removido com sucesso!");

                        Map<Integer, String> reorganizado = new HashMap<>();
                        int novoCodigo = 1;
                        for (String cursoNome : cursos.values()) {
                            reorganizado.put(novoCodigo++, cursoNome);
                        }
                        cursos = reorganizado;

                    } else {
                        System.out.println("Código inexistente!");
                        System.out.println("Retornando...");
                        Thread.sleep(1000);
                    }
                    break;

                case 4:
                    System.out.println("Voltando para o menu de cadastros...");
                    Thread.sleep(1000);

                    break;

                default:
                    System.out.println("Opção inválida!");
                    Thread.sleep(1000);
                    break;
            }

        }

    }
}
