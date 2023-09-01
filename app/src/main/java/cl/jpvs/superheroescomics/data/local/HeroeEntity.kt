package cl.jpvs.superheroescomics.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Heroe_table")
data class HeroeEntity(
    @PrimaryKey val id : Int,
    val nombre :String,
    val origen : String,
    val imagenLink : String,
    val poder : String,
    val annoCreacion : Int

)
