
document.addEventListener("DOMContentLoaded", () => {
    const btn = document.querySelector("button");
    btn.addEventListener("click", addInputs);
})



function addInputs(event){

    console.log(event);

    const input1 = document.getElementById("input1");
    const input2 = document.getElementById("input2");
   
    const result = document.querySelector("p");

    const val1 = input1.value;
    const val2 = input2.value;

    //could use parseInt or parseFloat as well
    result.innerText =  (new Number(val1)+ new Number(val2)).toFixed(2);

}