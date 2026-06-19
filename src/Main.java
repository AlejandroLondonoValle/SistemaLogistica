import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO DESAFÍO LOGITECH 2.0 ===\n");

        System.out.println("--- 1. Instanciación Segura ---");
        // Crear un CamionDeReparto con refrigeración activa
        CamionDeReparto camion = new CamionDeReparto("CAM-789", 80.0, 15.5, true);
        // Crear un BuqueCarga con 50 contenedores
        BuqueCarga buque = new BuqueCarga("BUQ-404", 95.0, 5000.0, 50);
        System.out.println("Instancias creadas correctamente.\n");


        // 2. Prueba de Fuego (Validación)
        System.out.println("--- 2. Prueba de Fuego (Validación de Setters) ---");
        System.out.println("Intentando usar setCombustible(-20) en el camión...");
        camion.setCombustible(-20);
        
        // El resultado debe ser 0, demostrando el éxito del Setter
        System.out.println("Valor actual del combustible en el camión: " + camion.getCombustible());
        if (camion.getCombustible() == 0) {
            System.out.println("ÉXITO: El Setter protegió el atributo asignando 0.");
        } else {
            System.out.println("FALLO: El Setter no validó correctamente el valor negativo.");
        }
        
        // Validación extra de capacidad de carga negativa
        System.out.println("\nIntentando asignar capacidad de carga negativa (-5.0)...");
        camion.setCapacidadCarga(-5.0);
        System.out.println();


        // 3. Demostración de Polimorfismo
        System.out.println("--- 3. Demostración de Polimorfismo ---");
        // Crear un ArrayList<Transporte> flota
        ArrayList<Transporte> flota = new ArrayList<>();
        
        // Restablecemos el combustible para simular el viaje en igualdad de condiciones
        camion.setCombustible(100.0);
        buque.setCombustible(100.0);

        // Agregar el camión y el buque a la lista
        flota.add(camion);
        flota.add(buque);
        
        System.out.println("Elementos agregados a la lista 'flota' de tipo ArrayList<Transporte>.");
        System.out.println("Combustible inicial establecido al 100.0%\n");

        // Usar un bucle for para que ambos viajen 100km
        System.out.println("Ejecutando viaje de 100km para toda la flota:");
        for (Transporte t : flota) {
            t.viajar(100);
            System.out.println("Nivel de combustible restante para [" + t.getIdTransporte() + "]: " + t.getCombustible() + "%");
            System.out.println("----------------------------------------------------------------");
        }

        // Nota de observación explícita
        System.out.println("\nNOTA DE OBSERVACIÓN:");
        System.out.println("Como se puede apreciar, el camión gastó más combustible (quedó con " + camion.getCombustible() + "%)");
        System.out.println("que el buque (quedó con " + buque.getCombustible() + "%) automáticamente gracias a la sobrescritura (@Override).");
        System.out.println("El camión consumió 20 unidades (doble por refrigeración), mientras que el buque consumió 10 unidades (consumo normal).\n");


        // Ejecución extra de métodos específicos de clases hijas
        System.out.println("--- 4. Demostración de Métodos Propios ---");
        buque.atracarEnPuerto();
        buque.mostrarDatos();
    }
}