
package com.eman.myrestaurant

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgDetail = findViewById<ImageView>(R.id.img_detail)
        val tvName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDescription =
            findViewById<TextView>(R.id.tv_detail_description)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        tvName.text = name
        tvDescription.text = description

        if (photo != 0) {
            imgDetail.setImageResource(photo)
        }
        supportActionBar?.title = "Detail Menu"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
    }
}
