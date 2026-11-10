package grace.guides

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PostSpec extends Specification implements DomainUnitTest<Post> {

    def setup() {
    }

    def cleanup() {
    }

    void "Post title cannot be null"() {
        when:
        domain.title = null

        then:
        !domain.validate(['title'])
        domain.errors['title'].code == 'nullable'
    }

    void "Post title cannot be blank"() {
        when:
        domain.title = ''

        then:
        !domain.validate(['title'])
        domain.errors['title'].code == 'blank'
    }

    void "Post title max length"() {
        when:
        domain.title = 'abcdefg' * 50

        then:
        !domain.validate(['title'])
        domain.errors['title'].code == 'maxSize.exceeded'
    }
}
