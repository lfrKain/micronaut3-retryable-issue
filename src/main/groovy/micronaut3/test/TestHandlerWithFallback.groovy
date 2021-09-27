package micronaut3.test

import groovy.util.logging.Slf4j
import io.micronaut.retry.annotation.Fallback
import io.micronaut.retry.annotation.Recoverable
import io.micronaut.retry.annotation.Retryable
import jakarta.inject.Singleton

@Fallback
@Singleton
@Slf4j
class TestHandlerWithFallback implements ITestHandler {

    @Override
    @Recoverable
    @Retryable(attempts = '2', delay = '1s', multiplier = '0')
    void handle() {
        throw new RuntimeException('test error')
    }

    void handle(Throwable throwable) {
        log.error('recovered!', throwable)
    }
}
