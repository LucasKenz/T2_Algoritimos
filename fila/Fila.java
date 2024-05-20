package T2_Algoritimos.fila;
public class Fila <E> {
    private E[] dados;
    private int primeiro;
    private int ultimo;
    private int tamanho;
 
    public static final int CAPACIDADE_MINIMA = 10;
 
    @SuppressWarnings("unchecked")
    public Fila (int capacidade) {
        if (capacidade > CAPACIDADE_MINIMA)
            dados = (E[]) new Object[capacidade];
        else
            dados = (E[]) new Object[CAPACIDADE_MINIMA];
        primeiro = 0;
        ultimo = dados.length - 1;
        tamanho = 0;
    }
    public Fila () {
        this(CAPACIDADE_MINIMA);
    }
    public int getTamanho() {
        return tamanho;
    }
    public boolean estaVazia () {
        return tamanho == 0;
    }
    public boolean estaCheia () {
        return tamanho == dados.length;
    }
    int proxima (int posicao) {
        return (posicao + 1) % dados.length;
    }
    public void enfileira (E info) {
        if (!estaCheia()) {
            ultimo = proxima(ultimo);
            dados[ultimo] = info;
            tamanho++;
        }
    }
    public E desenfileira () {
        E info = null;
        if (!estaVazia()) {
            info = dados[primeiro];
            primeiro = proxima(primeiro);
            tamanho--;
        }
        return info;
    }
    @Override
    public String toString () {
        if (estaVazia()) return "fila vazia";
        String s = "";
        int i = primeiro;
        do {
            s = s + dados[i] + "\n";
            i = proxima(i);
        } while (i != proxima(ultimo));
        return s;
    }
}