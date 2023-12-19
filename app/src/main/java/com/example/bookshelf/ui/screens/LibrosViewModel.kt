package com.example.bookshelf.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.LibrosApplication
import com.example.bookshelf.data.Libro
import com.example.bookshelf.data.LibrosRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface LibrosUiState {
    data class Success(val libros: List<Libro>) : LibrosUiState
    object Error : LibrosUiState
    object Loading : LibrosUiState
}

class LibrosViewModel(
    private val librosRepository: LibrosRepository
) : ViewModel() {

    var librosUiState: LibrosUiState by mutableStateOf(LibrosUiState.Loading)
        private set

    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    init {
        getLibros("jazz+history")
    }

    fun getLibros(query: String = "Jazz History", maxResults: Int = 10) {
        viewModelScope.launch {
            librosUiState = LibrosUiState.Loading
            librosUiState = try {
                LibrosUiState.Success(librosRepository.getLibros(query, maxResults))
            } catch (e: IOException) {
                e.printStackTrace()
                LibrosUiState.Error
            } catch (e: HttpException) {
                e.printStackTrace()
                LibrosUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[APPLICATION_KEY] as LibrosApplication)
                val bookshelfRepository = application.container.librosRepository
                LibrosViewModel(librosRepository = bookshelfRepository)
            }
        }
    }

    enum class SearchWidgetState {
        OPENED,
        CLOSED
    }

}