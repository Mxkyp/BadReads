clean:
	docker container rm $$(docker container ls -aq)

b:
	docker build --tag br_backend .

run:
	docker run --name backend -p 8080:8080 --network badreads_net -d br_backend

run2:
	docker run --name backend -p 8080:8080 --network badreads_net br_backend
connect:
	docker exec -it backend /bin/sh
