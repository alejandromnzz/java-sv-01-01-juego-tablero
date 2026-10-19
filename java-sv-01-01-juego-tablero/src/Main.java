import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        char[][] matriz = new char[10][10];

        int vidas = 10;

        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = '*';
            }
        }

        char YODA = 'Y';
        matriz[0][0]= YODA;

        char CASILLA_FINAL = 'F';
        matriz[9][9] = CASILLA_FINAL;

        Random aleatorio = new Random();
        int n1 = aleatorio.nextInt(10);
        int n2 = aleatorio.nextInt(10);

        matriz[n1][n2] = 'M';

        for (int i = 0; i < 5; i++) {
            do {
                n1 = aleatorio.nextInt(10);
                n2 = aleatorio.nextInt(10);
            } while (matriz[n1][n2]!='*');
            matriz[n1][n2] = 'P';
        }

        System.out.println("Tu jugador se encuentra en la casilla 0,0");
        System.out.println("Te puedes desplazar con las letras WASD");

        Scanner lector = new Scanner(System.in);
        System.out.println("Dime una letra: ");
        char desplazamiento = lector.next().charAt(0);

        int filaYoda = 0;
        int columnaYoda = 0;

        while (desplazamiento != 'F'){

            System.out.println("Dime una letra");
            desplazamiento = lector.next().charAt(0);

            if (desplazamiento =='D'){
                columnaYoda += 1;
                matriz[filaYoda][columnaYoda]=YODA;
                columnaYoda-= 1;
            }else if (desplazamiento =='W'){
                filaYoda -= 1;
                matriz[filaYoda][columnaYoda]=YODA;
                filaYoda += 1;
            }else if (desplazamiento =='A'){
                columnaYoda -= 1;
                matriz[filaYoda][columnaYoda]=YODA;
                columnaYoda += 1;
            }else if (desplazamiento =='S'){
                filaYoda += 1;
                matriz[filaYoda][columnaYoda]=YODA;
                filaYoda -= 1;
            }

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println(" ");
            }
        }
    }
}
