package carro;


public class Carro {
    private int anoFab;
    private String placa;


    public Carro(int anoFab, String placa) {
        this.anoFab = anoFab;
        this.placa = placa;

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

    @Override
    public String toString() {
        return "Carro [anoFab=" + anoFab + ", placa=" + placa + "]";
    }
}