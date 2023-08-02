import axios from 'axios';

const http = axios.create(
    {baseURL: 'http://localhost:3000/'}
);

export default {

    getTopics() {
        const url = "topics";
        return http.get(url);
    },
    getTopic(id) {
        const url = "topics/" + id;
        return http.get(url);
    }
}