package grace.guides

import groovy.transform.CompileStatic
import org.springframework.context.annotation.Import

import grails.boot.Grails

@CompileStatic
@Import(SecurityConfiguration)
class Application {

    static void main(String[] args) {
        Grails.run(Application, args)
    }

}
