package boletin_ejercicios_pascua;

import java.util.Scanner;

public class ejercicios {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            double[] notas = new double[10];
            double suma = 0;

            for (int i = 0; i < notas.length; i++) {
            System.out.print("Introduce la nota del alumno " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            suma += notas[i]; // Sumar la nota al total
        }
}

}