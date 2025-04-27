import java.util.Scanner;
public class Ex3 {
    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);
        System.out.println("Digite a quantidade de alunos:");
        int QuaA = myobj.nextInt();

        System.out.println("Digite a quantidade de notas que cada aluno vai receber:");
        int QuaN = myobj.nextInt();

        myobj.nextLine();

        String[] nomes = new String[QuaA];
        double[][] notas = new double[QuaA][QuaN];
        double[] medias = new double[QuaA];

        for (int i = 0; i < QuaA; i++) {
            System.out.println("Digite o nome do aluno " + (i+1) + ": ");
            nomes[i] = myobj.nextLine();
            double soma = 0;

            for (int j = 0; j < QuaN; j++) {
                System.out.println("Digite as notads do aluno " + (i+1) + ": ");
                notas[i][j] = myobj.nextDouble();
                soma += notas[i][j];
            }
            medias[i] = soma/QuaN;
            myobj.nextLine();
        }

            System.out.println("\nResultados:");
        for (int i = 0; i < QuaA; i++) {
            System.out.println("Aluno: " + nomes[i]);
            System.out.printf("Média: %.2f%n", medias[i]);

            if (medias[i] <= 2) {
                System.out.println("Reprovado");
            } else if (medias[i] > 2 && medias[i] < 6) {
                System.out.println("Recuperação");
            } else if (medias[i] >= 6 && medias[i] <= 10) {
                System.out.println("Aprovado");
            } else {
                System.out.println("Erro: média inválida (acima de 10)");
            }
            System.out.println();
        

        myobj.close();
        }
    }
}