public class Fila <E> { 
    private No<E> primeiro; 
    private No<E> ultimo;

    public boolean estaVazia(){
        return primeiro == null; 
    }


    public void enfileira (E i) {
        No<E> novo = new No<>(i);
        if (estaVazia()) {
            primeiro = novo;
        }
        else {
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }
 
    public E desinfileira (){
        if (estaVazia()) {
            return null;
        }
        // dar um enfileira e desinfileira na info.
        E temp = primeiro.getInfo(); 
        primeiro = primeiro.getProximo();
        if (primeiro == null) {
            ultimo = null;
            
        }
        return temp;
    }

    // criar métodos para: quando enfileiro 1 carro começar um tempo para aquele carro
    // quando desinfileiro um carro, calcular o tempo que ele ficou na fila
    // quando eu deseinfileiro um carro ele volta para o final da fila, mas com um contador de manobras +1



    @Override
    public String toString() {
        if(estaVazia()) {
            return "Fila vazia";
        }
        String s = "";
        No<E> aux = primeiro;
        while (aux != ultimo) {
            s = s + aux + " - ";
            aux = aux.getProximo();
        }
        s += aux;
        return s;
    }
}

class No<E> { 

    private E info;
    private No<E> proximo;
    
    public No (E info) {
        setInfo(info);
        proximo = null; 
    }
    public E getInfo() { 
        return info;
    }
    public No<E> getProximo() {
        return proximo;
    }
    public void setInfo(E info) { 
        this.info = info;
    }
    public void setProximo (No<E> proximo) {
        this.proximo = proximo;
    }
    @Override
    public String toString() {
        return info + "";
    }
}