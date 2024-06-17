# HuntTheWumpus

Este projeto é um jogo completo de exploração de cavernas chamado HuntTheWumpus, onde o jogador deve navegar por um labirinto de cavernas, evitando inimigos e coletando itens.

## Classes

### Jogo
Classe principal que controla o fluxo do jogo. Gera as cavernas, posiciona os elementos como inimigos e inicia o jogo com o jogador em uma caverna aleatória.

#### Métodos da Classe Jogo

- `atirarFlecha`: Permite ao jogador atirar uma flecha na tentativa de eliminar um inimigo na mesma caverna. O sucesso do tiro é determinado aleatoriamente.

### Caverna
Representa uma única caverna no labirinto. Cada caverna pode ter conexões com outras cavernas nas direções leste, oeste, norte e sul. Além disso, uma caverna pode conter um inimigo e possui um indicador se já foi visitada pelo jogador.

### Direcao
Enumeração que representa as possíveis direções que uma caverna pode ter conexões: leste, oeste, norte e sul.

### Inimigo
Classe abstrata que define a estrutura básica de um inimigo no jogo. Cada inimigo tem uma ação que pode afetar o jogador de alguma maneira.

### Menu
Classe responsável por exibir as opções de ação para o jogador e ler a opção escolhida pelo usuário.

### Morcego
Subclasse de Inimigo. Representa um morcego que pode transportar o jogador para outra caverna aleatoriamente.

### Poco
Subclasse de Inimigo. Representa um poço que reduz a vida do jogador quando ele cai nele.

### Wumpus
Subclasse de Inimigo. Representa o Wumpus, uma criatura perigosa que pode devorar o jogador instantaneamente.

### Output
Classe responsável por imprimir informações sobre a caverna atual, resultados de ações e o mapa das cavernas exploradas pelo jogador.

### Player
Classe que representa o jogador no jogo. Mantém informações sobre a caverna atual, vida, número de flechas e estado de vida do jogador.

## Visualização das Cavernas

A visualização das cavernas é feita através de uma representação gráfica no console, onde cada caverna é indicada por um símbolo específico e as conexões entre elas são mostradas, permitindo ao jogador entender sua localização atual e as direções possíveis para movimentação.

## Como Jogar

O jogador navega pelo labirinto de cavernas usando comandos para se mover nas direções disponíveis e atirar flechas quando necessário. O objetivo é encontrar a saída do labirinto sem ser capturado pelos inimigos ou ficar sem flechas.
