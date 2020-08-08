# natbank-server
Server application for natbank business model.

This is a Spring Boot REST API which simulates a funcional and simple bank
application. You can create client applications in order to consume this API.

## Model
Bank's users can create new accounts in order to use bank features.
Only one brasilian CPF is expected to be used.

New created accounts are initialized with 1k "coins" but it can be custumized in 
Transaction class. 

When creating an account, client apps must persist user's information to be able 
to authenticate later in the API. 

## Documentation
Everything is done by using json. For more informations, one can check ```/swagger-ui.html``` when running 
the api.

### creating an account
Access ```/account/new``` sending ```UserForm```
json body
```json
{
  "name": "Jonh",
  "password": "1234",
  "email": "jonh@email.com",
  "cpf": "XXX.XXX.XXX-XX"
}
```

A ```201``` http code should be returned.