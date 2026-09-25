public class FuenteChocolate extends Maquina {
    
private double capacidadKg;

public FuenteChocolate(int codigo, String marca, String modelo, double tarifaDiaria, double capacidadKg) { //basicamente esto sirve para que cuando se cree una nueva fuente, pueda meterle todos estos datos de golpe
    super(codigo, marca, modelo, tarifaDiaria); //esto hace que se ejecuten los datos de la clase padre para que esta clase los pueda usar
    this.capacidadKg = capacidadKg;
}

public double getCapacidadKg() {
    return capacidadKg;
}

public void setCapacidadKg(double capacidadKg) {
    this.capacidadKg = capacidadKg;
}

@Override
public double calcularCobros(int dias) {
    double total = super.calcularCobros(dias);  
//esto multiplica los kg que le caben a la maquina por los dias que alguien la alquila y eso da el recargo que hay que hacerle
    double recargo = this.capacidadKg * dias;

    return total + recargo;
}
}