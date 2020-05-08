<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper grey darken-4">
        <a href="#" class="brand-logo center grey-text text-lighten-4"><i class="material-icons right">games</i>Cadastro de Jogos</a>
      </div>
    </nav>

    <!-- FORMULÁRIO -->
    <form @submit.prevent="storeAndUpdateGame">
      <div>
        <input type="text" id="name" placeholder="Digite o nome do jogo" v-model="game.nome">
      </div>
      <div>
        <input type="text" id="genre" placeholder="Digite o gênero do jogo" v-model="game.genero">
      </div>
      <div>
        <input type="text" id="dateRelease" placeholder="Digite o ano de lançamento" v-model="game.data_lancamento">
      </div>
      <div>
        <button class="btn-small grey darken-4 waves-effect waves-green">Cadastrar jogo</button>
      </div>
    </form>

    <h5>Jogos ({{games.length}})</h5>

      <h4 v-show="games.length==0">Não é jogos cadastrados...</h4>
      <table v-show="games.length>0">
        <thead>
          <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Gênero</th>
            <th>Ano de lançamento</th>
            <th>Excluír</th>
            <th>Alterar</th>
          </tr>  
        </thead>
        <tfoot>
          <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Gênero</th>
            <th>Ano de lançamento</th>
            <th>Excluír</th>
            <th>Alterar</th>
          </tr>
        </tfoot>
        <tbody>
          <tr v-for="game in games" :key="game.id">
            <td>{{game.id}}</td>
            <td>{{game.nome}}</td>
            <td>{{game.genero}}</td>
            <td>{{game.data_lancamento}}</td>
            <td>
              <button @click="deleteGame(game)" class="btn-small grey darken-4 waves-effect waves-red">Excluír</button>
            </td>
            <td>
              <button @click="updateGame(game)" class="btn-small grey darken-4 waves-effect waves-green">Alterar</button>
            </td>
          </tr>
        </tbody>
      </table>

      <footer class="page-footer grey darken-4">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Aplicação Web para cadastro de jogos</h5>
                <p class="grey-text text-lighten-4">
                  Trabalho do projeto final da disciplina Desenvolvimento Web III.
                  App desenvovido com VueJS e Materialize para o front-end e SpringBoot
                  para a criação da API.
                </p>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            2020 - Gabriel Rojas
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
          </div>
        </footer>
  </div>
</template>

<script>
  import GameService from './services/gameservice';

  export default {
    data() {
      return {
        game: {
          id:'',
          nome:'',
          genero:'',
          data_lancamento:''
        },
        games: []
      }
    },
    mounted() {
      this.listGames();
    },
    methods: {
      listGames() {
        GameService.findAll().then(response => {
          this.games = response.data;
        })
      },
      storeAndUpdateGame() {
        if(!this.game.id) {
          GameService.store(this.game).then(response => {
            alert("Jogo adicionado com sucesso!");
            this.game = {};
            this.listGames();
            return response;
          })
        } else {
          GameService.update(this.game).then(response => {
            alert("Jogo alterado com sucesso!");
            this.game = {};
            this.listGames();
            return response;
          }) 
        }            
      },
      deleteGame(game) {        
        if(confirm("Tem certeza que deseja excluir esse jogo?")) {
          GameService.delete(game).then(response => {
          alert("Jogo excluído com sucesso!");
          this.listGames();
          return response;
          })
        }
      },
      updateGame(game) {
        this.game = game;
      }
    }
  }
</script> 

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  background-color: #f2f2f2;
  color: #2c3e50;
}
footer{
  margin-top: 350px;
}
</style>
