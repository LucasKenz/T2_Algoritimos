package T2_Algoritimos.pilha;
public class Pilha<Info> {
    private No<Info> topo;
    private int tamanho;
    //construtor padrão
    public boolean estaVazia () {
        return topo == null;
    }
    public void push (Info info) {
        No<Info> novo = new No<Info>(info);
        if (!estaVazia())
            novo.setProximo(topo);
        topo = novo;
        tamanho++;
    }
    public Info pop () {
        if (estaVazia()) return null;
        Info info = topo.getInfo();
        topo = topo.getProximo();
        tamanho--;
        return info;
    }
    public Info consultaTopo () {
        if (estaVazia()) return null;
        return topo.getInfo();
    }
    public No<Info> getNo() {
        return topo;
    }
    @Override
    public String toString() {
        if (estaVazia())
            return "pilha vazia";
        No<Info> aux = topo;
        String s = "";
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getProximo();
        }
        return s;
    }

    public int getTamanho() {
        return tamanho;
    }
}