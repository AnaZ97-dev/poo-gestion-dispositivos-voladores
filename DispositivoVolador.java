package tarea05;

// ------------------------------------------------------------
//                   Clase DispositivoVolador
// ------------------------------------------------------------
/**
 * Clase que representa un <b>dispositivo volador que tiene la capacidad de
 * volar</b>.
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar la información
 * relativa al estado del dispositivo y la información de su desplazamiento.
 * </p>
 * <p>
 * La clase también posee información general (estática), relativa a los
 * diferentes dispositivos que existen, como:
 * </p>
 * <ul>
 * <li><b>cantidad total de dispositivos </b> que existen.</li>
 * </ul>
 *
 * @author Ana Zafra Vallejo
 */
public class DispositivoVolador {

    // ------------------------------------------------------------------------
    // Atributos estáticos públicos (inmutables)
    // Pueden ser accedidos desde cualquier caso
    // ------------------------------------------------------------------------
    /**
     * Altitud máxima por defecto: {@value} metros.
     */
    public static final double ALTITUD_MAXIMA = 50.0;

    /**
     * Rango de operación por defecto: {@value}.
     */
    public static final int RANGO_OPERACION = 100;

    /**
     * Modelo por defecto: {@value}.
     */
    public static final String MODELO_DEFECTO = "Dispositivo Generico";

    /**
     * Tipo de motor por defecto: {@value}.
     */
    public static final String TIPO_MOTOR_DEFECTO = "Electrico";

    // ------------------------------------------------------------------------
    // Atributos estáticos privados (mutables)
    // No dependen de instancias de objetos particulares y sólo pueden 
    // modificarse desde la propia clase
    // ------------------------------------------------------------------------
    /**
     * Número total de dispositivos creados hasta el momento.
     */
    private static int numDispositivos = 0;

    // ------------------------------------------------------------------------
    // Atributos de objeto inmutables (privados)
    // Representan el estado del objeto pero no pueden cambiar su valor
    // ------------------------------------------------------------------------
    /**
     * Modelo del dispositivo.
     */
    private final String modelo;

    /**
     * Tipo de motor del dispositivo.
     */
    private final String tipoMotor;

    // ------------------------------------------------------------------------
    // Atributos de objeto variables (privados)
    // Representan el estado del objeto y pueden cambiar su valor
    // ------------------------------------------------------------------------
    /**
     * Altitud actual del dispositivo.
     */
    private double altitud;

    /**
     * Posición en el eje X. Cambio a Int de vez Double debido a la
     * especificación de getters/setters
     */
    private int posX;

    /**
     * Posición en el eje Y. * Cambio a Int de vez Double debido a la
     * especificación de getters/setters
     */
    private int posY;

    // ------------------------------------------------------------------------
    // Constructores de la clase
    // ------------------------------------------------------------------------
    // Constructor con dos parámetros
    /**
     * Constructor con 2 parámetros. Crea un objeto DispositivoVolador y
     * almacena los datos básicos del dispositivo (<b>modelo</b> y
     * <b>tipoMotor</b>)
     *
     * @param modelo modelo del dispositivo: "D-01", "H-02"
     * @param tipoMotor tipo de motor del dispositivo: "Electrico", "Combustion"
     * o "Hibrido"
     * @throws NullPointerException Si alguno de los parámetros es nulo.
     * @throws IllegalArgumentException Si alguno de los parámetros no es
     * válido.
     */
    public DispositivoVolador(String modelo, String tipoMotor) throws NullPointerException, IllegalArgumentException {
        // Validaciones de MODELO
        if (modelo == null) {
            throw new NullPointerException("El modelo del dispositivo no puede ser nulo.");
        }
        if (modelo.isEmpty()) {
            throw new IllegalArgumentException("El modelo del dispositivo no puede estar vacío.");
        }

        // Validaciones de TIPO DE MOTOR
        if (tipoMotor == null) {
            throw new NullPointerException("El tipo de motor no puede ser nulo.");
        }
        if (tipoMotor.isEmpty()) {
            throw new IllegalArgumentException("El tipo de motor no puede estar vacío.");
        }

        // Asignación de atributos inmutables
        this.modelo = modelo;

        // Verificamos si el tipo de motor es válido, si no, asignamos el defecto
        if (tipoMotor.equals("Electrico") || tipoMotor.equals("Combustion") || tipoMotor.equals("Hibrido")) {
            this.tipoMotor = tipoMotor;
        } else {
            this.tipoMotor = TIPO_MOTOR_DEFECTO;
        }

        // Inicialización de atributos de estado (ubicación) a cero.
        this.altitud = 0.0;
        this.posX = 0; // Cambio de 0.0 a 0 debido a la especificación de getters/setters */
        this.posY = 0; // Cambio de 0.0 a 0 debido a la especificación de getters/setters */

        // Actualización del atributo estático
        numDispositivos++;
    }

