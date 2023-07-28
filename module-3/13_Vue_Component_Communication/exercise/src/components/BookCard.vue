<template>
<div>
  <div class="card" v-bind:class="{read:currentBook.read}">
    <h2 class="book-title">{{currentBook.title}}</h2>
    <h3 class="book-author">{{currentBook.author}}</h3>
    <img v-bind:src="'http://covers.openlibrary.org/b/isbn/' + currentBook.isbn + '-M.jpg'" alt=""
        class="book-image">
    <button class="mark-read" v-if="!currentBook.read" v-on:click="toggle(true)">Mark Read</button>
    <button class="mark-unread" v-if="currentBook.read" v-on:click="toggle(false)">Mark Unread</button>
  </div>
</div>
</template>

<script>
export default {
    name: 'book-card',
    props: ["currentBook"],
    methods: {
        toggle(status) {
            const payload = {
                status: status,
                isbn: this.currentBook.isbn
            }

            this.$store.commit("UPDATE_STATUS", payload);
        }
    }
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
    position: relative;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}

.book-image {
    width: 80%;
}

.mark-read, .mark-unread {
    display: block;
    position: absolute;
    bottom: 40px;
    width: 80%;
    left: 10%;
    font-size: 1rem;
}
</style>