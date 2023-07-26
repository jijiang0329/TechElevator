<template>
<div class="main">
  <h2>Product Reviews for {{name}}</h2>
  <input type="text" v-model="name" />
  <p class="description">{{description}}</p>

  <div class="well-display">
      <div class="well">
          <span class="amount"> {{averageRating}} </span>
          Average Rating
      </div>
  </div>

<!-- to conditionally apply css classes use v-bind:class -->
  <div class="review" v-bind:class="{favorited: review.favorited === true}" 
        v-for="review in reviews" 
        v-bind:key="review.id">
      <h4>{{review.reviewer}}</h4>
      <div class="rating">
          <img v-bind:title="review.rating + ' Stars'" src="../assets/star.png" class="ratingStar"
          v-for="n in review.rating" v-bind:key="n" />
      </div>
      <h3>{{review.title}}</h3>
      <p>{{review.review}}</p>
      <p>Favorite? <input type="checkbox" v-model="review.favorited" /></p>
  </div>
</div>
</template>

<script>
export default {
    name: 'product-reviews',
    computed: {
        averageRating(){
            let sum = 0;
            //to reference our data we need to use keyword "this"
            for(let review of this.reviews) {
                sum += review.rating;
            }

            return sum/this.reviews.length;
        }
    },
    data(){
        return {
            name: "Goosebumps",
            description: "Scary stories for kids",
            reviews: [
                {
                    id: 1,
                    reviewer: "Christopher",
                    title: "Terrifying",
                    review: "I was not allowed to read these as a kid and now I see why",
                    rating: 3,
                    favorited: false
                },
                {
                    id: 2,
                    reviewer: "David",
                    title: "Phantom Of The Auditorium",
                    review: "Makes me want to be a thespian",
                    rating: 4,
                    favorited: false
                },
                {
                    id: 3,
                    reviewer: "Claire",
                    title: "Not As Bad As Oppenheimer",
                    review: "Save yourselves the time",
                    rating: 5,
                    favorited: false
                }
            ]
        }
    }
}
</script>

<style scoped>
.favorited{
    background-color: yellow;
}
p {
    color:green;
}
div.main {
  margin: 1rem 0;
}
div.main div.well-display {
    display: flex;
    justify-content: space-around;
    margin-bottom: 1rem;
}

div.main div.well-display div.well {
    display: inline-block;
    width: 15%;
    border: 1px black solid;
    border-radius: 6px;
    text-align: center;
    margin: 0.25rem;
    padding: 0.25rem;
}

div.main div.well-display div.well span.amount {
    color: darkslategray;
    display: block;
    font-size: 2.5rem;
}

div.main div.review {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
}

div.main div.review div.rating {
    height: 2rem;
    display: inline-block;
    vertical-align: top;
    margin: 0 0.5rem;
}

div.main div.review div.rating img {
    height: 100%;
}

div.main div.review p {
    margin: 20px;
}

div.main div.review h3 {
    display: inline-block;
}

div.main div.review h4 {
    font-size: 1rem;
}
</style>