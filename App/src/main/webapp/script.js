function state(){
    const state = 'Just califonia for now.';
    const stateContainer = document.getElementById('state');
    stateContainer.innerText = state;
}
function adult(){
    const house = 'No all ages are able to fill this form out.';
    const houseContainer = document.getElementById('adult');
    houseContainer.innerText = house;
}

function house(){
    const house = 'Nope! Everyone is free to fill out the form if need be!';
    const houseContainer = document.getElementById('housing');
    houseContainer.innerText = house;
}
function shelter(){
    const shel = 'Yes! As long as you are able to find a shelter that fits you perfectly!';
    const shelContainer = document.getElementById('shelter');
    shelContainer.innerText = shel;
}
function covid(){
    const shel = 'That depends on the homeless shelter you choose to go to.';
    const shelContainer = document.getElementById('covid');
    shelContainer.innerText = shel;
}