import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  list() {
    return http.get('/topics');
  },

  get(id) {
    return http.get(`/topics/${id}`);
  },
  createTopic(topic) {

      const url = "topics";
      return http.post(url, topic);

  },
  
  updateTopic(topic){
      const url = "topics/" + topic.id;
      return http.put(url, topic);
  },
  deleteTopic(id){
      const url = "topics/"+id;
      return http.delete(url)
  }

}
