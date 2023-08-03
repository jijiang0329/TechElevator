<template>
  <div>
      <h1>Make A Reservation</h1>

      <img v-if="isLoading" src="../assets/ping_pong_loader.gif" />

      <div v-if="!isLoading">
        
        <form v-on:submit.prevent="onCreateReservation">
            <div>
                <label>Hotel:</label>
                <select v-model="reservation.hotelId">
                    <option v-for="hotel in hotels" v-bind:key="hotel.id"
                        v-bind:value="hotel.id">
                        {{hotel.name}}
                    </option>
                </select>
            </div>
            <div>
                <label>Full Name:</label>
                <input type="text" v-model="reservation.fullName"
                 required oninvalid="this.setCustomValidity('WE NEED YOUR NAME!!!')"
                    oninput="this.setCustomValidity('')"
                 />
            </div>
            <div>
                <label>Number of Guests:</label>
                <input type="number" min="1" v-model="reservation.guests" />
            </div>
            <div>
                <label>Checkin Date</label>
                <input type="date" v-model="reservation.checkinDate" />
            </div>
            <div>
                <label>Checkout Date</label>
                <input type="date" v-model="reservation.checkoutDate" />
            </div>
            <input type="submit" value="Create Reservation" />
        </form>
      </div>
  </div>
</template>

<script>
import HotelService from '../services/HotelService'

export default {
    data(){
        return {
            isLoading: true,
            hotels: [],
            reservation: {
                hotelId: 0,
                fullName: "",
                checkinDate: "",
                checkoutDate: "",
                guests: 1
            }
        }
    },
    created(){
        HotelService.getHotels().then( (response) => {
            this.hotels = response.data;
            console.log(response.data);

            this.$store.commit("SET_HOTELS", response.data);

            this.isLoading = false;
        })
        
    },
    methods: {
        onCreateReservation(){
            HotelService.createReservation(this.reservation)
            .then((response) => {
                console.log(response.data);
                const reservationId = response.data.id;
                const hotelId = response.data.hotelId;
                const route = {
                    name: "Confirmation",
                    params: {
                        hotelId: hotelId,
                        reservationId: reservationId
                    }
                };

                this.$router.push(route);

            })
            .catch((error) => {
                if(error.response) {
                    //We found the server and got a response back
                    alert("Something went wrong: " + error.response.statusText);
                } else if(error.request){
                    //We could not reach the server
                    alert("We could not reach the server");
                } else {
                    alert("Something went horribly wrong");
                }
            })
        }
    }
}
</script>

<style>

</style>