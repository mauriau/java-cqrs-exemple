run:
	mvn spring-boot:run

clean-install:
	mvn clean install

build:
	mvb build


bdd-start:
	docker compose up -d

bdd-down:
	docker compose down

bdd-cleanup:
	docker compose down -v
	bdd-start