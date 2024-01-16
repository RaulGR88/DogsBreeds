package com.hgc.api_dogs.model

// Modelo de Datos - Representa la respuesta de la API
data class BreedsResponse(val message: Map<String, List<String>>, val status: String)
