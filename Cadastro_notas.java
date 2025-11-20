
// Cadastro_de_Notas.java - Michelle
import java.util.ArrayList; // importa ArrayList para armazenar listas
import java.util.HashMap; // importa HashMap para mapear IDs -> alunos
import java.util.Scanner; // importa Scanner para ler entrada do usuário

public class Cadastro_notas { // classe pública principal do arquivo

    public static void relatorioAlunosPorUC() {
        
        ArrayList<Aluno> lista = banco.listar();
        
        if (lista.isEmpty()) {
            System.out.println("\n=== NENHUM ALUNO CADASTRADO NO SISTEMA DE NOTAS ===");
            return;
        }

        System.out.println("\n--- RELATÓRIO: Alunos por Disciplina (UC) ---");

        // Mapa disciplina -> lista de alunos
        HashMap<String, ArrayList<String>> mapa = new HashMap<>();

        for (Aluno aluno : lista) {
            for (Disciplina d : aluno.getDisciplinas()) {

                // verifica se a disciplina já existe no mapa
                if (!mapa.containsKey(d.getNome())) {
                    mapa.put(d.getNome(), new ArrayList<>()); // cria lista vazia se não existir
                }

                // adiciona o aluno à lista da disciplina
                mapa.get(d.getNome()).add(aluno.getNome());
            }
        }
        
        // imprimir
        for (String uc : mapa.keySet()) {
            System.out.println("\nDisciplina: " + uc);
            for (String nomeAluno : mapa.get(uc)) {
                System.out.println(" - " + nomeAluno);
            }
        }
    }
    
    public static ArrayList<String> getUC() {
        ArrayList<String> listaUC = new ArrayList<>();
        
        // passa por todos os alunos cadastrados
        for (Aluno aluno : banco.listar()) {
            
            // pega todas as disciplinas de cada aluno
            for (Disciplina d : aluno.getDisciplinas()) {

                // adiciona somente se ainda não existir na lista
                if (!listaUC.contains(d.getNome())) {
                    listaUC.add(d.getNome());
                }
            }
        }
        
        return listaUC;
    }
    
    static BancoNotas banco = new BancoNotas(); // nosso "banco" de alunos
    
    public static ArrayList<Aluno> getAlunos() { // função para armazenar os nomes dos alunos para puxar paara outro
        // código
        return banco.listar();
    }
    
    // ------------------- CLASSE Disciplina --------------------
    static class Disciplina { // representa uma disciplina com várias notas
        private String nome; // nome da disciplina
        private ArrayList<Double> notas = new ArrayList<>(); // notas dessa disciplina
        
        public Disciplina(String nome) { // construtor com nome da disciplina
            this.nome = nome;
        }
        
        public String getNome() {
            return nome;
        }

        // adiciona uma nota (por avaliação) à disciplina
        public void adicionarNota(double nota) {
            notas.add(nota);
        }
        
        // substitui uma nota em um índice específico
        public void setNota(int indice, double nota) {
            if (indice >= 0 && indice < notas.size()) {
                notas.set(indice, nota);
            }
        }
        
        // retorna a lista de notas (para exibir ou editar)
        public ArrayList<Double> getNotas() {
            return notas;
        }

        // calcula a média desta disciplina (soma das notas / quantidade)
        public double calcularMediaDisciplina() {
            if (notas.isEmpty())
                return 0;
            double soma = 0;
            for (double n : notas)
                soma += n;
            return soma / notas.size();
        }
    }
    
    // ------------------- CLASSE Aluno --------------------
    public static class Aluno { // representa um aluno que tem várias disciplinas
        private String nome; // nome do aluno
        private ArrayList<Disciplina> disciplinas = new ArrayList<>(); // disciplinas do aluno
        
        public Aluno(String nome) { // construtor com nome
            this.nome = nome;
        }
        
        public String getNome() {
            return nome;
        }
        
        public ArrayList<Disciplina> getDisciplinas() {
            return disciplinas;
        }

        public int contarDisciplinasAprovadas() {
            int count = 0;
            for (Disciplina d : disciplinas) {
                if (d.calcularMediaDisciplina() >= 7.0) {
                    count++;
                }
            }
            return count;
        }

        // adiciona uma disciplina (vazia) ao aluno e retorna referência
        public Disciplina adicionarDisciplina(String nomeDisc) {
            Disciplina d = new Disciplina(nomeDisc);
            disciplinas.add(d);
            return d;
        }

        // calcula a média do aluno com base nas médias das disciplinas
        public double calcularMedia() {
            if (disciplinas.isEmpty())
                return 0;
            double somaMedias = 0;
            for (Disciplina d : disciplinas) {
                somaMedias += d.calcularMediaDisciplina();
            }
            return somaMedias / disciplinas.size();
        }


