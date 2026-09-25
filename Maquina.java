public class Maquina {

    private int codigo;
    private String marca;
    private String modelo;
    private double tarifaDiaria;
    private boolean disponible;  //hay que agregarlo al UML


    public double calcularCobros( int dias) { // metodo (solo para no perderme)
        
        double total = this.tarifaDiaria * dias;
        return total;
    }
   

public Maquina (int codigo, String marca, String modelo, double tarifaDiaria) {
    this.codigo = codigo;
    this.marca = marca;
    this.modelo = modelo;
    this.tarifaDiaria = tarifaDiaria;

    this.disponible = true;
}


public int getCodigo() {
    return codigo;
}


public void setCodigo(int codigo) {
    this.codigo = codigo;
}


public String getMarca() {
    return marca;
}


public void setMarca(String marca) {
    this.marca = marca;
}


public String getModelo() {
    return modelo;
}


public void setModelo(String modelo) {
    this.modelo = modelo;
}


public double getTarifaDiaria() {
    return tarifaDiaria;
}


public void setTarifaDiaria(double tarifaDiaria) {
    this.tarifaDiaria = tarifaDiaria;
}


public boolean isDisponible() {
    return disponible;
}


public void setDisponible(boolean disponible) {
    this.disponible = disponible;
}

}


