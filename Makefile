.PHONY: build
build:
	mvn package

.PHONY: test
test:
	mvn test

.PHONY: clean
clean:
	mvn clean

