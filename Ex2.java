import java.util.Scanner;
public class Ex2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cidade[] = new String[3];
        String semana[] = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        float temperatura[][] = new float[3][7];
        int opcao;

        while (true) {
            System.out.println("\n===============================");
            System.out.println("         MENU PRINCIPAL        ");
            System.out.println("===============================");
            System.out.println("1. Cadastrar cidades e temperaturas");
            System.out.println("2. Ver média de cada cidade");
            System.out.println("3. Cidade com maior média");
            System.out.println("4. Maior temperatura registrada");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n=== Cadastro de Cidades ===");
                    for (int i = 0; i < 3; i++) {
                        System.out.printf("Digite o nome da cidade %d: ", i + 1);
                        cidade[i] = scan.nextLine();
                    }

                    System.out.println("\n=== Cadastro de Temperaturas ===");
                    for (int i = 0; i < 3; i++) {
                        System.out.println("\nCidade: " + cidade[i]);
                        for (int j = 0; j < 7; j++) {
                            System.out.printf("Temperatura em %s: ", semana[j]);
                            temperatura[i][j] = scan.nextFloat();
                        }
                    }
                    System.out.println("\nCadastro finalizado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n=== Médias de Temperatura por Cidade ===");
                    for (int i = 0; i < 3; i++) {
                        float soma = 0;
                        for (int j = 0; j < 7; j++) {
                            soma += temperatura[i][j];
                        }
                        float media = soma / 7;
                        System.out.printf("Cidade: %-10s | Média: %.2f°C\n", cidade[i], media); 
                    }
                    break;

                case 3:
                    System.out.println("\n=== Cidade com a Maior Média de Temperatura ===");
                    float maiorMedia = Float.MIN_VALUE;
                    String cidadeComMaiorMedia = "";
                    for (int i = 0; i < 3; i++) {
                        float soma = 0;
                        for (int j = 0; j < 7; j++) {
                            soma += temperatura[i][j];
                        }
                        float media = soma / 7;
                        if (media > maiorMedia) {
                            maiorMedia = media;
                            cidadeComMaiorMedia = cidade[i];
                        }
                    }
                    System.out.printf("Cidade: %s\nMédia: %.2f°C\n", cidadeComMaiorMedia, maiorMedia);
                    break;

                case 4:
                    System.out.println("\n=== Maior Temperatura Registrada ===");
                    float maiorTemperatura = Float.MIN_VALUE;
                    String cidadeComMaiorTemperatura = "";
                    String diaDaSemana = "";
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            if (temperatura[i][j] > maiorTemperatura) {
                                maiorTemperatura = temperatura[i][j];
                                cidadeComMaiorTemperatura = cidade[i];
                                diaDaSemana = semana[j];
                            }
                        }
                    }
                    System.out.printf("Temperatura: %.2f°C\nCidade: %s\nDia: %s\n",
                                      maiorTemperatura, cidadeComMaiorTemperatura, diaDaSemana);
                    break;

                case 0:
                    System.out.println("\nSaindo do programa... Até a próxima!");
                    return;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    break;
            }
        }
    }
}
