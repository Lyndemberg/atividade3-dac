sudo docker build -t contatos/banco ./postgres
sudo docker run -d --name banco contatos/banco
sudo docker build -t contatos/app .
sudo docker run -p 8081:8080 -d --name app --link banco:host-banco contatos/app
