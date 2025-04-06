import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardDeTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n1. Criar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Mover tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> criarTarefa();
                case 2 -> listarTarefas();
                case 3 -> moverTarefa();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void criarTarefa() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        tarefas.add(new Tarefa(titulo, descricao));
        System.out.println("Tarefa criada!");
    }

    private void listarTarefas() {
        for (Status status : Status.values()) {
            System.out.println("\n--- " + status + " ---");
            tarefas.stream()
                    .filter(t -> t.getStatus() == status)
                    .forEach(System.out::println);
        }
    }

    private void moverTarefa() {
        System.out.print("Título da tarefa: ");
        String titulo = scanner.nextLine();
        Tarefa tarefa = tarefas.stream()
                .filter(t -> t.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);

        if (tarefa == null) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        System.out.println("Novo status (1: A_FAZER, 2: EM_ANDAMENTO, 3: CONCLUIDO): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1 -> tarefa.setStatus(Status.A_FAZER);
            case 2 -> tarefa.setStatus(Status.EM_ANDAMENTO);
            case 3 -> tarefa.setStatus(Status.CONCLUIDO);
            default -> System.out.println("Status inválido.");
        }

        System.out.println("Tarefa atualizada!");
    }

    public static void main(String[] args) {
        new BoardDeTarefas().iniciar();
    }
}
