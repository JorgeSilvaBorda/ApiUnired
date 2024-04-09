docker container rm $(docker ps | grep api-unired | cut -d " " -f 1 | xargs docker stop)
docker image rm jsilvab/api-unired:latest
