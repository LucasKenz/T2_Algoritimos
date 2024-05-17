public class Pilha<Info> { // o operador diamante é usado para especificar que será criada com outros tipos de informação, não só numero por exemplo, o poder do ,<Info> é poder usar outras classes
    private No<Info> topo; 
    private int tamanho;

    // vamos fazer toda a lógica da pilha para qualquer estrutura de dados

    //construtor padrão
    public boolean estaVazia (){
        return topo == null; // verifica se topo é nulo, ou seja se nçao tem elementos na pilha
    }
    
    public void push (Info info){
        No<Info> novo = new No<Info>(info); // é uma lista ligada simples somente com marcador de primeiro
        // operador diamante é para lembrar que é genérico

        if (!estaVazia()){
            novo.setProximo(topo); // imagina uma pilha estacada se chega um novo, chega um em cima (novo), o proximo era o topo e mudamos o ponteiro para apontar para o topo
        
        }
        topo = novo; // topo sempre aponta para o primeiro
        tamanho ++;
    }

    public Info pop (){
        if (estaVazia()) return null; // se esta vazia devolve null se não devolve o ques está no topo
        Info info = topo.getInfo(); // pega a info do topo
        topo = topo.getProximo(); // faz o topo apontar para o próximo
        tamanho --;
        return info; // devolve a info que turamos
       
    }
    
    public Info consultaTopo () {
        if (estaVazia()) return null;
        Info info = topo.getInfo();
        return info;
    }

    // public int size(){
    //     // if (estaVazia()) return 0; // não precisa a verificação já esta no while
    //     No<Info> novo = topo;
    //     int cont = 0;
    //     while (novo != null){
    //         novo = novo.getProximo();
    //         cont ++;
    //     }
    //     return cont;
    // }
    public int getTamanho(){
        return tamanho;
    }// com isso eu perco um pouco de memória e tenho que sempre dar tamanho ++ ou--;

    @Override
    public String toString(){
        if (estaVazia()){
            return "pilha vazia";
        }
        No<Info> aux = topo;
        String s = "";
        while (aux != null){
            s += aux + "\n";
            aux = aux.getProximo();
            // andando na pilha
        }
        return s;
    }

    
}
