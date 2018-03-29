sudo docker stop app
sudo docker stop banco
sudo docker rm banco
sudo docker rm app
sudo docker rmi -f contatos/banco
sudo docker rmi -f contatos/app