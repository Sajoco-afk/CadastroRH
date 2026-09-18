package rh;

/**
 * Classe abstrata que representa um funcionario da empresa.
 * Concentra os dados comuns a todos os tipos de funcionario
 * (assalariados e horistas) e define o contrato que cada
 * subclasse deve implementar para o calculo do pagamento.
 */
public abstract class Funcionario {

    // Atributos encapsulados (privados), acessiveis apenas via getters/setters
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String setor;

    public Funcionario(String nome, String cpf, String endereco, String telefone, String setor) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.setor = setor;
    }

    // ----- Getters e Setters -----

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     * Calcula o valor a receber pelo funcionario.
     * Cada subclasse implementa sua propria regra de calculo
     * (metodo abstrato -> polimorfismo).
     */
    public abstract double calcularPagamento();

    /**
     * Aplica um aumento percentual sobre os rendimentos do funcionario.
     * Cada subclasse decide sobre qual valor o aumento incide
     * (salario mensal ou valor da hora).
     *
     * @param percentual percentual de aumento, ex: 10 para 10%
     */
    public abstract void aplicarAumento(double percentual);

    /**
     * Retorna um texto descrevendo o tipo do funcionario.
     * Usado na exibicao dos dados.
     */
    public abstract String getTipo();

    /**
     * Exibe em tela os dados basicos do funcionario e seu pagamento.
     * Usa os metodos abstratos (polimorficos) calcularPagamento() e getTipo(),
     * portanto funciona igualmente para qualquer subclasse.
     */
    public void exibirDados() {
        System.out.println("----------------------------------------");
        System.out.println("Nome.....: " + nome);
        System.out.println("CPF......: " + cpf);
        System.out.println("Endereco.: " + endereco);
        System.out.println("Telefone.: " + telefone);
        System.out.println("Setor....: " + setor);
        System.out.println("Tipo.....: " + getTipo());
        System.out.printf("Pagamento: R$ %.2f%n", calcularPagamento());
    }
}
