package com.utn.tareas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
public class Tarea {
    private Long Id;
    private String descripcion;
    private boolean completada;
    private Prioridad prioridad;
    @Override
    public String toString(){
        return " Tareas["+"ID :"+Id+
                ", Descripcion :"+descripcion+
                ", Completada :"+completada+
                ", Prioridad :"+prioridad+']';


    }
}
