package rh;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Classe principal do sistema de RH.
 *
 * Permite cadastrar ate 10 funcionarios (assalariados ou horistas),
 * exibir seus dados e pagamentos, e aplicar um aumento percentual
 * geral para todos os funcionarios da lista.
 */
public class Main {

    private static final int MAX_FUNCIONARIOS = 10;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Garante que numeros decimais usem ponto, independente da localizacao do SO
        Locale.setDefault(Locale.US);

        List<Funcionario> funcionarios = new ArrayList<>();

        cadastrarFuncionarios(funcionarios);

        System.out.println("\n===== DADOS E PAGAMENTOS (ANTES DO AUMENTO) =====");
        exibirTodos(funcionarios);

        if (!funcionarios.isEmpty()) {
            aplicarAumentoGeral(funcionarios);

            System.out.println("\n===== DADOS E PAGAMENTOS (APOS O AUMENTO) =====");
            exibirTodos(funcionarios);
        }

        System.out.println("\nPrograma encerrado.");
    }

    /**
     * Le do usuario os dados de ate MAX_FUNCIONARIOS funcionarios,
     * perguntando o tipo (assalariado/horista) e os dados especificos
     * de cada um. Todos sao armazenados na mesma lista (List<Funcionario>),
     * demonstrando o uso de polimorfismo.
     */
    private static void cadastrarFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("=== Cadastro de Funcionarios (maximo de " + MAX_FUNCIONARIOS + ") ===");

        for (int i = 1; i <= MAX_FUNCIONARIOS; i++) {
            System.out.println("\nFuncionario " + i + " de " + MAX_FUNCIONARIOS);
            System.out.print("Deseja cadastrar este funcionario? (S/N): ");
            String resposta = scanner.nextLine().trim();

            if (!resposta.equalsIgnoreCase("S")) {
                break;
            }

            Funcionario funcionario = lerFuncionario();
            funcionarios.add(funcionario);
        }
    }

    /**
     * Le do teclado os dados comuns e, de acordo com o tipo escolhido,
     * os dados especificos, retornando a instancia correta
     * (Assalariado ou Horista).
     */
    private static Funcionario lerFuncionario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Setor: ");
        String setor = scanner.nextLine();

        int tipo;
        do {
            System.out.print("Tipo (1 - Assalariado / 2 - Horista): ");
            tipo = lerInteiro();
        } while (tipo != 1 && tipo != 2);

        if (tipo == 1) {
            System.out.print("Salario mensal: ");
            double salario = lerDouble();
            return new Assalariado(nome, cpf, endereco, telefone, setor, salario);
        } else {
            System.out.print("Horas trabalhadas: ");
            double horas = lerDouble();
            System.out.print("Valor da hora: ");
            double valorHora = lerDouble();
            return new Horista(nome, cpf, endereco, telefone, setor, horas, valorHora);
        }
    }

    /**
     * Exibe os dados e o pagamento de cada funcionario da lista.
     * Como o tipo declarado e Funcionario, cada chamada a exibirDados()
     * (que internamente chama calcularPagamento() e getTipo()) e resolvida
     * em tempo de execucao de acordo com o tipo real do objeto (polimorfismo).
     */
    private static void exibirTodos(List<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
            return;
        }
        for (Funcionario f : funcionarios) {
            f.exibirDados();
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Pede um percentual de aumento ao usuario e aplica esse aumento
     * a todos os funcionarios da lista, independentemente do tipo.
     */
    private static void aplicarAumentoGeral(List<Funcionario> funcionarios) {
        System.out.print("\nInforme o percentual de aumento geral (%): ");
        double percentual = lerDouble();

        for (Funcionario f : funcionarios) {
            f.aplicarAumento(percentual);
        }

        System.out.println("Aumento de " + percentual + "% aplicado a todos os funcionarios.");
    }

    // ----- Metodos auxiliares de leitura com validacao -----

    private static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Valor invalido. Digite novamente: ");
            }
        }
    }

    private static double lerDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.print("Valor invalido. Digite novamente: ");
            }
        }
    }
}
