package com.bandirma.harrypotter

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val potterService= RetrofitClient.getRetrofit().create(HarryPotterDbService::class.java)
        potterService.GetBookList().enqueue(object : Callback<String>{
            override fun onResponse(p0: retrofit2.Call<String>, p1: Response<String>) {

                Log.d("TAG",p1.body().toString())
                val liste : ArrayList<bookdataModel> = ArrayList()
                val obje=JSONObject(p1.body().toString())
                val kitapDizisi = obje.getJSONArray( "data")

                for (i in 0 until kitapDizisi.length()) {
                    val id = kitapDizisi.getJSONObject(i).getString( "id")
                    val title =kitapDizisi.getJSONObject(i).getJSONObject( "attributes").getString("title")
                    val cover= kitapDizisi.getJSONObject(i).getJSONObject("attributes").getString("cover")
                    val yazar= kitapDizisi.getJSONObject(i).getJSONObject("attributes").getString("author")
                    val yayinlanma=kitapDizisi.getJSONObject(i).getJSONObject("attributes").getString("release")

                    val item= bookdataModel(id,title,cover,yayinlanma,yazar, "",
                     "", "")
                    liste.add(item)
                }
                   val rvListe =findViewById<RecyclerView>(R.id.rvListe)
                   rvListe.layoutManager = LinearLayoutManager(baseContext)
                val adapter=BookDataAdapter(liste)
            }

            override fun onFailure(p0: retrofit2.Call<String>, p1: Throwable) {
                Toast.makeText(baseContext ,  "hata var",Toast.LENGTH_SHORT).show()

            }

        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}