import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe para representar um Produto
class Produto {
    private int id;
    private String nome;
    private int quantidade;

    // Construtor
    public Produto(int id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método para exibir informações do produto
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Quantidade: " + quantidade;
    }
}

// Classe principal para gerenciar o estoque
public class GerenciamentoEstoque {
    private List<Produto> estoque;

    // Construtor
    public GerenciamentoEstoque() {
        this.estoque = new ArrayList<>();
    }

    // Método para adicionar um novo produto ao estoque
    public void adicionarProduto(int id, String nome, int quantidade) {
        Produto novoProduto = new Produto(id, nome, quantidade);
        estoque.add(novoProduto);
        System.out.println("Produto adicionado com sucesso.");
    }

    // Método para atualizar a quantidade de um produto no estoque
    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto produto : estoque) {
            if (produto.getId() == id) {
                produto.setQuantidade(novaQuantidade);
                System.out.println("Quantidade do produto atualizada com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    // Método para listar todos os produtos no estoque
    public void listarProdutos() {
        System.out.println("Lista de produtos no estoque:");
        for (Produto produto : estoque) {
            System.out.println(produto);
        }
    }

    public static void main(String[] args) {
        GerenciamentoEstoque gerenciador = new GerenciamentoEstoque();
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Adicionar novo produto");
            System.out.println("2. Atualizar quantidade de um produto");
            System.out.println("3. Listar todos os produtos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do produto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do teclado

                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite a quantidade inicial: ");
                    int quantidade = scanner.nextInt();

                    gerenciador.adicionarProduto(id, nome, quantidade);
                    break;
                case 2:
                    System.out.print("Digite o ID do produto que deseja atualizar: ");
                    int idProduto = scanner.nextInt();

                    System.out.print("Digite a nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();

                    gerenciador.atualizarQuantidade(idProduto, novaQuantidade);
                    break;
                case 3:
                    gerenciador.listarProdutos();
                    break;
                case 4:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
