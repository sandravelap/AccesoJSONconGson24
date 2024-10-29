package controllers;

import com.google.gson.Gson;
import models.Instituto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeerInstiJSON {
    public String leerJson(Path p){
        StringBuilder mensaje = new StringBuilder();
        String stringInsti;
        Instituto instiNuevo = new Instituto();
        //si el fichero es legible lo cargamos en un String
        //ya que Gson convierte Strings a Json, el acceso al fichero es independiente
        Gson gson = new Gson();
        if (Files.isReadable(p)){
            try {
                stringInsti = Files.readString(p);
                instiNuevo = gson.fromJson(stringInsti, Instituto.class);
                mensaje.append(gson.toJson(instiNuevo));
            } catch (IOException e) {
                mensaje.append("Error al leer el archivo"+e.getMessage());
            }
        }else{
            mensaje.append("El archivo no se puede leer");
        }
        return mensaje.toString();
    }
}
