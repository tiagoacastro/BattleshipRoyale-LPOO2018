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
