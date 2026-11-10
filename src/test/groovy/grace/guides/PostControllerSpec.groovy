package grace.guides

import org.apache.shiro.subject.Subject
import org.apache.shiro.subject.support.SubjectThreadState
import org.apache.shiro.util.ThreadState

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class PostControllerSpec extends Specification implements ControllerUnitTest<PostController> {

    def setup() {
    }

    def cleanup() {
    }

    void "Post index"() {
        given:
        Subject subject = Mock()
        subject.isAuthenticated() >> true
        ThreadState subjectThreadState = new SubjectThreadState(subject)
        subjectThreadState.bind()

        when:
        controller.index()

        then:
        view == '/post/index.gsp'

        cleanup:
        subjectThreadState.clear()
    }
}
