# Battleship-Royale


### Group Info

up201605926 - João Malheiro de Sousa (up201605926@fe.up.pt)

up201606186 - Tiago Araújo Castro (up201606186@fe.up.pt)

### JavaDoc
[JavaDoc](https://joaomalheiro.github.io/)

### Package and Class diagram
    (Compacted, Complete on UML folder)
    
![Screenshot](https://i.imgur.com/RWPzqRf.jpg)


### Design Patterns

  **Singleton** - este design pattern servirá para a classe jogo apenas ser instanciada uma vez já que irá ser acedida inúmeras vezes ao longo da execução do programa.

  **Builder** - este design pattern servirá para dividir os barcos nas suas secções quadradas permitindo uma separação mais fácil do código.

  **Template** - este design pattern servirá para a criação dos vários tipos de barcos, podendo-se implementar novos barcos com as suas caraterísticas individuais sem alterar o algoritmo responsável pelo jogo.
  
  **Strategy** -  design pattern utilizado para facilitar a criação das várias dificuldades do jogo e alterar o comportamento do bot com os behaviours criados.

  **MVC (Model View Controller)** - usado para facilitar a modularidade e as dependências do jogo.
  
  
### Instalação

Instalar a APK que se encontra na pasta Executables ou correr o JAR ((java -jar Battleship_Royale.jar) na pasta Executables)


### Manual do Utilizador

MENU

Este é o menu inicial do jogo. Nele é possível retirar a música que está a ser tocada, iniciar sessão no facebook e continuar na aplicação carregando em “Play”.

![Screenshot](https://i.imgur.com/KeMjLJc.png)

CREATOR

De seguida, passamos para o CreatorScreen. Nele, o utilizador tem a tarefa de escolher o posicionamento dos seus navios no tabuleiro. É de acrescentar que o jogo só procede para o próximo ecrã quando todos os navios estiveram colocados. Também é possível rodar os navios para os colocar no tabuleiro carregando, após carregar no navio pretendido, no botão rotate e de seguida tocando na célula pretendida.

![Screenshot](https://i.imgur.com/ewSyR8l.png)
![Screenshot](https://i.imgur.com/MkNETyv.png)

DIFFICULTY

Aqui escolhe-se a dificuldade do jogo,  tendo três opcões, EASY, HARD e CRAZY.

![Screenshot](https://i.imgur.com/IJcULM1.png)

GAME

Aqui pode-se ver o ecrã de jogo. Nele é possível ver os dois tabuleiros de jogo (utilizador e bot) ou então alternar o tabuleiro com os navios do user com imagens que representam os navios que ainda faltam destruir. Para jogar, se o aparelho do utilizador tiver giroscópio, ele tem de carregar na célula e rodar o telemóvel para a frente (ecrã para cima). Se não o tiver, ele deverá apenas tocar na célula a disparar. O jogo sairá deste menu assim que o user ou o bot destruam os navios todos do adversário. É de notar também a possibilidade de parar a música de jogo no botão com icone de som.

![Screenshot](https://i.imgur.com/aETthwH.png)
![Screenshot](https://i.imgur.com/LWE9GEW.png)
![Screenshot](https://i.imgur.com/8i9M5HI.png)
![Screenshot](https://i.imgur.com/0BNGJ0X.png)

END SCREEN

Por fim, este é o menu final do jogo que indica se o utilizador perdeu ou ganhou (outcome do jogo) e permite ao mesmo voltar ao menu inicial se ele desejar jogar outra vez pressionando em qualquer parte do ecrã.

![Screenshot](https://i.imgur.com/lh7vYeH.png)


### Apreciação do trabalho desenvolvido e reflexão

As dificuldades no trabalho começaram no inicio, devido ao pouco conhecimento de programação em android e libgdx, a própria criação do projeto no inicio foi um desafio. No desenvolvimento do trabalho, houve certa dificuldade em perceber como fazer a user interface, mas após alguma pesquisa este problema foi ultrapassado. Tivemos também muita indecisão quanto aos temas que iamos abordar para o nosso trabalho, tendo de inicio a ideia de fazer networking (multiplayer) e android, mas no inicio/meio do trabalho decidimos mudar o nosso objetivo, trocando para uma abordagem mais individual acabando por nos decidir por intelegencia artificial (single player), android e social. A razão pela qual mudamos o nosso foco foi porque a forma como o trabalho estava a ser estruturado não iria propor uma boa aplicação do networking, logo, decidimos ir pela AI com a qual ficamos bastante contentes (esta contem três dificuldades,  sendo a facil tiros random, a hard tiros random a inicio, apos acertar num barco procura a sua volta para acertar noutra parte do barco e obter a sua orientação mandando o barco abaixo conseguentemente e a crazy que consiste no hard mode mas com 2 tiros por turno). Outra grande dificuldade encontrou-se na especificação das funções para o caso do carrier ship (em L) necessitando algoritmos mais complexos (no caso do hard mode, para mandar o barco abaixo teve-se que desenvolver bastante o algoritmo para o adaptar).
Saimos deste trabalho com maior conhecimento de android development e libgdx. Aprendemos também (de novo) a começar os trabalhos com mais tempo de forma a fazer as coisas com mais tempo. 
O trabalho foi desenvolvido ao longo de 1 semana e meia (de forma mais intensiva) por uma media de 4 horas por dia na primeira meia semana e cerca de 6~7 horas diarias na ultima semana.
Distribuição do trabalho: Tiago Castro 55% VS X 45% João Malheiro
