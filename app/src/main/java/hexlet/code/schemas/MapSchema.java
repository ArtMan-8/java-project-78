package hexlet.code.schemas;

import java.util.Map;

/** Класс MapSchema для создания схем проверки Map. */
public class MapSchema extends BaseSchema<Map<String, String>> {
    private boolean isRequired = false;
    private Integer size = null;
    private Map<String, BaseSchema<String>> schemas = null;

    public MapSchema() { }

    /**
     * Метод валидирует данные по определённой схеме.
     * @param data проверяемые данные
     * @return true, если данные соответствуют схеме, иначе false
     */
    @Override
    public boolean isValid(Map<String, String> data) {
        if (data == null) {
            return !isRequired;
        }

        if (size != null && data.size() != size) {
            return false;
        }

        if (schemas != null) {
            for (String key : schemas.keySet()) {
                if (!schemas.get(key).isValid(data.get(key))) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Метод добавляет правило валидации, что Map должна быть не пустой.
     * @return MapSchema
     */
    public MapSchema required() {
        this.isRequired = true;
        return this;
    }

    /**
     * Метод добавляет правило валидации, что Map должна иметь заданное количество элементов.
     * @param sizeMap количество элементов
     * @return MapSchema
     */
    public MapSchema sizeof(int sizeMap) {
        this.size = sizeMap;
        return this;
    }

    /**
     * Метод добавляет правило валидации, что Map должна содержать набор пар ключ-значение.
     * @param rules набор пар ключ-значение
     * @return MapSchema
     */
    public MapSchema shape(Map<String, BaseSchema<String>> rules) {
        this.schemas = rules;
        return this;
    }
}
