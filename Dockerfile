# 基础镜像
FROM  openjdk:17
# author
MAINTAINER jacky

ARG JAR_FILE

# 挂载目录
# VOLUME /home/packages/docker/
# 创建目录
RUN mkdir -p /home/packages/docker/
# 指定路径
WORKDIR /home/packages/docker/
# 复制jar文件到路径
COPY ./target/${JAR_FILE} redis-docker-image.jar
EXPOSE 8092
# 启动 服务
ENTRYPOINT ["java","-jar","redis-docker-image.jar"]
