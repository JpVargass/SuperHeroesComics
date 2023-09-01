package cl.jpvs.superheroescomics.data

import cl.jpvs.superheroescomics.data.local.HeroeEntity
import cl.jpvs.superheroescomics.data.remote.Heroe

fun Heroe.transformEntity(): HeroeEntity = HeroeEntity(
    this.id,
    this.nombre,
    this.origen,
    this.imagenLink,
    this.poder,
    this.annoCreacion
)