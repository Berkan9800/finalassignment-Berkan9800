export default class SnakeService {
    async getSnake() {

        return fetch("/restservices/snake")
            .then(response => response.json());



        //TODO: haal deze data van de server
        // return Promise.resolve({
        //     apiversion: "1",
        //     author: "de dapper student",
        //     color: "#ff0000",
        //     head: "default",
        //     tail: "default",
        //     version: "0.1"
        // });
    }

    async updateSnake(updatedSnake) {
        //TODO: update je slang aan de server-kant met de nieuwe gegevens

        let fetchOptions = {
            method: "PUT",
            body: JSON.stringify(updatedSnake),
            headers: {"Content-type": "application/json"}
        }
        return fetch("/restservices/snake/updatedSnake",fetchOptions)
            .then(response => response.json())
    }
}
