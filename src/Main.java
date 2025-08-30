import model.Pessoa;
import service.CadastroService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CadastroService cadastro = new CadastroService();

        int opcao;
        do {
            System.out.println("\n=== Sistema de Cadastro ===");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Buscar pessoa");
            System.out.println("4 - Remover pessoa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite a idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    cadastro.cadastrar(new Pessoa(nome, idade));
                    System.out.println("✅ Pessoa cadastrada!");
                    break;

                case 2:
                    System.out.println("\n=== Pessoas Cadastradas ===");
                    if (cadastro.listar().isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    } else {
                        for (int i = 0; i < cadastro.listar().size(); i++) {
                            System.out.println((i + 1) + " - " + cadastro.listar().get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome da pessoa para buscar: ");
                    String busca = sc.nextLine();
                    Pessoa encontrada = cadastro.buscarPorNome(busca);
                    if (encontrada != null) {
                        System.out.println("🔎 Encontrada: " + encontrada);
                    } else {
                        System.out.println("❌ Pessoa não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o índice da pessoa para remover: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (cadastro.remover(index - 1)) {
                        System.out.println("🗑️ Pessoa removida!");
                    } else {
                        System.out.println("❌ Índice inválido.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("⚠️ Opção inválida, tente novamente.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
