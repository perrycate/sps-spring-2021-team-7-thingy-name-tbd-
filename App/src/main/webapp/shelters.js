// Converts URL parameters to JSON
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const shelters = JSON.parse(urlParams.get('shelters'));

const shelterList = document.querySelector('#main__shelter-list');

for (let shelter of shelters) {
    // creates a division
    let division = document.createElement('div');
    division.setAttribute('class', 'division');
    shelterList.appendChild(division);

    // creates shelter element
    let shelterContainer = document.createElement('div');
    shelterContainer.setAttribute('class', 'shelter-list__shelter');

    let name = document.createElement('div');
    name.setAttribute('class', 'shelter-list__shelter__name');
    name.innerHTML = shelter.name;

    let description = document.createElement('div');
    description.setAttribute('class', 'shelter-list__shelter__description');
    description.innerHTML = shelter.description;

    let number = document.createElement('div');
    number.setAttribute('class', 'shelter-list__shelter__number');
    number.innerHTML = shelter.phoneNum;

    let location = document.createElement('div');
    location.setAttribute('class', 'shelter-list__shelter__location');
    location.innerHTML = shelter.location;

    shelterContainer.appendChild(name);
    shelterContainer.appendChild(description);
    shelterContainer.appendChild(number);
    shelterContainer.appendChild(location);

    // places shelter into DOM
    shelterList.appendChild(shelterContainer);
}
