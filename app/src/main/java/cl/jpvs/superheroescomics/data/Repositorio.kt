package cl.jpvs.superheroescomics.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.jpvs.superheroescomics.data.local.HeroeDao
import cl.jpvs.superheroescomics.data.local.HeroeEntity

import cl.jpvs.superheroescomics.data.remote.HeroeApi

class Repositorio (private val heroeApi: HeroeApi, private val heroeDao: HeroeDao) {

    //Listado de Heroes
    fun obtenerHeroeEntity(): LiveData<List<HeroeEntity>> = heroeDao.getAllHeroe()
    suspend fun CargarHeroes() {
        try {
            val response = heroeApi.getDataHeroe()
            if (response.isSuccessful) {
                val resp = response.body()
                resp?.let {
                    val heroesEntity = it.map { it.transformEntity() }
                    heroeDao.insertAllHeroe(heroesEntity)
                }
            } else {
                Log.e("repositorio", response.errorBody().toString())
            }
        } catch (exception: Exception) {
            Log.e("catch", exception.toString())


        }
    }
}


