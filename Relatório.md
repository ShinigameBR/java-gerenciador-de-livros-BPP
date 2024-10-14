# Relatório

## Introdução

O código original do sistema de gerenciamento de biblioteca, embora funcional, apresentava diversas áreas de melhoria em relação à legibilidade, manutenibilidade e organização. Este relatório descreve as decisões tomadas durante o processo de refatoração, os problemas corrigidos e a aplicação dos princípios de Clean Code.

##  Problemas Identificados no Código Original
1. Baixa Legibilidade: O código estava concentrado em métodos longos e complexos, dificultando a compreensão do fluxo da aplicação. Os nomes de variáveis e métodos nem sempre eram descritivos.

2. Falta de Encapsulamento: As propriedades das classes Livro e Usuario eram acessíveis diretamente, expondo a lógica interna e dificultando a manutenção do código.

3. Repetição de Código: O código apresentava trechos repetidos, como a lógica de validação e procura de livros e usuários, o que indicava uma falta de abstração.

4. Mistura de Responsabilidades: A classe Main estava sobrecarregada com a lógica de negócios e a interação com o usuário, o que tornava o código mais difícil de manter.

5. Tratamento Inadequado de Erros: A gestão de erros e exceções era insuficiente, resultando em mensagens de erro confusas para o usuário.

## Decisões Tomadas Durante a Refatoração
1. Aplicação do Encapsulamento
As classes Livro e Usuario foram modificadas para ter suas propriedades como privadas, utilizando métodos getter e setter para acessá-las. Essa abordagem promove o encapsulamento, permitindo que a lógica de negócios controle como as propriedades são manipuladas. Isso reduz a possibilidade de erros e facilita a manutenção.

2. Criação de Métodos Menores e Responsáveis
Os métodos foram divididos em unidades menores e mais focadas. Por exemplo, o método main foi simplificado, e operações específicas como adicionarLivro, registrarUsuario, emprestarLivro e devolverLivro foram extraídas. Essa separação ajuda a aumentar a legibilidade e facilita a compreensão da lógica do programa.

3. Nomes Descritivos e Coerentes
Nomes de variáveis, métodos e classes foram melhorados para serem mais descritivos. Nomes descritivos ajudam a reduzir a necessidade de comentários e melhoram a auto-documentação do código.

4. Organização da Lógica de Negócios
A lógica relacionada ao gerenciamento de livros e usuários foi centralizada na classe Biblioteca, enquanto a classe GerenciadorDeLivros foi simplificada para se concentrar apenas na interação com o usuário. Isso separa as preocupações, resultando em um código mais modular.

5. Melhoria no Tratamento de Erros
Foi implementada uma abordagem para o tratamento de erros e validações. Mensagens de erro foram adicionadas, e as verificações de condições, como a disponibilidade de um livro, foram aprimoradas. Isso melhora a experiência do usuário e torna o sistema mais confiável.

## Aplicação dos Princípios de Clean Code
A refatoração do código seguiu os princípios fundamentais de Clean Code:

1. Legibilidade: O código refatorado é mais fácil de ler e entender. A utilização de nomes descritivos e a divisão em métodos menores aumentam a clareza.

2. Manutenibilidade: Com a lógica de negócios organizada e separada da interação com o usuário, o código é mais fácil de manter e modificar. Qualquer mudança futura pode ser implementada com um menor risco de introduzir erros.

3. Simplicidade: A simplicidade foi priorizada em cada decisão, evitando complexidade desnecessária e garantindo que cada método tenha uma única responsabilidade.

4. Evitar Repetição: A refatoração eliminou a duplicação de código, criando métodos específicos para operações que eram realizadas repetidamente.

5. Teste Facilmente: Com a separação clara de responsabilidades e a organização do código, fica mais fácil implementar testes automatizados para verificar o funcionamento correto do sistema.

## Conclusão
A refatoração do sistema de gerenciamento de biblioteca resultou em um código mais limpo, legível e fácil de manter. As decisões tomadas foram fundamentadas nos princípios de Clean Code, abordando problemas como baixa legibilidade, repetição de código e falta de encapsulamento. O resultado é um sistema mais robusto, que pode ser facilmente expandido e adaptado a novas necessidades no futuro.