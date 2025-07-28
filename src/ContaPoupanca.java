public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numero, Cliente cliente) {
        super(numero, cliente);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            registrarTransacao("Saque (Poupança)", valor);
        } else {
            System.out.println("Saldo insuficiente na poupança.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        registrarTransacao("Deposito (Poupança)", valor);
    }
}
