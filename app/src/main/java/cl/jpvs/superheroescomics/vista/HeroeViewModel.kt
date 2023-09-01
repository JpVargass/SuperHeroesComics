package cl.jpvs.superheroescomics.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.jpvs.superheroescomics.data.Repositorio
import cl.jpvs.superheroescomics.data.local.HeroeDataBase
import cl.jpvs.superheroescomics.data.remote.HeroeRetroFit
import kotlinx.coroutines.launch

class HeroeViewModel (application: Application): AndroidViewModel(application) {
private lateinit var repositorio: Repositorio


init{
    val api = HeroeRetroFit.getRetroFitHeroe()
    val heroeDataBase = HeroeDataBase.getDataBase(application).getHeroeDao()
    repositorio = Repositorio(api,heroeDataBase)
}
    fun heroeLiveData() = repositorio.obtenerHeroeEntity()

    fun getAllHeroes() = viewModelScope.launch {
        repositorio.CargarHeroes()
    }
}
