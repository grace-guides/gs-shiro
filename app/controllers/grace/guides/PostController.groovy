package grace.guides

import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.Subject

class PostController {

    def index() {
        Subject currentUser = SecurityUtils.getSubject()
        if (currentUser.isPermitted('post:management')) {
            [postList: Post.list()]
        }
        else {
            render 'No permit'
        }
    }
}