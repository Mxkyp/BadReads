clean:
	docker container rm $$(docker container ls -aq)

b:
	docker build --tag post .

run:
	docker run --name database -e POSTGRES_PASSWORD=zq123edc --network badreads_net  -d post

t:
	docker run --name database -e POSTGRES_PASSWORD=zq123edc --network badreads_net post

connect:
	docker exec -it database /bin/sh

