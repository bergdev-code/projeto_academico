import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BancoProfessores {
    public static void gerar_profesores() {

        ArrayList<String> nomesProfs = Cadastro_professor.getNomesProfessores();
        Set<String> semrepetir = new HashSet<>(nomesProfs);

        System.out.println("\n=== PROFESSORES CADASTRADOS ===");

        if (semrepetir.isEmpty()) {
            System.out.println("\nNENHUM PROFESSOR CADASTRADO!");
            return;
        }

        for (String p : semrepetir) {
            System.out.println("- " + p);
        }
    }
}
