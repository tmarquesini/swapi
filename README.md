# swapi

API de consulta ao serviço [swapi.dev](https://swapi.dev) 

---

## Rotas

### Criar um novo usuário
Method: `POST`

Endpoint: `/register`

Payload: `{ 
  "username": "user",
  "password": "secret"
}`

Retorno: 
`{ "id": 1, "username": "user", "password": "hashedpassword" }`

### Autenticar um usuário
Method: `POST`

Endpoint: `/auth`

Payload: `{
"username": "user",
"password": "secret"
}`

Retorno:
`{ "type": "Bearer", "token": "tokendousuarioautenticado" }`

### Alterar a senha do usuário
Method: `PUT` 

Endpoint: `/password`

Headers: `
"Authorization": "Bearer tokendousuarioautenticado"`

Payload: `{
"username": "user",
"password": "secret"
}`

Retorno:
`{ "id": 1, "username": "user", "password": "hashedpassword" }`


### Rotas de recursos da API
Method: `GET` 

Headers: `
"Authorization": "Bearer tokendousuarioautenticado"`

Endpoints:
- `/filmes`
- `/filmes/{id}`
- `/populacao`
- `/populacao/{id}`
- `/planetas`
- `/planetas/{id}`

---

Desenvolvido por [Thiago Pavão Marquesini](mailto:contato@marquesini.com.br)
