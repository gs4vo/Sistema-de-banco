import java.io.*;
import java.util.List;

public class FileUtils {

    // Salva as contas em um arquivo
    public static void salvarContas(List<Conta> contas, String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Conta conta : contas) {
                writer.write(conta.getContaId() + "," + conta.getPessoa().getCpf() + "," + conta.getSaldo());
                writer.newLine();
            }
        }
    }

    public static void lerContas(String arquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                System.out.println("Lido: " + linha);
            }
        }
    }
}
