ifeq ($(OS),Windows_NT)
  SLASH='\'
else
  SLASH='/'
endif

GRADLEW=.$(SLASH)app$(SLASH)gradlew -p .$(SLASH)app
BIN_APP=.$(SLASH)app$(SLASH)build$(SLASH)install$(SLASH)app$(SLASH)bin$(SLASH)app

.PHONY: build

lint: # Проверить кодстайл
	$(GRADLEW) checkstyleMain
	$(GRADLEW) checkstyleTest

clean: # Очистить дистрибутив
	$(GRADLEW) clean

test: # Собрать дистрибутив и запустить тесты
	$(GRADLEW) build

test-report: # Подготовить покрытие тестов
	$(GRADLEW) jacocoTestReport

build: clean # Установить зависимости и собрать дистрибутив
	$(GRADLEW) build
