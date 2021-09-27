package micronaut3.test

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class Micronaut3TestSpec extends Specification {

    @Inject
    TestHandlerWithFallback includeFallbackHandler

    @Inject
    TestHandler handler

    void 'infinite loop when implementation and fallback is the same class'() {
        expect:
        includeFallbackHandler.handle()
    }

    void 'fallback is not called'() {
        expect:
        handler.handle()
    }
}
