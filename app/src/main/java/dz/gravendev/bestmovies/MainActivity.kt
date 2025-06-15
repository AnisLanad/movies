package dz.gravendev.bestmovies

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import dz.gravendev.bestmovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val MovieVM = ViewModelProvider(this)[MoviesViewModel::class.java]
        MovieVM.getMovies()
        MovieVM.movies.observe(this) {data ->
            binding.moviesList.layoutManager = GridLayoutManager(this,3)
            binding.moviesList.adapter = MovieAdapter(this,data)
            binding.progressBar.visibility = View.GONE

        }
    }
}