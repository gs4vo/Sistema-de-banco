import java.util.Objects;

public class Conta {

    private int contaId;
    private Pessoa pessoa;
    private double saldo;

    public Conta(int contaId, Pessoa pessoa, double saldo) {
        setContaId(contaId);
        setPessoa(pessoa);
        setSaldo(saldo);
    }

    public int getContaId() {
        return contaId;
    }

    public void setContaId(int contaId) {
        if (contaId <= 0) {
            throw new IllegalArgumentException("O ID da conta deve ser maior que zero.");
        }
        this.contaId = contaId;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa não pode ser nula.");
        }
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("O saldo não pode ser negativo.");
        }
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo.");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Conta conta = (Conta) obj;
        return contaId == conta.contaId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contaId);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "contaId=" + contaId +
                ", pessoa=" + pessoa +
                ", saldo=" + saldo +
                '}';
    }
}
