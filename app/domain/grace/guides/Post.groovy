package grace.guides

class Post {
    String title

    static constraints = {
        title(nullable: false, blank: false, maxSize: 255)
    }
}
