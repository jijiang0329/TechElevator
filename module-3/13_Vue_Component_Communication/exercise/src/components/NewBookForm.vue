<template>
  <div>
      
    <!-- if we want to pass the event we have to put a $ in front of it -->
    <form class="new-book-form" v-on:submit.prevent="addNewBook">
      <div >
        <label for="title">Title:</label>
        <input class="title-input" id="title" type="text" v-model="newBook.title" required />
      </div>

      <div >
        <label for="author">Author:</label>
        <input class="author-input" id="author" type="text" v-model="newBook.author" required />
      </div>

      <div >
        <label for="isbn">ISBN:</label>
        <input class="isbn-input" id="isbn" type="text" v-model="newBook.isbn" required  />
      </div>

      <input type="submit" value="Save" />
      
    </form>
  </div>
</template>

<script>
export default {
    name: 'new-book-form',
    data() {
        return {
            newBook: {
                title:"",
                author:"",
                isbn:""
            }
        }
    },
    methods: {
        addNewBook() {
            this.$store.commit("ADD_NEW_BOOK", this.newBook);
            this.newBookForm= {};
        }
    }

}
</script>

<style>

</style>