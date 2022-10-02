FROM maven:3.8.5-openjdk-17 as build
LABEL name="sadofrazer"
RUN mkdir /opt/UtilisateurRestApi
WORKDIR /opt/UtilisateurRestApi
#Dockerfile sera dans chaque webservices
COPY . /opt/UtilisateurRestApi/

ENV DB_NAME=it_training
ENV DB_HOST=localhost
ENV DB_USER=frazer
ENV DB_PASSWORD=frazer@123
ENV DB_PORT=3306
ENV HIBERNATE_MODE=create

# RUN sed -ie "s#DB_HOST#${DB_HOST}#g" /opt/UtilisateurRestApi/src/main/webapp/WEB-INF/datasource.properties
# RUN sed -ie "s#DB_PORT#${DB_PORT}#g" /opt/UtilisateurRestApi/src/main/webapp/WEB-INF/datasource.properties
# RUN sed -ie "s#DB_NAME#${DB_NAME}#g" /opt/UtilisateurRestApi/src/main/webapp/WEB-INF/datasource.properties
# RUN sed -ie "s#DB_USER#${DB_USER}#g" /opt/UtilisateurRestApi/src/main/webapp/WEB-INF/datasource.properties
# RUN sed -ie "s#DB_PASSWORD#${DB_PASSWORD}#g" /opt/UtilisateurRestApi/src/main/webapp/WEB-INF/datasource.properties

RUN mvn clean install
RUN mvn package
RUN cp /opt/UtilisateurRestApi/target/UtilisateurRestApi.war /opt/UtilisateurRestApi.war


FROM tomcat:8.5.79-jre17-temurin as tomcat
LABEL name="sadofrazer"
COPY --from=build /opt/UtilisateurRestApi.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
