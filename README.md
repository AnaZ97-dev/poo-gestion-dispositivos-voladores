# Programación Orientada a Objetos: Gestión de Dispositivos Voladores (Java)

Proyecto de programación en Java que aplica los principios de la **Programación Orientada a Objetos (POO)** para la gestión de una flota de dispositivos voladores. Incluye la creación de objetos, el control de su estado (altitud y posición) y el cálculo de su consumo energético.

## 🛠️ Tecnologías y Herramientas
*   **Lenguaje:** Java (JDK 17)
*   **IDE:** Apache NetBeans
*   **Conceptos:** POO, Clases, Objetos, Encapsulación, Excepciones, Métodos Estáticos, Documentación Javadoc.

## 🎯 Funcionalidades y Conceptos Aplicados

1.  **Atributos y Constantes:**
    *   Uso de **constantes públicas** (`ALTITUD_MAXIMA`, `RANGO_OPERACION`, `MODELO_DEFECTO`, `TIPO_MOTOR_DEFECTO`) y atributos estáticos privados (`numDispositivos`).
2.  **Constructores:**
    *   Constructor con parámetros que valida el modelo y el tipo de motor, lanzando `NullPointerException` o `IllegalArgumentException` si los datos son incorrectos.
    *   Constructor por defecto que llama al anterior con valores predefinidos.
    *   **Método fábrica** (`crearArrayDispositivos`) que crea un array de objetos validando la cantidad (entre 1 y 20).
3.  **Getters y Setters:**
    *   Métodos de consulta y modificación del estado del objeto (`altitud`, `posX`, `posY`).
    *   Los setters controlan los rangos permitidos, asignando 0.0 o 0 si el valor está fuera de rango.
4.  **Métodos de Acción:**
    *   `desplazar()`: Modifica la posición del dispositivo, lanzando `IllegalStateException` si el desplazamiento supera el rango de operación.
    *   `calcularConsumo()`: Calcula el consumo según la distancia y el tipo de motor, lanzando excepciones si la distancia es negativa o el motor es incorrecto.
5.  **Documentación:**
    *   Código completamente documentado con **Javadoc** (`@param`, `@return`, `@throws`, `@author`).

## 🚀 Cómo ejecutar el proyecto
1. Abre el proyecto en Apache NetBeans.
2. Ejecuta las clases de prueba (`TestEj0102`, `TestEj03`, `TestEj04`, `TestEj05`) para ver el comportamiento del programa.
