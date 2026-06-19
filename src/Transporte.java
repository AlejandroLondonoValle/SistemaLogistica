public class Transporte {
    private String idTransporte;
    private double combustible;
    private double capacidadCarga;

    /**
     * Constructor obligatorio para inicializar los tres atributos esenciales.
     */
    public Transporte(String idTransporte, double combustible, double capacidadCarga) {
        this.idTransporte = idTransporte;
        // Usamos los setters lógicos para asegurar que la inicialización respete las reglas de negocio
        setCombustible(combustible);
        setCapacidadCarga(capacidadCarga);
    }

    // --- GETTERS Y SETTERS CON LÓGICA DE NEGOCIO ---

    public String getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(String idTransporte) {
        this.idTransporte = idTransporte;
    }

    public double getCombustible() {
        return combustible;
    }

    /**
     * Controla que el nivel de combustible esté estrictamente entre 0 y 100.
     * Si el valor es menor a 0, asigna 0. Si es mayor a 100, asigna 100.
     */
    public void setCombustible(double combustible) {
        if (combustible < 0) {
            this.combustible = 0;
        } else if (combustible > 100) {
            this.combustible = 100;
        } else {
            this.combustible = combustible;
        }
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    /**
     * Si el valor de carga es negativo, imprime un mensaje de error y no asigna el valor.
     */
    public void setCapacidadCarga(double capacidadCarga) {
        if (capacidadCarga < 0) {
            System.out.println("ERROR: La capacidad de carga no puede ser negativa (" + capacidadCarga + "). Operación rechazada.");
        } else {
            this.capacidadCarga = capacidadCarga;
        }
    }

    /**
     * Método viajar: Resta 1 unidad de combustible por cada 10km recorridos.
     * Fórmula sugerida implícita: combustible consumido = distancia / 10
     */
    public void viajar(int distancia) {
        double consumo = distancia / 10.0;
        System.out.println("Transporte [" + idTransporte + "] viajando " + distancia + " km... (Consumo base estimado: " + consumo + " unidades)");
        double nuevoCombustible = this.combustible - consumo;
        setCombustible(nuevoCombustible);
    }
}