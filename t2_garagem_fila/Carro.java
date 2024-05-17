public class Carro {
    private int anoFab;
    private String placa;
    private int manobras;

    // tempo será igual a um start timer, que será o tempo que o carro levar até sair da garagem 
    private float tempoInicial =  System.currentTimeMillis();
    private float tempoFinal = System.currentTimeMillis();
    private float tempoTotal = tempoFinal - tempoInicial;

    // precisamos que o carro nasca com informações, não com o construtor padrão

    public int getManobras() {
        return manobras;
    }

    public void setManobras(int manobras) {
        this.manobras = manobras;
    }

    public Carro(int anoFab, String placa, int manobras) {
        this.anoFab = anoFab;
        this.placa = placa;
        this.manobras = manobras;
    }
    // coloco o tempo total no carro?

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
        return "[ano= " + anoFab + ", placa= " + placa + ", " +  "manobras: " + manobras + "]" ;
    }
    
}