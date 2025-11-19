import java.util.Scanner;

public class Cadastro_aluno {
    // Criação de ID de Matrícula privada, ou seja, sempre que o usuário retornar a
    // digitar, o valor não permanece em zero.
    private static int id_matricula = 0;

    public static void cadastrar_aluno() throws InterruptedException {
        // matricula, nome e curso
        Scanner scam_aluno = new Scanner(System.in);

        boolean ficar_aluno = true;
        while (ficar_aluno) {
            System.out.print("Insira seu nome completo: ");
            String nome = scam_aluno.nextLine();

            System.out.print("Insira o curso que deseja: ");
            String curso = scam_aluno.nextLine();

            // Condição .isEmpty() para verificar se uma string é vazia ou não
            if (nome.isEmpty() == false && curso.isEmpty() == false) {
                id_matricula++;
                // String.format = formata uma String para incluir variáveis de forma mais
                // simples
                System.out.println(String.format(
                        "Matrícula efetuada com sucesso!\nNome do aluno: %s\nCurso: %s\nRegistro de Matrícula: Nº %d",
                        nome,
                        curso, id_matricula));
            } else {
                System.out.println("Preencha os campos corretamente.");
            }
            String opcao_aluno = Confirmar_saida.saida();

            if (opcao_aluno.equalsIgnoreCase("n")) {
            } else if (opcao_aluno.equalsIgnoreCase("s")) {
                ficar_aluno = false;
            } else {
                System.out.println("Insira um caractere válido!");
            }
        }
    }
}
