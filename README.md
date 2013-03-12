Algoritimo de Conjunto
==================

Coleção de métodos implementados para operações de conjuntos genéricos.

## Manipulação do conujunto

***input***

    Conjunto<String> a = new Conjunto<String>("A");      // Cria um conjunto 'A' do tipo String
    a.Adicionar("gato");                                 // Adiciona um elemento 'gato' no conjunto
    a.Adicionar("leão");
    a.Remover("leão");                                   // Remove o elemento 'leão' do conjunto.
    a.Imprimir();                                        // Imprime o conjunto

***output***

    A = { gato }

## Operação de conjuntos

***input***

    Conjunto<String> a = new Conjunto<String>("A");
    a.Adicionar("gato");
    a.Adicionar("coelho");
    a.Adicionar("cachorro");
    
    Conjunto<String> b = new Conjunto<String>("B");
    b.Adicionar("leão");
    b.Adicionar("urso panda");
    b.Adicionar("coelho");
    
    Conjunto<String> c;

    a.Pertinencia("gato");                              // Verifica se o elemento 'gato' contem no conjunto 'a'
    a.Continencia(b);                                   // Verifica se o conjunto B está contido em A.
    
    c = a.Uniao(b);                                     // Une o conjunto 'b' no conjunto 'a'. (A U B)
    c.Imprimir();
    
    c = a.Interseccao(b);                               // Informa a intersecção do conjunto 'b' em 'a'. (A ^ B)
    c.Imprimir();
    
    c = a.Diferenca(b);                                 // Informa a diferença do conjunto 'b' em 'a'.
    c.Imprimir();
    
***output***

    true                                                // retorno para Pertinencia                              
    false                                               // retorno para Continencia
    
    A U B = { gato, coelho, cachorro, leão, urso panda }// conjunto 'A U B', resultado da união.
    A ^ B = { coelho }                                  // conjunto 'A ^ B', resultado da intersecção.
    A - B = { gato, cachorro }                          // conjunto 'A - B', resultado da diferença.

## Conjunto universo

Definindo um conjunto universo num conjunto `u`, podemos utiliza o método `Complemento` para saber o Complemento de um conjunto `a`

***input***

    a.Complemento(u);

## Operações avançadas de conjunto

***input***

    Conjunto<Integer> a = new Conjunto<Integer>("A");
    a.Adicionar(1);
    a.Adicionar(2);
    a.Adicionar(3);
    
    Conjunto<Integer> b = new Conjunto<Integer>("B");
    b.Adicionar(2);
    b.Adicionar(4);
    b.Adicionar(6);
    
    Conjunto<Tuplas<Integer>> c = a.Cartesiano(b);       // Informa o produto Cartesiano
    c.Imprimir();
    
***output***

    A x B = {(1, 2), (1, 4), (1, 6), (2, 2), (2, 4), (2, 6), (3, 2), (3, 4), (3, 6)} 

## Outros métodos

***input***

    Conjunto<String> a = new Conjunto<String>("A");
    a.Adicionar("gato");
    a.Adicionar("coelho");
    a.Adicionar("cachorro");
    
    a.ehVazio();                                        // Verifica se o conjunto 'a' é vazio.
    a.Cardinalidade();                                  // Informa a cardinalidade do conjunto 'a'.
    a.Limpar();                                         // Limpa o conjunto 'a'.

***output***

    false                                               // retorno para ehVazio
    3                                                   // retorno para Cardinalidade
