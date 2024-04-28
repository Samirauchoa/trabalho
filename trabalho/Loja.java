public class Loja {
    private final Conta conta;
    private final Funcionario[] funcionarios;

    public Loja(Conta conta, Funcionario[] funcionarios) {
        this.conta = conta;
        this.funcionarios = funcionarios;
    }

    public void pagarSalarios() {
        double totalSalario = 0;
        for (Funcionario funcionario : funcionarios) {
            totalSalario += funcionario.getSalario();
        }
        if (conta.getSaldo() >= totalSalario) {
            for (Funcionario funcionario : funcionarios) {
                conta.debitar(funcionario.getSalario());
                funcionario.receberSalario();
            }
            System.out.println("Salários pagos aos funcionários da loja.");
        } else {
            System.out.println("Saldo insuficiente para pagar os salários.");
        }
    }

    public void mostrarSaldo() {
        System.out.println("Saldo da loja: " + conta.getSaldo());
    }
}
