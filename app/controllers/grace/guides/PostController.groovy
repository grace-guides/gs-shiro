package grace.guides

import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.Subject

class PostController {

    static final POST_LIST = [
        new Post(id: 1, title: 'Grace 2022.0.0 released'),
        new Post(id: 2, title: 'Grace 2022.0.1 released'),
        new Post(id: 3, title: 'Grace 2022.0.2 released'),
        new Post(id: 4, title: 'Grace 2022.0.3 released'),
        new Post(id: 5, title: 'Grace 2022.0.4 released'),
        new Post(id: 6, title: 'Grace 2022.0.5 released'),
        new Post(id: 7, title: 'Grace 2022.0.6 released'),
        new Post(id: 8, title: 'Grace 2022.0.7 released'),
        new Post(id: 9, title: 'Grace 2022.0.8 released'),
        new Post(id: 10, title: 'Grace 2022.0.9 released')
    ]

    def index() {
        Subject currentUser = SecurityUtils.getSubject()
        if (currentUser.isPermitted('post:management')) {
            [postList: POST_LIST]
        }
        else {
            render 'No permit'
        }
    }
}