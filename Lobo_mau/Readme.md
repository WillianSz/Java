# OBI - Modalidade Nível 2 
## Fase 2
### Lobo Mau - [OBI](https://olimpiada.ic.unicamp.br/pratique/p2/2006/f2/lobo/)
Na fazenda do Sr. Amarante existe um certo número de ovelhas. Enquanto elas estão dormindo profundamente, alguns lobos famintos tentam invadir a fazenda e atacar as ovelhas. Ovelhas normais ficariam indefesas diante de tal ameaça, mas felizmente as ovelhas do Sr. Amarante são praticantes de artes marciais e conseguem defender-se adequadamente.

A fazenda possui um formato retangular e consiste de campos arranjados em linhas e colunas. Cada campo pode conter uma ovelha (representada pela letra ‘k’), um lobo (letra ‘v’). uma cerca (símbolo ‘#’) ou simplesente estar vazio (símbolo ‘.’). Consideramos que dois campos pertencem a um mesmo pasto se podemos ir de um campo ao outro através de um caminho formado somente com movimentos horizontais ou verticais, sem passar por uma cerca. Na fazenda podem existir campos vazios que não pertencem a nenhum pasto. Um campo vazio não pertence a nenhum pasto se é possível "escapar" da fazenda a partir desse campo (ou seja, caso exista um caminho desse campo até a borda da fazenda). Durante a noite, as ovelhas conseguem combater os lobos que estão no mesmo pasto, da seguinte forma: se em um determinado pasto houver mais ovelhas do que lobos, as ovelhas sobrevivem e matam todos os lobos naquele pasto. Caso contrário, as ovelhas daquele pasto são comidas pelos lobos, que sobrevive. Note que caso um pasto possua o mesmo número de lobos e ovelhas, somente os lobos sobreviverão, já que lobos são predadores naturais, ao contrário de ovelhas.

Escreva um programa que, dado um mapa da fazenda do Sr. Amarante indicando a posição das cercas, ovelhas e lobos, determine quantas ovelhas e quantos lobos estarão vivos na manhã seguinte.

Entrada
A entrada contém um único conjunto de testes, que deve ser lido do dispositivo de entrada padrão. A primeira linha da entrada contém dois inteiros R e C e que indicam respectivamente o número de linhas e de colunas de campos da fazenda. Cada uma das R linhas seguintes contém C caracteres, representando o conteúdo do campo localizado naquela linha e coluna (espaço vazio, cerca, ovelha ou lobo).

Saída
Seu programa deve imprimir, na saída padrão, uma única linha, contendo dois inteiros, sendo que o primeiro representa o número de ovelhas e o segundo representa o número de lobos que ainda estarão vivos na manhã seguinte.

<h3 align="center">
  <img width="700px" src="https://i.imgur.com/Q2DStaN.png" alt="">
</h3>
