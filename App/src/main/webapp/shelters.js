// Converts URL parameters to JSON.
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const shelters = JSON.parse(urlParams.get('shelters'));

const shelterList = document.querySelector('#main__shelter-list');

// inits google map.
const map = new google.maps.Map(document.getElementById("main__shelter-map"), {
  center: { lat: 34.0522, lng: -118.2437 },
  zoom: 10,
});

// used for translating street address to lat & lng.
const geocoder = new google.maps.Geocoder();

// translates regular street addresses into lat & lng.
function geocodeAddress(geocoder, resultsMap, address) {
  geocoder.geocode({ address: address }, (results, status) => {
    if (status === "OK") {
      resultsMap.setCenter(results[0].geometry.location);
      new google.maps.Marker({
        map: resultsMap,
        position: results[0].geometry.location,
      });
    } else {
      alert("Geocode was not successful for the following reason: " + status);
    }
  });
}

for (let shelter of shelters) {
    // creates a division.
    let division = document.createElement('div');
    division.setAttribute('class', 'division');
    shelterList.appendChild(division);

    // creates shelter element.
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

    // creates market on map.
    if (shelter.location !== undefined)
        geocodeAddress(geocoder, map, shelter.location);

    shelterContainer.appendChild(name);
    shelterContainer.appendChild(description);
    shelterContainer.appendChild(number);
    shelterContainer.appendChild(location);

    // places shelter into DOM.
    shelterList.appendChild(shelterContainer);
}
