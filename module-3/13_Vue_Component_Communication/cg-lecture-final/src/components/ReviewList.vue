<template>
<div>
  <div
      class="review"
      v-bind:class="{ favorited: review.favorited }"
      v-for="review in $store.state.reviews"
      v-bind:key="review.id"
      v-on:click="alertEventHappened($event, review.id)"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>
        Favorite?
        <input type="checkbox" v-model="review.favorited" />
      </p>
    </div>
</div>
</template>

<script>
export default {
 name: "review-list",
 methods: {
    /*
     * Returns the next review id. Normally, a database would assign a unique id for the review.
     * This code simulates that since there's no database in this example.
     */
    

    alertEventHappened(event, reviewId){
      alert("An event happened");
      if(event) {
        console.log("Event is " + event);
      }
      if(reviewId){
        console.log("Our review id is " + reviewId)
      }
    },

    
  }
}
</script>

<style>

</style>