package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<Object, Object>> {
    private boolean isRequired = false;
    private Integer size = null;

    MapSchema() { }

    @Override
    public boolean isValid(Map<Object, Object> value) {
        if (value == null) {
            return !isRequired;
        }

        return size == null || value.size() == size;
    }

    public MapSchema required() {
        this.isRequired = true;
        return this;
    }

    public MapSchema sizeof(int sizeMap) {
        this.size = sizeMap;
        return this;
    }
}
