# Spring Batch - Delimited File Reader Example
Este projeto demonstra o uso do Spring Batch para leitura de arquivos delimitados (CSV), processamento dos dados e escrita no console.

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.2.x
- Spring Batch
- Maven

## Descrição
A aplicação executa um job batch que:
- Lê um arquivo CSV localizado em `src/main/resources/files/sample-data.csv`
- Converte cada linha em uma instância da classe `Person`
- Imprime os dados processados no console

### Estrutura do CSV
O arquivo `sample-data.csv` deve conter dados no seguinte formato:

```
firstName,lastName
John,Doe
Jane,Smith
```

## Estrutura do Projeto

- **BatchConfig**: Configuração do job e steps do Spring Batch.
- **Person**: Classe modelo que representa cada registro do arquivo CSV.
- **PersonItemProcessor**: Classe para processar ou transformar dados lidos.
- **SpringBatchDelimitedApplication**: Classe principal da aplicação.

## Como Executar

Clone o repositório:

```bash
git clone https://github.com/IKauedev/spring-batch-delimited.git
````

Acesse a pasta do projeto:

```bash
cd spring-batch-delimited
```

Compile o projeto:

```bash
mvn clean install
```

Execute a aplicação:

```bash
mvn spring-boot:run
```

Ou execute o jar gerado:

```bash
java -jar target/spring-batch-delimited-0.0.1-SNAPSHOT.jar
```

## Saída Esperada

Ao executar, a aplicação deverá exibir no console as linhas processadas, por exemplo:

```
Converting (John, Doe)
Converting (Jane, Smith)
```

## Observações
* O arquivo CSV pode ser alterado ou substituído em `src/main/resources/files/sample-data.csv`.
* O processamento atual apenas imprime os dados, mas pode ser facilmente adaptado para persistir em banco de dados ou outros destinos.
