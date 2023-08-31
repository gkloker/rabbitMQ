# RabbitMQ

#### Endpoint GET

```
curl -X GET 'http://localhost:8080/rabbitmq/send?msg=RabbitMQ%20Test'
```

#### Endpoint POST

```
curl -- header "Content-Type: application/json" \ 
     -- request POST \
     -- data '{"cuit":"2031895813", "currency":"032", "date":"2023-08-31", "brand":"1000", "commerce":"11223344", "entity":"021", "subsidiary":"001", "numberAccount":"44332211"}' \
    'http://localhost:8080/rabbitmq/sendjson'
```
