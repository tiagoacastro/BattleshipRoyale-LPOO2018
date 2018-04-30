# Battleship-Royale


### Architecture Design


**Package and Class diagram**

![Screenshot](https://i.imgur.com/ttIhpAw.jpg)


**Behavioural Diagram**

![Screenshot](https://i.imgur.com/rHYrxG8.jpg)


**Design Patterns**

**Singleton** - este design pattern servirá para a classe jogo apenas ser instanciada uma vez já que irá ser acedida inúmeras vezes ao longo da execução do programa.

**Builder** - este design pattern servirá para dividir os barcos nas suas secções quadradas permitindo uma separação mais fácil do código.

**Template** - este design pattern servirá para a criação dos vários tipos de barcos, podendo-se implementar novos barcos com as suas caraterísticas individuais sem alterar o algoritmo responsável pelo jogo.

**MVC (Model View Controller)** - usado para facilitar a modularidade e as dependências do jogo.


**GUI Design**

Este é o menu principal do jogo. A partir deste menu, é possível tanto ir para o submenu com as definições como carregar em “Play” com vista a iniciar o jogo.

![Screenshot](https://i.imgur.com/577hvNc.png)

Aqui está representado o menu de definições de jogo. Nele vai ser possível ligar/desligar o som na aplicação tal como controlar o seu volume e voltar para o menu principal do jogo.

![Screenshot](https://i.imgur.com/HcgLIUl.png)

Este mock-up vai conter um text field em que o utilizador introduzirá os dados para se conectar e prosseguirá para o “map editor”

![Screenshot](https://i.imgur.com/JazlU7I.png)

Neste mock-up é possível observar um editor do tabuleiro do utilizador, nele é possível arrastar navios para as posições da matriz desejadas, guardar o tabuleiro esquematizado ou ir buscar um esquema que esteja guardado previamente. 

![Screenshot](https://i.imgur.com/BWRe9dY.png)

Finalmente, é mostrado neste mockup o jogo em si onde o jogador pode jogar, pausar ou sair do jogo. É também aqui mostrado o que o utilizador já destruiu dos navios inimigos e um ícone de definições caso queira alterar definições de som da aplicação.

![Screenshot](https://i.imgur.com/zBIA56i.png)

