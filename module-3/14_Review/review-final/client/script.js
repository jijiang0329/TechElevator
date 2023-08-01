
document.addEventListener("DOMContentLoaded", () => {

    /*
    const btnHotels = document.getElementById("btnHotels");
    btnHotels.addEventListener("click", () => {
        getHotels();
    });
    */
   getHotels();

   const btnCreate = document.getElementById("btnCreate");
   btnCreate.addEventListener("click", createReservation)

})

function createReservation(event) {

    event.preventDefault();

    const hotelId = document.getElementById("hotels").value;
    const fullName = document.getElementById("fullName").value;
    const checkin = document.getElementById("checkin").value;
    const checkout = document.getElementById("checkout").value;
    const numGuests = document.getElementById("guests").value;

    const reservation = {
        hotelId: hotelId,
        fullName: fullName,
        checkinDate: checkin,
        checkoutDate: checkout,
        guests: numGuests
    }

    const request = new XMLHttpRequest();
    request.open("POST", "http://localhost:9000/reservations");
    request.setRequestHeader("Content-Type", "application/json");
    request.onload = () => {

        if(request.status === 201 && request.readyState===4){

            //we could say earlier that request.responseType='json'
            //and it will do the conversion for us, but so that you
            //have another example we can also manually parse text
            //into a json object using JSON.parse
            const newReservation = JSON.parse(request.response);
            alert("Successfully created new reservation: "
             + newReservation.id);

             //if we want to navigate to another page (_blank opens in a new 
             //leave it out if you want to replace current content)
             window.open("/reservation-complete.html", '_blank');

        } else {
            //put error handling here
        }

    };

    //When we are sending data in our request body we need to format
    //the json object. Javascript has a JSON library that can help us
    //with this
    const requestBody = JSON.stringify(reservation);
    request.send(requestBody);

}

function getHotels(){
    
    //To make an HTTP request, we want to use Ajax
    const request = new XMLHttpRequest();

    //open the request, specifying the HTTP verb
    //and the destination
    request.open("GET", "http://localhost:9000/hotels");
    
    //This isn't always necessary but if you see some strange
    //behavior sometimes it helps to be specific about what
    //we expect back
    request.responseType="json";

    //We don't know when the response will come back,
    //it will vary depending on server congestion, etc.
    //but we can tell it that whenever you do come back,
    //run this specific code (below I am assigning an
    // anonymous function to the onload property)
    request.onload = () => {
        
        //we can check the http status and the state
        //of our request. In this case we want to make sure
        //our request is ready (4) and we received a response
        //status of 200
        if(request.readyState===4
            && request.status === 200 ){

            //we can pull the response off the request
            const hotels = request.response;
            console.log(hotels);

            const select = document.getElementById("hotels");
            hotels.forEach( (hotel) => {

                const option = document.createElement("option");
                option.setAttribute("value", hotel.id);
                option.innerText=hotel.name;
                select.appendChild(option);
            })
        }
    }

    //now that it's configured-actually send the request
    request.send();

}