// add pageTitle
const title = 'my Shopping List';

// add groceries
const groceries = ['apple', 'orange', 'banana', 'milk',
'juice', 'salsa', 'chips', 'pickles', 'lettuce', 'lime'];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
 const pageTitle = document.getElementById('title');
 pageTitle.innerText = title;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  let groceryList = document.getElementById("groceries");
for(let i=0; i< groceries.length; i++){
  let itemsList = document.createElement('li');
  itemsList.setAttribute('id', 'listItem'+ i );
  groceryList.appendChild(itemsList);
  itemsList.innerText = groceries[i];
}
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted(){
  for(let i = 0; i < groceries.length; i++){
    let itemsList = document.getElementById('listItem'+ i);
    console.log(itemsList);
     itemsList.setAttribute('class', 'completed');
   }
 }

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
