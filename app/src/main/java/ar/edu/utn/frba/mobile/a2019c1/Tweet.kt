package ar.edu.utn.frba.mobile.a2019c1

data class Tweet(
    val profilePic: String,
    val name: String,
    val certified: Boolean,
    val username: String,
    val content: String,
    val image: String?,
    val commentCount: Int,
    val retweetCount: Int,
    val likeCount: Int
)