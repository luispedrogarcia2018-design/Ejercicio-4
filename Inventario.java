import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    public static ArrayList <Maquina> Maquinas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static int opcion;

    public static void main(String [] args){


// Aqui van dos maquinas para cada tipo de maquina con todos sus pro datos
Maquinas.add(new MaquinaPalomitas(101, "palomamami", "f150", 150.00, 20, true));
Maquinas.add(new MaquinaPalomitas(102, "ostia", "3 turbo", 100.00, 15, false));


Maquinas.add(new MaquinaAlgodon(201, "vivo", "vivo4k", 180.00, 1200));
Maquinas.add(new MaquinaAlgodon(202, "candy", "dulce", 120.00, 900));


Maquinas.add(new FuenteChocolate(301, "sephora", "Pro", 250.00, 4.5));
Maquinas.add(new FuenteChocolate(302, "nike", "fountain", 90.00, 1.5));




        System.out.println("Bienvenido al menú Dulce Estación!");
        do{
            System.out.println("Ingrese una de las siguientes opciones:");
            System.out.println("1. Ingresar nueva máquina");
            System.out.println("2. Cotizar máquina");
            System.out.println("3. Alquilar nueva máquina");
            System.out.println("4. Devolver máquina");
            System.out.println("5. Mostrar inventarior");
            System.out.println("6. Salir");
            System.out.println("---------------------------------------");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1:
    System.out.println("Ingrese el tipo de máquina a ingresar:");
    System.out.println("1. Máquina de palomitas");
    System.out.println("2. Máquina de algodón de azúcar");
    System.out.println("3. Fuente de chocolate");
    opcion = scanner.nextInt();
    scanner.nextLine();
    
    while (true) {
        try {
            if (opcion == 1) {
                System.out.println("Ingrese el código:");
                int codigo = scanner.nextInt();
                scanner.nextLine(); 

                //esto es para ver que el codigo que ingrese foking alquien no este repetido
                boolean repetido = false;
                for (Maquina m : Maquinas) {
                    if (m.getCodigo() == codigo) {
                        repetido = true;
                        break;
                    }
                }

                if (repetido) {
                    System.out.println("Ese código ya existe. Intente con otro.");
                    continue; 
                } else {
                    System.out.println("Ingrese la marca:");
                    String marca = scanner.nextLine();
                    System.out.println("Ingrese el modelo:");
                    String modelo = scanner.nextLine();
                    System.out.println("Ingrese tarifa diaria:");
                    double tarifaDiaria = scanner.nextDouble();
                    System.out.println("Ingrese porciones por hora:");
                    int porciones = scanner.nextInt();
                    System.out.println("¿Tiene carrito? (true/false):");
                    boolean carrito = scanner.nextBoolean();

                    Maquinas.add(new MaquinaPalomitas(codigo, marca, modelo, tarifaDiaria, porciones, carrito));
                    System.out.println("máquina de palomas agregada exitosamente");
                    break; 
                }
            }
            else if (opcion == 2) {
                System.out.println("Ingrese el código:");
                int codigo = scanner.nextInt();
                scanner.nextLine();

                boolean repetido = false;
                for (Maquina m : Maquinas) {
                    if (m.getCodigo() == codigo) {
                        repetido = true;
                        break;
                    }
                }

                if (repetido) {
                    System.out.println("Ese código ya existe, Intente otro.");
                    continue;
                } else {
                    System.out.println("Ingrese la marca:");
                    String marca = scanner.nextLine();
                    System.out.println("Ingrese el modelo:");
                    String modelo = scanner.nextLine();
                    System.out.println("Ingrese tarifa diaria:");
                    double tarifaDiaria = scanner.nextDouble();
                    System.out.println("Ingrese la potencia (en vatios):");
                    int potencia = scanner.nextInt();

                    Maquinas.add(new MaquinaAlgodon(codigo, marca, modelo, tarifaDiaria, potencia));
                    System.out.println("máquina de algodón agregada exitosamente");
                    break; 
                }
            }
            else if (opcion == 3) {
                System.out.println("Ingrese el código:");
                int codigo = scanner.nextInt();
                scanner.nextLine();

                boolean repetido = false;
                for (Maquina m : Maquinas) {
                    if (m.getCodigo() == codigo) {
                        repetido = true;
                        break;
                    }
                }
                
                if (repetido) {
                    System.out.println("Ese código ya existe, Intente otro.");
                    continue;
                } else {
                    System.out.println("Ingrese la marca:");        
                    String marca = scanner.nextLine();
                    System.out.println("Ingrese el modelo:");
                    String modelo = scanner.nextLine();
                    System.out.println("Ingrese tarifa diaria:");
                    double tarifaDiaria = scanner.nextDouble();
                    System.out.println("Ingrese capacidad en kg:");
                    double capacidad = scanner.nextDouble(); 

                    Maquinas.add(new FuenteChocolate(codigo, marca, modelo, tarifaDiaria, capacidad));
                    System.out.println("fuente de chocolate agregada exitosamente");
                    break; 
                }
            }
            else {
                System.out.println("Esa opción no está disponible. Volviendo al menú principal.");
                break; // Rompe el while si meten otra foking opcion, como 4 o 5 o 6 o7 8
            }
            
        } catch (Exception e) {
            System.out.println("ERROR MAE, INGRESASTE UN DATO MAL intenta llenar los datos de nuevo.");
        }
    }
    break;

                case 2:
    while (true) {
        try {
            System.out.println("Ingrese el código de la máquina para cotizar:");
            int codigo = scanner.nextInt();
            
            if (codigo <= 0) {
                System.out.println("El código debe ser mayor a 0. Intente de nuevo.");
                continue; 
            }
            
            System.out.println("Ingrese la cantidad de días a alquilar:");
            int dias = scanner.nextInt();
            scanner.nextLine(); 

            boolean encontrada = false;
            for (Maquina m : Maquinas) {
                if (m.getCodigo() == codigo) {
                    encontrada = true;
                    System.out.println("-COTIZACIÓN -");
                    System.out.println("Máquina: " + m.getMarca() + " " + m.getModelo());
                    
                   
                    if (m.isDisponible()) {
                        System.out.println("Estado: Disponible para alquilar.");
                    } else {
                        System.out.println("Estado: OCUPADA (no se puede alquilar ahorita).");
                    }
                    
                    // estp calcula el total usando recargos e imprime con 2 decimales, y aparte, se usa ese formato de %d dias: --- solo la usamos para que no se vea hecho caca esa parte y se entienda facil
                    System.out.printf("Costo total por %d días: Q%.2f\n", dias, m.calcularCobros(dias));
                    break; // Rompe el for porque ya la encontro al fin
                }
            }

            // Si recorrio todo y no encontro ninguna fokinf maquina con ese foking codigo raro
            if (!encontrada) {
                System.out.println("No existe ninguna máquina con ese código.");
            }
            
            break; 

        } catch (Exception e) {
            System.out.println("¡Error! Ingresaste datos inválidos. Probá de nuevo.");
            scanner.nextLine(); 
        }
    }
    break; 

                case 3:
    while (true) {
        try {
            System.out.println("ingrese el código de la máquina a ALQUILAR:");
            // le cambie nombre a codigo porque chocaba con las de arriba paps
            int codigoAlquiler = scanner.nextInt(); 
            scanner.nextLine(); 
            
            if (codigoAlquiler <= 0) {
                System.out.println("código inválido. Intente de nuevo.");
                continue;
            }
            
            boolean encontrada = false;
            for (Maquina m : Maquinas) {
                if (m.getCodigo() == codigoAlquiler) {
                    encontrada = true;
                    
                    // si esta disponible esta cosa sigue con esto, si no, cae abajo al if encontrada
                    if (m.isDisponible()) {
                        System.out.println("Ingrese la cantidad de días a alquilar:");
                        int dias = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.printf("El total es: Q%.2f. ¿Desea confirmar? (si/no)\n", m.calcularCobros(dias));
                        String seleccion = scanner.nextLine();
                        
                        // equialsIgnoreCase alparecer sirve para que no importa como meta el usuaio el si, como si mete SI o si, o Si, o sI o no se
                        if (seleccion.equalsIgnoreCase("si")) {
                            m.setDisponible(false); // La marcamos como ocupada
                            System.out.println("¡Alquiler confirmado con éxito!");
                        } else {
                            System.out.println("Alquiler cancelado.");
                        }
                    } else {
                        System.out.println("Lo siento, esa máquina ya está alquilada ahorita.");
                    }
                    break; //se rompe el foking for kbron
                }
            }
            
            if (!encontrada) {
                System.out.println("No existe ninguna máquina con ese código.");
            }
            
            break; // Rompe el while y te saca al menú
            
        } catch (Exception e) {
            System.out.println("Dato inválido. Probá de nuevo.");
            scanner.nextLine();
        }
    }
    break; 
    

           case 4:
    while (true) {
        try {
            System.out.println("Ingrese el código de la máquina a DEVOLVER:");
            int codigoDevolucion = scanner.nextInt();
            scanner.nextLine();

            if (codigoDevolucion <= 0) {
                System.out.println("Código inválido. Intente de nuevo.");
                continue;
            }

            boolean encontrada = false;
            for (Maquina m : Maquinas) {
                if (m.getCodigo() == codigoDevolucion) {
                    encontrada = true;
                    
                    // Verificamos si realmente estaba alquilada
                    if (!m.isDisponible()) {
                        m.setDisponible(true); // La regresamos a la tienda
                        System.out.println("¡Máquina devuelta con éxito! Ya está disponible de nuevo.");
                    } else {
                        System.out.println("Ojo: Esta máquina ya estaba disponible, no estaba alquilada.");
                    }
                    break; // Rompe el ciclo for porque ya la encontró
                }
            }

            if (!encontrada) {
                System.out.println("No existe ninguna máquina con ese código.");
            }

            break; // Rompe el while(true) y regresa al menú

        } catch (Exception e) {
            System.out.println("Dato inválido. Probá de nuevo.");
            scanner.nextLine(); // Limpia la basura del teclado
        }
    }
   break; 
   case 5:
    System.out.println("\n- INVENTARIO ACTUAL -");
    if (Maquinas.isEmpty()) {
        System.out.println("Aún no hay máquinas registradas.");
    } else {
        for (Maquina m : Maquinas) {
            String estado = m.isDisponible() ? "Sí" : "No (Alquilada)";
            System.out.println("Código: " + m.getCodigo() + " | Marca: " + m.getMarca() + " | Disponible: " + estado);
        }
    }
    System.out.println("__________________\n");
    break;


    case 6:
    System.out.println("saliendo del sistema, Nos vemos jijijiji");
    System.exit(0); // Esto mata el programa de un solo golpe, ignorando cualquier while.


                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }
}
        