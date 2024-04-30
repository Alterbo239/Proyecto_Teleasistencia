package Servicio;

/**
 * La clase ServicioaDomicilio representa un servicio a domicilio en el sistema.
 */
public class ServicioaDomicilio {
    /**
     * El tipo de servicio a domicilio.
     */
    private String tipoServicio;

    /**
     * Constructor por defecto de la clase ServicioaDomicilio.
     */
    public ServicioaDomicilio() {
    }

    /**
     * Obtiene el tipo de servicio a domicilio.
     * @return El tipo de servicio a domicilio.
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Establece el tipo de servicio a domicilio.
     * @param tipoServicio El tipo de servicio a domicilio a establecer.
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}