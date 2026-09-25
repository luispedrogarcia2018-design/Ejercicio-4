public class MaquinaAlgodon extends Maquina{
    
private int potencia;// son atributos, hay que cambiarlo en el UML

public MaquinaAlgodon(int codigo, String marca, String modelo, double tarifaDiaria, int potencia) {
    super(codigo, marca, modelo, tarifaDiaria); //esto hace que se ejecuten los datos de la clase padre para que esta clase los pueda usar
    this.potencia = potencia;
}

public int getPotencia() {
    return potencia;
}

public void setPotencia(int potencia) {
    this.potencia = potencia;
}

@Override
public double calcularCobros(int dias) {
    double total = super.calcularCobros(dias);  //esto hace el cobro base para despues agregarle los 60 si pasa de 1000 de potencia 
    //este es el if que le suma los 60 bombis si la potencia pasa de 1000 
    if (this.potencia > 1000) {
        total = total + 60;
    }
    
    return total;
}
}