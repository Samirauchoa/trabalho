import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private final Loja[] lojas;
    private final Funcionario[] funcionarios;
    private final Lock lock;

    public Banco() {
        this.lojas = new Loja[2];
        this.funcionarios = new Funcionario[4];
        this.lock = new ReentrantLock();
    }

    public void adicionarLoja(Loja loja, int index) {
        lojas[index] = loja;
    }

    public void adicionarFuncionario(Funcionario funcionario, int index) {
        funcionarios[index] = funcionario;
    }

    public void realizarTransferencia(Conta origem, Conta destino, double valor) {
        lock.lock();
        try {
            if (origem.getSaldo() >= valor) {
                origem.debitar(valor);
                destino.creditar(valor);
                System.out.println("Transferência de " + valor + " realizada de " +
                        origem.getTitular() + " para " + destino.getTitular());
            } else {
                System.out.println("Saldo insuficiente para transferência de " + origem.getTitular());
            }
        } finally {
            lock.unlock();
        }
    }

    public void mostrarSaldos() {
        for (Loja loja : lojas) {
            loja.mostrarSaldo();
        }
        for (Funcionario funcionario : funcionarios) {
            funcionario.mostrarSaldos();
        }
    }
}
