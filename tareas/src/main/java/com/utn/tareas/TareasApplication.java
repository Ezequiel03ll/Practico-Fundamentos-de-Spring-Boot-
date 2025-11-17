package com.utn.tareas;


import com.utn.tareas.model.Prioridad;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication implements CommandLineRunner {
    private final TareaService tareaService;
    private final MensajeService mensajeService;

    public TareasApplication(TareaService tareaService, MensajeService mensajeService){
        this.tareaService=tareaService;
        this.mensajeService=mensajeService;
    }
	public static void main(String[] args) {
		SpringApplication.run(TareasApplication.class, args);}

        @Override
        public void run(String... args){

        //1. Mostrar mensaje de bienvenida (usando MensajeService)
            mensajeService.mostrarBienvenida();
        //2. Mostrar la configuración actual
            System.out.println("\n--Configuracion Actual--");
            tareaService.imprimirConfiguracion();
        //3. Listar todas las tareas iniciales
            System.out.println("\n--Listando todas la tareas-- ");
            tareaService.listarTodo().forEach(System.out::println);
        //4. Agregar una nueva tarea
            System.out.println("\n--Agregando Nuevas Tareas--");
            tareaService.addTarea("Revisar documentación del proyecto", Prioridad.MEDIA);
            tareaService.addTarea("Organizar reuniones con el equipo", Prioridad.BAJA);
            tareaService.addTarea("Limpiar archivos temporales y logs antiguos", Prioridad.BAJA);
        //5. Listar tareas pendientes
            System.out.println("\n--Tareas Pendientes--");
            tareaService.tareasPendientes().forEach(System.out::println);
        //6. Marcar una tarea como completada, en este caso la tarea con id 2L estaba completada : en false ahora se hace marcamos como true
            System.out.println("\n--Marcando tareas completas--");
            tareaService.marcarCompletada(2L);
            tareaService.marcarCompletada(4L);
            tareaService.marcarCompletada(5L);
            tareaService.marcarCompletada(6L);
        //7. Mostrar estadísticas
            System.out.println("\n--Mostrando Estadisticas--");
            System.out.println(tareaService.obtenerEstadisticas());
        //8. Listar tareas completadas
            System.out.println("\n--Listando Tareas completas--");
            tareaService.tareasCompletadas().forEach(System.out::println);
        //9. Mostrar mensaje de despedida
            mensajeService.mostrarDespedida();

        }


}


