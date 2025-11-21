package bancos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import cadastros.Cadastro_aluno;
import cadastros.Cadastro_curso;
import cadastros.Cadastro_professor;

public class BancoCursos {
    public static void gerar_cursos() {

        ArrayList<String> cursosProf = Cadastro_professor.getCursosProfessores();
        ArrayList<String> cursosCurso = Cadastro_curso.getCurso();
        ArrayList<String> cursosAluno = Cadastro_aluno.getCursoAluno();

        Set<String> cursosUnificados = new HashSet<>();

        cursosUnificados.addAll(cursosProf);
        cursosUnificados.addAll(cursosCurso);
        cursosUnificados.addAll(cursosAluno);

        System.out.println("\n=== CURSOS CADASTRADOS ===");

        if (cursosUnificados.isEmpty()) {
            System.out.println("\nNENHUM CURSO CADASTRADO!");
            return;
        }

        for (String curso : cursosUnificados) {
            System.out.println("- " + curso);
        }
    }
}
