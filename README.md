# PROYECTO SEGUNDO PARCIAL

Elaborar un programa que contenga un menú con 4 opciones, de acuerdo
al siguiente detalle:

## Opción 1:

Programa que permita crear y gestionar los ficheros y directorios de un
proyecto de Java. El programa debe permitir realizar los siguiente:

- Crear el proyecto de Java con todos sus correspondientes archivos y carpetas. Al
  crear el proyecto se debe solicitar el nombre del proyecto y el nombre del paquete. Según el nombre del paquete se crearan las carpetas dentro del proyecto; por
  ejemplo mi paquete se llama “ec.edu.uta.fisei.software”, se deben crear 5 carpetas
  en la ruta correspondiente “ec, edu, uta, fisei y software” (ejemplo en la imagen).

- Mostrar los archivos y directorios contenidos en la ubicación principal del proyecto creado, con su respectiva información (tamaño, permisos de lectura o escritura, etc.).
- Crear archivos de cualquier extensión (se debe permitir al usuario seleccionar de un
  grupo de extensiones).
- Modificar el nombre de una carpeta y de un archivo (si es el caso de un archivo se
  puede modificar la extensión); se debe mostrar un mensaje que diga si está seguro
  de realizar esta acción.
- Eliminar un archivo o directorio (mostrar un mensaje que diga si está seguro de
  realizar esta acción).
- Leer el archivo que desee el usuario y mostrar el contenido en pantalla.
- Escribir un archivo que desee el usuario, permitiendo ingresar la información a
  escribir por teclado (mostrar un mensaje preguntando si se desea sobrescribir el
  archivo o si se desea agregar la información al final).
- Permitir al usuario realizar una copia de un archivo que desee y que permita realizar
  la copia de la siguiente manera:
  - Duplicado integro, es decir la misma información del original.
  - Duplicado con cambios, reemplazando las vocales por números asignados a cada
    vocal.
  - Plantee otra forma de duplicado similar a las anteriores.

<!-- Añadir imagen -->

## Opción 2:

Aplicación que permita realizar el proceso de venta de boletos de viaje para
una empresa de transporte de pasajeros.

- Se debe ingresar la información del cliente por teclado para la cabecera de la factura
  (cédula, nombre, apellido, teléfono, correo electrónico) y controlar el ingreso de
  estos campos mediante expresiones regulares. Toda esta información y la fecha de
  compra se debe almacenar en un vector o en una lista.
- La empresa de transporte de pasajeros solamente dispone de rutas de origen
  Ambato. Las ciudades de destino deben estar almacenadas en un archivo
  previamente, en donde contenga al menos 10 ciudades con los siguientes campos
  (código, ciudad, numero de asientos, precio normal, precio por grupos). Al facturar
  se debe aplicar el precio por grupos para compras de 4 o más asientos, caso contrario aplicar el precio normal. La información de las ciudades de destino se mostrará al momento de iniciar el proceso de venta.
- Crear al menos 3 vectores en donde se almacenarán los códigos de ciudades de
  destino o clientes que tengan descuento. Cuando se realice los cálculos de la factura
  se debe recorrer cada vector para verificar y aplicar los descuentos a la compra. Los
  vectores serán creados de la siguiente manera:
  - Un vector con códigos de ciudades de destino un descuento del 10% por ser las
    principales ciudades del Ecuador.
  - Un vector con códigos de clientes que compren frecuentemente, los cuales
    tendrán un descuento del 2% al total de la factura.
  - Un descuento ideado por usted. (Debe ser creativo y utilizando más de una
    condicional)
    - Se podrá comprar boletos a tantas ciudades como el cliente decida y almacenar en
      una lista. Los datos que se deben guardar son los siguientes: ciudad, número de
      asientos, fecha del viaje, subtotal.
    - Al finalizar el proceso de compra se debe preguntar al usuario si la factura
      desea física o electrónica. Si selecciona física se generará la factura en un archivo txt,
      caso contrario se imprimirá en pantalla la información. (Se recomienda utilizar printf
      para imprimir los resultados). Los datos a imprimir el final de la factura serán:
      subtotal, descuentos, IVA y valor a pagar.
    - El formato de impresión de la factura será: cabecera (datos del cliente y fecha de
      compra), cuerpo (detalle de la compra con sus respectivos totales), pie de la factura
      (subtotal, descuentos, IVA y valor a pagar).
      Opción 3: Aplicación de un tema libre, a su elección, el cual será valorado de acuerdo a
      la originalidad, esfuerzo realizado en el mismo y uso de estructuras revisadas en clase:
      estructuras de selección y repetición, uso de programación orientada a objetos (clases,
      métodos, constructores), gestión de ficheros(creación, escritura y lectura) y estructuras
      de datos (vectores, matrices, listas, etc.).
      Opción 4: Salir.
      En todas las opciones:
    - Al terminar, se deberá preguntar al usuario si desea ejecutar esa opción otra vez
      o no, en caso de querer salir debe regresar al menú principal de opciones.
    - Utilizar programación orientada a objetos para poder reutilizar el código y
      optimizar los procesos de su programa.

Se valorará de la aplicación:

- la efectividad
- eficiencia
- facilidad de uso
- pertinencia de las sentencias y estructuras utilizadas
- comentarios sobre el código y que tenga los controles correspondientes.
- Se debe exponer el programa y cada integrante deberá demostrar que conoce el código y lo puede cambiar de acuerdo a lo que se pida en ese momento.
- Las explicaciones deben ser puntuales y técnicamente fundamentadas, para lo cual es fundamental conocer la teoría explicada en clase y en la bibliografía correspondiente.

> Solo se pueden utilizar para la elaboración del programa las sentencias que se han revisado en clase.

## LINKS DE UTILIDAD PARA EL DESARROLLO DEL PROYECTO:

- [Principales ciudades del Ecuador](https://www.camaraofespanola.org/principales-ciudades-de-ecuador/)
- [Códigos provinciales del Ecuador](http://www.ecuadorlegalonline.com/consultas/registro-civil/codigos-provinciacedula-identidad/)
