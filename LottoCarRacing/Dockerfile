# 1. Java 21 (Eclipse Temurin) 베이스
FROM eclipse-temurin:21-jdk

# 2. Tomcat 10 설치
RUN apt-get update && \
    apt-get install -y wget tar && \
    wget https://archive.apache.org/dist/tomcat/tomcat-10/v10.0.27/bin/apache-tomcat-10.0.27.tar.gz && \
    tar xzf apache-tomcat-10.0.27.tar.gz && \
    mv apache-tomcat-10.0.27 /usr/local/tomcat && \
    rm apache-tomcat-10.0.27.tar.gz

# 3. 기존 웹앱 삭제
RUN rm -rf /usr/local/tomcat/webapps/*

# 4. WAR 파일 복사
COPY lottoRacingVer2.war /usr/local/tomcat/webapps/


# 5. Tomcat 포트
EXPOSE 8080

# 6. Tomcat 실행
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
