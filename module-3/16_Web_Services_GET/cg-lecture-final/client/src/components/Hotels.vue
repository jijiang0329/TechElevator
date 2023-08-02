<template>
  <div>
      <h1>Hotels</h1>

      <img v-if="isLoading" src="../assets/ping_pong_loader.gif" />

      <div v-if="!isLoading">
        <h2  v-for="hotel in hotels" v-bind:key="hotel.id">
            {{hotel.name}}
        </h2>
      </div>
  </div>
</template>

<script>
import HotelService from '../services/HotelService'

export default {
    data(){
        return {
            isLoading: true,
            hotels: []
        }
    },
    created(){
        HotelService.getHotels().then( (response) => {
            this.hotels = response.data;
            console.log(response.data);
            this.isLoading = false;
        })
        
    }
}
</script>

<style>

</style>