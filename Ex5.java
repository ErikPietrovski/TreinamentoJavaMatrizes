/*Enunciado:
Uma empresa está monitorando a produção semanal de seus funcionários. Você deve desenvolver um programa que:

Solicite o nome de 5 funcionários e armazene-os em um vetor.

Para cada um deles, peça a quantidade de peças produzidas por dia durante 7 dias da semana, armazenando os 
dados em uma matriz producao[5][7].

Ao final, o programa deve calcular e exibir:

A produção total de cada funcionário na semana.

A média diária de produção de cada funcionário.

O nome do funcionário com maior produção total.

O dia da semana (1 a 7) em que houve a maior produção total entre todos os funcionários combinados.

Requisitos extras para dificultar:
Utilize funções/métodos para organizar o código.

Não use bibliotecas externas além de Scanner.

Faça uma validação simples para não permitir entrada negativa de peças produzidas. */
import java.util.Scanner;
public class Ex5 {
    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);
        String[] Semana = {"Seg", "Ter", "Qua", "Qui","Sex", "Sab", "Dom"};
        System.out.print("Digite a quantidade de funcionários: ");
        int quantidade = myobj.nextInt();
        myobj.nextLine();

        String[] Funcionarios = new String[quantidade];
        int[][] Pecas = new int[quantidade][7];
        int opcao;

        while(true){
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar funcionários");
            System.out.println("2 - Catalogar produção dos funcionários");
            System.out.println("3 - Ver rendimento de cada dia da semana");
            System.out.println("4 - Ver rendimento total por funcionario na semana");
            System.out.println("5 - Ver produçao total de cada dia");
            System.out.println("6 - Ver funcionário com maior produção");
            System.out.println("7  - Ver dia com menor produção total");
            System.out.println("8  - Ver funcionário com maior média diária");
            System.out.println("9  - Mostrar média geral da empresa por dia");
            System.out.println("10 - Exibir ranking de produtividade (do maior ao menor)");
            System.out.println("11 - Exibir tabela completa de produção");
            System.out.println("12 - Corrigir produção de um funcionário em um dia");
            System.out.println("13 - Resetar todos os dados de produção");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = myobj.nextInt();

            switch (opcao) {
                case 1:
                System.out.println("=== Cadastro de Funcionários ===");
                for (int i = 0; i < Funcionarios.length; i++) {
                    String nome;
                    do {
                        System.out.print("Cadastre o funcionário " + (i + 1) + ": ");
                        nome = myobj.nextLine();
                        if (nome.isEmpty()) {
                            System.out.println("Nome não pode estar vazio. Tente novamente.");
                        }
                    } while (nome.isEmpty());
                    Funcionarios[i] = nome;
                }
                    break;
                case 2:
                System.out.println("=== Produçao dos funcionarios ===");
                for (int i = 0; i < Pecas.length; i++) {
                    System.out.println("Produçao do funcionario " + Funcionarios[i] +":");
                    for (int j = 0; j < 7; j++) {
                        System.out.print("Peças produzidas na(o) " + Semana[j] + ": ");
                        Pecas[i][j] = myobj.nextInt();
                    }
                }
                    break;
                case 3:
                System.out.println("=== Rendimento por dia da semana ===");
                for (int j = 0; j < 7; j++) {
                    int totalDia = 0;
                    for (int i = 0; i < Pecas.length; i++) {
                        totalDia += Pecas[i][j];
                    }
                    System.out.println(Semana[j] + ": " + totalDia + " peças");
                }
                    break;
                case 4:
                System.out.println("=== Rendimento da semana ===");
                for (int i = 0; i < Pecas.length; i++) {
                    int totalSemana = 0;
                    for (int j = 0; j < 7; j++) {
                        totalSemana += Pecas[i][j];
                    }
                    System.out.println(Funcionarios[i] + ": " + totalSemana + " peças na semana");
                }
                    break;                
                case 5:
                System.out.println("=== Produção total de um dia ===");
                for (int i = 0; i < Semana.length; i++) {
                    System.out.println(i + " - " + Semana[i]);
                }

                System.out.print("Escolha o dia (0 a 6): ");
                int diaEscolhido = myobj.nextInt();
                if (diaEscolhido < 0 || diaEscolhido > 6) {
                 System.out.println("Dia inválido.");
                    break;
                }
                int totalDia = 0;
                for (int i = 0; i < quantidade; i++) {
                    totalDia += Pecas[i][diaEscolhido];
                }
                System.out.println("Produção total na " + Semana[diaEscolhido] + ": " + totalDia + " peças.");            
                    break;
                case 6:
                System.out.println("=== Funcionario com a maior Produção Total ===");
                int maiorProducao = 0;
                int indiceMaior = 0;
                for (int i = 0; i < Pecas.length; i++) {
                    int total = 0;
                    for (int j = 0; j < 7; j++) {
                        total += Pecas[i][j];
                    }
                    if (total > maiorProducao) {
                        maiorProducao = total;
                        indiceMaior = i;
                    }
                }
                System.out.println("Funcionário com maior produção: " + Funcionarios[indiceMaior] + " com " + maiorProducao + " peças");
                    break;
                case 7:
                System.out.println("=== Dia com Menor Produção Total ===");
                int[] totalPorDia = new int[7];
                for (int dia = 0; dia < 7; dia++) {
                    for (int func = 0; func < quantidade; func++) {
                        totalPorDia[dia] += Pecas[func][dia];
                    }
                }
                int menorDia = 0;
                for (int i = 1; i < 7; i++) {
                    if (totalPorDia[i] < totalPorDia[menorDia]) {
                        menorDia = i;
                    }
                }
                System.out.println("O dia com menor produção foi " + Semana[menorDia] + " com um total de " + totalPorDia[menorDia] + " peças.");
                    break;
                case 8:
                System.out.println("=== Funcionário com Maior Média Diária ===");
                double maiorMedia = -1;
                int indiceMaiorMedia = -1;
                for (int i = 0; i < quantidade; i++) {
                    int soma = 0;
                    for (int j = 0; j < 7; j++) {
                        soma += Pecas[i][j];
                    }
                    double media = soma/7;
                    if (media > maiorMedia) {
                        maiorMedia = media;
                        indiceMaiorMedia = i;
                    }
                }
            
                if (indiceMaiorMedia != -1) {
                    System.out.printf("Funcionário com maior média diária: %s (%.2f peças por dia)\n",
                                      Funcionarios[indiceMaiorMedia], maiorMedia);
                } else {
                    System.out.println("Nenhum dado de produção foi registrado ainda.");
                }
                    break;
                case 9:
                System.out.println("=== Média Geral da Empresa por Dia ===");

                for (int dia = 0; dia < 7; dia++) {
                    int soma = 0;
                    for (int func = 0; func < quantidade; func++) {
                        soma += Pecas[func][dia];
                    }
                    double media = (double) soma / quantidade;
                    System.out.printf("%s: média de %.2f peças\n", Semana[dia], media);
                }
                    break;
                case 10:
                System.out.println("=== Ranking de Produtividade ===");
                int[] somaFuncionario = new int[quantidade];
                for (int i = 0; i < quantidade; i++) {
                    for (int j = 0; j < 7; j++) {
                        somaFuncionario[i] += Pecas[i][j];
                    }
                }
                for (int i = 0; i < quantidade - 1; i++) {
                    for (int j = 0; j < quantidade - i - 1; j++) {
                        if (somaFuncionario[j] < somaFuncionario[j + 1]) {
                            int tempSoma = somaFuncionario[j];
                            somaFuncionario[j] = somaFuncionario[j + 1];
                            somaFuncionario[j + 1] = tempSoma;

                            String tempNome = Funcionarios[j];
                            Funcionarios[j] = Funcionarios[j + 1];
                            Funcionarios[j + 1] = tempNome;
                        }
                    }
                }

                for (int i = 0; i < quantidade; i++) {
                    System.out.println((i + 1) + "º - " + Funcionarios[i] + ": " + somaFuncionario[i] + " peças");
                }
                    break;
                case 11:
                System.out.println("=== Tabela Completa de Produção ===");
                System.out.print("Funcionário\t");
                for (String dia : Semana) {
                    System.out.print(dia + "\t");
                }
                System.out.println("Total");
                for (int i = 0; i < quantidade; i++) {
                    int total = 0;
                    System.out.print(Funcionarios[i] + "\t");
                    for (int j = 0; j < 7; j++) {
                        System.out.print(Pecas[i][j] + "\t");
                        total += Pecas[i][j];
                    }
                    System.out.println(total);
                }
                    break;
                case 12:
                System.out.println("=== Corrigir Produção ===");
    
                for (int i = 0; i < quantidade; i++) {
                    System.out.println(i + " - " + Funcionarios[i]);
                }
                System.out.print("Escolha o funcionário (índice): ");
                int fIndex = myobj.nextInt();
            
                for (int i = 0; i < 7; i++) {
                    System.out.println(i + " - " + Semana[i]);
                }
                System.out.print("Escolha o dia (índice): ");
                int dIndex = myobj.nextInt();
            
                System.out.print("Nova quantidade de peças: ");
                int novaQuantidade = myobj.nextInt();
            
                if (fIndex >= 0 && fIndex < quantidade && dIndex >= 0 && dIndex < 7) {
                    Pecas[fIndex][dIndex] = novaQuantidade;
                    System.out.println("Correção feita com sucesso!");
                } else {
                    System.out.println("Índices inválidos.");
                }
                    break;
                case 13:
                System.out.println("=== Resetar Produção ===");
                for (int i = 0; i < quantidade; i++) {
                    for (int j = 0; j < 7; j++) {
                        Pecas[i][j] = 0;
                    }
                }
                System.out.println("Todos os dados de produção foram zerados.");
                    break;
                case 0:
                System.out.println("Encerrando o programa. Até a próxima!");
                myobj.close();
                System.exit(0);
                    break;
                default:
                    break;
            }

        }

    }
}
