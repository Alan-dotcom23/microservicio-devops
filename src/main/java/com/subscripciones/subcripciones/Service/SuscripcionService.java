package com.subscripciones.subcripciones.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.subscripciones.subcripciones.Model.Suscrpcion;
import com.subscripciones.subcripciones.Repository.SuscripcionRepository;

/**
 * CAPA DE SERVICIO: LÓGICA DE NEGOCIO
 * Aquí se aplican las reglas que el cliente (dueño del negocio) exige.
 */
@Service
public class SuscripcionService {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    public List<Suscrpcion> buscarTodos() {
        return suscripcionRepository.listarTodos();
    }

    public Suscrpcion buscarPorId(int id) {
        return suscripcionRepository.buscarPorId(id);
    }

    public List<Suscrpcion> buscarPorCategoria(String categoria) {
        // Podríamos agregar una validación para asegurar que la categoría no venga vacía
        return suscripcionRepository.buscarCategorias(categoria);
    }

    /**
     * REGLA DE NEGOCIO: CREACIÓN
     * Solo se guardan suscripciones con precio positivo y nombre de plan existente.
     * @return 1 si se creó con éxito, 0 si falló la validación.
     */
    public int crear(Suscrpcion suscrpcionCreate) {
        // Validación de precio y que el nombre del plan no sea nulo/vacío
        if (suscrpcionCreate.getPrice() > 0 && suscrpcionCreate.getPlanName() != null) {
            suscripcionRepository.save(suscrpcionCreate);  
            return 1;
        } else {
            return 0; // Error de lógica de negocio
        }
    }

    public Suscrpcion actualizar(Suscrpcion susActualizar) {
        // Aquí podrías validar que el ID exista antes de intentar actualizar
        return suscripcionRepository.actualizar(susActualizar);
    }

    /**
     * REGLA DE NEGOCIO: ELIMINACIÓN
     * La lógica de "solo eliminar si está inactivo" ya viene desde el Repository.
     */
    public int eliminar(int id) {
        return suscripcionRepository.eliminarSuscripcion(id);
    }

    public List<Suscrpcion> buscarActivos() {
        return suscripcionRepository.buscarActivos();
    }

    /**
     * TOGGLE DE ESTADO
     * Permite activar o desactivar una suscripción rápidamente.
     */
    public void actualizarEstado(int id) {
        suscripcionRepository.cambiarActivo(id);
    }
}