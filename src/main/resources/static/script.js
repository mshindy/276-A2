
function selectStudent(name, weight, hair, gpa, height, pid){
    //get form inputs
    document.getElementById("nameInput").value = name;
    document.getElementById("heightInput").value = height;
    document.getElementById("weightInput").value = weight;
    document.getElementById("gpaInput").value = gpa;
    document.getElementById("hairInput").value = hair;
    document.getElementById("pid").value = pid;
    //display edit student form
    var form = document.getElementById("edit-student");
    
    if(form.style.display == "none"){
        form.style.display = "flex";
    }
}

function deleteStudent(){
    //check that all required fields are filled
    var form = document.getElementById("edit-student-form");
    if(!form.checkValidity()){
        return;
    }
    //check that fields have valid input and then make request to database
    //catch errors
    if (validateForm()){
        var pid = document.getElementById("pid").value;
        console.log(pid);

        fetch("/students/" + pid, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
            location.reload();
        })
        .then(data => {
            // Handle success response
            console.log("Student deleted successfully");
            // Redirect to another page if needed
            window.location.href = "added.html";
            location.reload();
        })
        .catch(error => {
            // Handle error
            console.error("Error deleting student:", error);
            location.reload();
        });
    } 
}

//checks that all form inputs contain valid values
function validateForm() {
    var nameInput = document.getElementById("nameInput");
    var heightInput = document.getElementById("heightInput");
    var weightInput = document.getElementById("weightInput");
    var gpaInput = document.getElementById("gpaInput");
    var hairInput = document.getElementById("hairInput");
  
    var letterRegex = /^[A-Za-z]+$/;
    var intRegex = /^[0-9]+$/;
    var numberRegex = /^[0-9.]+$/;
  
    if (!letterRegex.test(nameInput.value)) {
      alert("Name should contain only characters.");
      return false;
    }
  
    if (!intRegex.test(heightInput.value)) {
      alert("Height should contain only numbers.");
      return false;
    }
  
    if (!intRegex.test(weightInput.value)) {
      alert("Weight should contain only numbers.");
      return false;
    }
  
    if (!numberRegex.test(gpaInput.value)) {
      alert("GPA should contain only numbers and '.'.");
      return false;
    }
  
    if (!letterRegex.test(hairInput.value)) {
      alert("Hair color should contain only characters.");
      return false;
    }

    return userConfirm();
  }

  function userConfirm(){
    var isConfirmed = confirm("Are you sure you want to submit?");
    if (isConfirmed){
        return true;
    }
    else {
        return false;
    }

}