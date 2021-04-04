package Clase8;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String args[]) {
        int num = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese un número para conocer su doble");
        num = input.nextInt();

        int doble = calcularDoble(num);

        System.out.println("El doble del número ingresado es "+ doble);

    }
    public static int calcularDoble(int num) {
        return num * 2;
    }
}
