package dz.gravendev.bestmovies

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val movie_title: TextView = itemView.findViewById(R.id.movie_title)
    val movie_img: ImageView = itemView.findViewById(R.id.movie_image)
    val movie_genre: TextView = itemView.findViewById(R.id.movie_genre)
    val movie_rating: TextView = itemView.findViewById(R.id.movie_rating)
    val movie_year: TextView = itemView.findViewById(R.id.movie_year)
}