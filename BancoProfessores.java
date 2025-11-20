import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BancoProfessores {
    public static void gerar_profesores() {

        ArrayList<String> nomesProfs = Cadastro_professor.getNomesProfessores();

        Set<String> semrepetir = new HashSet<>();
        semrepetir.addAll(nomesProfs);
        
        System.out.println("\n=== PROFESSORES CADASTRADOS ===");
        for (String p : semrepetir) {
            System.out.println("- " + p);
        }

        if (semrepetir.isEmpty()) {
            System.out.println("NENHUM PROFESSOR CADASTRADO!");
        } else {
            for (String prof : semrepetir) {
                System.out.println("- " + prof);
            }
        }
    }
}
