package br.com.fiap.mad.a1tdsz

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

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

        val textView = findViewById<TextView>(R.id.textView)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val button = findViewById<Button>(R.id.button)
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        val buttonForward = findViewById<Button>(R.id.buttonForward)
        val imageView = findViewById<ImageView>(R.id.imageView)

        button.setOnClickListener {
            val name = editTextName.text.toString()
            textView.text = "Olá $name"
            textView.isVisible = true
        }

        val movies = listOf(
            R.drawable.sociedade_do_anel_pt, // 0
            R.drawable.two_towers, // 1
            R.drawable.return_king_pt, // 2
        )

        var currentIndex = 0

        buttonBack.setOnClickListener {
//            currentIndex = if (currentIndex == 0) {
//                movies.size - 1
//            } else {
//                currentIndex - 1
//            }
            if (currentIndex == 0) {
                currentIndex = movies.size - 1
            } else {
                currentIndex -= 1
            }
            imageView.setImageResource(movies[currentIndex])
        }

        buttonForward.setOnClickListener {
            if (currentIndex == movies.size - 1) {
                currentIndex = 0
            } else {
                currentIndex += 1
            }
            imageView.setImageResource(movies[currentIndex])
        }
    }
}