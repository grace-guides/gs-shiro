package grace.guides

import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.subject.Subject

class AuthController {

    static allowedMethods = [index: "GET", login: "POST", logout: "GET"]

    def index() {
        Subject currentUser = SecurityUtils.getSubject()
        if (currentUser.isAuthenticated()) {
            redirect(uri: '/')
        }
    }

    def login(LoginCommand cmd) {
        def username = cmd.username
        def password = cmd.password
        if (username && password) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password)
            Subject currentUser = SecurityUtils.getSubject()
            try {
                currentUser.login(token)
            } catch (Exception e) {
                e.printStackTrace()
                redirect(uri: '/500')
            }
            redirect(uri: '/')
        } else {
            redirect(controller: 'auth', action: 'index', params: [fail: true])
        }
    }

    def logout() {
        log.info "User logout"
        Subject currentUser = SecurityUtils.getSubject()
        currentUser.logout()
        redirect(uri: "/")
    }

}

class LoginCommand {
    String username
    String password
}