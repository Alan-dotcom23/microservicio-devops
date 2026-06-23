package com.subscripciones.subcripciones.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.subscripciones.subcripciones.Model.Suscrpcion;
import com.subscripciones.subcripciones.Service.SuscripcionService;

/**
 * CONTROLADOR REST - API v1
 * Punto de entrada para las peticiones HTTP (GET, POST, PUT, DELETE).
 */
@RestController
@RequestMapping("/api/v1") // Prefijo global para todos los endpoints de este controlador
@CrossOrigin(origins = "*") // Permite peticiones desde tu HTML
public class SuscripcionController {

    @Autowired 
    private SuscripcionService suscripcionService;

    /**
     * Obtener todas las suscripciones.
     * GET http://localhost:8080/api/v1/buscarTodos
     */
    @GetMapping("/buscarTodos")
    public List<Suscrpcion> buscarTodos() {
        return suscripcionService.buscarTodos();
    }
      /**
     * Obtener todas las suscripciones.
     * GET http://localhost:8080/api/v1/holaMundo
     */
    @GetMapping("/holaMundo")
    public String holaMundo() {
        return "hola mundo";
    }
    /**
     * Crear una nueva suscripción.
     * Recibe un JSON en el cuerpo de la petición.
     */
    @PostMapping("/crear")
    public Suscrpcion crear(@RequestBody Suscrpcion suscrpcion) {
        suscripcionService.crear(suscrpcion);
        return suscrpcion;
    }
    
    /**
     * Actualizar una suscripción existente por ID.
     * @param id Identificador de la ruta.
     * @param suscrpcion Datos actualizados en el JSON.
     */
    @PutMapping("/actualizar/{id}")
    public Suscrpcion actualizar(@PathVariable int id, @RequestBody Suscrpcion suscrpcion) {
        // Aseguramos que el ID de la ruta sea el mismo del objeto para evitar inconsistencias
        suscrpcion.setId(id);
        suscripcionService.actualizar(suscrpcion);
        return suscrpcion;
    }

    /**
     * Buscar una suscripción específica.
     */
    @GetMapping("/buscarPorId/{id}")
    public Suscrpcion buscarPorID(@PathVariable int id) {
        return suscripcionService.buscarPorId(id);
    }

    /**
     * Filtrar suscripciones por categoría.
     */
    @GetMapping("/buscarPorCategoria/{cat}")
    public List<Suscrpcion> buscarPorCategoria(@PathVariable String cat) {
        return suscripcionService.buscarPorCategoria(cat);
    }

    /**
     * Listar solo los planes que están marcados como activos.
     */
    @GetMapping("/buscarActivos")
    public List<Suscrpcion> buscarActivos() {
        return suscripcionService.buscarActivos();
    }

    /**
     * Endpoint para alternar el estado (Toggle) de activo/inactivo.
     */
    @GetMapping("/suscripcion/{id}/activo")
    public String cambiarEstado(@PathVariable int id) {
        suscripcionService.actualizarEstado(id);
        return "Estado de suscripción " + id + " actualizado correctamente.";
    }

    /**
     * Eliminar una suscripción (Recordar: solo si está inactiva).
     */
    @DeleteMapping("/suscripcion/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        int resultado = suscripcionService.eliminar(id);
        if (resultado == 1) {
            return "Registro " + id + " eliminado con éxito.";
        } else {
            return "No se pudo eliminar: verifique que el ID exista y el plan esté INACTIVO.";
        }
    }
}