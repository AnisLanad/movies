package dz.gravendev.bestmovies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter(
    val context: Context,
    val data: ArrayList<Movie>
): RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(context).inflate(R.layout.row_movie, parent,false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movie_title.text = data[position].title
        holder.movie_year.text = data[position].year.toString()
        holder.movie_genre.text = data[position].genre[0]
        holder.movie_rating.text = data[position].rating
        Picasso.get()
            .load(data[position].image).into(holder.movie_img)
        holder.itemView.setOnClickListener {
            val i = Intent(context,MovieDetailsActivity::class.java)
            i.putExtra("movie_id",data[position].id)
            context.startActivity(i)
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }
}