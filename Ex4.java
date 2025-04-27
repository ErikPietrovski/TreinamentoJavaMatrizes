/*
Crie um programa em Java que simula o controle de estoque de produtos em um pequeno mercado.
Peça ao usuário a quantidade de produtos que deseja cadastrar.

Para cada produto, solicite:

O nome do produto.

A quantidade em estoque (como String).

O preço unitário (como String).

Armazene todas as informações em uma matriz de String, com 3 colunas:

Coluna 0: Nome do produto

Coluna 1: Quantidade

Coluna 2: Preço unitário

Converta os dados numéricos (quantidade e preço) para int e double.

Calcule e mostre o valor total em estoque de cada produto (quantidade * preço).
*/
import java.util.Scanner;

public class Ex4 {

    public class Ex4 {
        public static void main(String[] args) {
            Scanner myobj = new Scanner(System.in);
    
            System.out.print("Quantos produtos deseja cadastrar? ");
            int quantidadeProdutos = myobj.nextInt();
            myobj.nextLine(); // Limpar o buffer de nova linha
    
            // Matriz para armazenar os dados
            String[][] estoque = new String[quantidadeProdutos][3];
    
            // Cadastrar os produtos
            for (int i = 0; i < quantidadeProdutos; i++) {
                System.out.println("\nProduto " + (i + 1));
    
                System.out.print("Nome do produto: ");
                estoque[i][0] = myobj.nextLine();
    
                System.out.print("Quantidade em estoque: ");
                estoque[i][1] = myobj.nextLine();
                // Verificar se a quantidade é um número válido
                while (!estoque[i][1].matches("\\d+")) {
                    System.out.print("Por favor, insira uma quantidade válida (número inteiro): ");
                    estoque[i][1] = myobj.nextLine();
                }
    
                System.out.print("Preço unitário: ");
                estoque[i][2] = myobj.nextLine();
                // Verificar se o preço é um número válido
                while (!estoque[i][2].matches("\\d+\\.\\d{2}")) {
                    System.out.print("Por favor, insira um preço válido (número com duas casas decimais): ");
                    estoque[i][2] = myobj.nextLine();
                }
            }
    
            // Exibir o resumo do estoque
            System.out.println("\nResumo do estoque:");
    
            for (int i = 0; i < quantidadeProdutos; i++) {
                int quantidade = Integer.parseInt(estoque[i][1]);
                double precoUnitario = Double.parseDouble(estoque[i][2]);
    
                double valorTotal = quantidade * precoUnitario;
    
                System.out.printf("Produto: %s | Quantidade: %d | Preço Unitário: R$ %.2f | Valor Total em Estoque: R$ %.2f%n",
                        estoque[i][0], quantidade, precoUnitario, valorTotal);
            }
    
            myobj.close();
        }
    }
}