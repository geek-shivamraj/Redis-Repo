# Redis + Java + SpringBoot + Apache Camel + Docker 

| Tech | Version |
| ------ | ------ |
| Java | 17.0.6 [2023-01-17 LTS]|
| Spring Boot | 3.1.3 |
| Apache Camel | 4.0.0 |
| Docker | Docker Version 24.0.6, build ed223bc |
| Redis | 7.2.1 |

| Module | Tech |
| ------ | ------ |
| SpringBoot-Redis-Demo | Java, SpringBoot, Redis|
| RedisCachingDemo | Java, SpringBoot, Redis|
| RedisCamelDemo | Apache Camel, Java, SpringBoot, Redis|

## _Steps to install Redis_

Here We're using Redis deployed in Docker container using WSL - Windows Subsystem for Linux

**Step1**: Download Docker Desktop & install it (You may need to update wsl - Windows Subsystem for Linux)

| Commands | Description |
| ------ | ------ |
| **wsl -l -v** | List the Linux distributions currently installed |
| **wsl --install** | Installs Ubuntu |

**Step2**: Now open Ubuntu terminal & run following commands:

| No. | Commands | Description |
| --- | -------- | ------ |
| **1.**| **sudo -s** | Login as super user or Admin |
| **2.**| **docker --version** | Docker Version |
| **3.**| **docker images** | List the already pulled images |
| **4.**| **docker pull redis** | Pull **redis** latest version from official docker repository |
| **5.**| **docker run --name redis03 -p 6379:6379 -d redis** | Runs the Redis image named **redis**  in a new Container named **redis03** in detached mode. This binds container's port 6379 to host machine port 6379 i.e., **-p hostPort:containerPort** |
| **6.**| **docker exec -it redis03 sh** | Starts a new shell session in the container **redis03** |
| **7.**| **docker ps -a** | Shows all the containers (Running or Stopped) |
| **8.**| **redis-cli** | Login into Redis CLI |
| **9.**| **docker stop redis03** | Stops the container **redis03** |
| **9.**| **docker rm redis03** | Removes the stopped container **redis03** |
| **9.**| **docker rmi redis** | Removes the image named **redis** |

**Refer Docker**: https://docs.docker.com/engine/reference/commandline/cli/

**Refer Redis CLI**: https://redis.io/docs/getting-started/

**Refer Apache Camel**: https://camel.apache.org/camel-core/getting-started/index.html
