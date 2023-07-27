<template>
  <div>
    <a href="#" v-on:click.prevent="showForm = true" v-show="showForm == false">Leave Review</a>
    <!-- if we want to pass the event we have to put a $ in front of it -->
    <form v-on:submit.prevent="addNewReview" v-show="showForm">

      <div class="form-element">
        <label for="reviewer">Name:</label>
        <input v-on:keyup.r="alertEventHappened" id="reviewer" type="text" v-model="newReview.reviewer" required />
      </div>

      <div class="form-element">
        <label for="title">Title:</label>
        <input id="title" type="text" v-model="newReview.title" required />
      </div>

      <div class="form-element">
        <label for="rating">Rating:</label>
        <select id="rating" v-model="newReview.rating" required >
          <option value=1>1 Star</option>
          <option value=2>2 Star</option>
          <option value=3>3 Star</option>
          <option value=4>4 Star</option>
          <option value=5>5 Star</option>
        </select> 
      </div>

      <div class="form-element">
        <label for="review">Review:</label>
        <textarea id="review" v-model="newReview.review" required  />
      </div>

      <input type="submit" value="Save" />
      <button v-on:click.prevent="reset">Cancel</button>
    </form>
   </div>
</template>

<script>
export default {
 name: "add-review",
 data(){
     return {
       showForm: false, 
       newReview: {} ,
       nextReviewId: 1004 
     }
 },
 methods: {
     getNextReviewId() {

      return this.nextReviewId++;
    }, 
    addNewReview(){
      this.newReview.id = this.getNextReviewId();
      //the rating is coming in as a string but we want it to be an int
      //so it can calculate the average. I will explicitly cast to a number
      this.newReview.rating = parseInt(this.newReview.rating);
     
     //we cannot do this anymore because state is readonly
     //this.$store.state.reviews.unshift(this.newReview)

     //to call a mutation we use store.commit(mutation_name, payload)
      
      /*
      const payload = {
          param1 : this.newReview,
          param2 : "data",
          param3: 5
      } */
      
      this.$store.commit("ADD_REVIEW", this.newReview);

      this.reset();
    },
    reset(){
      this.newReview = {};
      this.showForm = false;
    }
 }
}
</script>

<style>

</style>