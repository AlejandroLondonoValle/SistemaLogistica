public class BuqueCarga extends Transporte {
    // Atributo privado específico
    private int cantidadContenedores;

    /**
     * Constructor que utiliza super() para la inicialización del núcleo.
     */
    public BuqueCarga(String idTransporte, double combustible, double capacidadCarga, int cantidadContenedores) {
        super(idTransporte, combustible, capacidadCarga);
        this.cantidadContenedores = cantidadContenedores;
    }

    public int getCantidadContenedores() {
        return cantidadContenedores;
    }

    public void setCantidadContenedores(int cantidadContenedores) {
        this.cantidadContenedores = cantidadContenedores;
    }

    /**
     * Método propio: atracarEnPuerto()
     * Imprime un mensaje indicando el ID del transporte y que está listo para descarga.
     */
    public void atracarEnPuerto() {
        System.out.println("⚓ [PUERTO] El Buque de Carga [" + getIdTransporte() + "] ha atracado exitosamente. ¡Listo para la descarga de " + cantidadContenedores + " contenedores!");
    }

    /**
     * Método propio: mostrarDatos()
     * Muestra la información básica y calcula el Costo de Viaje en USD.
     */
    public void mostrarDatos() {
        // Cálculo del costo (fórmula lógica basada en $150 USD por contenedor)
        double costoViajeUSD = cantidadContenedores * 150.0;
        
        System.out.println("============= DATOS DEL BUQUE =============");
        System.out.println("ID Transporte  : " + getIdTransporte());
        System.out.println("Combustible    : " + getCombustible() + " %");
        System.out.println("Capacidad Carga: " + getCapacidadCarga() + " Toneladas");
        System.out.println("Contenedores   : " + cantidadContenedores);
        System.out.println("Costo de Viaje : " + costoViajeUSD + " USD");
        System.out.println("===========================================");
    }
}