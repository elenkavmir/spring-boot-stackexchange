function get() {
    var x = new XMLHttpRequest();
    x.open("GET", "api/rest/questions?findstring=java", true);
    x.onload = function () {
        alert(x.responseText);
    }
    x.send(null);
}