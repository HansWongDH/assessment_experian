FROM node:latest
WORKDIR /app
COPY package.json yarn.lock /app/
RUN yarn install
COPY . /app/
RUN yarn

CMD ["yarn", "start", "dev"]