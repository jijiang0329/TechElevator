
document.addEventListener("DOMContentLoaded", () => {

    const btnHotels = document.getElementById("btnHotels");
    btnHotels.addEventListener("click", () => {
        getHotels();
    })
})

function getHotels() {

    const request = new XMLHttpRequest();//Ajax request
    request.open("GET", "http://localhost:9000/hotels");
    request.responseType="json";
    request.onload = () => {
        if(request.status===200 && request.readyState===4){
            const hotels = request.response;
            console.log(hotels);
        }
    }
}