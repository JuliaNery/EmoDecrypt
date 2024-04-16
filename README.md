# Projeto Emotion Decoder

## 👨‍💻 Integrantes:

- Victor Fanfoni RM-99173 - Mobile, .NET
- Helena Paixão RM-550929 - QA, .NET
- Gustavo Costa RM-99102 - IA, .NET
- Julia Nery RM-552292 - JAVA, DATABASE
- Giulia Pina RM-97694 - DEVOPS, DATABASE

---

## 🚀 Descrição do Projeto:

Este projeto visa processar linguagem natural para insights empresariais. Utiliza tecnologias como Spring Boot, Hibernate e H2 Database.

---

## 🛠️ Dependências do Projeto:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.2.4</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.ancient</groupId>
	<artifactId>emo-decrypt</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>emo-decrypt</name>
	<description>Process Natural Language to business insights</description>
	<properties>
		<java.version>21</java.version>
	</properties>

	<repositories>
		<repository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
		<repository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<releases>
				<enabled>false</enabled>
			</releases>
		</repository>
	</repositories>
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.ai</groupId>
				<artifactId>spring-ai-bom</artifactId>
				<version>0.8.1</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.ai</groupId>
			<artifactId>spring-ai-openai-spring-boot-starter</artifactId>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>
```

## 🏗️ Arquitetura:
O projeto segue uma arquitetura MVC (Model-View-Controller), onde a lógica de negócios é separada da interação com o usuário e da manipulação dos dados.
<p align="center"> <img src="https://github.com/RicardoVicentepc/client/assets/86174349/c4fd273a-c04c-44c8-847a-cca4fa31041d" alt="Arquitetura"> </p>

---

## 📊 Modelo Entidade-Relacionamento (MER):
<p align="center"> <img src="https://github.com/RicardoVicentepc/client/assets/86174349/e5d931b9-473c-4d57-b502-2421e10eeb4b" alt="Modelo Entidade-Relacionamento (MER)"> </p>

---

## 📑 Modelo Lógico Relacional (MLR):
<p align="center"> <img src="https://github.com/RicardoVicentepc/client/assets/86174349/411f7911-ab4d-4dfa-b78c-4772fd9fb71e" alt="Modelo Lógico Relacional (MLR)"> </p>

---

## 🔧 Diagrama de Classe:
<p align="center"> <img src="https://github.com/RicardoVicentepc/client/assets/86174349/a3c7ab2a-6d4a-49d6-8a88-138f73684317" alt="Diagrama de Classe"> </p>

---

## ▶️ Instalação das Dependências do Maven:

1. **Verificar a instalação do Maven:**
    - Antes de começar, verifique se você já possui o Maven instalado em seu sistema. Para verificar, abra o terminal e execute o seguinte comando:
      ```bash
      mvn -v
      ```
    - Se o Maven estiver instalado, você verá informações sobre a versão do Maven e o Java instalado. Caso contrário, prossiga para o próximo passo.

2. **Baixar e instalar o Maven:**
    - Acesse o [site oficial do Apache Maven](https://maven.apache.org/download.cgi) para baixar a versão mais recente do Maven.
    - Siga as instruções de instalação específicas para o seu sistema operacional. Geralmente, isso envolve descompactar o arquivo baixado em um diretório de sua escolha e configurar as variáveis de ambiente.

3. **Verificar a instalação novamente:**
    - Após a instalação, verifique novamente se o Maven foi instalado corretamente executando o comando `mvn -v` no terminal. Você deve ver as informações sobre a versão do Maven e do Java instalado.

4. **Pronto para usar:**
    - Com o Maven devidamente instalado e configurado, você está pronto para usar o gerenciador de dependências em seus projetos Java. Não se esqueça de navegar até o diretório raiz do projeto e executar os comandos do Maven conforme necessário.

---

## 🛣️ Endpoints:
- POST - [http://localhost:8080/MassaDados](http://localhost:8080/MassaDados)

| código | descrição                             |
  |--------|---------------------------------------|
  |201| Massa de Dados cadastrada com Sucesso |
  |400| Verifique os dados de envio           |

- GET - [http://localhost:8080/MassaDados](http://localhost:8080/MassaDados)

| código | descrição                |
  |--------|--------------------------|
  | 200    | Lista de Massas de Dados |

- GET - [http://localhost:8080/MassaDados/{id}](http://localhost:8080/MassaDados/{1})

| código | descrição                        |
  |--------|----------------------------------|
  | 200    | Categoria cadastrada com Sucesso |
  | 404    | Massa de dados não encontrada.   |
  | 400    | Verifique os dados de envio      |

---

## 📹 Link do Vídeo de Explicação:
https://www.youtube.com/watch?v=7gJjuK1w6mw