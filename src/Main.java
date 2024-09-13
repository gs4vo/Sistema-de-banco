import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Conta> contas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        carregarContas();

        while (true) {
            System.out.println("1. Listar Contas");
            System.out.println("2. Adicionar Conta");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    listarContas();
                    break;
                case 2:
                    adicionarConta();
                    break;
                case 3:
                    realizarDeposito();
                    break;
                case 4:
                    realizarSaque();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void listarContas() {
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    private static void adicionarConta() {
        System.out.print("Nome do Titular: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do Titular: ");
        int idade = scanner.nextInt();
        System.out.print("CPF do Titular: ");
        String cpf = scanner.next();
        System.out.print("ID da Conta: ");
        int contaId = scanner.nextInt();
        System.out.print("Saldo Inicial: ");
        double saldo = scanner.nextDouble();

        Pessoa pessoa = new Pessoa(nome, idade, cpf);
        Conta conta = new Conta(contaId, pessoa, saldo);
        contas.add(conta);

        System.out.println("Conta adicionada com sucesso!");
    }

    private static void realizarDeposito() {
        System.out.print("ID da Conta para depósito: ");
        int contaId = scanner.nextInt();
        System.out.print("Valor do depósito: ");
        double valor = scanner.nextDouble();

        for (Conta conta : contas) {
            if (conta.getContaId() == contaId) {
                conta.depositar(valor);
                System.out.println("Depósito realizado com sucesso!");
                return;
            }
        }

        System.out.println("Conta não encontrada.");
    }

    private static void realizarSaque() {
        System.out.print("ID da Conta para saque: ");
        int contaId = scanner.nextInt();
        System.out.print("Valor do saque: ");
        double valor = scanner.nextDouble();

        for (Conta conta : contas) {
            if (conta.getContaId() == contaId) {
                try {
                    conta.sacar(valor);
                    System.out.println("Saque realizado com sucesso!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro ao sacar: " + e.getMessage());
                }
                return;
            }
        }

        System.out.println("Conta não encontrada.");
    }

    private static void carregarContas() {
        // Dados iniciais
        Pessoa pessoa1 = new Pessoa("Gustavo", 18, "11225600955");
        Pessoa pessoa2 = new Pessoa("Maria", 25, "12345678901");
        Pessoa pessoa3 = new Pessoa("João", 30, "98765432100");
        Pessoa pessoa4 = new Pessoa("Ana", 22, "11223344551");

        contas.add(new Conta(111, pessoa1, 2000));
        contas.add(new Conta(112, pessoa2, 1500));
        contas.add(new Conta(113, pessoa3, 3000));
        contas.add(new Conta(114, pessoa4, 2500));
    }
}
