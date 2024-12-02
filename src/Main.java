import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> listaCompra = new ArrayList<>();
        String productoAñadir = null;
        String productoEliminar = null;
        String respuesta = null;

        while (!"Q".equals(productoAñadir)){
            System.out.println("¿Que producto desea añadir a la lista?     ([Q] para salir)");
            productoAñadir = scanner.next().toUpperCase();

            if (listaCompra.contains(productoAñadir)){
                System.out.println("Este producto ya esta en la lista");

            } else if (!productoAñadir.equals("Q")) {
                while (!Arrays.asList("A", "B").contains(respuesta)){
                    System.out.println("¿Estas seguro de que desea añadir " + productoAñadir + " a la lista?\n A) SI\n B) NO");
                    respuesta = scanner.next().toUpperCase();
                }
                if (respuesta.equals("A")){
                    listaCompra.add(productoAñadir);
                    System.out.println("Producto añadido");
                }
            }

            //Se restaura el valor de la respuesta para que no se añada a la lista directamente
            respuesta = null;
        }

        while (!"B".equals(respuesta)){
            System.out.println("La lista de la compra es: \n" + listaCompra + "\n¿Desea eliminar algun producto?\n A) SI\n B) NO");
            respuesta = scanner.next().toUpperCase();

            if (respuesta.equals("A")){
                while (!listaCompra.contains(productoEliminar) && !"Q".equals(productoEliminar)){
                    System.out.println("¿Que producto desea eliminar?     ([Q] para salir)\n" + listaCompra);
                    productoEliminar = scanner.next().toUpperCase();

                    if (!productoEliminar.equals("Q")){
                        if (listaCompra.contains(productoEliminar)){
                            listaCompra.remove(productoEliminar);
                        }else {
                            System.out.println("Ese producto no esta");
                        }
                    }
                }
            }

        }

        System.out.println("\n\n----LISTA DE LA COMPRA----");
        listaCompra.forEach(p -> System.out.println("- " + p));

    }

}