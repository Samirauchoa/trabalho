public class SistemaBancario {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Conta contaLoja1 = new Conta("Conta Loja 1", 0);
        Conta contaLoja2 = new Conta("Conta Loja 2", 0);

        Funcionario[] funcionariosLoja1 = {
                new Funcionario(new Conta("Salário Funcionario1 Loja1", 0), new Conta("Invest Funcionario1 Loja1", 0), 1400),
                new Funcionario(new Conta("Salário Funcionario2 Loja1", 0), new Conta("Invest Funcionario2 Loja1", 0), 1400)
        };
        Funcionario[] funcionariosLoja2 = {
                new Funcionario(new Conta("Salário Funcionario1 Loja2", 0), new Conta("Invest Funcionario1 Loja2", 0), 1400),
                new Funcionario(new Conta("Salário Funcionario2 Loja2", 0), new Conta("Invest Funcionario2 Loja2", 0), 1400)
        };

        Loja loja1 = new Loja(contaLoja1, funcionariosLoja1);
        Loja loja2 = new Loja(contaLoja2, funcionariosLoja2);

        banco.adicionarLoja(loja1, 0);
        banco.adicionarLoja(loja2, 1);

        for (int i = 1; i <= 5; i++) {
            Cliente cliente = new Cliente(new Conta("Cliente " + i, 1000));
            cliente.start();
        }

        loja1.pagarSalarios();
        loja2.pagarSalarios();

