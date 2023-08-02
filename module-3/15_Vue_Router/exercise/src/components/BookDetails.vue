<template>
  <book-card v-bind:book="book"/>
</template>

<script>
import BookCard from './BookCard.vue'

export default {
    components: {
        BookCard
    },
    data(){
        return {
            isbn: 0
        }
    },
    computed: {
        book(){            
            return this.$store.state.books.find(bk => bk.isbn == this.isbn); 
        }
    },
    created(){
       
       //To pull a variable off the url itself
       this.isbn = this.$route.params.isbn;
      
      
    }
}
</script>

<style>

</style>