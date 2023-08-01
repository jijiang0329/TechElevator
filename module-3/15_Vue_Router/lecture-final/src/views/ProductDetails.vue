<template>
  <div id="app" class="main">
      <h1>{{product.name}}</h1>
      <p class="description">{{product.description}}</p>
      <div class="actions">
          <router-link v-bind:to="{name: 'products'}">Back To Products</router-link>
          <router-link v-bind:to="{name: 'add-review', params: {productId: product.id}}">
              Add New Review
            </router-link>
      </div>
      <div class="well-display">
          <average-summary />
          <star-summary rating="1" />
          <star-summary rating="2" />
          <star-summary rating="3" />
          <star-summary rating="4" />
          <star-summary rating="5" />
      </div>
      <review-list />
  </div>
</template>

<script>
import AverageSummary from '../components/AverageSummary.vue'
import StarSummary from '../components/StarSummary.vue'
import ReviewList from '../components/ReviewList.vue'

export default {
    name: "product-details",
    components: {
        AverageSummary, StarSummary, ReviewList
    },
    data(){
        return {
            productId: 0
        }
    },
    computed: {
        product(){            
            return this.$store.state.products.find(p => p.id == this.productId); 
        }
    },
    /*This is similar to a constructor, in that it runs once
    right when the component is created, and that's it*/
    created(){
       
       //To pull a variable off the url itself
       this.productId = this.$route.params.productId;
      
      this.$store.commit("SET_ACTIVE_PRODUCT", this.productId);
    }
}
</script>

<style>

</style>