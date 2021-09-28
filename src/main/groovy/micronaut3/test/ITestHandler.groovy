package micronaut3.test

interface ITestHandler {

    @MyRetryable(attempts = '2', delay = '1s', multiplier = '0')
    String handle()
}
