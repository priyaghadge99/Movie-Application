# Movie-Application

1. how to build image 	
docker build . -t movie-service

2. how to to rename of image movieservice
docker image tag movie-service:latest priyaghadge/movie-service:latest

3. push image into dockerhub
docker push priyaghadge/movie-service:latest
=======================
# Error : Commnication link failure --due to openjdk image and project java version mismatch


# Run docker compose -- 
docker compose up -d 