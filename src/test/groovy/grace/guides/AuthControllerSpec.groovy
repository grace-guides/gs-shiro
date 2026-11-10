package grace.guides

import org.apache.shiro.subject.Subject
import org.apache.shiro.subject.support.SubjectThreadState
import org.apache.shiro.util.ThreadState

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class AuthControllerSpec extends Specification implements ControllerUnitTest<AuthController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test index action"() {
        given:
        Subject subject = Mock()
        subject.isAuthenticated() >> true
        ThreadState subjectThreadState = new SubjectThreadState(subject)
        subjectThreadState.bind()

        when:
        controller.index()

        then:
        view == '/auth/index.gsp'

        cleanup:
        subjectThreadState.clear()
    }
}
