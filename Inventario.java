import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    public static ArrayList <Maquina> Maquinas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static int opcion;

    private static void main(String [] args){
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
                    while (true){
                    try{
                        if (opcion == 1){
                            Maquinas.add(new MaquinaPalomitas(opcion, null, null, opcion, opcion, false));
                        }
                        else if (opcion == 2){
                            Maquinas.add(new MaquinaAlgodon(opcion, null, null, opcion, opcion));
                        }
                        else if (opcion == 3){
                            Maquinas.add(new FuenteChocolate(opcion, null, null, opcion, opcion));
                        }
                        else{
                            throw new IllegalArgumentException("Esa opción no está disponible");
                        }
                    }catch (Exception e){
                        System.out.println("Ingrese un valor válido");
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                    }
                
                }

                case 2:
                    System.out.println("Ingrese el código de la máquina");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    while (true){
                    try{
                    if (codigo>0){
                        for (int i = 0; i<Maquinas.size(); i++){
                            if (Maquinas.get(i).getCodigo()==codigo){
                                System.out.println("El precio de la máquina es de: "
                                    + Maquinas.get(i).getTarifaDiaria()
                                + " /día");
                                if (!Maquinas.get(i).isDisponible()){
                                    System.out.println("La máquina se encuentra disponible");
                                }
                                else{
                                    System.out.println("La máquina no está disponible");
                                }
                        }   else{
                                System.out.println("Esta máquina no está disponible");
                            }
                    }
                }   else{
                    throw new IllegalArgumentException("Este código es inválido");
                }
            }catch (Exception e){
                System.out.println("Este código es inválido, pruebe de nuevo");
                codigo = scanner.nextInt();
                scanner.nextLine();
            }
            }

                case 3:
                System.out.println("Ingrese el códigod de la máquina a devolver");
                codigo = scanner.nextInt();
                scanner.nextLine();
                while (true){
                    try{

                    if (codigo>0){
                        for (int i = 0; i<Maquinas.size(); i++){
                            if (Maquinas.get(i).getCodigo()==codigo){
                                if (!Maquinas.get(i).isDisponible()){
                                    System.out.println("La máquina se encuentra disponible");
                                }
                                else{
                                    System.out.println("La máquina no está disponible");
                                }

                                System.out.println("Ingrese la cantidad de días a alquilar: ");
                                int dias = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("El precio de alquilar la máquina es de: "
                                    + Maquinas.get(i).calcularCobros(dias)
                                + ", ¿desea continuar? (si/no) ");
                                String seleccion = scanner.nextLine();
                                if (seleccion =="si"){
                                    boolean disponible = false;
                                    Maquinas.get(i).setDisponible(disponible);
                                }
                                else{
                                    System.out.println("Se ha cancelado la selección");
                                }
                            }
                            else{
                                System.out.println("Esta máquina no está disponible");
                            }
                    }
                }   else{
                    throw new IllegalArgumentException("Este código es inválido");
                }
            }catch (Exception e){
                System.out.println("Este código es inválido, pruebe de nuevo");
                codigo = scanner.nextInt();
                scanner.nextLine();
            }
            }
            case 4:
                    System.out.println("Ingrese el código de la máquina");
                    codigo = scanner.nextInt();
                    scanner.nextLine();
                    while (true){
                    try{

                    if (codigo>0){
                        for (int i = 0; i<Maquinas.size(); i++){
                            if (Maquinas.get(i).getCodigo()==codigo){
                                Maquinas.get(i).setDisponible(true);
                        }   else{
                                System.out.println("No se ha encontrado esta máquina");
                            }
                    }
                }   else{
                    throw new IllegalArgumentException("Este código es inválido");
                }
            }catch (Exception e){
                System.out.println("Este código es inválido, pruebe de nuevo");
                codigo = scanner.nextInt();
                scanner.nextLine();
            }
            }

            default:
                System.out.println("Opción inválida");
                }}
        while(opcion!= 6);


    }
}
