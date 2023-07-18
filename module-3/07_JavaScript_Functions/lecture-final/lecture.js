/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne(asAString) {

  if(asAString){
    return "One";
  }

  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(num1, num2){
  return num1 * num2;
}

function multiplyAll(){

  let product = 1;
  for(let i=0; i < arguments.length; i++){
    product *= arguments[i];
  }

  return product;

}


/**
 * 
 * @param {number} num1 
 * @param {number} num2 
 * @returns 
 */
function multiplyUndefined(num1=0, num2=0){
  return num1 * num2;
}

function concatStrings(string1="", string2=""){
  string1 = 100;
  string2= 300;
  return string1 + string2;
}

 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }

}

/**
 * 
 * @param {string} name the name of the person
 * @param {number} age  the age of the person
 * @param {string[]} listOfQuirks  a list of quirks about the person
 * @param {string} separator string separator
 * @returns 
 */
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

///array functions
function arrayFunctions(){
  const myArray = []; //empty array
  myArray.push(5); //Adding an element to the end of the array
  myArray.unshift(4); //unshift addds to the beginning
  myArray.unshift(3);

  console.log("Pop: " + myArray.pop()); //removes the last element and returns it
  console.log("Shift: " + myArray.shift());//removes the first element and returns it



  return myArray;
}

function isEven(num){
  return num % 2 === 0;
}


function filterExample(){

  const myArray = [2,4,5,6,8,9,12];

  //return array with just even numbers
  /*const evenOnly = [];
  
  for(let num of myArray){

      if(num % 2 === 0){
        evenOnly.push(num);
      }

  }*/

  //const evenOnly = myArray.filter( isEven );

  //Filter returns only the values that return true
  const evenOnly = myArray.filter((num) =>{
    return num % 2 === 0;
  });


  return evenOnly;
}

function welcome(name){
  return "Welcome " + name + "!";
}

function mapExample(){

  const names = ["Christopher","Claire", "Marina","Dan"];

  /*
  const welcomeCards = [];
  for(let name of names){
    const welcome = "Welcome " + name + "!";
    welcomeCards.push(welcome);
  } */

  //const welcomeCards = names.map(welcome);

  const welcomeCards = names.map((name)=>{
    return "Welcome " + name + "!";
  });

  return welcomeCards;
}

function map2Example(){

  const nearEarthAsteroidsFromNASAAPI = [
    {
      asteroid_name: "doom",
      discovery_year: 2000,
      discoverer: "Joe Smith"
    },
    {
      asteroid_name: "earth slayer",
      discovery_year: 2020,
      discoverer: "Tony Pancake"
    },
    {
      asteroid_name: "big guy",
      discovery_year: 2022,
      discoverer: "Doug"
    }
  ];

  
  return nearEarthAsteroidsFromNASAAPI.map( (asteroid) => {
    return {
      asteroidName: asteroid.asteroid_name,
      yearDiscovered: asteroid.discovery_year,
      discoveredBy: asteroid.discoverer
    }
  });

/*
  //if I only wanted the names
  return nearEarthAsteroidsFromNASAAPI.map( (asteroid) => {
    return asteroid.asteroid_name;
  })
*/
}

function forEachExample(){

  const asteroids = map2Example();

  /*
  for(let asteroid of asteroids){
    console.log(asteroid.asteroidName);
  }*/

  asteroids.forEach( (asteroid) => {
    console.log(asteroid.asteroidName)
  })
}

function findExample(){

  const asteroids = map2Example();

  //returns the first instance that is true
  //returns only an individual instance, not a collection
  return asteroids.find( (asteroid) => {
    return asteroid.asteroidName === "earth slayer";
  })

}



/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {

  /*
  let sum = 0;
  for(let num of numbersToSum){
    sum += num;
  }
*/


  let sum = numbersToSum.reduce( (previousValue, currentValue) => {
    return previousValue + currentValue;
  }, 0 //if we want a default start value, put it after the anonymous function

  );


  return sum;
}



function reduceExample2(){

  const asteroids = map2Example();

  return asteroids.reduce( (previousValue, currentValue) => {

    if(previousValue.length === 0) {
      return currentValue.asteroidName;
    } else {
      return previousValue + "," + currentValue.asteroidName
    }

  },""
  )

}
