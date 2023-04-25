package br.senai.sp.jandira.triproom.model

import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.painter.Painter
import br.senai.sp.jandira.triproom.R
import java.time.LocalDate

data class Trip @RequiresApi(Build.VERSION_CODES.O) constructor(
    var id: Long = 0,
    var location: String = "",
    var description: String = "",
    var startDate: LocalDate = LocalDate.of(2000,1,1),
    var endDate: LocalDate = LocalDate.of(2000,1,1),
    var image: Int = R.drawable.no_photography_24



)
