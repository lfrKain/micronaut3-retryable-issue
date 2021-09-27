package micronaut3.test

import groovy.util.logging.Slf4j
import io.micronaut.retry.annotation.Fallback

@Fallback
@Slf4j
class TestHandlerFallback implements ITestHandler {

    @Override
    String handle() {
        return "Fallback"
    }

}
