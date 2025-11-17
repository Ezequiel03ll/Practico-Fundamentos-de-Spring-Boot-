package com.utn.tareas.repository;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;


import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {
    private final List<Tarea> tareas=new CopyOnWriteArrayList<>();;
    private final AtomicLong autoId = new AtomicLong(1);
    public TareaRepository (){
        tareas.add(new Tarea(autoId.getAndIncrement(),"Realizar Practica de Spring Boot",true, Prioridad.ALTA));
        tareas.add(new Tarea(autoId.getAndIncrement(),"Hacer el test del proyecto",false, Prioridad.MEDIA));
        tareas.add(new Tarea(autoId.getAndIncrement(),"Documentar como se ejecuta",true, Prioridad.ALTA));
        tareas.add(new Tarea(autoId.getAndIncrement(),"Generar un Redme profesional ",false, Prioridad.ALTA));
    }
    // metodo para guardar una tarea con id automatico
    public void save(Tarea tarea){
        if (tarea.getId() == null) {
            tarea.setId(autoId.getAndIncrement());
            tareas.add(tarea);
        } else {
            tareas.removeIf(t -> t.getId().equals(tarea.getId()));
            tareas.add(tarea);
        }
    }
    //metodo para obtener todas las tereas
    public List<Tarea> findAll (){
        return Collections.unmodifiableList(tareas);
    }
    //metodo para buscar por ID
    public  Optional<Tarea> findByID(Long Id){
        for (Tarea t : tareas) {
            if (t.getId().equals(Id)){
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }
    //metodo para eliminar un tarea por ID
    public void deleteById(Long Id){
        tareas.removeIf(t -> Objects.equals(t.getId(), Id));

    }
}
