# Battleship-Royale

### Group Info

up201605926 - João Malheiro de Sousa (up201605926@fe.up.pt)

up201606186 - Tiago Araújo Castro (up201606186@fe.up.pt)

### JavaDoc
[JavaDoc](https://joaomalheiro.github.io/)

### Architecture Design


### Package and Class diagram
    (Compacted)
    
![Screenshot](https://i.imgur.com/RWPzqRf.jpg)


### Behavioural Diagram

![Screenshot](https://i.imgur.com/rHYrxG8.jpg)


### Design Patterns

  **Singleton** - este design pattern servirá para a classe jogo apenas ser instanciada uma vez já que irá ser acedida inúmeras vezes ao longo da execução do programa.

  **Builder** - este design pattern servirá para dividir os barcos nas suas secções quadradas permitindo uma separação mais fácil do código.

  **Template** - este design pattern servirá para a criação dos vários tipos de barcos, podendo-se implementar novos barcos com as suas caraterísticas individuais sem alterar o algoritmo responsável pelo jogo.

  **MVC (Model View Controller)** - usado para facilitar a modularidade e as dependências do jogo.

  **Strategy** -  design pattern utilizado para facilitar a criação das várias dificuldades do jogo e alterar o comportamento do bot com os behaviours criados.
  
### Manual do Utilizador

Este é o menu inicial do jogo. Nele é possível retirar a música que está a ser tocada, iniciar sessão no facebook e continuar na aplicação carregando em “Play”.

![Screenshot](https://i.imgur.com/KeMjLJc.png)

De seguida, passamos para o CreatorScreen. Nele, o utilizador tem a tarefa de escolher o posicionamento dos seus navios no tabuleiro. É de acrescentar que o jogo só procede para o próximo ecrã quando todos os navios estiveram colocados. Também é possível rodar os navios para os colocar no tabuleiro carregando, após carregar no navio pretendido, no botão rotate e de seguida tocando na célula pretendida.

![Screenshot](https://i.imgur.com/ewSyR8l.png)
![Screenshot](https://i.imgur.com/MkNETyv.png)

CREATOR

![Screenshot](https://i.imgur.com/IJcULM1.png)

Aqui pode-se ver o ecrã de jogo. Nele é possível ver os dois tabuleiros de jogo (utilizador e bot) ou então alternar o tabuleiro com os navios do user com imagens que representam os navios que ainda faltam destruir. Para jogar, se o aparelho do utilizador tiver giroscópio, ele tem de carregar na célula e rodar o telemóvel para a frente (ecrã para cima). Se não o tiver, ele deverá apenas tocar na célula a disparar. O jogo sairá deste menu assim que o user ou o bot destruam os navios todos do adversário. É de notar também a possibilidade de parar a música de jogo no botão com icone de som.

![Screenshot](https://i.imgur.com/fqsa4tY.png)
![Screenshot](https://i.imgur.com/LWE9GEW.png)
![Screenshot](https://i.imgur.com/8i9M5HI.png)
![Screenshot](https://i.imgur.com/ns7PLgg.png)

Por fim, este é o menu final do jogo que indica se o utilizador perdeu ou ganhou (outcome do jogo) e permite ao mesmo voltar ao menu inicial se ele desejar jogar outra vez pressionando em qualquer parte do ecrã.

![Screenshot](https://i.imgur.com/lh7vYeH.png)

### Test Design

  **-** Testar bom funcionamento e comportamento de todos os botões presentes nos menus (play, settings, etc);

  **-** Testar se quando todos os pontos de um navio são alvo de um tiro do adversário ele “afunda”;

  **-** Testar que não é possível sobrepor navios ao dar setup ao tabuleiro de jogo;

  **-** Testar se os toques no ecrã por parte do utilizador são lidos corretamente (em termos de coordenadas) no jogo;

  **-** Testar se o jogo termina quando todos os navios de um jogador tiverem sido destruidos;

  **-** Testar a ligação entre os dois telemóveis através do servidor
