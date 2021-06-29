package com.guatex.sacod_reporteguias.entities;

public class E_AjusteCOD_ACR {

    private String Correlativvo;
    private String Tipo;
    private String CodCob;
    private String Aplicado;
    private String Autorizacion;
    private String Descripcion;
    private String Noguia;
    private String Monto;

	private String notNull(String var) {
		return var != null ? var.trim() : "";
	}
    
    /**
     * @return the Correlativvo
     */
    public String getCorrelativvo() {
        return notNull(Correlativvo);
    }

    /**
     * @param Correlativvo the Correlativvo to set
     */
    public void setCorrelativvo(String Correlativvo) {
        this.Correlativvo =notNull(Correlativvo);
    }

    /**
     * @return the Tipo
     */
    public String getTipo() {
        return notNull(Tipo);
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(String Tipo) {
        this.Tipo = notNull(Tipo);
    }

    /**
     * @return the CodCob
     */
    public String getCodCob() {
        return notNull(CodCob);
    }

    /**
     * @param CodCob the CodCob to set
     */
    public void setCodCob(String CodCob) {
        this.CodCob = notNull(CodCob);
    }

    /**
     * @return the Aplicado
     */
    public String getAplicado() {
        return notNull(Aplicado);
    }

    /**
     * @param Aplicado the Aplicado to set
     */
    public void setAplicado(String Aplicado) {
        this.Aplicado = notNull(Aplicado);
    }

    /**
     * @return the Autorizacion
     */
    public String getAutorizacion() {
        return notNull(Autorizacion);
    }

    /**
     * @param Autorizacion the Autorizacion to set
     */
    public void setAutorizacion(String Autorizacion) {
        this.Autorizacion = notNull(Autorizacion);
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return notNull(Descripcion);
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = notNull(Descripcion);
    }

    /**
     * @return the Noguia
     */
    public String getNoguia() {
        return notNull(Noguia);
    }

    /**
     * @param Noguia the Noguia to set
     */
    public void setNoguia(String Noguia) {
        this.Noguia = notNull(Noguia);
    }

    /**
     * @return the Monto
     */
    public String getMonto() {
        return notNull(Monto);
    }

    /**
     * @param Monto the Monto to set
     */
    public void setMonto(String Monto) {
        this.Monto = notNull(Monto);
    }
}