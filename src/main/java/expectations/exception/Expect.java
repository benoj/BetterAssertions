package expectations.exception;

public class Expect {

    public static Expectation expect(RunnableWithException fn){
        return new Expectation(fn);
    }
}
