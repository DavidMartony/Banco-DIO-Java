import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public abstract class Conta {
    protected String numero;
    protected Cliente cliente;
    protected double saldo;
    protected List<Transacao> transacoes;

    public Conta(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
    }

    public abstract void sacar(double valor);
    public abstract void depositar(double valor);

    public void transferir(double valor, Conta destino) {
        if (this.saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
            registrarTransacao("Transferência enviada", valor);
            destino.registrarTransacao("Transferência recebida", valor);
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNumero() {
        return numero;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    protected void registrarTransacao(String tipo, double valor) {
        Transacao t = new Transacao(tipo, valor, LocalDateTime.now());
        transacoes.add(t);
    }

    public void exibirExtrato() {
        System.out.println("Extrato da conta " + numero);
        for (Transacao t : transacoes) {
            System.out.println(t);
        }
        System.out.println("Saldo atual: R$ " + saldo);
    }
}