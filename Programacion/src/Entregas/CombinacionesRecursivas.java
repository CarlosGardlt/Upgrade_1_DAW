package Entregas;

import java.util.Scanner;

public class CombinacionesRecursivas {
    
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        
        System.out.println("Introduce el valor de n (conjunto): ");
        
        int n = Scanner.nextInt();
        
        System.out.println("Introduce el valor de k (subconjunto): ");
        
        int k = Scanner.nextInt();
        
        CombinacionesRecursivas combinacionesRecursivas = new CombinacionesRecursivas();
        combinacionesRecursivas.combinaciones(n, k);
        if (k > n) {
            System.out.println("k no puede ser mayor que n, prueba otra vez");
        } else {
            int resultado = combinacionesRecursivas.combinaciones(n,k);
            System.out.println("El numero total de combinaciones es: " + resultado);
        }
    }

    private int combinaciones(int k, int n){
        if(k == 0 || k == n){
            return 1;
        }else{
            return combinaciones(k - 1, n - 1) + combinaciones(k- 1,n);
        }
    }
}

