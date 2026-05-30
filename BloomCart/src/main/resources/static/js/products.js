console.log("Js is running");
let cartCount = 0;

const buttons =
document.querySelectorAll(".cart-btn");

const cartDisplay =
document.getElementById("cart-count");



function displayProducts(products) {
    let container = document.getElementById("productContainer");

    container.innerHTML = "";

    products.forEach(p => {
        container.innerHTML += `
            <div class="product-card">
                <img src="${p.imageUrl}" alt="${p.name}">
                <h3>${p.name}</h3>
                <p>${p.description}</p>
                <h4>₹${p.price}</h4>

                <button onclick="addToCart(${p.id})">
                    Add to Cart
                </button>
            </div>
        `;
    });
}
document.addEventListener("DOMContentLoaded", loadProducts);

function loadProducts() {
    fetch("http://192.168.1.41:8080/Product/all")
        .then(res => res.json())
        .then(data => {
            displayProducts(data);
        })
        .catch(err => console.log("Error:", err));
}


function addToCart(productId) {
    let cart = JSON.parse(localStorage.getItem("cart")) || [];

    cart.push(productId);

    localStorage.setItem("cart", JSON.stringify(cart));

    alert("Added to cart!");
}
