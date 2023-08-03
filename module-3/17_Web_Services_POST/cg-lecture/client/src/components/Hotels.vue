<template>
  <div>
      <h1>Hotels Reservation</h1>

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
                <label>Full Name</label>
                <input type="text" v-model="reservation.fullName">
            </div>
            <div>
                <label>Guests</label>
                <input type="number" min="1" v-model="reservation.guests">
            </div>
            <div>
                <label>Check In:</label>
                <input type="date" v-model="reservation.chechinDate">
            </div>
            <div>
                <label>Check Out:</label>
                <input type="date" v-model="reservation.chechoutDate">
            </div>
            <input type="submit" value="Create Reservation">
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
                chechinDate: "",
                chechoutDate: "",
                guests: 0,
            }
        }
    },
    created(){
        HotelService.getHotels().then( (response) => {
            this.hotels = response.data;
            console.log(response.data);
            this.isLoading = false;
        })
        
    },
    method: {
        onCreateReservation() {
            HotelService.createReservation(this.reservation).then((response) => {
                console.log(response.data);
            })
        }
    }
}
</script>

<style>

</style>