package com.example.bookshelf.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.LibrosApplication
import com.example.bookshelf.data.LibrosRepository
import com.example.bookshelf.model.Libro
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface LibrosUiState {
    data class Success(val libros: List<Libro>) : LibrosUiState
    object Error : LibrosUiState
    object Loading : LibrosUiState
}

class LibrosViewModel(private val librosRepository: LibrosRepository) : ViewModel() {

    var librosUiState: LibrosUiState by mutableStateOf(LibrosUiState.Loading)
        private set

    init {
        getLibros()
    }

    fun getLibros() {
        viewModelScope.launch {
            librosUiState = LibrosUiState.Loading
            librosUiState = try {
                LibrosUiState.Success(librosRepository.getLibros())
            } catch (e: IOException) {
                LibrosUiState.Error
            } catch (e: HttpException) {
                LibrosUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as LibrosApplication)
                val librosRepository = application.container.librosRepository
                LibrosViewModel(librosRepository = librosRepository)
            }
        }
    }
}