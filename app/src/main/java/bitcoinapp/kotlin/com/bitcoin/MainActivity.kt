package bitcoinapp.kotlin.com.bitcoin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadBTC()

    }

    private fun loadBTC() {
        val recyclerView = findViewById<RecyclerView>(R.id.listBTC)

        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getBitcoin()

        call.enqueue(object : Callback<PostModel> {

            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {

                if (response.isSuccessful) {

                    val tvUpdate: TextView = findViewById(R.id.updated)
                    val tvDesc: TextView = findViewById(R.id.desc)

                    tvUpdate.text = response.body()?.time?.updated
                    tvDesc.text = response.body()?.disclaimer

                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.adapter = PostAdapter(response.body()!!)
                }
            }

            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                t.printStackTrace()

                Log.e("error", t.message.toString())
            }
        })
    }

 }