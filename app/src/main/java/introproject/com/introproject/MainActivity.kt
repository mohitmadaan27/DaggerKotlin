package introproject.com.introproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject lateinit var retrofit: Retrofit
      var listView: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MyApplication).netComponent.inject(this)



        listView = findViewById(R.id.listViewHeroes)
        getHeroes()
    }

    public fun getHeroes() {
        val api = retrofit?.create(Api::class.java)
        val call = api?.getHeroes()

        call!!.enqueue(object : Callback<kotlin.collections.List<Hero>> {
            override fun onResponse(call: Call<kotlin.collections.List<Hero>>, response: Response<kotlin.collections.List<Hero>>) {
                val heroList = response.body()
                val heroes = arrayOfNulls<String>(heroList!!.size)

                for (i in heroList.indices) {
                    heroes[i] = heroList[i].name
                }

                listView!!.setAdapter(ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes))
            }

            override fun onFailure(call: Call<kotlin.collections.List<Hero>>, t: Throwable) {
                Toast.makeText(getApplicationContext(), t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }


}
