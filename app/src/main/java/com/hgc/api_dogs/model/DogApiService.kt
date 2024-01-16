package com.hgc.api_dogs.model

import retrofit2.http.GET

// Interfaz para definir los endpoints de la API usando Retrofit
interface DogApiService {
    @GET("https://dog.ceo/api/breeds/list/all\n")
    suspend fun getAllBreeds(): BreedsResponse // Función suspendida para llamadas asíncronas
}