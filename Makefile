###BACKEND
backend = ./backend/
build-backend:
	docker build --tag br_backend $(backend) 

run-backend:
	docker run --name backend -p 8080:8080 --network badreads_net -d br_backend

connect-backend:
	docker exec -it backend /bin/sh

###DATABASE#############################################################################################
database= ./database/ 

build-database:
	docker build --tag post $(database)

run-database:
	docker run --name database -e POSTGRES_PASSWORD=zq123edc --network badreads_net  -d post

connect-database:
	docker exec -it database /bin/sh

###FRONTEND#############################################################################################
frontend = ./frontend/ 

build-frontend:
	docker build --tag br_frontend $(frontend)

run-frontend:
	docker run -p 3000:3000 --name frontend --network badreads_net -d br_frontend

connect-frontend:
	docker exec -it backend /bin/sh
