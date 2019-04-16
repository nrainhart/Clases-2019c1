package ar.edu.utn.frba.mobile.a2019c1

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_footer.view.*
import kotlinx.android.synthetic.main.item_header.view.*
import kotlinx.android.synthetic.main.item_image.view.*
import kotlinx.android.synthetic.main.item_post.view.*
import kotlinx.android.synthetic.main.item_profile.view.*

class TweetsAdapter(
    private val listener: MainFragment.OnFragmentInteractionListener?,
    private var tweets: List<Tweet> = mutableListOf()
) : RecyclerView.Adapter<TweetsAdapter.ViewHolder>() {

    fun addTweets(tweets: List<Tweet>) {
        this.tweets = tweets
        notifyDataSetChanged()
    }

    private fun tweet(position: Int): Tweet {
        val itemIndex = position - 1 // el primer item es el encabezado
        return tweets[itemIndex]
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) R.layout.item_post
        else {
            val hasPicture = !tweet(position).image.isNullOrBlank()
            if (hasPicture) R.layout.item_image
            else R.layout.item_simple
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(viewType, parent, false)
        when (viewType) {
            R.layout.item_post -> {
                view.postButton.setOnClickListener {
                    listener?.showFragment(StatusUpdateFragment())
                }
            }
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.item_simple, R.layout.item_image -> {
                val tweet = tweet(position)
                holder.itemView.nameText.text = tweet.name
                holder.itemView.certifiedIcon.visibility = if (tweet.certified) View.VISIBLE else View.GONE
                holder.itemView.usernameText.text = tweet.username
                holder.itemView.tweetContent.text = tweet.content
                holder.itemView.commentCount.text = tweet.commentCount.toString()
                holder.itemView.retweetCount.text = tweet.retweetCount.toString()
                holder.itemView.likeCount.text = tweet.likeCount.toString()
                loadImageFromUrlInto(tweet.profilePic, holder.itemView.profilePic)
                tweet.image?.let { imageUrl ->
                    loadImageFromUrlInto(imageUrl, holder.itemView.image)
                }
            }
            else -> {}
        }
    }

    private fun loadImageFromUrlInto(imageUrl: String, imageView: ImageView?) {
        imageView?.let {
            Picasso.get()
                .load(Uri.parse(imageUrl))
                .into(it)
        }
    }

    override fun getItemCount(): Int = tweets.size + 1 // el primer item es el encabezado

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
