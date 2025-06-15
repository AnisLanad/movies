package dz.gravendev.bestmovies

import android.os.Bundle
import android.webkit.WebChromeClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import dz.gravendev.bestmovies.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val movieId = intent.extras!!.getString("movie_id")
        val movieVM = ViewModelProvider(this)[MoviesViewModel::class.java]
        movieVM.getMovieDetails(movieId!!)
        movieVM.moviesDetails.observe(this){movie ->
            binding.movieTitle.text = movie.title
            binding.movieDescriptionDetails.text = movie.description
            binding.movieRatingDetails.text = movie.rating
            Picasso.get().load(movie.big_image).into(binding.movieBigImage)
            binding.mWebView.settings.javaScriptEnabled = true
            binding.mWebView.loadUrl(movie.trailer_embed_link)
            binding.mWebView.webChromeClient = WebChromeClient()

        }
    }
}