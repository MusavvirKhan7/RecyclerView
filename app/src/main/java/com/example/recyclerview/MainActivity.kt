package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var myrecyclerview : RecyclerView
    lateinit var newsArraylist : ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        myrecyclerview = findViewById<RecyclerView>(R.id.myrecycler)
        var newsimagearray = arrayOf(

            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6
        )

       var newsheadingarray = arrayOf(
           "RCB's Karthik Shines Bright with Stunning Batting Performance!",
           "Pakistan's Superb Bowling Display Secures Another Win!",
           "New Zealand's Unbeatable Form Continues with Another Win!",
           "RCB's Victory Parade: Kohli's Captaincy Steers Team to Success!",
           "Umpiring Controversy: RCB Fans Demand Fairness in Officiating!",
           "Putin Vows to End Suffering in War-Torn Regions",
           "Strong Message: UK Government Throws Support Behind Palestine"
       )
       val newsContent = arrayOf(
           getString(R.string.news_content),
           getString(R.string.news_content),
           getString(R.string.news_content),
           getString(R.string.news_content),
           getString(R.string.news_content),
           getString(R.string.news_content),
           getString(R.string.news_content)

       )
           // to set whether vertically or horizontally moving/layout
        myrecyclerview.layoutManager = LinearLayoutManager(this)
        newsArraylist = arrayListOf<News>()

        for( index in newsimagearray.indices){
            val news = News(newsheadingarray[index], newsimagearray[index], newsContent[index])
            newsArraylist.add(news)

        }
        var myAdapter = MyAdapter (newsArraylist,this)
        myrecyclerview.adapter = myAdapter

        myAdapter.setItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                // on clicking each item what action do you want to perform

                val intent = Intent(applicationContext, NewsDetailActivity::class.java)
                intent.putExtra("heading", newsArraylist[position].newsHeading)
                intent.putExtra("imageid", newsArraylist[position].newimg)
                intent.putExtra("newscontent", newsArraylist[position].newsContent)

                startActivity(intent)
            }

        })


    }
}