
#  Boletín de Ejercicios Tema 11

## UpgradeHub 1º DAM/DAW

## Ejercicio 1: Escritura y lectura en un fichero de texto
Escribe un programa que guarde en un fichero llamado `alumnos.txt` los nombres de 5 alumnos introducidos por teclado. Luego, abre el fichero y muestra su contenido por pantalla.

## Ejercicio 2: Añadir información a un fichero existente
Modifica el programa anterior para que, en lugar de sobrescribir el fichero, añada los nuevos nombres al final del fichero `alumnos.txt` sin borrar los anteriores.

## Ejercicio 3: Almacenar objetos en un fichero (serialización)
Crea una clase `Alumno` con los atributos `nombre`, `edad` y `notaMedia`. Escribe un programa que permita crear 3 objetos `Alumno` y los almacene en un fichero binario llamado `alumnos.dat` usando serialización. Luego, lee el fichero y muestra la información de los alumnos por pantalla.

## Ejercicio 4: Leer un fichero binario con objetos serializados
A partir del fichero `alumnos.dat` del ejercicio anterior, escribe un programa que lea todos los objetos `Alumno` almacenados y muestre su contenido en consola.

## Ejercicio 5: Crear y eliminar directorios
Escribe un programa que cree una carpeta llamada `backup`. Si ya existe, debe eliminarla completamente (incluyendo su contenido). Puedes utilizar clases como `File` y `Files`.

## Ejercicio 6: Listar contenido de un directorio
Crea un programa que liste todos los ficheros (no directorios) de una carpeta indicada por el usuario por teclado. Muestra el nombre, tamaño y última fecha de modificación de cada fichero.
