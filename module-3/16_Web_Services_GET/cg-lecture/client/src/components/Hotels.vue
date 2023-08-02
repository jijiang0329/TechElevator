<template>
  <div>
      <h1>Hotels</h1>
      <img v-if="isloading" src="../assets/ping_pong_loader.gif" alt="">
      <div v-if="!isloading"><h2 v-for="hotel in hotels" v-bind:key="hotel.id">
            {{hotel.name}}
      </h2></div>
  </div>
</template>

<script>
import HotelService from '../services/HotelService'
export default {
    data() {
        return {
            isloading: true,
            hotels: []
        }
    },
    created() {
        HotelService.getHotels().then( (response) => {
            this.hotels = response.data;
            console.log(response.data);
            this.isloading = false;
        })
        
    }
}
</script>

<style>

</style>