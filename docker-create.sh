docker build -f Dockerfile.jdk --tag jsilvab/api-unired:latest .
docker run -dit -p 8082:8082 --name api-unired jsilvab/api-unired:latest
