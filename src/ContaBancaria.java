import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int h = 0;
        int i;
        String cpf = "";
        String nome = "";
        String nomeUpper;
        double saldoAtual;
        int operacao;
        String dadosDoCliente;
        String operacoes = """
                    
                    Operações:
                    
                    1- Consultar saldo atual
                    2- Receber valor
                    3- Transferir valor
                    4- Trocar usuário
                    5- Sair
                    """;
        while (h < 1) {
            i = 0;
            while (i < 1) {
                System.out.println("Insira seu nome completo:");
                nome = leitura.nextLine();
                if (!nome.isEmpty()) {
                    i++;
                } else {
                    System.out.println("Nome inválido");
                }
            }
            nomeUpper = nome.toUpperCase();
            i = 0;
            while (i < 1) {
                System.out.println("Insira seu CPF:");
                cpf = leitura.nextLine();
                if (cpf.length() == 11) {
                    i++;
                } else {
                    System.out.println("CPF inválido");
                }
            }
            saldoAtual = 2500;
            dadosDoCliente = """
                    ******************************************************
                    Dados do cliente:
                    
                    Nome:                 %s
                    CPF:                  %s
                    Tipo de conta:        CORRENTE
                    Saldo atual:          R$ %.2f
                    ******************************************************
                    
                    """.formatted(nomeUpper, cpf, saldoAtual);

            System.out.println(dadosDoCliente);
            System.out.println(operacoes);

            i = 0;
            while (i < 1) {
                operacao = leitura.nextInt();
                switch (operacao) {
                    case 1:
                        System.out.println(String.format("\nO seu saldo atual é: R$ %.2f", saldoAtual));
                        System.out.println(operacoes);
                        break;
                    case 2:
                        System.out.println("\nQual valor você irá receber?");
                        double valorRecebido = leitura.nextDouble();
                        if (valorRecebido < 0) {
                            System.out.println("Valor inválido");
                            System.out.println(operacoes);
                            break;
                        }
                        saldoAtual += valorRecebido;
                        String mensagem2 = """
                                Valor recebido: R$ %.2f
                                Seu saldo atualizado é: R$ %.2f""".formatted(valorRecebido, saldoAtual);
                        System.out.println(mensagem2);
                        System.out.println(operacoes);
                        break;
                    case 3:
                        System.out.println("\nQual valor você irá transferir?");
                        double valorTransferido = leitura.nextDouble();
                        if (valorTransferido > saldoAtual) {
                            System.out.println("O seu saldo atual é menor que a quantidade que você deseja transferir");
                            System.out.println(operacoes);
                            break;
                        } else if (valorTransferido < 0) {
                            System.out.println("Valor inválido");
                            System.out.println(operacoes);
                            break;
                        }
                        saldoAtual -= valorTransferido;
                        String mensagem3 = """
                                Valor transferido: R$ %.2f
                                Seu saldo atualizado é: R$ %.2f""".formatted(valorTransferido, saldoAtual);
                        System.out.println(mensagem3);
                        System.out.println(operacoes);
                        break;
                    case 4:
                        nome = "";
                        cpf = "";
                        i++;
                        break;
                    case 5:
                        System.out.println("\nAtendimento encerrado");
                        i++;
                        h++;
                        break;
                    default:
                        System.out.println("\nOpção inválida");
                        System.out.println(operacoes);
                        break;
                }
            }
        }
    }
}
