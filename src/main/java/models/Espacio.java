package models;

public class Espacio {
    private String nombre;
    private String tipo;
    private String municipios;
    private String pais;

    public Espacio() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMunicipios() {
        return municipios;
    }

    public void setMunicipios(String municipios) {
        this.municipios = municipios;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
