public class MaquinaPalomitas extends Maquina {

    private int porcionesPorHora;
    private boolean tieneCarrito;

    public MaquinaPalomitas(int codigo, String marca, String modelo, double tarifaDiaria, int porcionesPorHora, boolean tieneCarrito) {
        super(codigo, marca, modelo, tarifaDiaria); //esto hace que se ejecuten los datos de la clase padre para que esta clase los pueda usar
        this.porcionesPorHora = porcionesPorHora;
        this.tieneCarrito = tieneCarrito;
    }

    public int getPorcionesPorHora() {
        return porcionesPorHora;
    }

    public void setPorcionesPorHora(int porcionesPorHora) {
        this.porcionesPorHora = porcionesPorHora;
    }

    public boolean isTieneCarrito() {
        return tieneCarrito;
    }

    public void setTieneCarrito(boolean tieneCarrito) {
        this.tieneCarrito = tieneCarrito;
    }
    
    //si la máquina de palomitas tiene carrito, se le suman Q40 por cada día extra
    //ahorita va el constructor para hacer esto

   public double calcularCobros(int dias){
    
       // primero se saca el costo normal llamando al método de la clase padre
    double total = super.calcularCobros(dias);
    
    // si tiene carrito, se le sumamos los 40 bombis por cada día
    if (this.tieneCarrito == true) {
        total = total + (40 * dias);
    }
    
    return total;
}
@Override
public String getCategoria() {
    return "Palomitas";
}
}


    