import axios from 'axios'

const http = axios.create(
    {baseURL: 'http://localhost:9000/'}
)

//anything in export is public for others to call
export default {

    getHotels(){
        //alert("In Our Service - Get Hotels")
        const url = "hotels"
        return http.get(url);

    },
    getHotel(id){
        const url = "hotels/" + id;
        return http.get(url);
    },
    createReservation(reservation) {

        const url = "reservations";
        return http.post(url, reservation);

    },
    getReservation(id){
        const url = "reservations/"+id;
        return http.get(url);
    },
    updateReservation(reservation){
        const url = "reservations/" + reservation.id;
        return http.put(url, reservation);
    },
    deleteReservation(id){
        const url = "reservations/"+id;
        return http.delete(url)
    }

}