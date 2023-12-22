App desenvolvido com base no consumo da api do githun: https://api.github.com

O projeto foi implementado utilizando a arquitetura MVVM, respeitando padrões do clean e utilizando componentes do jetpack compose.

Libs utilizadas:
- Koin (DI)
- Retrofit
- Navigation
- Gson
- Coil
- Okhttp
- JUnit
- Mocck

  Resumo do projeto:

O app inicialmente mostra uma lista geral de usuarios do github, consumindo o endpoint: https://api.github.com/users
(Para esta primeira listage, foi utilizado um filtro na chamada, listando apenas uma amostra específica)

Na tela inicial é possível acessar os detalhes de um dos usuários da lista, bem como pesquisar um novo usuário e acessar seus detalhes.

Dentro da tela de detalhes, é possível ver algumas informações extras do usuário e navegar até uma nova tela que mostra a lista de repositórios do usuário, com detalhes
dos projetos, por exemplo nome, linguagem utilizada, quantidade de favoritos entre outros.
Ao clicar na lista de repositoios o usuário é direcionado a página do github com o respectivo projeto do repositório.
