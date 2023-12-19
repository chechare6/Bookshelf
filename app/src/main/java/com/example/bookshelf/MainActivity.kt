package com.example.bookshelf

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.content.ContextCompat
import com.example.bookshelf.ui.BookshelfApp
import com.example.bookshelf.ui.theme.BookshelfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfTheme {
                    BookshelfApp(
                        onBookClicked = {
                            ContextCompat.startActivity(
                                this,
                                Intent(Intent.ACTION_VIEW, Uri.parse(it.previewLink)),
                                null
                            )
                        }
                    )
                }
            }
        }
    }