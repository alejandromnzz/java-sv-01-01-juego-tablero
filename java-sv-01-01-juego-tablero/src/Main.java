import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        char[][] matriz = new char[10][10];

        int vidas = 3;

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

        for (int i = 0; i < 8; i++) {
            do {
                n1 = aleatorio.nextInt(10);
                n2 = aleatorio.nextInt(10);
            } while (matriz[n1][n2]!='*');
            matriz[n1][n2] = 'M';
        }

        for (int i = 0; i < 8; i++) {
            do {
                n1 = aleatorio.nextInt(10);
                n2 = aleatorio.nextInt(10);
            } while (matriz[n1][n2]!='*');
            matriz[n1][n2] = 'P';
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }

        System.out.println("Tu jugador se encuentra en la casilla 0,0");
        System.out.println("Te puedes desplazar con las letras WASD");

        Scanner lector = new Scanner(System.in);

        int filaYoda = 0;
        int columnaYoda = 0;

        while (vidas != 0){

            System.out.println("Dime una letra");
            char desplazamiento = lector.next().charAt(0);

            int column_Y1 = columnaYoda;
            int fila_Y1 = filaYoda;

            if (desplazamiento =='D'){
                column_Y1 ++;
            }else if (desplazamiento =='W'){
                fila_Y1 --;
            }else if (desplazamiento =='A'){
                column_Y1 --;
            }else if (desplazamiento =='S'){
                fila_Y1 ++;
            }

            if (fila_Y1 < 0 || fila_Y1 >= matriz.length || column_Y1 < 0 || column_Y1 >= matriz.length){
                System.out.println("HAS LLEGADO AL LIMITE");
                    continue;
            }

            if (matriz[fila_Y1][column_Y1]=='M'){
                System.out.println("Te has chocado contra un muro. Pierdes una vida.");
                vidas--;
            }

            if (matriz[fila_Y1][column_Y1]=='P'){
                System.out.println("Te has chocado contra una poción. Responde correctamente y ganarás una vida, falla la respuesta y perderas una vida.");

                int[] soluciones = new int[3];
                soluciones[1] = 56;
                soluciones[2] = 9;
                soluciones[3] = 17;

                int eleccion = aleatorio.nextInt(3);

                if (eleccion == 0){
                    System.out.println("¿Cuánto es la multiplicación de 7 x 8?");
                    int respuesta = lector.nextInt();
                    if (respuesta == soluciones[eleccion]){
                        vidas++;
                        System.out.println("Has ganado una vida.");
                    }else{
                        vidas--;
                        System.out.println("Has perdido una vida");
                    }
                } else if (eleccion == 1) {
                    System.out.println("¿Cuánto es la resta de 27 - 18?");
                    int respuesta = lector.nextInt();
                    if (respuesta == soluciones[eleccion]){
                        vidas++;
                        System.out.println("Has ganado una vida.");
                    }else{
                        vidas--;
                        System.out.println("Has perdido una vida");
                    }
                }else if (eleccion == 2){
                    System.out.println("¿Cuánto es la división de 136 / 8?");
                    int respuesta = lector.nextInt();
                    if (respuesta == soluciones[eleccion]){
                        vidas++;
                        System.out.println("Has ganado una vida.");
                    }else{
                        vidas--;
                        System.out.println("Has perdido una vida");
                    }
                }
            }

            matriz[filaYoda][columnaYoda]= '*';
            filaYoda = fila_Y1;
            columnaYoda = column_Y1;
            matriz[filaYoda][columnaYoda]= YODA;

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println(" ");
            }
        }

        System.out.println("HAS PERDIDO");
    }
}
