import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> ingredientes = new ArrayList<>();
        ArrayList<String> instrucoes = new ArrayList<>();

        System.out.println("=== LIVRO DE RECEITAS ===");

        System.out.print("Nome da receita: ");
        String nomeReceita = scanner.nextLine();

        
        System.out.println("\nDigite os ingredientes.");
        System.out.println("Deixe vazio para finalizar.");

        while (true) {

            System.out.print("\nIngrediente: ");
            String ingrediente = scanner.nextLine();

            if (ingrediente.isEmpty()) {
                break;
            }

            System.out.print("Quantidade: ");
            String quantidade = scanner.nextLine();

            ingredientes.add(quantidade + " - " + ingrediente);
        }

        System.out.println("\nDigite o modo de preparo.");
        System.out.println("Deixe vazio para finalizar.");

        int passo = 1;

        while (true) {

            System.out.print("Passo " + passo + ": ");
            String instrucao = scanner.nextLine();

            if (instrucao.isEmpty()) {
                break;
            }

            instrucoes.add(instrucao);

            passo++;
        }

        String nomeArquivo = nomeReceita.replace(" ", "_") + ".txt";

        try {

            FileWriter writer = new FileWriter(nomeArquivo);

            writer.write(nomeReceita + "\n\n");

            writer.write("Ingredientes:\n");

            for (int i = 0; i < ingredientes.size(); i++) {

                writer.write((i + 1) + ". "
                        + ingredientes.get(i) + "\n");
            }

            writer.write("\n");

            writer.write("Modo de preparo:\n");

            for (int i = 0; i < instrucoes.size(); i++) {

                writer.write((i + 1) + ". "
                        + instrucoes.get(i) + "\n");
            }

            writer.close();

            System.out.println("\nReceita salva com sucesso!");
            System.out.println("Arquivo criado: " + nomeArquivo);
            System.out.println("\nFicar feliz :)");

        } catch (IOException e) {

            System.out.println("Erro ao salvar arquivo.");
        }

        scanner.close();
    }
}