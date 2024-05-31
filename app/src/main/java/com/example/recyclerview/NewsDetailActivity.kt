package com.example.recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_detail)

        val heading = intent.getStringExtra("heading")
        val imgid = intent.getIntExtra("imgid", R.drawable.img)
        val newscontent = intent.getStringExtra("newscontent")

        val headingtv = findViewById<TextView>(R.id.title)
        val imgidiv = findViewById<ImageView>(R.id.imgmain)
        val newscontenttv = findViewById<TextView>(R.id.content)

        headingtv.text = heading
        newscontenttv.text = newscontent
        imgidiv.setImageResource(imgid)

    }
}