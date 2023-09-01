package cl.jpvs.superheroescomics.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HeroeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserAllHeroe(heroeList: List<HeroeEntity>)

    @Query("SELECT * FROM heroe_table order by id Asc")
    fun getAllHeroe(): LiveData<List<HeroeEntity>>
}