./mvnw package
docker build . -t christmas-tree-brightness
docker run -p 8080:8080 christmas-tree-brightness
