package main.java.com.example;
public class CamionDeReparto extends Transporte {
    // Atributo privado específico
    private boolean tieneRefrigeracion;

    /**
     * Constructor que utiliza super() para enviar los datos obligatorios a la clase padre.
     */
    public CamionDeReparto(String idTransporte, double combustible, double capacidadCarga, boolean tieneRefrigeracion) {
        super(idTransporte, combustible, capacidadCarga);
        this.tieneRefrigeracion = tieneRefrigeracion;
    }

    public boolean isTieneRefrigeracion() {
        return tieneRefrigeracion;
    }

    public void setTieneRefrigeracion(boolean tieneRefrigeracion) {
        this.tieneRefrigeracion = tieneRefrigeracion;
    }

    /**
     * Sobrescritura (@Override) del método viajar.
     * Si tieneRefrigeracion es true, el consumo de combustible es el doble (2 unidades por cada 10km).
     * Si es false, se comporta como un transporte normal.
     */
    @Override
    public void viajar(int distancia) {
        if (this.tieneRefrigeracion) {
            double consumo = (distancia / 10.0) * 2;
            System.out.println("🚚 Camión con Refrigeración Activa [" + getIdTransporte() + "] viajando " + distancia + " km... (Consumo DUPLICADO: " + consumo + " unidades)");
            double nuevoCombustible = getCombustible() - consumo;
            setCombustible(nuevoCombustible);
        } else {
            // Comportamiento de transporte normal
            super.viajar(distancia);
        }
    }
}