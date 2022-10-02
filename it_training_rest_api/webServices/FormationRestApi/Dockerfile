FROM maven:3.8.5-openjdk-18-slim as build
LABEL name="sadofrazer"
RUN mkdir /opt/FormationRestApi
WORKDIR /opt/FormationRestApi
#Dockerfile sera dans chaque webservices
COPY . /opt/FormationRestApi/

ENV DB_NAME=it_training
ENV DB_HOST=localhost
ENV DB_USER=frazer
ENV DB_PASSWORD=frazer@123
ENV DB_PORT=3306
ENV HIBERNATE_MODE=create
# RUN sed -ie "s#DB_HOST#${DB_HOST}#g" /opt/FormationRestApi/src/main/webapp/WEB-INF/datasource.properties
# RUN sed -ie "s#DB_PORT#${DB_PORT}#g" /opt/FormationRestApi/src/main/webapp/WEB-INF/datasource.properties
# RUN sed -ie "s#DB_NAME#${DB_NAME}#g" /opt/FormationRestApi/src/main/webapp/WEB-INF/datasource.properties
# RUN sed -ie "s#DB_USER#${DB_USER}#g" /opt/FormationRestApi/src/main/webapp/WEB-INF/datasource.properties
# RUN sed -ie "s#DB_PASSWORD#${DB_PASSWORD}#g" /opt/FormationRestApi/src/main/webapp/WEB-INF/datasource.properties

RUN cat /opt/FormationRestApi/src/main/webapp/WEB-INF/datasource.properties

RUN mvn clean 
RUN mvn install
RUN mvn package
RUN cp /opt/FormationRestApi/target/FormationRestApi.war /opt/FormationRestApi.war


FROM tomcat:8.5.79-jre17-temurin as tomcats
LABEL name="sadofrazer"
COPY --from=build /opt/FormationRestApi.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]