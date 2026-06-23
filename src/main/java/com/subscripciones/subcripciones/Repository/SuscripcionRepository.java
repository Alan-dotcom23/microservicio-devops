package com.subscripciones.subcripciones.Repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.subscripciones.subcripciones.Model.Suscrpcion;

/**
 * REPOSITORIO DE SUSCRIPCIONES
 * Gestiona el almacenamiento en memoria de los planes disponibles.
 */
@Repository
public class SuscripcionRepository {

    // Simulación de la tabla 'suscripciones'
    private List<Suscrpcion> listaSuscrpcions = new ArrayList<>();

    public SuscripcionRepository(){
        listaSuscrpcions.add(new Suscrpcion(1,"Basic", 1000,2, true, "personal"));
        listaSuscrpcions.add(new Suscrpcion(2,"PersonalPro", 2000,3, true, "personal"));
        listaSuscrpcions.add(new Suscrpcion(3,"Family", 2000,5, true, "family"));
        listaSuscrpcions.add(new Suscrpcion(4,"FamilyPro", 3000,10, true, "family"));
        listaSuscrpcions.add(new Suscrpcion(5,"Pro", 4000,20, true, "pro"));
    }
    /**
     * SELECT * FROM suscripciones
     */
    public List<Suscrpcion> listarTodos() {
        return listaSuscrpcions;
    }

    /**
     * INSERT INTO suscripciones ...
     * @param suscrpcion Objeto a persistir.
     * @return El objeto guardado.
     */
    public Suscrpcion save(Suscrpcion suscrpcion) {
        listaSuscrpcions.add(suscrpcion);
        return suscrpcion;
    }

    /**
     * SELECT * FROM suscripciones WHERE id = ?
     */
    public Suscrpcion buscarPorId(int id) {
        for (Suscrpcion sub : listaSuscrpcions) {
            if (sub.getId() == id) {
                return sub; // Retorna el hallazgo de inmediato
            }
        }
        return null; // Si no lo encuentra, retorna nulo (se gestionará en el Service)
    }

    /**
     * SELECT * FROM suscripciones WHERE is_active = true
     */
    public List<Suscrpcion> buscarActivos() {
        List<Suscrpcion> listaActivos = new ArrayList<>();
        for (Suscrpcion sub : listaSuscrpcions) {
            // Verificamos que no sea nulo antes de comparar
            if (sub.getIsActive() != null && sub.getIsActive()) {
                listaActivos.add(sub); 
            }
        }
        return listaActivos;
    }

    /**
     * SELECT * FROM suscripciones WHERE category = ?
     */
    public List<Suscrpcion> buscarCategorias(String categoria) {
        List<Suscrpcion> listaCategoria = new ArrayList<>();
        for (Suscrpcion sub : listaSuscrpcions) {
            // equalsIgnoreCase para que no falle por mayúsculas/minúsculas
            if (sub.getCategory().equalsIgnoreCase(categoria)) {
                listaCategoria.add(sub); 
            }
        }
        return listaCategoria;
    }

    /**
     * UPDATE suscripciones SET ... WHERE id = ?
     */
    public Suscrpcion actualizar(Suscrpcion actualSuscrpcion) {
        for (int i = 0; i < listaSuscrpcions.size(); i++) {
            if (listaSuscrpcions.get(i).getId() == actualSuscrpcion.getId()) {
                listaSuscrpcions.set(i, actualSuscrpcion);
                break; // Importante: salir del ciclo al encontrarlo
            }
        }
        return actualSuscrpcion;
    }

    /**
     * DELETE FROM suscripciones WHERE id = ? AND is_active = false
     * REGLA: Solo se pueden eliminar planes que estén inactivos.
     * @return 1 si eliminó, 0 si no pudo (porque está activo o no existe).
     */
    public int eliminarSuscripcion(int id) {
        for (int i = 0; i < listaSuscrpcions.size(); i++) {
            Suscrpcion sub = listaSuscrpcions.get(i);
            if (sub.getId() == id && !sub.getIsActive()) {
                listaSuscrpcions.remove(i);
                return 1;
            }
        }
        return 0;
    }

    /**
     * Lógica de Switcher: Cambia el estado actual del plan (Toggle).
     */
    public void cambiarActivo(int id) {
        for (Suscrpcion sub : listaSuscrpcions) {
            if (sub.getId() == id) {
                // Invertimos el valor booleano
                sub.setIsActive(!sub.getIsActive());
                break;
            }
        }
    }
}