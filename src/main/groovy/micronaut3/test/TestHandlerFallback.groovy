package micronaut3.test

import groovy.util.logging.Slf4j
import io.micronaut.retry.annotation.Fallback
import jakarta.inject.Singleton

@Fallback
//@Singleton
@Slf4j
class TestHandlerFallback implements ITestHandler {

    @Override
    void handle() {
        log.info('recovered!')
    }

    void handle(Throwable throwable) {
        log.error('recovered!', throwable)
    }
}
