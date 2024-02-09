package com.example.imagecaching
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private val imageUrls = listOf(
        R.drawable.cartierwomen2,
        R.drawable.cartierwomen4,
        R.drawable.cartierwomen6,
        R.drawable.cartierwomen5,
        R.drawable.cartierwomen3
    )

    private lateinit var imageView: ImageView
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        val nextButton: Button = findViewById(R.id.nextButton)
        val previousButton: Button = findViewById(R.id.previousButton)

        nextButton.setOnClickListener {
            showNextImage()
        }

        previousButton.setOnClickListener {
            showPreviousImage()
        }

        // Load the initial image
        loadCurrentImage()
    }

    private fun loadCurrentImage() {
        Glide.with(this)
            .load(imageUrls[currentIndex])
            .placeholder(R.drawable.ic_launcher_background) // Set a placeholder image
            .error(R.drawable.ic_launcher_foreground) // Set an error image
            .into(imageView)
    }

    private fun showNextImage() {
        currentIndex = (currentIndex + 1) % imageUrls.size
        loadCurrentImage()
    }

    private fun showPreviousImage() {
        currentIndex = (currentIndex - 1 + imageUrls.size) % imageUrls.size
        loadCurrentImage()
    }

}
