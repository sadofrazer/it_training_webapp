FROM node:18.3.0-alpine as angular-build
LABEL name="Frazer SADO"
LABEL email="sadofrazer@yahoo.fr"
LABEL project="ITTRAINING"

ENV FORMATION_API_HOST=formation-rest-api
ENV UTILISATEUR_API_HOST=utilisateur-rest-api
ENV UTILISATEUR_API_PORT=8080
ENV FORMATION_API_PORT=8080
ENV UTILISATEUR_REST_API_URL=http://${UTILISATEUR_API_HOST}:${UTILISATEUR_API_PORT}/UtilisateurRestApi/rest
ENV FORMATION_REST_API_URL=http://${FORMATION_API_HOST}:${FORMATION_API_PORT}/FormationRestApi/rest



RUN mkdir /opt/angular
WORKDIR /opt/angular
COPY . .

#sed -ie "s/PORT/$test/g" .env
RUN sed -ie "s#FORMATION_REST_API_URL#${FORMATION_REST_API_URL}#g" /opt/angular/src/app/entities/Formation/formation.ts
RUN sed -ie "s#UTILISATEUR_REST_API_URL#${UTILISATEUR_REST_API_URL}#g" /opt/angular/src/app/entities/Utilisateur/utilisateur.ts


RUN npm install
RUN npm install -g @angular/cli@13 || true
RUN ng build --prod || npm run build --prod

FROM nginx:stable as webapp
LABEL name="Frazer SADO"
LABEL email="sadofrazer@yahoo.fr"
COPY --from=angular-build /opt/angular/dist/angular-front-end /usr/share/nginx/html
COPY --from=angular-build /opt/angular/default.conf /etc/nginx/conf.d/default.conf