        // retorna índices das disciplinas cuja média < 7.0
        public ArrayList<Integer> indicesDisciplinasInsuficientes() {
            ArrayList<Integer> idx = new ArrayList<>();
            for (int i = 0; i < disciplinas.size(); i++) {
                if (disciplinas.get(i).calcularMediaDisciplina() < 7.0)
                    idx.add(i);
            }
            return idx;
        }
    }

    // ------------------- CLASSE BancoNotas --------------------
    static class BancoNotas { // gerencia coleções de alunos
        private ArrayList<Aluno> lista = new ArrayList<>(); // lista de alunos
        private HashMap<Integer, Aluno> mapa = new HashMap<>(); // id -> aluno

        // cadastra um novo aluno e retorna seu ID (posição)
        public int cadastrarAluno(Aluno a) {
            lista.add(a);
            int id = lista.size() - 1;
            mapa.put(id, a);
            return id;
        }

        // retorna aluno por ID (ou null)
        public Aluno buscarPorId(int id) {
            return mapa.get(id);
        }

        // retorna lista de alunos
        public ArrayList<Aluno> listar() {
            return lista;
        }

        // procura aluno pelo nome (ignora maiúsc/minúsc). Retorna ID ou -1 se não
        // achar.
        public int buscarIdPorNome(String nome) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNome().equalsIgnoreCase(nome))
                    return i;
            }
            return -1;
        }
    }

    // ------------------- MÉTODO principal --------------------
    public static void cadastrar_notas() {

        Scanner scam_notas = new Scanner(System.in); // Scanner para a entrada
        int op = 0;

        while (op != 5) {

            System.out.println("\n=== CADASTRO DE NOTAS ===");
            System.out.println("1 - Cadastrar nota (adicionar disciplina/avaliacoes a um aluno)");
            System.out.println("2 - Listar boletim de um aluno (médias por disciplina e média geral)");
            System.out.println("3 - Listar todos os alunos (com IDs)");
            System.out.println("4 - Apagar notas");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            op = scam_notas.nextInt();
            scam_notas.nextLine(); // consome \n

            switch (op) {

                case 1: // cadastrar nota (se o aluno não existir, cria)
                    System.out.print("Nome do aluno: ");
                    String nomeAluno = scam_notas.nextLine();

                    int idAluno = banco.buscarIdPorNome(nomeAluno);
                    Aluno aluno;
                    if (idAluno == -1) {
                        // cria novo aluno
                        aluno = new Aluno(nomeAluno);
                        idAluno = banco.cadastrarAluno(aluno);
                        System.out.println("Aluno criado com ID: " + idAluno);
                    } else {
                        aluno = banco.buscarPorId(idAluno);
                    }

                    System.out.print("Disciplina: ");
                    String nomeDisc = scam_notas.nextLine();

                    // cria a disciplina para este aluno
                    Disciplina disc = aluno.adicionarDisciplina(nomeDisc);

                    // quantas notas esta disciplina terá?
                    System.out.print("Quantas notas (avaliações) deseja registrar para esta disciplina? ");
                    int qtd = scam_notas.nextInt();
                    scam_notas.nextLine();

                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Nota " + (i + 1) + ": ");
                        double n = scam_notas.nextDouble();
                        scam_notas.nextLine();
                        disc.adicionarNota(n);
                    }

                    System.out.println("Disciplina e suas notas adicionadas ao aluno ID " + idAluno);
                    break;

                case 2: // listar boletim de um aluno e aplicar regras
                    if (banco.listar().isEmpty()) {
                        System.out.println("\n=== NENHUM ALUNO CADASTRADO ===");
                        break;
                    }

                    System.out.print("Digite o nome do aluno para visualizar o boletim: ");
                    String busca = scam_notas.nextLine();

                    int buscaId = banco.buscarIdPorNome(busca);
                    if (buscaId == -1) {
                        System.out.println("--- ALUNO NÃO ENCONTRADO ---");
                        break;
                    }

                    Aluno a = banco.buscarPorId(buscaId);

                    System.out.println("\n--- BOLETIM: " + a.getNome().toUpperCase() + " (ID " + buscaId + ") ---");
                    System.out.println("ID  | DISCIPLINA          | MÉDIA DA DISCIPLINA | NOTAS (avaliacoes)");

                    for (int i = 0; i < a.getDisciplinas().size(); i++) {
                        Disciplina d = a.getDisciplinas().get(i);
                        System.out.printf("%-3d | %-20s | %-18.2f | ",
                                i, d.getNome(), d.calcularMediaDisciplina());
                        // exibe notas individuais entre colchetes
                        System.out.print("[");
                        for (int j = 0; j < d.getNotas().size(); j++) {
                            System.out.printf("%.2f", d.getNotas().get(j));
                            if (j < d.getNotas().size() - 1)
                                System.out.print(", ");
                        }
                        System.out.println("]");
                    }

                    double mediaAluno = a.calcularMedia();
                    System.out.printf("\nMédia do aluno (média das médias das disciplinas): %.2f\n", mediaAluno);

                    // regras pedidas
                    if (mediaAluno >= 7.0) {
                        System.out.println("Situação: APROVADO");
                    } else if (mediaAluno >= 4.0) {
                        System.out.println("Situação: RECUPERAÇÃO");

                        // disciplinas insuficientes (média < 7) deste aluno
                        ArrayList<Integer> insuf = a.indicesDisciplinasInsuficientes();
                        if (insuf.isEmpty()) {
                            System.out.println("Nenhuma disciplina com média insuficiente.");
                        } else {
                            System.out.println("\nDisciplinas com média insuficiente (<7):");
                            System.out.println("ID  | DISCIPLINA          | MÉDIA  | NOTAS");

                            for (int idx : insuf) {
                                Disciplina d = a.getDisciplinas().get(idx);
                                System.out.printf("%-3d | %-20s | %-6.2f | ", idx, d.getNome(),
                                        d.calcularMediaDisciplina());
                                System.out.print("[");
                                for (int j = 0; j < d.getNotas().size(); j++) {
                                    System.out.printf("%.2f", d.getNotas().get(j));
                                    if (j < d.getNotas().size() - 1)
                                        System.out.print(", ");
                                }
                                System.out.println("]");
                            }

                            // opção de alterar nota apenas nas disciplinas deste aluno
                            System.out.print("\nDeseja alterar alguma nota deste aluno? (s/n): ");
                            String resp = scam_notas.nextLine();
                            if (resp.equalsIgnoreCase("s")) {
                                System.out.print("Digite o ID da disciplina a alterar: ");
                                int idDisc = scam_notas.nextInt();
                                scam_notas.nextLine();

                                if (idDisc >= 0 && idDisc < a.getDisciplinas().size()) {
                                    Disciplina d = a.getDisciplinas().get(idDisc);

                                    // mostra notas atuais com índices
                                    System.out.println("Notas atuais da disciplina '" + d.getNome() + "':");
                                    for (int j = 0; j < d.getNotas().size(); j++) {
                                        System.out.printf("%d) %.2f\n", j, d.getNotas().get(j));
                                    }

                                    System.out.print("Digite o número (índice) da nota que deseja alterar: ");
                                    int idNota = scam_notas.nextInt();
                                    scam_notas.nextLine();

                                    if (idNota >= 0 && idNota < d.getNotas().size()) {
                                        System.out.print("Nova nota: ");
                                        double nova = scam_notas.nextDouble();
                                        scam_notas.nextLine();
                                        d.setNota(idNota, nova);
                                        System.out.println("Nota alterada com sucesso.");

                                        // mostrar nova média e situação atualizada
                                        double novaMediaDisc = d.calcularMediaDisciplina();
                                        double novaMediaAluno = a.calcularMedia();
                                        System.out.printf("Nova média da disciplina '%s': %.2f\n", d.getNome(),
                                                novaMediaDisc);
                                        System.out.printf("Nova média do aluno: %.2f\n", novaMediaAluno);

                                        if (novaMediaAluno >= 7.0)
                                            System.out.println("Situação: APROVADO");
                                        else if (novaMediaAluno >= 4.0)
                                            System.out.println("Situação: RECUPERAÇÃO");
                                        else
                                            System.out.println("Situação: REPROVADO");
                                    } else {
                                        System.out.println("Índice de nota inválido.");
                                    }
                                } else {
                                    System.out.println("ID de disciplina inválido.");
                                }
                            }
                        }
                    } else {
                        System.out.println("Situação: REPROVADO");
                    }

                    break;

                case 3: // listar todos os alunos com seus IDs
                    ArrayList<Aluno> todos = banco.listar();
                    if (todos.isEmpty()) {
                        System.out.println("\n=== NENHUM ALUNO CADASTRADO ===");
                    } else {
                        System.out.println("\n--- ALUNOS CADASTRADOS ---");
                        System.out.println("ID | NOME");
                        for (int i = 0; i < todos.size(); i++) {
                            System.out.print(String.format("%-2d | %s\n", i, todos.get(i).getNome()));
                        }
                    }
                    break;

                case 4:
                    System.out.print(
                            "\n/-/-/- REMOVER DADOS -/-/-/\n" +
                                    "1 - Remover DISCIPLINA inteira de um aluno\n" +
                                    "2 - Remover UMA NOTA específica de uma disciplina\nDigite: ");

                    int opcRemover = scam_notas.nextInt();
                    scam_notas.nextLine();

                    System.out.print("Nome do aluno: ");
                    String nomeRemove = scam_notas.nextLine();

                    int idRemove = banco.buscarIdPorNome(nomeRemove);
                    if (idRemove == -1) {
                        System.out.println("\n === ALUNO NÃO ENCONTRADO ===");
                        break;
                    }

                    Aluno alunoR = banco.buscarPorId(idRemove);

                    switch (opcRemover) {

                        case 1: // remover disciplina inteira
                            if (alunoR.getDisciplinas().isEmpty()) {
                                System.out.println("Este aluno não possui disciplinas cadastradas.");
                                break;
                            }

                            System.out.println("\nDisciplinas do aluno:");
                            for (int i = 0; i < alunoR.getDisciplinas().size(); i++) {
                                System.out.println(i + " - " + alunoR.getDisciplinas().get(i).getNome());
                            }

                            System.out.print("Digite o código (ID) da disciplina: ");
                            int idDiscRem = scam_notas.nextInt();
                            scam_notas.nextLine();

                            if (idDiscRem < 0 || idDiscRem >= alunoR.getDisciplinas().size()) {
                                System.out.println("ID inválido!");
                                break;
                            }

                            // Remove a disciplina
                            alunoR.getDisciplinas().remove(idDiscRem);
                            System.out.println("\n === DISCIPLINA REMOVIDA COM SUCESSO ===");

                            // SE o aluno não tem mais disciplinas → remover o aluno inteiro
                            if (alunoR.getDisciplinas().isEmpty()) {
                                System.out.println("\nO aluno '" + alunoR.getNome() + "' não possui mais disciplinas.");
                                System.out.println("\n --- REMOVENDO OS DADOS DO ALUNO... ---");

                                // Remover aluno do banco
                                banco.listar().remove(idRemove);
                                banco.mapa.remove(idRemove);

                                // REORGANIZAR OS IDs do mapa
                                banco.mapa.clear();
                                for (int i = 0; i < banco.listar().size(); i++) {
                                    banco.mapa.put(i, banco.listar().get(i));
                                }

                                System.out.println("\n --- ALUNO REMOVIDO COM SUCESSO ---");
                            }

                            break;

                        case 2: // remover nota específica
                            removerNotaEspecifica(alunoR, scam_notas);
                            break;

                        default:
                            System.out.println("\n === OPÇÃO INVÁLIDA ===");
                    }

                    break;

                case 5:
                    System.out.println("SAINDO...");
                    break;

                default:
                    System.out.println("\n === OPÇÃO INVÁLIDA ===");
            }
        }

    }

    // dentro da classe Cadastro_notas, fora de qualquer outro método
    public static void removerNotaEspecifica(Aluno aluno, Scanner scam_notas) {

        if (aluno.getDisciplinas().isEmpty()) {
            System.out.println("\n--- ESTE ALUNO NÃO POSSUI DISCIPLINAS CADASTRADAS ---");
            return;
        }

        System.out.println("\nDisciplinas do aluno:");
        for (int i = 0; i < aluno.getDisciplinas().size(); i++) {
            System.out.printf("%d - %s\n", i, aluno.getDisciplinas().get(i).getNome());
        }

        System.out.print("Digite o ID da disciplina: ");
        int idDisc = scam_notas.nextInt();
        scam_notas.nextLine();

        if (idDisc < 0 || idDisc >= aluno.getDisciplinas().size()) {
            System.out.println("\n--- ID INVÁLIDO ---");
            return;
        }

        Disciplina d = aluno.getDisciplinas().get(idDisc);

        if (d.getNotas().isEmpty()) {
            System.out.println("\n=== ESTA DISCIPLINA NÃO POSSUI NOTAS CADASTRADAS ===");
            return;
        }

        System.out.println("\nNotas da disciplina '" + d.getNome() + "':");
        for (int i = 0; i < d.getNotas().size(); i++) {
            System.out.print(String.format("%d) %.2f\n", i, d.getNotas().get(i)));
        }

        System.out.print("Digite o índice da nota que deseja remover: ");
        int idNota = scam_notas.nextInt();
        scam_notas.nextLine();

        if (idNota < 0 || idNota >= d.getNotas().size()) {
            System.out.println("--- ÍNDICE DE NOTA INVÁLIDO ---");
            return;
        }

        d.getNotas().remove(idNota);
        System.out.println("\n=== NOTA REMOVIDA COM SUCESSO! ===");
    }

}
