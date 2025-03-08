package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean isRequired = false;
    private boolean isPositive = false;
    private Integer min = Integer.MIN_VALUE;
    private Integer max = Integer.MAX_VALUE;

    public NumberSchema() { }

    @Override
    public boolean isValid(Integer value) {
        if (value == null) {
            return !isRequired;
        }

        if (isPositive && value < 0) {
            return false;
        }

        return value >= min && value <= max;
    }

    public NumberSchema required() {
        this.isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    public NumberSchema range(Integer minNumber, Integer maxNumber) {
        this.min = minNumber;
        this.max = maxNumber;
        return this;
    }
}
