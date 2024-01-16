package com.hgc.api_dogs.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgc.api_dogs.model.BreedsResponse
import com.hgc.api_dogs.model.DogApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// ViewModel que maneja la lógica de negocio y la llamada a la API
class DogViewModel : ViewModel() {
    // Observable que almacenará la respuesta de la API
    var breeds by mutableStateOf<BreedsResponse?>(null)

    // Configuración de Retrofit para realizar solicitudes HTTP
    private val apiService = Retrofit.Builder()
        .baseUrl("https://dog.ceo/") // URL base de la API
        .addConverterFactory(GsonConverterFactory.create()) // Convertidor para JSON
        .build()
        .create(DogApiService::class.java) // Creación del servicio API

    // Función para obtener las razas de perros
    fun getBreeds() {
        viewModelScope.launch { // Lanzamiento en el alcance del ViewModel
            breeds = apiService.getAllBreeds() // Asignación del resultado a 'breeds'
        }
    }
}