package dz.gravendev.bestmovies


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MoviesViewModel: ViewModel() {
    var movies = MutableLiveData<ArrayList<Movie>>()
    var moviesDetails = MutableLiveData<Movie>()
    fun getMovies() = CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetrofitInstance.movieApi.getTopMovies()
            if(response.isSuccessful) {
                CoroutineScope(Dispatchers.Main).launch {
                    movies.value = response.body()
                }
            }else{

            }
        }catch (e:Exception){

        }
    }
    fun getMovieDetails(movieId: String) = CoroutineScope(Dispatchers.IO).launch {
        try{
            val response = RetrofitInstance.movieApi.getMovieDetails(movieId)
            if(response.isSuccessful){
                CoroutineScope(Dispatchers.Main).launch {
                    moviesDetails.value = response.body()
                }

                }else{

            }

        }catch (e:Exception) {

        }
    }

}