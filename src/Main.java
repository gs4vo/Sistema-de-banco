import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Gustavo", 18, "11225600955");
        Pessoa pessoa2 = new Pessoa("Maria", 25, "12345678901");
        Pessoa pessoa3 = new Pessoa("João", 30, "98765432100");
        Pessoa pessoa4 = new Pessoa("Ana", 22, "11223344551");

        Conta conta1 = new Conta(111, pessoa1, 2000);
        Conta conta2 = new Conta(112, pessoa2, 1500);
        Conta conta3 = new Conta(113, pessoa3, 3000);
        Conta conta4 = new Conta(114, pessoa4, 2500);

        List<Conta> contas = new ArrayList<>();
        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);
        contas.add(conta4);

        for (Conta conta : contas) {
            System.out.println(conta);
        }

        conta1.depositar(500);
        System.out.println("Saldo da conta1 após depósito: " + conta1.getSaldo());

        try {
            conta1.sacar(300);
            System.out.println("Saldo da conta1 após saque: " + conta1.getSaldo());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao sacar: " + e.getMessage());
        }

        try {
            FileUtils.salvarContas(contas, "contas.txt");
            System.out.println("Contas salvas no arquivo.");
            FileUtils.lerContas("contas.txt");
        } catch (Exception e) {
            System.out.println("Erro ao salvar ou ler contas: " + e.getMessage());
        }
    }
}
