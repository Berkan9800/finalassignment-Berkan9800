export default class GamesService {
    async getGameIds() {
        //TODO: fetch alle games van de de service, idealiter zonder alle details
        // return Promise.resolve(['dummy-1', 'dummy-2']);
        return fetch("restservices/snake")
            .then(response => response.status)

    }

    async getReplay(gameId) {
        //TODO: fetch de details van een enkele game. Let wel, het staat vrij wat voor informatie je precies toont
        //zolang je maar laat zien dat je data kunt opslaan over meerdere zetten heen. Dus deze dummy-data is puur
        //ter illustratie.

        // return Promise.resolve({
        //     id: 'altijd-dezelfde',
        //     aantalBeurten: 42,
        //     meestBezochtePlek: { x: 3, y: 5},
        //     redenEind: 'muur-geraakt',
        //     aantalBochtjesLinksaf: 27
        // });

        return fetch(`restservices/snake/${gameId}`)
            .then(response => response.status)
    }

    async removeReplay(gameId) {
        //TODO: gebruik fetch om een enkele game (bij de server) te deleten
        // return Promise.resolve();
        return fetch(`restservices/snake/${gameId}`, {method: "DELETE"})
            .then(response => response.status)
    }
}