    // Constructor por defecto
    /**
     * Constructor sin parámetros. Crea un objeto DispositivoVolador con los
     * parámetros por defecto.
     */
    public DispositivoVolador() {
        this(MODELO_DEFECTO, TIPO_MOTOR_DEFECTO);
    }

    // Método fábrica
    /**
     * Método fábrica que crea un array de objetos DispositivoVolador, que
     * representa, cada uno de ellos, a un dispositivo. Internamente, crea un
     * array de referencias a objetos de tipo DispositivoVolador con los
     * parámetros por omisión.
     *
     * @param cantidad tamaño del array.
     * @return array de referencias a los dispositivos.
     * @throws IllegalArgumentException Si la cantidad es inferior a 1 o
     * superior a 20.
     */
    public static DispositivoVolador[] crearArrayDispositivos(int cantidad) throws IllegalArgumentException {
        if (cantidad < 1 || cantidad > 20) {
            throw new IllegalArgumentException("Número de dispositivos incorrecto: " + cantidad
                    + ". Debe ser mayor o igual que 1 y menor o igual que 20");
        }

        DispositivoVolador[] arrayDispositivos = new DispositivoVolador[cantidad];

        for (int i = 0; i < cantidad; i++) {
            arrayDispositivos[i] = new DispositivoVolador();
        }

        return arrayDispositivos;
    }

    // ------------------------------------------------------------------------
    // Getters (consultan el estado del objeto)
    // ------------------------------------------------------------------------
    // Getters que consultan el estado en un momento dado
    /**
     * Devuelve el modelo del dispositivo.
     *
     * @return String modelo del dispositivo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Devuelve el tipo de motor del dispositivo.
     *
     * @return String tipo de motor del dispositivo.
     */
    public String getTipoMotor() {
        return tipoMotor;
    }

    /**
     * Devuelve la altitud actual del dispositivo.
     *
     * @return double altitud actual del dispositivo.
     */
    public double getAltitudActual() {
        return altitud;
    }

    /**
     * Devuelve la posición en el eje X del dispositivo.
     *
     * @return int posición en el eje X del dispositivo.
     */
    public int getPosicionX() {
        return posX;
    }

    /**
     * Devuelve la posición en el eje Y del dispositivo.
     *
     * @return posición en el eje Y del dispositivo.
     */
    public int getPosicionY() {
        return posY;
    }

    // Métodos getter estáticos (acceden a los atributos estáticos de la clase)
    /**
     * Devuelve el total de dispositivos creados.
     *
     * @return int total de dispositivos creados.
     */
    public static int getNumDispositivos() {
        return numDispositivos;
    }

