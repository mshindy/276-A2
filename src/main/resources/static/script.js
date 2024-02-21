
function selectStudent(name, weight, hair, gpa, height, pid){
    document.getElementById("nameInput").value = name;
    document.getElementById("heightInput").value = height;
    document.getElementById("weightInput").value = weight;
    document.getElementById("gpaInput").value = gpa;
    document.getElementById("hairInput").value = hair;
    document.getElementById("pidInput").value = pid;

    var form = document.getElementById("edit-student-form");
    
    if(form.style.display == "none"){
        form.style.display = "block";
    }
}