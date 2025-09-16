# Estágio 1: Build da Aplicação com Maven e Java 21
# Usamos uma imagem que já contém Maven e a JDK 21, conforme seu pom.xml
FROM maven:3.9-eclipse-temurin-21 AS builder

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o pom.xml primeiro para aproveitar o cache de camadas do Docker.
# As dependências só serão baixadas novamente se o pom.xml mudar.
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o resto do código-fonte do projeto
COPY src ./src

# Executa o build do Maven para gerar o arquivo .jar, pulando os testes.
RUN mvn package -DskipTests

# Estágio 2: Criação da Imagem Final de Execução
# Usamos uma imagem JRE (Java Runtime Environment) que é mais leve que a JDK.
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copia o arquivo .jar gerado no estágio anterior para a imagem final.
# O nome do JAR é baseado no <artifactId> e <version> do seu pom.xml.
COPY --from=builder /app/target/AluraFake-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080, que é a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação quando o container for executado
ENTRYPOINT ["java", "-jar", "app.jar"]