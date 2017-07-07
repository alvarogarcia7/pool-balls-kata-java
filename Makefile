.PHONY: build
build:
	mvn package

.PHONY: test
test:
	mvn test

.PHONY: clean
clean:
	mvn clean

.PHONY: install
install:
	mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V

