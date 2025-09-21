FROM node:20-alpine as builder

WORKDIR /usr/src/app

COPY ./new_frontend_router/package.json ./new_frontend_router/package-lock.json* ./

RUN npm install

COPY ./new_frontend_router/ .

ARG SERVER_NAME=localhost

RUN echo VITE_SERVER_NAME=${SERVER_NAME} > .env.production

RUN npm run build

FROM nginx:stable-alpine3.21-perl
COPY --from=builder /usr/src/app/build/* /etc/nginx/html/
COPY nginx.conf /etc/nginx/templates/nginx.conf.template
