package micronaut3.test

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class Micronaut3TestSpec extends Specification {

    @Inject
    TestHandler handler
    void 'fallback is called'() {
        when:
        String result = handler.handle()

        then:
        noExceptionThrown()
        result == 'Fallback'
    }
}
