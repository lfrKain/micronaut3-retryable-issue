package micronaut3.test

import groovy.util.logging.Slf4j
import io.micronaut.retry.annotation.Recoverable
import io.micronaut.retry.annotation.Retryable
import jakarta.inject.Singleton

@Singleton
@Slf4j
class TestHandler implements ITestHandler {

    @Override
    @Recoverable
    @Retryable(attempts = '2', delay = '1s', multiplier = '0')
    void handle() {
        throw new RuntimeException('test error')
    }
}
