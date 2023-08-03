import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  get(id) {
    return http.get(`/messages/${id}`);
  },

  createMessage(message) {

      const url = "messages";
      return http.post(url, message);

  },
  
  updateMessage(message){
      const url = "messages/" + message.id;
      return http.put(url, message);
  },

  deleteMessage(id){
      const url = "messages/"+id;
      return http.delete(url)
  }

}
