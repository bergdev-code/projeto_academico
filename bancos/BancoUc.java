package bancos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import cadastros.Cadastro_disciplinas;
import cadastros.Cadastro_notas;
import cadastros.Cadastro_professor;

public class BancoUc {
    public static void gerar_uc() {

        ArrayList<String> UcDisciplinas = Cadastro_disciplinas.getUcDisciplinas();
        ArrayList<String> UcProf = Cadastro_professor.getUcProfessor();
        ArrayList<String> UcNotas = Cadastro_notas.getUC();

        Set<String> UcUnificados = new HashSet<>();

        UcUnificados.addAll(UcDisciplinas);
        UcUnificados.addAll(UcProf);
        UcUnificados.addAll(UcNotas);

        System.out.println("\n=== DISCIPLINAS CADASTRADAS ===");

        if (UcUnificados.isEmpty()) {
            System.out.println("\nNENHUMA DISCIPLINA CADASTRADA!");
            return;
        }

        for (String uc : UcUnificados) {
            System.out.println("- " + uc);
        }
    }
}
