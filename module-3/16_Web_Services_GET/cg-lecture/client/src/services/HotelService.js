import axios from 'axios';

const http = axios.create(
    {baseURL: 'http://localhost:9000/'}
);

export default {

    getHotels() {
        const url = "hotels";
        return http.get(url);
    },
    getHotel(id) {
        const url = "hotels/" + id;
        return http.get(url);
    }
}