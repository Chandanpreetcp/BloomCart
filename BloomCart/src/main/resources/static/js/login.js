const loginForm =
document.getElementById("login-form");


loginForm.addEventListener("submit", async function(e){

    e.preventDefault();


    const loginData = {

        email:
        document.getElementById("email").value,

        password:
        document.getElementById("password").value
    };


    try{

        const response = await fetch(
            "http://localhost:8080/auth/login",

            {

                method: "POST",

                headers:{
                    "Content-Type":"application/json"
                },

                body: JSON.stringify(loginData)
            }
        );


        if(response.ok){

            alert("Login Successful!");

            window.location.href = "index.html";
        }

        else{

            alert("Invalid Credentials!");
        }

    }

    catch(error){

        console.log(error);

        alert("Server Error");
    }

});