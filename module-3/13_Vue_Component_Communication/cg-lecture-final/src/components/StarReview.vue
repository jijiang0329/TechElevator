<template>
   <div class="well">
        <span class="amount">{{ numberOfReviews }}</span>
        {{rating}} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
      </div>
</template>

<script>
export default {
 name: "star-review",
 props: ["rating"],
 computed: {
     numberOfReviews() {
      return this.$store.state.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === this.rating);
      }, 0);
    }
 }
}
</script>

<style>

</style>