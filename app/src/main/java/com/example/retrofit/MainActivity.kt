package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit.remote.PokemonEntry
import com.example.retrofit.remote.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RetrofitBuilder.create()
        val response = retrofit.getPokemonById("8")

        response.enqueue(object: Callback<PokemonEntry> {
            override fun onResponse(call: Call<PokemonEntry>, response: Response<PokemonEntry>) {
                Log.d("retroFit", "${response.body()}")
                val resp = response.body()
                if (resp != null){
                    Log.d("retroFit", "Estadisticas")
                    val stats = resp.stats

                    for (state in stats){
                        Log.d("retroFit", "${state.stat_name.stat}: ${state.base_stat}")
                    }

                    val types = resp.types
                    Log.d("retroFit", "Types: ${types[0].type.name}",)
                    val sprite = resp.sprites
                    Log.d("retroFit", "${sprite.sprite}")
                }

            }


            override fun onFailure(call: Call<PokemonEntry>, t: Throwable) {
                Log.w("retroFit", "error: ${t.message}")
            }

        })
    }
}