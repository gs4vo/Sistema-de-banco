public class Pessoa {

    private String nome;
    private int idade;
    private String cpf; // Alterado para String

    public Pessoa(String nome, int idade, String cpf) {
        setNome(nome);
        setIdade(idade);
        setCpf(cpf);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade < 0 || idade > 150) {
            throw new IllegalArgumentException("Idade deve estar entre 0 e 150 anos.");
        }
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
            throw new IllegalArgumentException("CPF inválido. Deve conter exatamente 11 dígitos.");
        }
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
