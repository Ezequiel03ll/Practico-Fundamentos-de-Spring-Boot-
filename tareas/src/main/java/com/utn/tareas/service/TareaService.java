package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {
    private TareaRepository tareaRepository;

    //archivo properties
    @Value("${app.nombre}")
    private String nombreAplicacion;

    @Value("${app.max-tareas}")
    private int maxTareas;

    @Value("${app.mostrar-estadisticas}")
    private boolean mostrarEstadisticas;

    // inyeccion de dependencias por constructor buenas practicas
    public TareaService(TareaRepository tareaRepository){
        this.tareaRepository=tareaRepository;
    }
    // meotod para agregar tareas nuevas con descripcion y prioridad
    public void addTarea(String descripcion, Prioridad prioridad){
        if (tareaRepository.findAll().size() >= maxTareas) {
            throw new RuntimeException("No se pueden agregar más tareas. Límite: " + maxTareas);
        }
        Tarea newTarea = new Tarea(null, descripcion, false, prioridad);
        tareaRepository.save(newTarea);
    }
    // metodo para listar tereas
    public List<Tarea> listarTodo(){
        return tareaRepository.findAll();
    }
    // metodo para listar solo tareas pendientes
    public List<Tarea> tareasPendientes(){
        return tareaRepository.findAll().stream()
                .filter(t -> !t.isCompletada())
                .collect(Collectors.toList());
    }
    // metodo para listar solo tareas completadas
    public List<Tarea> tareasCompletadas() {
        return tareaRepository.findAll().stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }
    // metodo para marcar una tarea como completada
    public boolean marcarCompletada(Long id) {
        return tareaRepository. findByID(id)
                .map(t -> {
                    t.setCompletada(true);
                    tareaRepository.save(t);
                    return true;
                })
                .orElse(false);
    }
    public String obtenerEstadisticas() {
        List<Tarea> todas = tareaRepository.findAll();
        long total = todas.size();
        long completadas = todas.stream().filter(Tarea::isCompletada).count();
        long pendientes = total - completadas;

        return String.format("Total Tareas: %d," +
                " Completadas: %d" +
                ", Pendientes: %d"
                , total, completadas, pendientes);
    }
    // imprimiendo propiedades
    public void imprimirConfiguracion() {
            System.out.println("""
            Configuracion de la App =
            Nombre: %s
            Máximo-Tareas: %d
            Mostrar Estadisticas: %b
            """.formatted(nombreAplicacion, maxTareas, mostrarEstadisticas));
        }

}
