package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Alumno;
import models.Instituto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class EscribirInstiJSON {
    public String escribir(Path p){
        StringBuilder mensaje = new StringBuilder();
        //variable para crear la ruta de destino con carpeta y nombre
        Path pOutJson;
        //variable para guardar el String con el texto a volcar
        String instiString;
        //creamos la ruta al archivo en la carpeta de destino que nos da el ususario:
        pOutJson= Path.of(p.toFile().getPath(),"salidaInsti.json");
        //creamos un Instituto a volcar en el archivo de salida
        Instituto instiOut = new Instituto();
        instiOut.setNombre("IES Biello Aragón");
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Robótica", "Lola", 18));
        alumnos.add(new Alumno("Electricidad", "Martin", 19));
        alumnos.add(new Alumno("Administrativo", "Nuria", 20));
        instiOut.setAlumnos(alumnos);

        try {
            //si el fichero no existe lo creamos
            if (!Files.exists(pOutJson) && Files.isWritable(p)) {
                Files.createFile(pOutJson);
            }
            //creamos el constructor de parseadores gson
            GsonBuilder gsonBuilder = new GsonBuilder();
            //creamos el gson con la opción de indentar correctamente al generar el JSON
            //podríamos instanciar un Gson directamente pero no con la opción prettyprinting
            Gson gson =  gsonBuilder.setPrettyPrinting().create();
            //generamos con Gson el String a volcar en el archivo
            instiString = gson.toJson(instiOut);
            Files.writeString(pOutJson, instiString);
            mensaje.append("Archivo generado correctamente");
        } catch (IOException e) {
            mensaje.append("Ocurrió un problema al leer el archivo");
        }




        return mensaje.toString();
    }
}
