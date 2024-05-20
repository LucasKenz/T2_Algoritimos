package T2_Algoritimos.carro;
import java.time.Duration;
import java.time.LocalDateTime;

public class Carro {
    private int anoFab;
    private String placa;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private int manobras;

    public Carro(int anoFab, String placa) {
        this.anoFab = anoFab;
        this.placa = placa;
        this.entrada = null;
        this.saida = null;
        this.manobras = 0;
    }

    public int getAnoFab() {
        return anoFab;
    }

    public void setAnoFab(int anoFab) {
        this.anoFab = anoFab;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada.withNano(entrada.getNano() / 1000000 * 1000000);
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida.withNano(saida.getNano() / 1000000 * 1000000);
    }

    public int getManobras() {
        return manobras;
    }

    public void setManobras(int manobras) {
        this.manobras = manobras;
    }

    public long getTempo() {
        return Duration.between(entrada, saida).toSeconds();
    }

    @Override
    public String toString() {
        return "Carro [anoFab=" + anoFab + ", manobras=" + manobras + ", placa=" + placa
                + ", entrada=" + entrada + ", saida=" + saida + "]";
    }
}