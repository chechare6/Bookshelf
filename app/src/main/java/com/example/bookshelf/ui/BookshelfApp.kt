package com.example.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.ui.screens.LibrosViewModel
import com.example.bookshelf.ui.screens.MainAppBar
import com.example.bookshelf.ui.screens.MainScreen

@Composable
fun BookshelfApp() {
    val librosViewModel: LibrosViewModel = viewModel(factory = LibrosViewModel.Factory)
    val searchWidgetState = librosViewModel.searchWidgetState
    val searchTextState = librosViewModel.searchTextState
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState.value,
                searchTextState = searchTextState.value,
                onTextChange = {
                    librosViewModel.updateSearchTextState(newValue = it)
                },
                onCloseClicked = {
                    librosViewModel.updateSearchWidgetState(newValue = LibrosViewModel.SearchWidgetState.CLOSED)
                },
                onSearchClicked = {
                    librosViewModel.getLibros(it)
                },
                onSearchTriggered = {
                    librosViewModel.updateSearchWidgetState(newValue = LibrosViewModel.SearchWidgetState.OPENED)
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen(
                librosUiState = librosViewModel.librosUiState,
                retryAction = librosViewModel::getLibros,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp),
                contentPadding = it
            )
        }
    }
}