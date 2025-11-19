import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cadastro_curso {

    private static Map<Integer, String> cursos = new HashMap<>();

    public static void cadastrar_curso() {
        Scanner scam_curso = new Scanner(System.in);

        int codigo = 0;

        int opcao;
        do {
            System.out.println("\n=== MENU DE CADASTRO DE CURSOS ===");
            System.out.println("1 - Cadastrar curso");
            System.out.println("2 - Listar cursos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scam_curso.nextInt();
            scam_curso.nextLine();
            switch (opcao) {
                case 1:
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
                        opcao = 0;
                    } else {
                        System.out.println("Insira um caractere válido!");
                    }
                    break;

                case 2:
                    System.out.println("\n=== LISTA DE CURSOS ===");
                    if (cursos.isEmpty()) {
                        System.out.println("Nenhum curso cadastrado.");
                    } else {
                        for (Map.Entry<Integer, String> curso : cursos.entrySet()) {
                            System.out.println("Código: " + curso.getKey() + " | Nome: " + curso.getValue());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

    }
}
