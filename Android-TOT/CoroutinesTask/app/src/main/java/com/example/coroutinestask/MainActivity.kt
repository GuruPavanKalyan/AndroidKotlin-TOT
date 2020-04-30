package com.example.coroutinestask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.coroutinestask.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var list: MutableList<Pojo>
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        list = mutableListOf()
        CoroutineScope(Dispatchers.IO).launch {
            topNews()
        }
    }
    private suspend fun topNews() {
        val url =
            URL("https://newsapi.org/v2/top-headlines?sources=google-news&apiKey=9289a087e01d439896afd13a985363b2")
        val httpsURLConnection: HttpsURLConnection = url.openConnection() as HttpsURLConnection
        val inputStream: InputStream = httpsURLConnection.inputStream
        val text = inputStream.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main) {
            displayNews(text)

        }
    }

    private fun displayNews(text: String) {

        val root: JSONObject = JSONObject(text)
        val articles: JSONArray = root.getJSONArray("articles")
        for (i: Int in 0..articles.length() - 1) {
            val obj: JSONObject = articles.getJSONObject(i)
            var title: String = obj.getString("title")
            var link: String = obj.getString("urlToImage")
            val pojo: Pojo = Pojo(title, link)
            list.add(pojo)

        }
        adapter = NewsAdapter(this,list)
        binding.rv.adapter = adapter

    }
}
