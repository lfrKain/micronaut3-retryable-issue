package micronaut3.test

import groovy.util.logging.Slf4j
import io.micronaut.retry.annotation.Recoverable
import io.micronaut.retry.event.RetryEvent
import io.micronaut.retry.event.RetryEventListener
import jakarta.inject.Singleton

@Singleton
@Slf4j
@Recoverable(api = ITestHandler)
class TestHandler implements ITestHandler, RetryEventListener {

    @Override
    String handle() {
        throw new RuntimeException('test error')
    }

    @Override
    void onApplicationEvent(RetryEvent event) {
        println "============================ TestHandler.onApplicationEvent ============================"
    }
}
