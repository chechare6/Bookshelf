package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.bookshelf.R
import com.example.bookshelf.data.Libro

@Composable
fun MainScreen(
    librosUiState: LibrosUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    onBookClicked: (Libro) -> Unit
) {
    when(librosUiState) {
        is LibrosUiState.Loading -> LoadingScreen()
        is LibrosUiState.Success ->
            LibrosListScreen(
                libros = (librosUiState).libros,
                modifier = modifier
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    ),
                onBookClicked
            )
        else -> ErrorScreen(retryAction, modifier)
    }
}