<template>
  <div class="main">
    <h2 v-on:click="alertEventHappened">Product Reviews for {{ $store.state.name }}</h2>

    <p class="description">{{ $store.state.description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount">{{ averageRating }}</span>
        Average Rating
      </div>

      <star-review rating="1"  />
      <star-review rating="2"  />
      <star-review rating="3"  />
      <star-review rating="4"  />
      <star-review rating="5"  />


      
    </div>

    <add-review />

    <review-list />
  </div>
</template>

<script>
import StarReview from './StarReview.vue'
import AddReview from './AddReview.vue'
import ReviewList from './ReviewList.vue'

export default {
  name: "product-review",
  components: {
    StarReview, AddReview, ReviewList
  },
  data() {
    return {
};
  },
  computed: {
    averageRating() {
      let sum = this.$store.state.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      console.log("Sum is " + sum)
      return (sum / this.$store.state.reviews.length).toFixed(2);
    }
  }
};
</script>

<style>

</style>

