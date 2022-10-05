# Compile Angular App
FROM node:lts-alpine3.16 as compile
WORKDIR /usr/local/app
COPY ./ /usr/local/app/
RUN npm install
RUN npm run build --prod

# Build Docker Image
FROM nginx:1.23.1-alpine
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=compile /usr/local/app/dist/trackbia-front /usr/share/nginx/html