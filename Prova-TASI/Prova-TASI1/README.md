# Prova de Tópicos Avançados em Sistemas de Informação

Primeira prova da matéria de Tópicos Avançados em Sistemas de Informação no curso de Sistemas de Informação para a turma do 7° período. A prova consiste em desenvolver um CRUD em Java.

## Aluno

    Eduardo Faria Caetano Silva

### Como utilizar a API

Para utilizar a API da prova, você deve cloná-la e rodá-la localmente. Este projeto utiliza-se de:

- Lombok
- H2 Database
- JPA
- SpringBoot Dev Tools
- SpringWeb

Além disso, você deverá ter instalado o Maven 3.9.0 e Java 11.
Após toda a ambientação do projeto,execute-o e verifique o acesso através do seguinte link:

    http://localhost:8080/h2-console

Caso consiga, verifique as credenciais no arquivo de applications.properties e acesse-o.
Ao acessar, basta clicar no nome da tabela DELIVERY_ENTITY que aparecerá o comando para fazer o select de todas as informações inseridas nessa tabela. Por já possuir uma população de duas linhas, você já irá verificar que possuirá campos preenchidos.

Para testar, baixe a aplicação de Postman ou qualquer outro software de sua preferência e execute os seguintes comandos e suas ações:

#### Post

    localhost:8080/delivery/

Insira o body com as informações corretas. Abaixo está um exemplo de body para ser inserido:

    {
        "cpf":  11122233345,
        "date": "14/04/2023",
        "cep": 3398510,
        "deliveryStatus": "Em entrega",
        "active": true
    }

#### GetById

    localhost:8080/delivery/{code}

Insira no lugar do code algum código que deseja buscar. Abaixo está um exemplo de requisição:

    localhost:8080/delivery/1

#### Put

    localhost:8080/delivery/{code}

Insira no lugar do code algum código que deseja ativar ou desativar um objeto. Abaixo está um exemplo de requisição:

    localhost:8080/delivery/1

Não é necessário um body para fazer a ativação ou desativação do objeto.