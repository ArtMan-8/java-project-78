package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {
    private boolean isRequired = false;
    private Integer size = null;
    private Map<String, BaseSchema<String>> schemas = null;

    public MapSchema() { }

    @Override
    public boolean isValid(Map<String, String> value) {
        if (value == null) {
            return !isRequired;
        }

        if (size != null && value.size() != size) {
            return false;
        }

        if (schemas != null) {
            for (String key : schemas.keySet()) {
                if (!schemas.get(key).isValid(value.get(key))) {
                    return false;
                }
            }
        }

        return true;
    }

    public MapSchema required() {
        this.isRequired = true;
        return this;
    }

    public MapSchema sizeof(int sizeMap) {
        this.size = sizeMap;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> rules) {
        this.schemas = rules;
        return this;
    }
}
