FROM node:20-alpine

RUN apk add --no-cache curl

WORKDIR /usr/src/app

COPY package.json package-lock.json* ./

RUN npm install

COPY . .

ENV PORT=3000

EXPOSE ${PORT}

CMD ["npm", "run", "dev"]
