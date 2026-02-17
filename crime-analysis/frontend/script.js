const fileInput = document.getElementById("fileInput");
const fileName = document.getElementById("fileName");
const result = document.getElementById("result");

fileInput.addEventListener("change", function() {
    if (this.files.length > 0) {
        fileName.textContent = this.files[0].name;
    }
});

function processFile() {
    if (fileInput.files.length === 0) {
        alert("Please select a CSV file first.");
        return;
    }

    result.innerHTML = "✔ File uploaded successfully! Ready for analysis.";
}
