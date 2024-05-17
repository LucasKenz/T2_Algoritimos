import java.util.Scanner;

public class Garagem {
    public static void main(String[] args) {
        Fila<Carro> f = new Fila<>();
        Scanner sc = new Scanner(System.in);
        int capacidade = sc.nextInt();

        for (int i = 1; i <= capacidade; i++) {
            Carro c = new Carro(i, "ABC-DEF" + i, 0);
            f.enfileira(c);
            System.out.println(f);
        }
        // com a garagem máxima agora tenho que dar a opção do usuário fazer a busca

        // depois de buscado ele pode escolher desinfileirar o carro
        // ou encerrar o programa

        // se ele desinfileirar o carro, o carro volta para o final da fila com manobras +1
        // se ele encerrar o programa, o programa encerra


    }
}