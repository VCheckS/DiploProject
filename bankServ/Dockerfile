    FROM node:14

    WORKDIR /bankServ

    COPY data.json .
    COPY package.json .
    COPY package-lock.json .

    RUN npm install

    COPY . .

    CMD ["npm", "start"]