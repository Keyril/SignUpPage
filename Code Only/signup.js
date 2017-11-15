function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}



function submitStuff(){
var http = new XMLHttpRequest();
var url = "http://localhost:8080/students";
var kvpairs = [];
var form =  document. getElementById("signup")
for ( var i = 0; i < form.elements.length; i++ ) {
  var e = form.elements[i];
  kvpairs.push(encodeURIComponent(e.name) + "=" + encodeURIComponent(e.value));
}
var queryString = kvpairs.join("&");
var params =queryString;
http.open("POST", url, true);

//Send the proper header information along with the request
http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

http.onreadystatechange = function() {//Call a function when the state changes.
  if(http.readyState == 4 && http.status == 200) {
      alert("Submitted Profile");
      window.location.href="./index.html"
    }
  }
  http.send(params);
}
function deleteUser(id){
  var http = new XMLHttpRequest();
  var deleteID =  document.getElementById("delete"+id)
  console.log(deleteID);
}
