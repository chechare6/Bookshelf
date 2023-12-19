package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.bookshelf.R

@Composable
fun MainScreen(
    librosUiState: LibrosUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues
) {
    when(librosUiState) {
        is LibrosUiState.Loading -> LoadingScreen(modifier.size(200.dp))
        is LibrosUiState.Success ->
            LibrosListScreen(
                libros = (librosUiState).libros,
                modifier = modifier
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    )
            )
        else -> ErrorScreen(retryAction, modifier)
    }
}