<template>
  <div id="app">
    
    <product-reviews />
    <p>Test Paragraph</p>
  </div>
</template>

<script>
import ProductReviews from "./components/ProductReviews.vue"

export default {
  name: "app",
  components: {
    ProductReviews
  }
}
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  max-width: 800px;
}
</style>
