/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
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

 function multiplyTogether(firstParameter, secondParameter) {
   return firstParameter * secondParameter;
 }

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */

function multiplyNoUndefined(firstParameter = 0, secondParameter = 0) {
  return firstParameter * secondParameter;
}

 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * Will this show?
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
  if(typeof scopedToBlock !== 'undefined'){
    if ((inScopeInScopeTest && scopedToBlock)) {
      console.log("This won't print!");
      console.log("scopeToBlock is in scope due to VAR HOISTING and can be accessed")
    }
  }else{
    console.log("scopeToBlock is not in scope and cannot be accessed")
  }
}

/**
 * Take the details of a person and create an English readable sentence
 * that uses that information to describe them. We join the quirks together
 * with the separator, or `, ` by default.
 * 
 * @param {string} name The name of the quirky person
 * @param {number} age The age of the quirky person
 * @param {string[]} listOfQuirks  The list of funny quirks
 * @param {string} separator The character or string used to separate the quirks
 * @returns {string} The full english sentence describing a person and their quirks
 */

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce(
    (sum, numberToAdd) => {
      return sum + numberToAdd;
    }
  );
}

let baseValue = 250;

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum adding it to a baseValue using a second .reduce parameter 
 * representing the initial value.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbersAddToBase(numbersToSum) {
  return numbersToSum.reduce(
    (sum, numberToAdd) => {
      return sum + numberToAdd;
    }, 
    baseValue
  );
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {

  return numbersToFilter.filter( 
    (number) => {
      return number % 3 === 0;
    }
  );

}

/**
 * Takes an array and generates their sum. Uses non-anonymous function.
 * @name sumAllNumbersNonAnon
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbersNonAnon(numbersToSum){
  return numbersToSum.reduce(addNumbers);
}

function addNumbers(value1, value2){
  return value1 + value2;
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3, and uses a non-anonymous function.
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThreeNonAnon(numbersToFilter){
  return numbersToFilter.filter(isDivisibleByThree);
}


function isDivisibleByThree(number){
  return number % 3 === 0;
}

/**
 * How about making it more generic to take in any filter???
 * 
 * @param {number[]} numbersToFilter 
 * @param {function} filterMethod 
 */

function allMatchingDefinedFilterDefinition(numbersToFilter, filterMethod){
  return numbersToFilter.filter(filterMethod);
}

function isDivisibleByThree(value){
  return value % 3 === 0;
}

function isDivisibleBySeven(value){
  return value % 7 === 0;
}

function containsHello(value){
  return String(value).indexOf("hello") >= 0;
}

/**
 * BONUS CHALLENGE, IT'S NOW 90% OF THE WAY THERE. 
 * CAN YOU MAKE IT RETURN A SINGLE ARRAY OF ALL VALUES??
 * @param {function[]} filters The collection of filters to apply to the sourceArray
 * @param {function} filterExecutor The function used to process each filter
 * @param {object[]} sourceArray The source of values
 */
function executeMultipleFilters(filters, filterExecutor, sourceArray){

  let result = [];

  filters.forEach((filter) => {
    result.push(    filterExecutor(sourceArray, filter) );
    
  });

  return result;

}