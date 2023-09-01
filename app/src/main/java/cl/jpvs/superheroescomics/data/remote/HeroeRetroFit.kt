package cl.jpvs.superheroescomics.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/* url_base "https://y-mariocanedo.vercel.app/" */
class HeroeRetroFit {
    companion object {
        private const val BASE_URL = "https://y-mariocanedo.vercel.app/"

        fun getRetroFitHeroe(): HeroeApi {

            val mRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return mRetrofit.create(HeroeApi::class.java)

        }
    }

}


