const plusBtns =
document.querySelectorAll(".plus");
const minusBtns =
document.querySelectorAll(".minus");
// PLUS
plusBtns.forEach((btn)=>{
    btn.addEventListener("click", ()=>{

        const quantity =
        btn.parentElement.querySelector(".quantity");

        let value =
        Number(quantity.textContent);

        value++;

        quantity.textContent = value;

    });

});
// MINUS
minusBtns.forEach((btn)=>{

    btn.addEventListener("click", ()=>{

        const quantity =
        btn.parentElement.querySelector(".quantity");

        let value =
        Number(quantity.textContent);

        if(value > 1){

            value--;

            quantity.textContent = value;
        }

    });

});