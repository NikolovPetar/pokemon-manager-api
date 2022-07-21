@ECHO OFF
FOR /f "tokens=*" %%i IN ('docker ps -a -q -f "name=pokemon-manager"') DO docker stop %%i
FOR /f "tokens=*" %%i IN ('docker ps -a -q -f "name=pokemon-manager"') DO docker rm -f %%i
docker image prune -f --filter label=stage=builder
FOR /f "tokens=*" %%i IN ('docker images xed -q') DO docker rmi -f %%i
docker volume prune -f
docker network prune -f