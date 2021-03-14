# spring-cloud-netflix-proxy-apis
[Criando proxy de APIs com Spring cloud, Zuul e Eureka](https://wp.me/p5RSbg-kW)

O Zuul não tem suporte na versão mais atual do spring-boot, por isso nesse fork ele foi substituido 
pelo `spring-cloud-gateway`
## Pré requisito
- Docker
- Docker compose

## Preparando ambiente

### Com Docker
Execute o `build.sh` ou build as imagens docker manualmente.

Cada modulo tem o seu próprio `Dockerfile` e `build.sh` com o comando utilizado para buildar a imagem.
Caso vc esteja usando Windows e não queira usar o git bash, você pode abrir e rodar o conteudo de cada build.sh,
por exemplo o customers:
```
cd eureka
docker build --rm -t borelanjo/eureka:latest .
```


## Executando 

- Iniciando
```
docker-compose up -d
```

- Caso queria verificar os logs:
```shell
docker-compose logs -f
```

- Encerrando:
```shell
docker-compose down
```

## Acessando Eureka: 
http://localhost:8761
Instances currently registered with Eureka
```

Application	AMIs	Availability Zones	Status
CUSTOMERS	n/a (1)	(1)	UP (1) - 192.168.11.247:customers:8060
PRODUCTS	n/a (1)	(1)	UP (1) - 192.168.11.247:products:8070
ZUUL	      n/a (1)	(1)	UP (1) - 192.168.11.247:zuul:8080
```

## Acessando APIs

As portas das api não estão expostas no docker compose, então caso queria acessar elas diretamente terá que modificar o
docker compose, por exemplo o customer-service ficaria assim:

```yaml
  paciente-alfa-producer-service:
    image: 'borelanjo/paciente-producer-service:latest'
    networks:
      - borelanjo-network
    depends_on:
      - eureka-service
    environment:
      APP_URL: paciente-alfa-producer-service
      EUREKA_DEFAULT_ZONE: 'http://eureka-service:8761/eureka'
      ACTIVEMQ_BROKER_URL: 'tcp://activemq-service:61616'
    ports:
      - "8096:8082"
```

#### Via Proxy (Gateway)
- http://localhost:8080/api/pacientes

No docker-compose tem 2 instâncias de cada consumidor e produtor, caso queira você pode modificar o docker-compose

