package com.example.testapirestrofit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val servece = RetrofitClient.createService(PostService::class.java)
        val call: Call<List<PostEntity>> = servece.listPosts()
        call.enqueue(object : Callback<List<PostEntity>>{
            override fun onResponse(call: Call<List<PostEntity>>, response: Response<List<PostEntity>>, ) {
                val list = response.body()
            }

            override fun onFailure(call: Call<List<PostEntity>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }
}

/*

https://jsonplaceholder.typicode.com/posts

 {
        "userId": 1,
        "id": 1,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    }
 */