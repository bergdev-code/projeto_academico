package cadastros;
import java.util.ArrayList;
import java.util.Scanner;

import funcoes.Confirmar_saida;

public class Cadastro_disciplinas {

    private static ArrayList<Integer> array_codigo_disciplina = new ArrayList<>();
    private static ArrayList<String> array_nome_disciplina = new ArrayList<>();
    private static int codigo_disciplinas = 0;

    public static ArrayList<String> getUcDisciplinas() {
        ArrayList<String> lista = new ArrayList<>();

        for (String nome : array_nome_disciplina) {
            lista.add(nome);
        }

        return lista;
    }

    public static void cadastrar_disciplinas() throws InterruptedException {

        Scanner scam_disciplina = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.print(
                    "==={ CADASTRAR DISCIPLINAS }===\n" +
                            "1 - Cadastrar disciplinas\n" +
                            "2 - Listar disciplinas\n" +
                            "3 - Remover disciplinas\n" +
                            "4 - SAIR\nDigite: ");
            int valor_menu = scam_disciplina.nextInt();
            scam_disciplina.nextLine();

            switch (valor_menu) {
                case 1:
                    System.out.println("Iniciando...");
                    Thread.sleep(1000);
                    System.out.print("\n-/-/-CADASTRAR DISCIPLINAS-/-/-\nInsira o nome da disciplina: ");
                    String nome_disciplina = scam_disciplina.nextLine();

                    if (!nome_disciplina.isEmpty()) {
                        codigo_disciplinas++;
                        array_nome_disciplina.add(nome_disciplina);
                        array_codigo_disciplina.add(codigo_disciplinas);
                        System.out.println("\n--- DADOS ADICIONADOS COM SUCESSO! ---");

                        String opcao_disciplinas = Confirmar_saida.saida();

                        if (opcao_disciplinas.equalsIgnoreCase("n")) {
                            Thread.sleep(1000);
                        } else if (opcao_disciplinas.equalsIgnoreCase("s")) {
                            Thread.sleep(1000);
                            continuar = false;
                        } else {
                            System.out.println("\n === INSIRA ALGUM CARACTERE VÁLIDO ===");
                        }
                    } else {
                        System.out.println("\n === INSIRA ALGUMA DISCIPLINA ===");
                    }
                    break;

                case 2:
                    System.out.println("Buscando...");
                    Thread.sleep(1000);
                    System.out.println("-/-/-/DISCIPLINAS CADASTRADAS/-/-/-\n");
                    if (!array_nome_disciplina.isEmpty()) {
                        for (int i = 0; i < array_nome_disciplina.size(); i++) {
                            System.out.println(
                                    String.format("CÓDIGO: %d | DISCIPLINA: %s",
                                            array_codigo_disciplina.get(i),
                                            array_nome_disciplina.get(i)));
                        }
                    } else {
                        System.out.println("\n === NENHUMA DISCIPLINA CADASTRADA! ===\n");
                        System.out.println("Retornando...");
                        Thread.sleep(1000);
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Abrindo menu...");
                    Thread.sleep(1000);
                    System.out.print(
                            "-/-/-/REMOVER CADASTRO/-/-/-\n" +
                                    "1 - Remover pelo código\n" +
                                    "2 - Remover pelo nome\nDigite: ");
                    int disciplina_remover = scam_disciplina.nextInt();
                    scam_disciplina.nextLine();

                    switch (disciplina_remover) {
                        case 1:
                            System.out.print("Insira o código da disciplina que deseja retirar: ");
                            int codigo_remover = scam_disciplina.nextInt();
                            System.out.println("Lendo os códigos...");
                            Thread.sleep(1000);

                            int indexCodigo = array_codigo_disciplina.indexOf(codigo_remover);
                            if (indexCodigo != -1) {
                                array_nome_disciplina.remove(indexCodigo);
                                array_codigo_disciplina.remove(indexCodigo);

                                for (int i = 0; i < array_codigo_disciplina.size(); i++) {
                                    array_codigo_disciplina.set(i, i + 1);
                                }
                                codigo_disciplinas = array_nome_disciplina.size();

                                System.out.println("\n === DADOS EXCLUÍDOS COM SUCESSO! ===");

                                Thread.sleep(1000);

                                String opcao_disciplinas = Confirmar_saida.saida();
                                if (opcao_disciplinas.equalsIgnoreCase("n")) {
                                    Thread.sleep(1000);
                                } else if (opcao_disciplinas.equalsIgnoreCase("s")) {
                                    Thread.sleep(1000);
                                    continuar = false;
                                } else {
                                    System.out.println("\n === INSIRA ALGUM CARACTERE VÁLIDO ===");
                                    Thread.sleep(1000);
                                }
                            } else {
                                System.out.println("\n --- CÓDIGO INVÁLIDO ---");
                                Thread.sleep(1000);
                            }
                            break;

                        case 2:
                            System.out.print("Insira o nome da disciplina que deseja excluir: ");
                            String nome_retirar = scam_disciplina.nextLine();
                            System.out.println("Lendo os nomes...");
                            Thread.sleep(1000);

                            int indexNome = array_nome_disciplina.indexOf(nome_retirar);
                            if (indexNome != -1) {
                                array_nome_disciplina.remove(indexNome);
                                array_codigo_disciplina.remove(indexNome);

                                for (int i = 0; i < array_codigo_disciplina.size(); i++) {
                                    array_codigo_disciplina.set(i, i + 1);
                                }
                                codigo_disciplinas = array_nome_disciplina.size();

                                System.out.println("\n === DADOS EXCLUÍDOS COM SUCESSO! ===");
                                Thread.sleep(1000);
                                String opcao_disciplinas = Confirmar_saida.saida();
                                if (opcao_disciplinas.equalsIgnoreCase("n")) {
                                    Thread.sleep(1000);
                                } else if (opcao_disciplinas.equalsIgnoreCase("s")) {
                                    Thread.sleep(1000);
                                    continuar = false;
                                } else {
                                    System.out.println("\n === INSIRA UM CARACTERE VÁLIDO ===");
                                    Thread.sleep(1000);
                                }
                            } else {
                                System.out.println("\n=== NOME INVÁLIDO! ===");
                                Thread.sleep(1000);
                            }
                            break;

                        default:
                            System.out.println("\n === OPÇÃO INVÁLIDA! ===");
                            Thread.sleep(1000);
                            break;
                    }
                    break;

                case 4:
                    System.out.println("SAINDO...");
                    Thread.sleep(1000);
                    continuar = false;
                    break;

                default:
                    System.out.println("\n === OPÇÃO INVÁLIDA ===!");
                    Thread.sleep(1000);
                    break;
            }
        }
    }
}
