public class Cliente extends Thread {
    private final Conta conta;

    public Cliente(Conta conta) {
        this.conta = conta;
    }

    public void run() {
        while (conta.getSaldo() > 0) {
            double valorCompra = Math.random() > 0.5 ? 100 : 200;
            if (conta.getSaldo() >= valorCompra) {
                conta.debitar(valorCompra);
                System.out.println("Cliente realizou uma compra de " + valorCompra);
            }
        }
        System.out.println("Cliente esgotou o saldo da conta.");
    }
}

