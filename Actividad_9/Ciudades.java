
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ciudades {
    public static void main(String[] args) {
        Ciudades app = new Ciudades();
        app.crearMenu();
    }

    private void crearMenu(){
        System.out.println("Bienvenido a la gestion de ciudades");
        Scanner scan = new Scanner(System.in);
        var salidaBucle  = true;
        ArrayList<String> ciudades = new ArrayList<>();
        while(salidaBucle){
            pintarMenu();
            var opcion = 0;
            try {
                opcion = scan.nextInt();
                scan.nextLine(); // limpiar el salto de linea
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un número valido");
                scan.nextLine();
                continue;
            }
            switch(opcion) {
                case 1 -> agregarCiudad(scan, ciudades);
                case 2 -> eliminarCiudad(scan, ciudades);
                case 3 -> mostrarCiudades(ciudades);
                case 4 -> buscarCiudad(scan, ciudades);
                case 5 -> salidaBucle = false;
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private void pintarMenu(){
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Agregar una ciudad");
        System.out.println("2. Eliminar una ciudad");
        System.out.println("3. Mostrar todas las ciudades");
        System.out.println("4. Buscar una ciudad");
        System.out.println("5. Salir");
    }
    
/// 1. Agregar una ciudad

    private void agregarCiudad(Scanner sc, ArrayList<String> ciudades){
        System.out.println("Ingresa el nombre de la ciudad");
        var nombre = sc.nextLine().trim().toLowerCase();
        if(ciudades.contains(nombre) || nombre.isBlank()){
            System.out.println("La ciudad ya existe, no se permiten ciudades duplicadas o vacias");
        }else{
            ciudades.add(nombre);
            System.out.println("La ciudad " + nombre  + " se ha agregado");
        };
    }

    /// 2. Mostrar todas las ciudades

    private void mostrarCiudades(ArrayList<String> ciudades){
        if(!ciudades.isEmpty()) {
            System.out.println("Las ciudades son:");
            for (String ciudad : ciudades) {
                System.out.println(ciudad);
            }
        }else{
            System.out.println("No hay ciudades que mostrar");
        }
    }

    /// 3. Buscar una ciudad

    private void buscarCiudad(Scanner sc, ArrayList<String> ciudades){
        System.out.println("Ingresa el nombre de la ciudad");
        var nombre = sc.nextLine().trim().toLowerCase();
        if(ciudades.contains(nombre)){
            System.out.println("La ciudad " + nombre  + " ya existe en la lista");
        }else{
            System.out.println("La ciudad " + nombre  + " no existe en la lista");
        }
    }

    /// 4. Eliminar una ciudad

    private void eliminarCiudad(Scanner sc, ArrayList<String> ciudades){
        System.out.println("Ingresa el nombre de la ciudad");
        var nombre = sc.nextLine().trim().toLowerCase();
        if(ciudades.contains(nombre)){
            ciudades.remove(nombre);
            System.out.println("La ciudad " + nombre  + " se ha eliminado correctamente");
        }else{
            System.out.println("La ciudad " + nombre  + " no existe en la lista y no se puede eliminar");
        }
    }
}