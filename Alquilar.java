public class Alquilar {
    private int potencia;
    private int codigo;
    private String marca;
    private String modelo;
    private double tarifaDiaria;
    public boolean verificar(boolean Disponible){
        return Disponible;
    }
    public Alquilar(int codigo, String marca, String modelo, double tarifaDiaria){
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaDiaria = tarifaDiaria;
    }

}
