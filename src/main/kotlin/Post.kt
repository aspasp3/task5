data class Post (
    val id:Long,
    val AuthorId:Long,
    val AuthorName:String,
    val content:String,
    val likes: Int = 0
)

object WallService {
    private var posts = emptyArray<Post>()
    private var currentUniqId:Long=1


    fun add(post: Post): Post {
        posts += post.copy(id = currentUniqId)
        currentUniqId++
        return posts.last()
    }
    fun update(post2: Post): Boolean {
        //TODO("test upd")
        for ((index,post) in posts.withIndex()) {
            if(post.id == post2.id) {
               posts[index] = post.copy(content = post2.content)
               return true
            }
        }
        return false
    }

    fun showPostById(id: Long) {

        for ((index,post) in posts.withIndex()) {
            if(post.id == id) {
                //posts[index] = post.copy(content = post2.content)
                println(posts[index])
            }
        }

    }

}