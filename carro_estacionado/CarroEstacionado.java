package carro_estacionado;

import java.time.Duration;
import java.time.LocalDateTime;
import carro.Carro;

public class CarroEstacionado extends Carro {
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private int manobras;

    public CarroEstacionado(int anoFab, String placa) {
        super(anoFab, placa);
        this.entrada = null;
        this.saida = null;
        this.manobras = 0;
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
        return "CarroEstacionado [anoFab=" + getAnoFab() + ", manobras= " + manobras + ", placa=" + getPlaca() + ", entrada=" + entrada + ", saida=" + saida + "]";
    }
}