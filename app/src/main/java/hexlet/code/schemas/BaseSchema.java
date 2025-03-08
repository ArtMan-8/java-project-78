package hexlet.code.schemas;

public class BaseSchema<T> {
    public boolean isValid(T value) {
        throw new RuntimeException("not implemented");
    }
}
