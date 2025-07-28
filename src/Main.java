import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Conta> contas = new HashMap<>();

        System.out.println("=== Bem-vindo ao Banco DIO ===");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Ver Extrato");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, cpf, email);

                    System.out.print("Número da conta: ");
                    String numero = scanner.nextLine();

                    System.out.print("Tipo da conta (1 - Corrente | 2 - Poupança): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    Conta conta;
                    if (tipo == 1) {
                        conta = new ContaCorrente(numero, cliente);
                    } else {
                        conta = new ContaPoupanca(numero, cliente);
                    }

                    contas.put(numero, conta);
                    System.out.println("✅ Conta criada com sucesso!");
                }

                case 2 -> {
                    System.out.print("Número da conta: ");
                    String numero = scanner.nextLine();
                    Conta conta = contas.get(numero);

                    if (conta != null) {
                        System.out.print("Valor do depósito: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();

                        conta.depositar(valor);
                        System.out.println("✅ Depósito realizado com sucesso.");
                    } else {
                        System.out.println("❌ Conta não encontrada.");
                    }
                }

                case 3 -> {
                    System.out.print("Número da conta: ");
                    String numero = scanner.nextLine();
                    Conta conta = contas.get(numero);

                    if (conta != null) {
                        System.out.print("Valor do saque: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();

                        conta.sacar(valor);
                    } else {
                        System.out.println("❌ Conta não encontrada.");
                    }
                }

                case 4 -> {
                    System.out.print("Número da conta de origem: ");
                    String origemNum = scanner.nextLine();
                    Conta origem = contas.get(origemNum);

                    if (origem != null) {
                        System.out.print("Número da conta de destino: ");
                        String destinoNum = scanner.nextLine();
                        Conta destino = contas.get(destinoNum);

                        if (destino != null) {
                            System.out.print("Valor da transferência: ");
                            double valor = scanner.nextDouble();
                            scanner.nextLine();

                            origem.transferir(valor, destino);
                        } else {
                            System.out.println("❌ Conta de destino não encontrada.");
                        }
                    } else {
                        System.out.println("❌ Conta de origem não encontrada.");
                    }
                }

                case 5 -> {
                    System.out.print("Número da conta: ");
                    String numero = scanner.nextLine();
                    Conta conta = contas.get(numero);

                    if (conta != null) {
                        conta.exibirExtrato();
                    } else {
                        System.out.println("❌ Conta não encontrada.");
                    }
                }

                case 0 -> {
                    System.out.println("✅ Sistema encerrado. Até logo!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("❌ Opção inválida.");
            }
        }
    }
}