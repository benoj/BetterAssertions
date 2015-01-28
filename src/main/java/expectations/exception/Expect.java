package expectations.exception;

public class Expect {

    public static ExceptionExpectation expect(RunnableWithException fn){
        return new ExceptionExpectation(fn);
    }
}
