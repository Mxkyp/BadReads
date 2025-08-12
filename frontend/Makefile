clean:
	docker container rm $$(docker container ls -aq)
	
b:
	docker build --tag br_frontend .

run:
	docker run -p 3000:3000 --name frontend --network badreads_net -d br_frontend

connect:
	docker exec -it backend /bin/sh
