import java.util.Scanner;
public class Ex1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nomes[] = new String[30];
        double notas[][] = new double[30][3];
        int opcao;
        int totalalunos = 0;

        while(true){
        System.out.println("\n=== MENU ===");
        System.out.println("1. cadastrar novo aluno");
        System.out.println("2. Lançar notas de aluno");
        System.out.println("3. Ver boletim de todos os alunos");
        System.out.println("4. Buscar boletim de um aluno");
        System.out.println("5. Ver média geral da turma");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        opcao = scan.nextInt();
        scan.nextLine();

        switch(opcao){
            case 1:
                System.out.print("Digite o nome do aluno: ");
                    nomes[totalalunos] = scan.nextLine();
                    totalalunos++;
                    break;
            case 2:
                 if (totalalunos == 0) {
                    System.out.println("Não há alunos cadastrados.");
                } else {
                    for (int i = 0; i < totalalunos; i++) {
                        System.out.println(i + " - " + nomes[i]);
                    }
            
                    System.out.print("Escolha o número do aluno: ");
                    int indiceAluno = scan.nextInt();
            
                    if (indiceAluno >= 0 && indiceAluno < totalalunos) {
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Digite a nota " + (i + 1) + ": ");
                            notas[indiceAluno][i] = scan.nextDouble();
                        }
                    } else {
                        System.out.println("Número inválido.");
                    }
                }
                break;
            case 3:
                for (int i = 0; i < totalalunos; i++) {
                    System.out.println("Notas do aluno: " + nomes[i]);
                for (int j = 0; j < 3; j++) {
                    System.out.println("Nota " + (j + 1) + ": " + notas[i][j]);
                    }
                }
                break;
            case 4:
                //4. Buscar boletim de um aluno
                if (totalalunos == 0) {
                        System.out.println("Não há alunos cadastrados.");
                    } else {
                        for (int i = 0; i < totalalunos; i++) {
                            System.out.println((i + 1) + " - " + nomes[i]);
                        }
                        System.out.print("Informe o número do aluno (1 a " + totalalunos + "): ");
                        int alun = scan.nextInt();
                        if (alun >= 1 && alun <= totalalunos) {
                            System.out.println("Notas do aluno " + nomes[alun - 1] + ":");
                            for (int i = 0; i < 3; i++) {
                                System.out.println("Nota " + (i + 1) + ": " + notas[alun - 1][i]);
                            }
                        } else {
                            System.out.println("Número inválido.");
                        }
                    }
                    break;
            case 5:
                if (totalalunos == 0) {
                        System.out.println("Não há alunos cadastrados.");
                    } else {
                        double somaT = 0;
                        int Qnotas = 0;
                        for (int i = 0; i < totalalunos; i++) {
                            for (int k = 0; k < 3; k++) {
                                somaT += notas[i][k];
                                Qnotas++;
                            }
                        }
                        double mediaturma = somaT / Qnotas;
                        System.out.printf("A média geral da turma é: %.2f\n", mediaturma);
                    }
                    break;
            case 0:
                return;
        }
        scan.close();
    }
}
}
