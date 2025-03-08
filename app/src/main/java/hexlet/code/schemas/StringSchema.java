package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private boolean isRequired = false;
    private int minLength = 0;
    private String text = "";

    public StringSchema() { }

    @Override
    public boolean isValid(String value) {
        if (!isRequired && (value == null || value.isEmpty())) {
            return true;
        }

        if (value == null || value.isEmpty()) {
            return false;
        }

        if (value.length() < minLength) {
            return false;
        }

        return value.contains(text);
    }

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int min) {
        this.minLength = min;
        return this;
    }

    public StringSchema contains(String str) {
        this.text = str;
        return this;
    }
}
