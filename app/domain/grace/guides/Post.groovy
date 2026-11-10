package grace.guides

class Post {
    String title

    static constraints = {
        title(nullable: false, maxSize: 255)
    }
}
