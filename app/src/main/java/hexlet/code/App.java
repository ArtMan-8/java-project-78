package hexlet.code;

public class App {
    public static void main(String[] args) {
        var v = new Validator();
        var schema = v.string();

        System.out.println(schema.isValid(""));
    }
}
