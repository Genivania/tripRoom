package br.senai.sp.jandira.triproom.repository

import br.senai.sp.jandira.triproom.model.Trip
import java.time.LocalDate

class TripRepository {
    companion object{
        fun getTrips(): List<Trip>{
            return listOf(
                Trip(
                    id = 1,
                    location = "Jandira",
                    description = "Escadão de Jandira ",
                    startDate = LocalDate.of(2023,4,21),
                    endDate = LocalDate.of(2023,4,21)
                ),
                Trip(
                    id = 1,
                    location = "Jandira",
                    description = "Escadão de Jandira ",
                    startDate = LocalDate.of(2023,4,21),
                    endDate = LocalDate.of(2023,4,21)
                ),
            )
        }
    }
}