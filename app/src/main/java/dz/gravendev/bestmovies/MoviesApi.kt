package dz.gravendev.bestmovies

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
@Headers("x-rapidapi-key: a9bc735619mshbd5ddcbed475417p195374jsn4a52f619fcf6",
    "x-rapidapi-host: imdb-top-100-movies.p.rapidapi.com",
    "Content-type: application/json")
@GET(".")
suspend fun getTopMovies( ):Response<ArrayList<Movie>>


@Headers("x-rapidapi-key: a9bc735619mshbd5ddcbed475417p195374jsn4a52f619fcf6",
        "x-rapidapi-host: imdb-top-100-movies.p.rapidapi.com",
        "Content-type: application/json")
@GET("/{movie_id}")
suspend fun getMovieDetails(
    @Path("movie_id") MovieId: String
): Response<Movie>




}