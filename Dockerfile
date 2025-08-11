FROM alpine:3.22.1

ENV PORT="3000"

WORKDIR /usr/src/app
COPY . .
EXPOSE ${PORT} 

RUN apk add nodejs npm \
  && npm install

CMD ["npm", "run", "dev"]


