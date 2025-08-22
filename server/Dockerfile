FROM nginx:stable-alpine3.21-perl
COPY nginx.conf /etc/nginx/templates/nginx.conf.template
COPY ./example_fullchain.pem ./example_fullchain.pem /etc/nginx/
RUN apk add vim
