import { http } from './api';

export default {

    //Buscar jogos
    findAll:() => {
        return http.get('jogos');
    },

    //Adicionar jogo
    store:(game) => {
        return http.post('jogos', game);
    },

    //Alterar dados dos jogos
    update:(game) => {
        return http.put(`jogos/${game.id}`, game)
    },

    //Deletar jogo
    delete:(game) => {
        return http.delete(`jogos/${game.id}`, { data: game })
    }

}