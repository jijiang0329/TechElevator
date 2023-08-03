<template>
  <div>
      <h1>Your reservation is successful!</h1>
      <p> Your reservation at {{hotel.name}} has been placed for 
          {{reservation.checkinDate}} to {{reservation.checkoutDate}}
          for {{reservation.guests}} guests.
      </p>
      <h3>Confirmation code: {{reservation.id}} </h3>

    
  </div>
</template>

<script>
import HotelService from '../services/HotelService'
export default {
    data(){
        return {
            reservation: null,
            hotel: null
        }
    },
    created(){

        const hotelId = this.$route.params.hotelId;
        const reservationId = this.$route.params.reservationId;

        /*
        HotelService.getHotel(hotelId).then((response) => {
            this.hotel = response.data;
        }) */
        this.hotel = this.$store.state.hotels.find( (hotel) => {
            return hotel.id === hotelId;
        })

        HotelService.getReservation(reservationId).then((response) => {
            this.reservation = response.data;
        })


    }
}
</script>

<style>

</style>