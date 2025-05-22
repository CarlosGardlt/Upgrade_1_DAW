
#  Boletín de Ejercicios Tema 11 – Solucionado

## UpgradeHub 1º DAM/DAW

## Ejercicio 1: Escritura y lectura en un fichero de texto
**Enunciado:** Escribe un programa que guarde en un fichero llamado `alumnos.txt` los nombres de 5 alumnos introducidos por teclado. Luego, abre el fichero y muestra su contenido por pantalla.

```java
import java.io.*;
import java.util.Scanner;

// Clase principal del programa
public class Ejercicio1 {
    public static void main(String[] args) {
        // Objeto Scanner para leer datos del teclado
        Scanner sc = new Scanner(System.in);
        // Creamos un objeto File que representa el archivo alumnos.txt
        File archivo = new File("alumnos.txt");

        try (// Abrimos el fichero para escritura usando BufferedWriter
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < 5; i++) {
                System.out.print("Introduce nombre del alumno " + (i + 1) + ": ");
                String nombre = sc.nextLine();
                bw.write(nombre);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nContenido del fichero:");
        try (// Abrimos el fichero para lectura usando BufferedReader
             BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Ejercicio 2: Añadir información a un fichero existente
**Enunciado:** Modifica el programa anterior para que, en lugar de sobrescribir el fichero, añada los nuevos nombres al final del fichero `alumnos.txt` sin borrar los anteriores.

```java
import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Objeto Scanner para leer datos del teclado
        Scanner sc = new Scanner(System.in);
        // Creamos un objeto File que representa el archivo alumnos.txt
        File archivo = new File("alumnos.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            for (int i = 0; i < 3; i++) {
                System.out.print("Introduce otro nombre de alumno: ");
                String nombre = sc.nextLine();
                bw.write(nombre);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Ejercicio 3: Almacenar objetos en un fichero (serialización)
**Enunciado:** Crea una clase `Alumno` con los atributos `nombre`, `edad` y `notaMedia`. Escribe un programa que permita crear 3 objetos `Alumno` y los almacene en un fichero binario llamado `alumnos.dat` usando serialización. Luego, lee el fichero y muestra la información de los alumnos por pantalla.

```java
import java.io.*;
import java.util.Scanner;

class Alumno implements Serializable {
    String nombre;
    int edad;
    double notaMedia;

    public Alumno(String nombre, int edad, double notaMedia) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return nombre + " - Edad: " + edad + ", Nota media: " + notaMedia;
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        // Objeto Scanner para leer datos del teclado
        Scanner sc = new Scanner(System.in);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("alumnos.dat"))) {
            for (int i = 0; i < 3; i++) {
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Edad: ");
                int edad = sc.nextInt();
                System.out.print("Nota media: ");
                double nota = sc.nextDouble();
                sc.nextLine();

                Alumno a = new Alumno(nombre, edad, nota);
                oos.writeObject(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Ejercicio 4: Leer un fichero binario con objetos serializados
**Enunciado:** A partir del fichero `alumnos.dat` del ejercicio anterior, escribe un programa que lea todos los objetos `Alumno` almacenados y muestre su contenido en consola.

```java
import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("alumnos.dat"))) {
            while (true) {
                Alumno a = (Alumno) ois.readObject();
                System.out.println(a);
            }
        } catch (EOFException e) {
            System.out.println("Fin del fichero.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

## Ejercicio 5: Crear y eliminar directorios
**Enunciado:** Escribe un programa que cree una carpeta llamada `backup`. Si ya existe, debe eliminarla completamente (incluyendo su contenido). Puedes utilizar clases como `File` y `Files`.

```java
import java.io.File;

public class Ejercicio5 {
    public static void main(String[] args) {
        File dir = new File("backup");

        if (dir.exists()) {
            deleteDirectory(dir);
            System.out.println("Directorio eliminado.");
        } else {
            if (dir.mkdir()) {
                System.out.println("Directorio creado.");
            } else {
                System.out.println("No se pudo crear el directorio.");
            }
        }
    }

    public static void deleteDirectory(File file) {
        File[] archivos = file.listFiles();
        if (archivos != null) {
            for (File f : archivos) {
                if (f.isDirectory()) {
                    deleteDirectory(f);
                } else {
                    f.delete();
                }
            }
        }
        file.delete();
    }
}
```

## Ejercicio 6: Listar contenido de un directorio
**Enunciado:** Crea un programa que liste todos los ficheros (no directorios) de una carpeta indicada por el usuario por teclado. Muestra el nombre, tamaño y última fecha de modificación de cada fichero.

```java
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        // Objeto Scanner para leer datos del teclado
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce ruta del directorio: ");
        String ruta = sc.nextLine();

        File dir = new File(ruta);
        if (dir.isDirectory()) {
            File[] archivos = dir.listFiles();
            if (archivos != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                for (File f : archivos) {
                    if (f.isFile()) {
                        System.out.println("Nombre: " + f.getName());
                        System.out.println("Tamaño: " + f.length() + " bytes");
                        System.out.println("Última modificación: " + sdf.format(f.lastModified()));
                        System.out.println("----------------------------");
                    }
                }
            }
        } else {
            System.out.println("La ruta no es válida o no es un directorio.");
        }
    }
}
```
