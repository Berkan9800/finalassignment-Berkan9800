export default class GamesService {
    async getGameIds() {
        // TODO: fetch alle games van de de service, idealiter zonder alle details
        // return Promise.resolve(['dummy-1', 'dummy-2']);
        return fetch("/restservices/snake/gamestaticsallgames")
            .then(response => response.json())
            .then(data => {
                document.querySelector("#text1").textContent = JSON.stringify(data)
            })
            .catch(error => {
                console.log(error.message)
            })


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

        if (gameId === undefined) {
            console.log("error bij functie getReplay")
        } else {
            console.log("gelukt bij functie getReplay");
            return fetch(`restservices/snake/${gameId}`)
                .then(response => response.json())
                .then(data => {
                    document.querySelector("#text2").textContent = JSON.stringify(data)

                }).catch(error => {
                    console.log(error.message)
                })
        }

    }

    async removeReplay(gameId) {
        //TODO: gebruik fetch om een enkele game (bij de server) te deleten
        // return Promise.resolve();
        if (gameId === undefined) {
            console.log("error bij functie removeReplay")
        } else {
            console.log("gelukt bij functie removeReplay");
            return fetch(`restservices/snake/${gameId}`, {method: "DELETE"})
                .then(response => response.json())
                .then(data => {
                    document.querySelector("#text3").textContent = JSON.stringify(data)
                }).catch(error => {
                    console.log(error.message)
                })
        }

    }
}
