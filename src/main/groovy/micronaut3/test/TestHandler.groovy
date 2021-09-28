package micronaut3.test

import groovy.util.logging.Slf4j
import io.micronaut.retry.annotation.Recoverable
import io.micronaut.retry.annotation.Retryable
import io.micronaut.retry.event.RetryEvent
import io.micronaut.retry.event.RetryEventListener
import jakarta.inject.Singleton

@Singleton
@Slf4j
@Recoverable(api = ITestHandler)
class TestHandler implements ITestHandler, RetryEventListener {

    @Override
    // Comment out this to see that the tests finishes soon because there is no retry or delay
    @Retryable(attempts = '2', delay = '1s', multiplier = '0')
    String handle() {
        throw new RuntimeException('test error')
    }

    @Override
    void onApplicationEvent(RetryEvent event) {
        println "============================ TestHandler.onApplicationEvent ============================"
    }
}
