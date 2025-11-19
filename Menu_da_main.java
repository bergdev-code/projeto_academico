import java.util.Scanner;

public class Menu_da_main {
    public static void Menu_main() throws InterruptedException {
        Scanner scam_menu = new Scanner(System.in);
        boolean ficar = true;

        Cadastro_aluno cadastrar_aluno = new Cadastro_aluno();

        System.out.println("Seja bem vindo!");
        do {
            System.out.print(
                    "[-/-/-/-MENU DE CADASTROS-/-/-/-]\n1 - Cadastrar Cursos\n2 - Cadastrar Disciplinas\n3 - Cadastrar Professores\n4 - Cadastrar Alunos\n5 - Cadastrar Notas\n6 - Retornar ao Menu inicial\nValor: ");
            int valor_menu = scam_menu.nextInt();
            switch (valor_menu) {
                case 1:
                    System.out.println("Iniciando...");
                    Thread.sleep(1500);
                    Cadastro_curso.cadastrar_curso();
                    break;
                case 2:
                    System.out.println("Iniciando...");
                    Thread.sleep(1500);
                    Cadastro_disciplinas.cadastrar_disciplinas();
                    break;
                case 3:
                    System.out.println("Iniciando...");
                    Thread.sleep(1500);
                    Cadastro_professor.cadastrar_professor();
                    break;
                case 4:
                    System.out.println("Iniciando...");
                    Thread.sleep(1500);
                    Cadastro_aluno.cadastrar_aluno();
                    break;
                case 5:
                    System.out.println("Iniciando...");
                    Thread.sleep(1500);
                    Cadastro_notas.cadastrar_notas();
                    break;
                case 6:
                    System.out.println("Retornando...");
                    Thread.sleep(1500);
                    Main.main(null);
                    break;
                default:
                    System.out.println("Insira um valor válido!");
                    break;
            }
        } while (ficar);
        scam_menu.close();
    }
}
