package com.hack.lesson12_gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val numColumns = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViews()
    }

    private fun setUpViews(){
        val gridLayoutManager = GridLayoutManager(applicationContext, numColumns)
        gridLayoutManager.orientation = RecyclerView.VERTICAL
        photosRV.layoutManager = gridLayoutManager
        val adapter = PhotosAdapter(createPhotos(), numColumns){
            Log.d("MainActivity", "onClick = $it")
        }
        photosRV.adapter = adapter
    }

    private fun createPhotos() : ArrayList<String>{
        val photos = ArrayList<String>()
        photos.add("https://www.riotgames.com/darkroom/1440/b2b587d91d3c5d2922953ac62fbb2cb8:dfd0d5c2d07f981fb8cda29623b5e54e/paris.jpg")
        photos.add("https://q-xx.bstatic.com/xdata/images/hotel/840x460/210768979.jpg?k=8c5a446976bf74a068d77c5e1dcf37158b9625883dd99ff46175fa6d263836e2&o=")
        photos.add("https://digital.ihg.com/is/image/ihg/intercontinental-paris-4031206249-2x1?fit=fit,1&wid=2400&hei=1200&qlt=85,0&resMode=sharp2&op_usm=1.75,0.9,2,0")
        photos.add("https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/itemimages/16/93/1693297_v5.jpeg")
        photos.add("https://lp-cms-production.imgix.net/image_browser/Arc%20de%20Triomphe%20-%20Paris%20highlights.jpg?format=auto")
        photos.add("https://www.cia-france.ru/media/1560/paris-petite_720x500.jpg")
        return photos
    }
}