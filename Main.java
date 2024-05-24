
import java.util.Random;
import java.util.Scanner;

//import T2_Algoritimos.carro.Carro;
import carro_estacionado.CarroEstacionado;
import fila.Fila;
import pilha.No;
import pilha.Pilha;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDeseja utilizar Pilha ou Fila?\n 1 - Pilha\n 2 - Fila\n");
        int opcao = scanner.nextInt();
        System.out.println("\nQual é a capacidade da garagem? ");
        int capacidade = scanner.nextInt();

        if (opcao == 1) {
            Main main = new Main();
            Pilha<CarroEstacionado> garagem = new Pilha<CarroEstacionado>();
            main.populatePilha(garagem, capacidade);

            System.out.println(
                    "\nDeseja realizar qual operação?\n 1 - Entrada de carro\n 2 - Saída de carro\n 3 - Consultar carro\n 4 - Consultar garagem\n 5 - Sair\n");
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
                        "\nDeseja realizar qual operação?\n 1 - Entrada de carro\n 2 - Saída de carro\n 3 - Consultar carro\n 4 - Consultar garagem\n 5 - Sair\n");
                operacao = scanner.nextInt();
            }
        } else if (opcao == 2) {
            Main main = new Main();
            Fila<CarroEstacionado> garagem = new Fila<CarroEstacionado>();
            main.populateFila(garagem, capacidade);

            System.out.println(
                    "\nDeseja realizar qual operação?\n 1 - Entrada de carro\n 2 - Saída de carro\n 3 - Consultar carro\n 4 - Consultar garagem\n 5 - Sair\n");
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
                        "\nDeseja realizar qual operação?\n 1 - Entrada de carro\n 2 - Saída de carro\n 3 - Consultar carro\n 4 - Consultar garagem\n 5 - Sair\n");
                operacao = scanner.nextInt();
            }
        } else {
            System.out.println("\nOpção inválida!\n");
        }
    }

    // Métodos para Pilha
    public void populatePilha(Pilha<CarroEstacionado> pilha, int n) {
        Random random = new Random();
        CarroEstacionado[] carros = new CarroEstacionado[n];
        for (int i = 0; i < n; i++) {
            carros[i] = new CarroEstacionado(random.nextInt(1968, 2024), "ABC" + i);
            carros[i].setEntrada(LocalDateTime.now());
            pilha.push(carros[i]);
        }
        System.out.println("\nCarros na garagem: \n" + pilha);
    }

    public void entradaPilha(Pilha<CarroEstacionado> pilha, int capacidade, Scanner scanner) {
        if (pilha.getTamanho() >= capacidade) {
            System.out.println("\nGaragem cheia!\n");
            return;
        }
        System.out.println("Qual é o ano de fabricação do carro? ");
        int anoFab = scanner.nextInt();
        System.out.println("\nQual é a placa do carro? ");
        String placa = scanner.next();
        CarroEstacionado carro = new CarroEstacionado(anoFab, placa);
        carro.setEntrada(LocalDateTime.now());
        pilha.push(carro);
        System.out.println("\nCarro adicionado com sucesso!\n");
    }

    public void saidaPilha(Pilha<CarroEstacionado> pilha, Scanner scanner) {
        if (pilha.estaVazia()) {
            System.out.println("Garagem vazia!\n");
            return;
        }
        System.out.println("Qual é a placa do carro? ");
        String placa = scanner.next();
        Pilha<CarroEstacionado> aux = new Pilha<CarroEstacionado>();
        boolean encontrado = false;
        while (!encontrado && !pilha.estaVazia()) {
            CarroEstacionado carro = pilha.pop();
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
            CarroEstacionado carro = aux.pop();
            carro.setManobras(carro.getManobras() + 1);
            pilha.push(carro);
        }
        if (!encontrado) {
            System.out.println("\nCarro não encontrado!\n");
        }
    }

    public void buscaPilha(Pilha<CarroEstacionado> pilha, Scanner scanner) {
        if (pilha.estaVazia()) {
            System.out.println("\nGaragem vazia!\n");
            return;
        }
        System.out.println("\nQual é a placa do carro? ");
        String placa = scanner.next();
        boolean encontrado = false;
        @SuppressWarnings("rawtypes")
        No no = pilha.getNo();
        int posicao = 0;
        while (no != null && !encontrado) {
            CarroEstacionado carro = (CarroEstacionado) no.getInfo();
            if (carro.getPlaca().equals(placa)) {
                System.out.println("\nCarro encontrado!\n|[Posição: " + posicao + ", Hora de entrada: "
                        + carro.getEntrada() + "]|\n");
                encontrado = true;
            }
            no = no.getProximo();
            posicao++;
        }
        if (!encontrado) {
            System.out.println("\nCarro não encontrado!\n");
        }
    }

    // Métodos para Fila
    public void populateFila(Fila<CarroEstacionado> fila, int n) {
        Random random = new Random();
        CarroEstacionado[] carros = new CarroEstacionado[n];
        for (int i = 0; i < n; i++) {
            carros[i] = new CarroEstacionado(random.nextInt(1968, 2024), "ABC" + i);
            carros[i].setEntrada(LocalDateTime.now());
            fila.enfileira(carros[i]);
        }
        System.out.println("\nCarros na garagem: \n" + fila);
    }

    public void entradaFila(Fila<CarroEstacionado> fila, int capacidade, Scanner scanner) {
        if (fila.getTamanho() >= capacidade) {
            System.out.println("\nGaragem cheia!\n");
            return;
        }
        System.out.println("Qual é o ano de fabricação do carro? ");
        int anoFab = scanner.nextInt();
        System.out.println("\nQual é a placa do carro? ");
        String placa = scanner.next();
        CarroEstacionado carro = new CarroEstacionado(anoFab, placa);
        carro.setEntrada(LocalDateTime.now());
        fila.enfileira(carro);
        System.out.println("\nCarro adicionado com sucesso!\n");
    }

    public void saidaFila(Fila<CarroEstacionado> fila, Scanner scanner) {
        if (fila.estaVazia()) {
            System.out.println("Garagem vazia!\n");
            return;
        }
        System.out.println("Qual é a placa do carro? ");
        String placa = scanner.next();
        Fila<CarroEstacionado> aux = new Fila<CarroEstacionado>();
        boolean encontrado = false;
        while (!encontrado && !fila.estaVazia()) {
            CarroEstacionado carro = fila.desenfileira();
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
            CarroEstacionado carro = aux.desenfileira();
            carro.setManobras(carro.getManobras() + 1);
            fila.enfileira(carro);
        }
        if (!encontrado) {
            System.out.println("\nCarro não encontrado!\n");
        }
    }

    public void buscaFila(Fila<CarroEstacionado> fila, Scanner scanner) {
        if (fila.estaVazia()) {
            System.out.println("\nGaragem vazia!\n");
            return;
        }
        System.out.println("\nQual eh a placa do carro? ");
        String placa = scanner.next();
        boolean encontrado = false;
        int posicao = 0;
        for (int i = 0; i < fila.getTamanho(); i++) {
            CarroEstacionado carro = fila.desenfileira();
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