    // ------------------------------------------------------------------------
    // Setters (modifican el estado del objeto)
    // ------------------------------------------------------------------------
    /**
     * Modifica la altitud actual del dispositivo.
     *
     * @param altitudActual Altitud actual del dispositivo.
     */
    public void setAltitudActual(double altitudActual) {
        if (altitudActual < 0 || altitudActual > ALTITUD_MAXIMA) {
            this.altitud = 0.0;
        } else {
            this.altitud = altitudActual;
        }
    }

    /**
     * Modifica la posición en el eje X del dispositivo.
     *
     * @param posicionX posición en el eje X del dispositivo.
     */
    public void setPosicionX(int posicionX) {
        if (Math.abs(posicionX) > RANGO_OPERACION) {
            this.posX = 0;
        } else {
            this.posX = posicionX;
        }
    }

    /**
     * Modifica la posición en el eje Y del dispositivo.
     *
     * @param posicionY posición en el eje Y del dispositivo
     */
    public void setPosicionY(int posicionY) {
        if (Math.abs(posicionY) > RANGO_OPERACION) {
            this.posY = 0;
        } else {
            this.posY = posicionY;
        }
    }

    // ------------------------------------------------------------------------
    // Métodos de acción (almacenan la lógica y el comportamiento del objeto)
    // ------------------------------------------------------------------------
    /**
     * Realiza el desplazamiento del dispositivo en los ejes X e Y.
     *
     * @param desplazamientoX posiciones que se desplaza en el eje X.
     * @param desplazamientoY posiciones que se desplaza en el eje Y.
     * @throws IllegalStateException Si el desplazamiento implica salir del
     * rango de operación del dispositivo.
     */
    public void desplazar(int desplazamientoX, int desplazamientoY) throws IllegalStateException {
        // Comprobar rango en X
        // Calculamos dónde acabaría (posición actual + desplazamiento).
        if (Math.abs(this.posX + desplazamientoX) > RANGO_OPERACION) {
            throw new IllegalStateException("El dispositivo se ha intentado desplazar fuera de su rango de operación en el eje X.");
        }
        // Comprobar rango en Y
        // Hacemos lo mismo para Y.
        if (Math.abs(this.posY + desplazamientoY) > RANGO_OPERACION) {
            throw new IllegalStateException("El dispositivo se ha intentado desplazar fuera de su rango de operación en el eje Y.");
        }

        // Si ambos son válidos, actualizamos.
        this.posX += desplazamientoX;
        this.posY += desplazamientoY;
    }

    /**
     * Calcula el consumo del dispositivo según la distancia recorrida y el tipo
     * de motor que tiene.
     *
     * @param distanciaRecorrida distancia recorrida por el dispositivo.
     * @return double consumo del dispositivo.
     * @throws IllegalArgumentException Si la distancia recorrida es negativa.
     * @throws IllegalStateException Si el tipo de motor del dispositivo es
     * incorrecto.
     */
    public double calcularConsumo(int distanciaRecorrida) throws IllegalArgumentException, IllegalStateException {
        if (distanciaRecorrida < 0) {
            throw new IllegalArgumentException("La distancia recorrida no puede ser negativa.");
        }

        double factor;
        switch (this.tipoMotor) {
            case "Electrico":
                factor = 1.2;
                break;
            case "Combustion":
                factor = 2.0;
                break;
            case "Hibrido":
                factor = 1.5;
                break;
            default:
                throw new IllegalStateException("Tipo de motor incorrecto.");
        }
        return distanciaRecorrida * factor;
    }

    // ------------------------------------------------------------------------
    // Método toString (imprime el estado del objeto)
    // ------------------------------------------------------------------------
    /**
     * Devuelve el estado actual del objeto en un mensaje formateado en un tipo
     * String.
     *
     * @return String estado actual del objeto.
     */
    @Override
    public String toString() {
        return String.format("[Modelo=%s, Tipo de motor=%s, Altitud=%.2f metros, Posicion en X=%d, Posicion en Y=%d]",
                this.modelo,
                this.tipoMotor,
                this.altitud,
                this.posX,
                this.posY);
    }
}
