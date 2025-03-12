package hexlet.code.schemas;

import java.util.Map;

/** Класс MapSchema для создания схем проверки Map. */
public class MapSchema extends BaseSchema<Map<String, String>> {
    @Override
    public final MapSchema required() {
        super.required();
        return this;
    }

    /**
     * Метод добавляет правило валидации, что Map должна иметь заданное количество элементов.
     * @param size количество элементов
     * @return MapSchema
     */
    public MapSchema sizeof(int size) {
        this.addSchema("sizeOfMap", (data) -> data.size() == size);
        return this;
    }

    /**
     * Метод добавляет правило валидации, что Map должна содержать набор пар ключ-значение.
     * @param rules набор пар ключ-значение
     * @return MapSchema
     */
    public MapSchema shape(Map<String, BaseSchema<String>> rules) {
        this.addSchema("shapeOfMap", (data) -> {
            for (String key : rules.keySet()) {
                if (!rules.get(key).isValid(data.get(key))) {
                    return false;
                }
            }

            return true;
        });
        return this;
    }
}
