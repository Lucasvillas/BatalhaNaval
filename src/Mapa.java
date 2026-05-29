import java.util.Scanner;

public class Mapa {
    private char[][] mapa = new char[10][10];

    public Mapa() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                mapa[i][j] = '~';
            }
        }
    }

    public void posicionarNavios(Scanner scanner) {
        System.out.print("Quantos navios (1 a 5)? ");
        int navios = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < navios; i++) {
            System.out.println("\nNavio " + (i + 1));
            System.out.print("X: ");
            int x = Integer.parseInt(scanner.nextLine());
            System.out.print("Y: ");
            int y = Integer.parseInt(scanner.nextLine());

            if(x < 0 || x >= 10 || y < 0 || y >= 10 || mapa[x][y] == 'N') {
                System.out.println("Posição inválida ou ocupada!");
                i--; continue;
            }
            mapa[x][y] = 'N';
        }
    }

    public boolean receiveShot(int x, int y) {
        if(mapa[x][y] == 'N') {
            mapa[x][y] = 'X';
            return true;
        }
        mapa[x][y] = 'O';
        return false;
    }

    public boolean lost() {
        for(char[] row : mapa) {
            for(char celula : row) {
                if(celula == 'N') return false;
            }
        }
        return true;
    }

    public void printMapa() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for(int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for(int j = 0; j < 10; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
    }
}