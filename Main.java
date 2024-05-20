package T2_Algoritimos;
import java.util.Random;
import java.util.Scanner;

import T2_Algoritimos.carro.Carro;
import T2_Algoritimos.fila.Fila;
import T2_Algoritimos.pilha.No;
import T2_Algoritimos.pilha.Pilha;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDeseja utilizar Pilha ou Fila?\n 1 - Pilha\n 2 - Fila\n");
        int opcao = scanner.nextInt();
        System.out.println("\nQual e a capacidade da garagem? ");
        int capacidade = scanner.nextInt();

        if (opcao == 1) {
            Main main = new Main();
            Pilha<Carro> garagem = new Pilha<Carro>();
            main.populatePilha(garagem, capacidade);

            System.out.println(
                    "\nDeseja realizar qual operacao?\n 1 - Entrada de carro\n 2 - Saida de carro\n 3 - Consultar carro\n 4 - Consultar garagem\n 5 - Sair\n");
            int operacao = scanner.nextInt();

            while (operacao != 5) {
                switch (operacao) {
                    case 1:
                        main.entradaPilha(garagem, capacidade, scanner);
                        break;
                    case 2:
                        main.saidaPilha(garagem, scanner);
                        break;
                    case 3:
                        main.buscaPilha(garagem, scanner);
                        break;
                    case 4:
                        System.out.println("\nCarros na garagem: \n" + garagem + "\n");
                        break;
                    default:
                        System.out.println("\nOperação inválida!\n");
                        break;
                }
                System.out.println(
                        "\nDeseja realizar qual operacao?\n 1 - Entrada de carro\n 2 - Saida de carro\n 3 - Consultar carro\n 4 - Consultar garagem\n 5 - Sair\n");
                operacao = scanner.nextInt();
            }
        } 
        else if (opcao == 2) {
            Main main = new Main();
            Fila<Carro> garagem = new Fila<Carro>();
            main.populateFila(garagem, capacidade);

            System.out.println(
                    "\nDeseja realizar qual operacao?\n 1 - Entrada de carro\n 2 - Saida de carro\n 3 - Consultar carro\n 4 - Consultar garagem\n 5 - Sair\n");
            int operacao = scanner.nextInt();

            while (operacao != 5) {
                switch (operacao) {
                    case 1:
                        main.entradaFila(garagem, capacidade, scanner);
                        break;
                    case 2:
                        main.saidaFila(garagem, scanner);
                        break;
                    case 3:
                        main.buscaFila(garagem, scanner);
                        break;
                    case 4:
                        System.out.println("\nCarros na garagem: \n" + garagem + "\n");
                        break;
                    default:
                        System.out.println("\nOperação inválida!\n");
                        break;
                }
                System.out.println(
                        "\nDeseja realizar qual operacao?\n 1 - Entrada de carro\n 2 - Saida de carro\n 3 - Consultar carro\n 4 - Consultar garagem\n 5 - Sair\n");
                operacao = scanner.nextInt();
            }
        } 
        else {
            System.out.println("\nOpção inválida!\n");
        }
    }

    // Metodos para Pilha
    public void populatePilha(Pilha<Carro> pilha, int n) {
        Random random = new Random();
        Carro[] carros = new Carro[n];
        for (int i = 0; i < n; i++) {
            carros[i] = new Carro(random.nextInt(1968, 2024), "ABC" + i);

            carros[i].setEntrada(LocalDateTime.now());
            pilha.push(carros[i]);
        }
        System.out.println("\nCarros na garagem: \n" + pilha);
    }

    public void entradaPilha(Pilha<Carro> pilha, int capacidade, Scanner scanner) {
        if (pilha.getTamanho() >= capacidade) {
            System.out.println("\nGaragem cheia!\n");
            return;
        }
        System.out.println("Qual eh o ano de fabricacao do carro? ");
        int anoFab = scanner.nextInt();
        System.out.println("\nQual eh a placa do carro? ");
        String placa = scanner.next();
        Carro carro = new Carro(anoFab, placa);
        carro.setEntrada(LocalDateTime.now());
        pilha.push(carro);
        System.out.println("\nCarro adicionado com sucesso!\n");
    }

    public void saidaPilha(Pilha<Carro> pilha, Scanner scanner) {
        if (pilha.estaVazia()) {
            System.out.println("Garagem vazia!\n");
            return;
        }
        System.out.println("Qual eh a placa do carro? ");
        String placa = scanner.next();
        Pilha<Carro> aux = new Pilha<Carro>();
        boolean encontrado = false;
        while (!encontrado && !pilha.estaVazia()) {
            Carro carro = pilha.pop();
            if (carro.getPlaca().equals(placa)) {
                carro.setSaida(LocalDateTime.now());
                carro.setManobras(carro.getManobras() + 1);
                System.out.println("\nCarro removido com sucesso!\n" + carro + "\nTempo Total: " + carro.getTempo()
                        + " segundos\n");
                encontrado = true;
            } else {
                carro.setManobras(carro.getManobras() + 1);
                aux.push(carro);
            }
        }
        while (!aux.estaVazia()) {
            Carro carro = aux.pop();
            carro.setManobras(carro.getManobras() + 1);
            pilha.push(carro);
        }
        if (!encontrado) {
            System.out.println("\nCarro nao encontrado!\n");
        }
    }

    public void buscaPilha(Pilha<Carro> pilha, Scanner scanner) {
        if (pilha.estaVazia()) {
            System.out.println("\nGaragem vazia!\n");
            return;
        }
        System.out.println("\nQual eh a placa do carro? ");
        String placa = scanner.next();
        boolean encontrado = false;
        @SuppressWarnings("rawtypes")
        No no = pilha.getNo();
        int posicao = 0;
        while (no != null && !encontrado) {
            Carro carro = (Carro) no.getInfo();
            if (carro.getPlaca().equals(placa)) {
                System.out.println("\nCarro encontrado!\n|[Posicao: " + posicao + ", Hora de entrada: "
                        + carro.getEntrada() + "]|\n");
                encontrado = true;
            }
            no = no.getProximo();
            posicao++;
        }
        if (!encontrado) {
            System.out.println("\nCarro nao encontrado!\n");
        }
    }

    // Metodos para Fila
    public void populateFila(Fila<Carro> fila, int n) {
        Random random = new Random();
        Carro[] carros = new Carro[n];
        for (int i = 0; i < n; i++) {
            carros[i] = new Carro(random.nextInt(1968, 2024), "ABC" + i);
            carros[i].setEntrada(LocalDateTime.now());
            fila.enfileira(carros[i]);
        }
        System.out.println("\nCarros na garagem: \n" + fila);
    }

    public void entradaFila(Fila<Carro> fila, int capacidade, Scanner scanner) {
        if (fila.getTamanho() >= capacidade) {
            System.out.println("\nGaragem cheia!\n");
            return;
        }
        System.out.println("Qual eh o ano de fabricação do carro? ");
        int anoFab = scanner.nextInt();
        System.out.println("\nQual eh a placa do carro? ");
        String placa = scanner.next();
        Carro carro = new Carro(anoFab, placa);
        carro.setEntrada(LocalDateTime.now());
        fila.enfileira(carro);
        System.out.println("\nCarro adicionado com sucesso!\n");
    }

    public void saidaFila(Fila<Carro> fila, Scanner scanner) {
        if (fila.estaVazia()) {
            System.out.println("Garagem vazia!\n");
            return;
        }
        System.out.println("Qual eh a placa do carro? ");
        String placa = scanner.next();
        Fila<Carro> aux = new Fila<Carro>();
        boolean encontrado = false;
        while (!encontrado && !fila.estaVazia()) {
            Carro carro = fila.desenfileira();
            if (carro.getPlaca().equals(placa)) {
                carro.setSaida(LocalDateTime.now());
                carro.setManobras(carro.getManobras() + 1);
                System.out.println("\nCarro removido com sucesso!\n" + carro + "\nTempo Total: " + carro.getTempo()
                        + " segundos\n");
                encontrado = true;
            } else {
                carro.setManobras(carro.getManobras() + 1);
                aux.enfileira(carro);
            }
        }
        while (!aux.estaVazia()) {
            Carro carro = aux.desenfileira();
            carro.setManobras(carro.getManobras() + 1);
            fila.enfileira(carro);
        }
        if (!encontrado) {
            System.out.println("\nCarro nao encontrado!\n");
        }
    }

    public void buscaFila(Fila<Carro> fila, Scanner scanner) {
        if (fila.estaVazia()) {
            System.out.println("\nGaragem vazia!\n");
            return;
        }
        System.out.println("\nQual eh a placa do carro? ");
        String placa = scanner.next();
        boolean encontrado = false;
        int posicao = 0;
        for (int i = 0; i < fila.getTamanho(); i++) {
            Carro carro = fila.desenfileira();
            if (carro.getPlaca().equals(placa)) {
                System.out.println("\nCarro encontrado!\n|[Posicao: " + posicao + ", Hora de entrada: "
                        + carro.getEntrada() + "]|\n");
                encontrado = true;
            }
            fila.enfileira(carro);
            posicao++;
        }
        if (!encontrado) {
            System.out.println("\nCarro nao encontrado!\n");
        }
    }
}
