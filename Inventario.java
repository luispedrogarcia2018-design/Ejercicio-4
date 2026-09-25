import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    private static ArrayList <Maquina> Maquinas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList <Alquilar> MaquinaALquilada = new ArrayList<>();
    private static int opcion;
    private static double totalVendido;
    private static int codigo;
    private static boolean existe;
    private static int dias;

    public static void mostrarResumen(String categoria) {
    int total = 0;
    int disponibles = 0;

    for (Maquina maquina : Maquinas) {
        if (maquina.getCategoria().equals(categoria)) {
            total++;

            if (maquina.isDisponible()) {
                disponibles++;
            }
        }
    }

    System.out.println("Categoría: " + categoria);
    System.out.println("Total: " + total);
    System.out.println("Disponibles: " + disponibles);
    System.out.println("Alquiladas: " + (total - disponibles));
    System.out.println("-------------------------------------");
}
    public static void main(String [] args){
        System.out.println("Bienvenido al menú Dulce Estación!");
        do{
            System.out.println("Ingrese una de las siguientes opciones:");
            System.out.println("1. Ingresar nueva máquina");
            System.out.println("2. Cotizar máquina");
            System.out.println("3. Alquilar nueva máquina");
            System.out.println("4. Devolver máquina");
            System.out.println("5. Salir y observar resumen de inventario");
            System.out.println("---------------------------------------");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1:
                    System.out.println("Ingrese el tipo de máquina a ingresar:");
                    System.out.println("1. Máquina de palomitas");
                    System.out.println("2. Máquina de algodón de azúcar");
                    System.out.println("3. Fuente de chocolate");
                    int tipoMaquina = scanner.nextInt();
                    scanner.nextLine();
                    while (true){
                    try{
                        if (tipoMaquina == 1){
                            int codigo = scanner.nextInt();
                            scanner.nextLine();
                            String marca = scanner.nextLine();
                            String modelo = scanner.nextLine();
                            double tarifaDiaria = scanner.nextDouble();
                            int porcionesPorHora = scanner.nextInt();
                            boolean tieneCarrito = scanner.nextBoolean();
                            boolean existe = false;

                            for (Maquina maquina : Maquinas) {
                                if (maquina.getCodigo() == codigo) {
                                    existe = true;
                                    break;
                                    }
                                }

                            if (existe) {
                                System.out.println("Ese código ya está registrado");
                            } else {
                                Maquinas.add(new MaquinaPalomitas(
                                    codigo, marca, modelo, tarifaDiaria,
                                porcionesPorHora, tieneCarrito
                                ));
                            }
                        }

                        else if (tipoMaquina == 2){
                            int codigo = scanner.nextInt();
                            scanner.nextLine();
                            String marca = scanner.nextLine();
                            String modelo = scanner.nextLine();
                            double tarifaDiaria = scanner.nextDouble();
                            int potencia = scanner.nextInt();
                            for (Maquina maquina : Maquinas) {
                                if (maquina.getCodigo() == codigo) {
                                    existe = true;
                                    break;
                                    }
                                }

                            if (existe) {
                                System.out.println("Ese código ya está registrado");
                            } else {
                                Maquinas.add(new MaquinaAlgodon(
                                    codigo, marca, modelo, tarifaDiaria,potencia
                                ));
                            }
                        }
                        else if (tipoMaquina == 3){
                            int codigo = scanner.nextInt();
                            scanner.nextLine();
                            String marca = scanner.nextLine();
                            String modelo = scanner.nextLine();
                            double tarifaDiaria = scanner.nextDouble();
                            double capacidadKg = scanner.nextDouble();
                            for (Maquina maquina : Maquinas) {
                                if (maquina.getCodigo() == codigo) {
                                    existe = true;
                                    break;
                                    }
                                }

                            if (existe) {
                                System.out.println("Ese código ya está registrado");
                            } else {
                                Maquinas.add(new FuenteChocolate(
                                    codigo, marca, modelo, tarifaDiaria,capacidadKg
                                ));
                            }
                            
                        }
                        else{
                            throw new IllegalArgumentException("Esa opción no está disponible");
                        }
                        break;
                    }catch (Exception e){
                        System.out.println("Ingrese un valor válido");
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                    }
                
                }
                break;

                case 2:
                    System.out.println("Ingrese el código de la máquina");
                    while (true){
                    try{
                        codigo = scanner.nextInt();
                        scanner.nextLine();
                    if (codigo>0){
                        for (int i = 0; i<Maquinas.size(); i++){
                            if (Maquinas.get(i).getCodigo()==codigo){
                                System.out.println("Ingrese la cantidad de días a rentar:");
                                while (true){
                                try{
                                dias = scanner.nextInt();
                                scanner.nextLine();
                                if (dias<0){
                                    throw new IllegalArgumentException("La cantidad de días debe ser mayor a 0");
                                }
                                else{
                                    break;
                                }


                                }catch (Exception e){
                                System.out.println("Este valor no es válido");
                            }
                        }

                                System.out.println("El precio de la máquina es de: "
                                    + Maquinas.get(i).calcularCobros(dias)
                                + " /día");
                                if (Maquinas.get(i).isDisponible()){
                                    System.out.println("La máquina se encuentra disponible");
                                }
                                else{
                                    System.out.println("La máquina no está disponible");
                                }
                                
                        }
                    }
                }   else{
                        throw new IllegalArgumentException("Este código es inválido");
                }
                break; 
            }catch (Exception e){
                System.out.println("Este código es inválido, pruebe de nuevo");
            }
            }
            break;

                case 3:
                System.out.println("Ingrese el código de la máquina a devolver");
                while (true){

                    try{
                        codigo = scanner.nextInt();
                        scanner.nextLine();
                    if (codigo>0){
                        for (int i = 0; i<Maquinas.size(); i++){
                            if (Maquinas.get(i).getCodigo()==codigo){
                                if (Maquinas.get(i).isDisponible()){
                                    System.out.println("La máquina se encuentra disponible");
                                    System.out.println("Ingrese la cantidad de días a alquilar: ");
                                    int dias = scanner.nextInt();
                                    scanner.nextLine();
                                    while (true){
                                    try{
                                    dias = scanner.nextInt();
                                    scanner.nextLine();
                                    if (dias<0){
                                        throw new IllegalArgumentException("La cantidad de días debe ser mayor a 0");
                                    }
                                    else{
                                        break;
                                    }


                                    }catch (Exception e){
                                        System.out.println("Este valor no es válido");
                                    }
                                    }

                                    System.out.println("El precio de alquilar la máquina es de: "
                                    + Maquinas.get(i).calcularCobros(dias)
                                    + ", ¿desea continuar? (si/no) ");
                                    String seleccion = scanner.nextLine().toUpperCase();
                                if (seleccion.equals("SI")){
                                    boolean disponible = false;
                                    Maquinas.get(i).setDisponible(disponible);
                                    codigo = Maquinas.get(i).getCodigo();
                                    String marca = Maquinas.get(i).getMarca();
                                    String modelo = Maquinas.get(i).getModelo();
                                    double tarifaDiaria = Maquinas.get(i).getTarifaDiaria(); 
                                    MaquinaALquilada.add(new Alquilar(codigo, marca, modelo, tarifaDiaria));
                                    totalVendido += Maquinas.get(i).calcularCobros(dias);
                                }
                                else if(seleccion.equals("NO")){
                                    System.out.println("Se ha cancelado la transacción");
                                }
                                else{
                                    System.out.println("Esa opción no está disponible");
                                }
                                }
                                else{
                                    System.out.println("La máquina no está disponible");
                                }
                            }
                    }
                }   else{
                    throw new IllegalArgumentException("Este código es inválido");
                }
                break;
            }catch (Exception e){
                System.out.println("Este código es inválido, pruebe de nuevo");
            }
            }
            break;

            case 4:
                    System.out.println("Ingrese el código de la máquina");
                    while (true){
                    try{
                        codigo = scanner.nextInt();
                        scanner.nextLine();
                    if (codigo>0){
                        for (int i = 0; i<Maquinas.size(); i++){
                            if (Maquinas.get(i).getCodigo()==codigo){
                                Maquinas.get(i).setDisponible(true);
                        } 
                    }
                }   else{
                    throw new IllegalArgumentException("Este código es inválido");

                }
                break;
            }catch (Exception e){
                System.out.println("Este código es inválido, pruebe de nuevo");
            }
            }
            break;
            
            case 5:
                break;

            default:
                System.out.println("Opción inválida");
                }}
        while(opcion!=5);

        mostrarResumen("Palomitas");
        mostrarResumen("Algodon");
        mostrarResumen("Chocolate");
        System.out.println("El total de dinero de las máquinas alquiladas es de: "
        + totalVendido);
    }
}
