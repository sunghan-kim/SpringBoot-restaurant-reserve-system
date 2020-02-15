//console.log("Hi!");

(async () => {
    const url = 'http://localhost:8080/restaurants';
    const response = await fetch(url);
    const restaurants = await response.json();
    console.log(restaurants);

    const element = document.getElementById("app");

    element.innerHTML = JSON.stringify(restaurants);

    const element2 = document.getElementById("app2");

    element2.innerHTML = `
        <p>
            ${restaurants[0].id}
            ${restaurants[0].name}
            ${restaurants[0].address}
        </p>
        <p>
            ${restaurants[1].id}
            ${restaurants[1].name}
            ${restaurants[1].address}
        </p>
    `;

    const element3 = document.getElementById("app3");

    element3.innerHTML = `
        ${restaurants.map(restaurant => `
            <p>
                ${restaurant.id}
                ${restaurant.name}
                ${restaurant.address}
            </p>        
        `).join('')}
    `;

})();