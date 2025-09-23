FROM node:20-alpine as builder

WORKDIR /usr/src/app

COPY ./frontend/package.json ./frontend/package-lock.json* ./

RUN npm install

COPY ./frontend/ .

ARG SERVER_NAME=localhost

RUN echo VITE_SERVER_NAME=${SERVER_NAME} > .env.production

RUN npm run build

FROM nginx:stable-alpine3.21-perl
COPY --from=builder /usr/src/app/dist/ /etc/nginx/html
COPY nginx.conf /etc/nginx/templates/nginx.conf.template
