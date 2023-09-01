package cl.jpvs.superheroescomics.data.remote
/*
{
"id": 1,
"nombre": "BATMAN",
"origen": "Gotham City",
"imagenLink": "https://cloudfront-us-east-1.images.arcpublishing.com/metroworldnews/OMMXHLDAABDBVHRUH2FPDLVZCY.jpg",
"poder": "No tiene super poderes, recurre a su intelecto",
"Año_creacion": 1939
},
{
"id": 2,
"nombre": "SUPERMAN",
"origen": "Krypton",
"imagenLink": "https://www.latercera.com/resizer/8kirpzf5mzM3XIGOwclOyU8SoLQ=/arc-anglerfish-arc2-prod-copesa/public/ZPVTH2N4GJFYVPDUMTKY4KMYCM.jpg",
"poder": "Súper fuerza, velocidad, resistencia, agilidad, reflejos, durabilidad, sentidos y longevidad",
"Año_creacion": 1938
}
]
 */
data class Heroe(
    val id: Int,
    val nombre :String,
    val origen : String,
    val imagenLink : String,
    val poder : String,
    val annoCreacion : Int


)
