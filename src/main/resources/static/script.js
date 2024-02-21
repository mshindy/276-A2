
function selectStudent(name, weight, hair, gpa, height, pid){
    document.getElementById("nameInput").value = name;
    document.getElementById("heightInput").value = height;
    document.getElementById("weightInput").value = weight;
    document.getElementById("gpaInput").value = gpa;
    document.getElementById("hairInput").value = hair;
    document.getElementById("pid").value = pid;

    var form = document.getElementById("edit-student-form");
    
    if(form.style.display == "none"){
        form.style.display = "block";
    }
}

function deleteStudent() {
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