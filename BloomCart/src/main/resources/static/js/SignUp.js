const signupForm =
document.getElementById("signup-form");


signupForm.addEventListener("submit", async function(e){

    e.preventDefault();


    const userData = {

        name:
        document.getElementById("name").value,

        email:
        document.getElementById("email").value,

        password:
        document.getElementById("password").value,
		
		role:
		document.getElementById("role").value
    };


    try{

        const response = await fetch(
            "http://localhost:8080/User/create",

            {

                method: "POST",

                headers:{
                    "Content-Type":"application/json"
                },

                body: JSON.stringify(userData)
            }
        );


        if(response.ok){

            alert("Signup Successful!");

            window.location.href = "login.html";
        }

        else{

            alert("Signup Failed!");
        }

    }

    catch(error){

        console.log(error);

        alert("Server Error");
    }

});