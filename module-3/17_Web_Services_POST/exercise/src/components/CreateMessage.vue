<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="title">Title</label>
      <input type="text" name="title" v-model="message.title" />
    </div>
    <div class="field">
      <label for="messageText">Message</label>
      <input type="text" name="messageText" v-model="message.messageText" />
    </div>
    <div class="actions">
      <button type="submit" v-on:click="saveMessage()">Save Message</button>
    </div>
  </form>
</template>

<script>
import messageService from "../services/MessageService";

export default {
  name: "create-message",
  props: ["topicId"],
  data() {
    return {
      message: {
        id: Math.floor(Math.random() * (1000 - 100) + 100),
        topicId: this.topicId,
        title: "",
        messageText: ""
      }
    };
  },
  methods: {
    saveMessage() {
      messageService.createMessage(this.message)
            .then((response) => {
                
                
                const id = response.data.topicId;
                const route = {
                    name: "Messages",
                    params: {
                        id: id,
                        
                    }
              
                };

                this.$router.push(route);

            })
            .catch((error) => {
                if(error.response) {
                    //We found the server and got a response back
                    alert("Something went wrong: " + error.response.statusText);
                } else if(error.request){
                    //We could not reach the server
                    alert("We could not reach the server");
                } else {
                    alert("Something went horribly wrong");
                }
            })
    }
  }
};
</script>

<style>
</style>
