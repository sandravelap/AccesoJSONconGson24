package models;


public class Alumno {
    private String curso;
    private String nombre;
    private Integer edad;

    public Alumno() {
    }

    public Alumno(String curso, String nombre, Integer edad) {
        this.curso = curso;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
