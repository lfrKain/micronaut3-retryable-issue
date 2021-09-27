package micronaut3.test

//import groovy.util.logging.Slf4j
//import io.micronaut.retry.annotation.Fallback
//import io.micronaut.retry.annotation.Recoverable
//import io.micronaut.retry.annotation.Retryable
//import jakarta.inject.Singleton
//
//@Fallback
//@Slf4j
//class TestHandlerWithFallback implements ITestHandler {
//
//    @Override
//    @Retryable(attempts = '2', delay = '1s', multiplier = '0')
//    String handle() {
//        throw new RuntimeException('test error')
//    }
//
//    String handle(Throwable throwable) {
//        return "Fallback"
//    }
//}
