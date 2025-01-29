package Entregas;

import java.util.Scanner;
import java.util.Random;


public class BatallaNaval { 

    private final static int TAMAÑO = 5;
    private static char[][] tableroUsuario;
    private static int[][] tableroOculto;
    
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
    	
    	tableroUsuario = new char[TAMAÑO][TAMAÑO];
    	tableroOculto = new int[TAMAÑO][TAMAÑO];
        
    }

    private void inicializarTablero(){
    	Random random = new Random();
        int numBarcos = 3;
        	for(int t =0; t < numBarcos; t++){
          boolean colocado =false;
          while(!colocado){
              int fila = random.nextInt(5);
              int columna = random.nextInt(5);
              if(tableroOculto[fila][columna] == 0){
                  tableroOculto[fila][columna] = 1;
                  colocado = true;

         BatallaNaval batallaNaval = new BatallaNaval();
                  batallaNaval.inicializarTablero();
                  batallaNaval.inicializarTableroUsuario();
                  batallaNaval.iniciarBatalla();       
              }
          }
        }
    }

    private void inicializarTableroUsuario(){
        for(int a =0; a < tableroUsuario.length;a++){
            for(int b=0; b < tableroUsuario[a].length;b++){
                tableroUsuario[a][b] = 'ˆ';
            }
        }
    }

    private void mostrarEncabezado(){
        for (char columna = 'A'; columna < 'A' + TAMAÑO; columna++) {
            System.out.printf(" %c", columna);
        }
        System.out.println();
    }
    private void mostrarTablero() {
        mostrarEncabezado();
        for (int a = 0; a < TAMAÑO; a++) {
            System.out.print(a+ " |");
            for (int b = 0; b < TAMAÑO; b++) {
                if(tableroUsuario[a][b] == 'X'){
                    System.out.printf(RED + tableroUsuario[a][b] + RESET + "|");
                } else if (tableroUsuario[a][b] == '~') {
                    System.out.print(BLUE + tableroUsuario[a][b] + RESET + "|");
                }else{
                    System.out.printf(tableroUsuario[a][b] + "|");
                }
            }
            
        }
        
    }

    private void mostrarTableroReal() {
        mostrarEncabezado();
        for (int a = 0; a < TAMAÑO; a++) {
            System.out.print(a + " |");
            for (int b = 0; b < TAMAÑO; b++) {
                System.out.print(tableroOculto[a][b] + "|");
            }
        }
    }
    Scanner scanner = new Scanner(System.in);
    
    public void iniciarBatalla() {
        iniciarTitulo();
        System.out.println("¡Pulsa enter para empezar el juego!");
        int intentos = 0;
        int barcosTocados =0;
        boolean esGanador = false;

        while (intentos <= 10 && !esGanador) {
            if(barcosTocados == 3){
                esGanador =true;
                tituloVictoria();
            }else {
                scanner.nextLine();
                System.out.println(intentos+ " intentos");         
                System.out.println("Introduce las coordenadas para disparar");
                int columna = traductorCoordenadas(scanner);
                System.out.println("Elige una fila del 0 al 4");
                int fila = scanner.nextInt();

                if (fila < 0 || fila >= TAMAÑO) {
                    System.out.println("Coordenadas no validas. Intenta de nuevo.");
                    continue;
                }

                if (tableroUsuario[fila][columna] == 'X' || tableroUsuario[fila][columna] == '~') {
                    System.out.println("Ya disparaste aquí. Intenta otra posicion.");
                    continue;
                }

                if (tableroOculto[fila][columna] == 0) {
                    tituloAgua();
                    tableroUsuario[fila][columna] = '~';
                    mostrarTablero();
                } else {
                    tituloTocado();
                    tableroUsuario[fila][columna] = 'X';
                    barcosTocados++;
                    mostrarTablero();
                }
                intentos++;
                if(intentos > 10){
                    tituloDerrota();
                    mostrarTableroReal();
                }
            }
        }
    }  

    private int traductorCoordenadas(Scanner scanner){
        int columna=-1;
        boolean filaValida = false;
        while(!filaValida) {
            System.out.println("Elige una columna (A-B-C-D-E)");
            String nombrefila = scanner.nextLine();
            switch (nombrefila.toUpperCase()) {
                case "A":
                    columna = 0;
                    filaValida = true;
                    break;
                    
                case "B":
                    columna = 1;
                    filaValida = true;
                    break;
                    
                case "C":
                    columna = 2;
                    filaValida = true;
                    break;
                    
                case "D":
                    columna = 3;
                    filaValida = true;
                    break;
                    
                case "E":
                    columna = 4;
                    filaValida = true;
                    break;              
            }
        }
        return columna;
    }

    private void iniciarTitulo(){
        System.out.println("¡BATALLA NAVAL!"); 
    }

    private void tituloVictoria(){
        System.out.println("¡VICTORIA!");
        
    }
    private void tituloDerrota(){
        System.out.println("DERROTA... :(");
    }
    private void tituloAgua(){
        System.out.println("¡AGUA!");
    }
        
    private void tituloTocado(){
        System.out.println("¡TOCADO!");
            }
} 	

