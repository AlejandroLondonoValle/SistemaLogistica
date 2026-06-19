# Desafío LogiTech 2.0 🚚⚓

Este repositorio contiene la solución completa para el desafío técnico **"LogiTech 2.0"**, un sistema de gestión y simulación logística desarrollado en **Java**. El objetivo principal del proyecto es demostrar la correcta aplicación de los pilares de la Programación Orientada a Objetos (POO), haciendo especial énfasis en el **encapsulamiento estricto**, la **herencia**, la **validación de datos en capas de acceso (Setters con lógica)** y el **polimorfismo** dinámico a través de la sobrescritura de métodos.

---

## 🛠️ Tecnologías y Estándares Utilizados

* **Lenguaje:** Java (JDK 8 o superior)
* **Paradigma:** Programación Orientada a Objetos (POO)
* **Estilo de Código:** Convenciones estándar de Java (CamelCase, encapsulamiento estricto con modificadores `private`).
* **Documentación:** Comentarios bajo el estándar de Javadoc para la descripción de clases y métodos de negocio.

---

## 🏗️ Arquitectura de Clases

El sistema se divide en un núcleo central y dos especializaciones logísticas según el medio de transporte:


```

[ Transporte (Clase Padre) ]
▲             ▲
│             │
┌───────┴──────┐   ┌──┴──────────┐
│CamionDeReparto│   │ BuqueCarga  │ (Clases Hijas)
└──────────────┘   └─────────────┘

```

### 1. Clase Padre: `Transporte` (El Núcleo)
Define las propiedades estructurales mínimas de cualquier vehículo en la flota.
* **Atributos Protegidos/Privados:** `idTransporte` (String), `combustible` (double), `capacidadCarga` (double).
* **Validaciones Clave:**
    * `setCombustible(double)`: Restringe el rango del valor para que se mantenga estrictamente entre `0` y `100`. Si detecta anomalías o desbordamientos inferiores a 0, inicializa el atributo de forma segura en `0`.
    * `setCapacidadCarga(double)`: Bloquea la asignación si el valor provisto es negativo, imprimiendo un error explícito por consola sin alterar el estado previo del atributo.
* **Método Base:** `viajar(int distancia)`, reduce de manera base `1` unidad de combustible por cada `10 km` recorridos.

### 2. Clases Hijas (Especialización)
* **`CamionDeReparto`:** Introduce el atributo `tieneRefrigeracion` (boolean). Realiza una **sobrescritura (@Override)** del método `viajar`. Si la refrigeración se encuentra encendida, el consumo logístico se duplica de manera automática (`2` unidades por cada `10 km`) debido al gasto del motor refrigerante.
* **`BuqueCarga`:** Introduce la gestión de volumen marítimo mediante `cantidadContenedores` (int). Implementa comportamientos únicos como `atracarEnPuerto()` y `mostrarDatos()`, calculando el costo total operativo del trayecto en USD.

---

## 🚀 Flujo de Implementación (`Main.java`)

La clase principal actúa como un entorno de pruebas automatizado que ejecuta secuencialmente los siguientes pasos para certificar la robustez del software:

1.  **Instanciación Segura:** Construcción controlada de un camión con refrigeración activa y de un buque de carga configurado con 50 contenedores utilizando llamadas explícitas a `super()`.
2.  **Prueba de Fuego (Validación de Estado):** Intento forzado de inyección de combustible corrupto (`-20`). El sistema mitiga el fallo asignando de forma segura `0`, demostrando que la capa lógica del *Setter* protege las reglas de negocio del objeto.
3.  **Demostración de Polimorfismo:** Agrupación de la flota heterogénea dentro de un único contenedor genérico (`ArrayList<Transporte>`). Mediante un bucle `for`, se invoca el método `viajar(100)` de manera unificada. El entorno demuestra en tiempo de ejecución cómo cada objeto reacciona de forma diferente según su implementación interna (el camión consume el doble de combustible que el buque automáticamente).

---

## 💻 Instrucciones de Ejecución

Para compilar y ejecutar el proyecto de forma local desde la terminal de comandos, sigue estos pasos:

1.  **Clonar o descargar** los archivos fuentes (`Transporte.java`, `CamionDeReparto.java`, `BuqueCarga.java`, `Main.java`) en un mismo directorio.
2.  Abrir la consola en la ruta del proyecto y compilar todos los archivos `.java`:
    ```bash
    javac *.java
    ```
3.  Ejecutar la clase principal para iniciar la simulación logística:
    ```bash
    java Main
    ```

---

## 📊 Ejemplo de Salida en Consola

Al ejecutar el programa, se desplegará el siguiente flujo de eventos:

```text
=== INICIANDO DESAFÍO LOGITECH 2.0 ===

--- 1. Instanciación Segura ---
Instancias creadas correctamente.

--- 2. Prueba de Fuego (Validación de Setters) ---
Intentando usar setCombustible(-20) en el camión...
Valor actual del combustible en el camión: 0.0
✅ ÉXITO: El Setter protegió el atributo asignando 0.

Intentando asignar capacidad de carga negativa (-5.0)...
❌ ERROR: La capacidad de carga no puede ser negativa (-5.0). Operación rechazada.


--- 3. Demostración de Polimorfismo ---
Elementos agregados a la lista 'flota' de tipo ArrayList<Transporte>.
Combustible inicial establecido al 100.0%

Ejecutando viaje de 100km para toda la flota:
🚚 Camión con Refrigeración Activa [CAM-789] viajando 100 km... (Consumo DUPLICADO: 20.0 unidades)
Nivel de combustible restante para [CAM-789]: 80.0%
----------------------------------------------------------------
🚌 Transporte [BUQ-404] viajando 100 km... (Consumo base estimado: 10.0 unidades)
Nivel de combustible restante para [BUQ-404]: 90.0%
----------------------------------------------------------------

💡 NOTA DE OBSERVACIÓN:
Como se puede apreciar, el camión gastó más combustible (quedó con 80.0%) que el buque (quedó con 90.0%) automáticamente gracias a la sobrescritura (@Override).

--- 4. Demostración de Métodos Propios ---
⚓ [PUERTO] El Buque de Carga [BUQ-404] ha atracado exitosamente. ¡Listo para la descarga de 50 contenedores!
============= DATOS DEL BUQUE =============
ID Transporte  : BUQ-404
Combustible    : 90.0 %
Capacidad Carga: 5000.0 Toneladas
Contenedores   : 50
Costo de Viaje : 7500.0 USD
===========================================

```
