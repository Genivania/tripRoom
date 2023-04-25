package br.senai.sp.jandira.triproom.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.model.Category

class CategoryRepository {

    companion object {
        @Composable
        fun getCategories(): List<Category> {
            return listOf(
                Category(
                    id = 1,
                    categoryName = "Montain",
                    categoryIcon = painterResource(id = R.drawable.montanha)
                ),
                Category(
                    id = 2,
                    categoryName = "Snow",
                    categoryIcon = painterResource(id = R.drawable.snow)
                ),
                Category(
                    id = 3,
                    categoryName = "Beach",
                    categoryIcon = painterResource(id = R.drawable.praia)
                )
            )
        }
    }

}