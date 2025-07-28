import java.time.LocalDateTime;

public record Transacao(String tipo, double valor, LocalDateTime dataHora) {
    @Override
    public String toString() {
        return "[" + dataHora + "] " + tipo + ": R$ " + valor;
    }
}
