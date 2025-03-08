### Hexlet tests and linter status:
[![Actions Status](https://github.com/ArtMan-8/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/ArtMan-8/java-project-78/actions) [![Maintainability](https://api.codeclimate.com/v1/badges/04c696385b36dd31eddc/maintainability)](https://codeclimate.com/github/ArtMan-8/java-project-78/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/04c696385b36dd31eddc/test_coverage)](https://codeclimate.com/github/ArtMan-8/java-project-78/test_coverage) 

<hr />

# Валидатор данных

## Валидация строк
Правила валидации:
- **required** — делает данные обязательными для заполнения, не позволяет использовать null или пустую строку
- **minLength** — добавляет ограничение минимальной длины строки
- **contains** — добавляет проверку по содержимому в строке

Пример использования:
```java 
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

var v = new Validator();
var schema = v.string();

schema.isValid(""); // true
schema.isValid(null); // true

schema.required();
schema.isValid(null); // false
schema.isValid(""); // false
schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false
```
    

## Валидация чисел
Правила валидации:
- **required** — делает данные обязательными для заполнения, не позволяет использовать null
- **positive** — добавляет ограничение, только положительные числа
- **range** — добавляет допустимый диапазон

Пример использования:
```java
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

var v = new Validator();
var schema = v.number();

schema.isValid(5); // true
schema.isValid(null); // true
schema.positive().isValid(null); // true

schema.required();
schema.isValid(null); // false
schema.isValid(10); // true

schema.isValid(-10); // false
schema.isValid(0); // false

schema.range(5, 10);
schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```


## Валидация объектов типа Map
Правила валидации:
- **required** — делает Map обязательными, не позволяет использовать null
- **sizeof** — добавляет ограничение размера мапы

Пример использования:
```java
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;

var v = new Validator();
var schema = v.map();

schema.isValid(null); // true
schema.required();
schema.isValid(null); // false
schema.isValid(new HashMap<>()); // true

var data = new HashMap<String, String>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);
schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
```


### Валидация вложенных объектов типа Map
Правила валидации:
- **shape** — позволяет описывать валидацию для значений каждого ключа объекта Map

Пример использования:
```java
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

var v = new Validator();
var schema = v.map();

Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));
schema.shape(schemas);

// Проверяем объекты
Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1); // true

Map<String, String> human2 = new HashMap<>();
human2.put("firstName", "John");
human2.put("lastName", null);
schema.isValid(human2); // false

Map<String, String> human3 = new HashMap<>();
human3.put("firstName", "Anna");
human3.put("lastName", "B");
schema.isValid(human3); // false
```
