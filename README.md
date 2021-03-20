# jokenpo-web
Jokenpô-Online

Descrição da Aplicação:

    Para o desenvolvimento da aplicação, Jokenpô-Online, foi utilizado o Spring Framework.
    Favorecendo-se de todas as funcionalidades que o Spring permite: Spring Boot, Spring Web,
    JPA.
    Para a interação do back-end com o front-end, utilizou-se o mecanismo de modelo Thymeleaf.

Step-by-step Rodar App:

    1- Criar a Base de Dados. Segue o script para sua criação:

        CREATE TABLE IF NOT EXISTS jogador (
            id INT AUTO_INCREMENT PRIMARY KEY,
            nome VARCHAR(25) NOT NULL
        );

        CREATE TABLE IF NOT EXISTS partida (
            id INT AUTO_INCREMENT PRIMARY KEY,
            jogador INT,
            FOREIGN KEY (jogador) REFERENCES Jogador(id),
            pontuacao_jogador INT,
            pontuacao_computador INT,
            vencedor VARCHAR(20)
        );

    2- Para rodar a aplicação, é necessário startar a classe JokenpoWebApplication.java;
    3- Acessar via browser o seguinte endereço:
            
            http://localhost:8080/home

    4- Iniciar o fluxo do sistema.