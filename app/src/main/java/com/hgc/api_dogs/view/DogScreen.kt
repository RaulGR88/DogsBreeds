import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hgc.api_dogs.viewmodel.DogViewModel

// Composable para mostrar la pantalla
@Composable
fun DogScreen(viewModel: DogViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    // Obtiene las razas del ViewModel y las transforma a una lista
    val breeds = viewModel.breeds?.message?.toList()

    // Columna para alinear elementos verticalmente
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Botón para cargar las razas
        Button(onClick = { viewModel.getBreeds() }) {
            Text("Cargar razas de perros")
        }

        // Verifica si hay razas disponibles y las muestra
        breeds?.let {
            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                items(items = it) { breed ->
                    // Tarjeta para cada raza
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = 4.dp
                    ) {
                        // Columna para mostrar la raza y sus subrazas
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            // Nombre de la raza
                            Text(breed.first, style = MaterialTheme.typography.h6)
                            // Lista de subrazas, si las hay
                            breed.second.forEach { subBreed ->
                                Text(" - $subBreed", style = MaterialTheme.typography.body1)
                            }
                        }
                    }
                }
            }
        }
    }
}