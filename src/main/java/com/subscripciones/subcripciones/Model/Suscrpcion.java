package com.subscripciones.subcripciones.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modelo que representa un Plan de Suscripción en el sistema.
 * Define la estructura de datos que se enviará y recibirá a través de la API.
 */
@Data // Genera automáticamente: Getters, Setters, toString, equals y hashCode.
@AllArgsConstructor // Constructor con todos los atributos: Útil para cargar datos iniciales (Seed).
@NoArgsConstructor // Constructor vacío: Necesario para que Jackson transforme el JSON en Objeto.
public class Suscrpcion {

    // Identificador único de la suscripción (PK simulada)
    private int id;

    // Nombre comercial del plan (Ej: "Premium", "Básico", "Familiar")
    private String planName;

    // Costo mensual del plan en moneda local
    private int price;

    // Lógica de Negocio: Cantidad máxima de dispositivos que pueden usar la cuenta en simultáneo
    private int maxScreen;

    /**
     * Estado del plan. 
     * Se usa 'Boolean' (Objeto) en lugar de 'boolean' (Primitivo) 
     * para permitir estados nulos antes de la validación.
     */
    private Boolean isActive;

    // Categoría del servicio (Ej: "Streaming", "Software", "Música")
    private String category;
}