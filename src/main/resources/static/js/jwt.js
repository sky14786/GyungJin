include("../js/jquery.js");
include("../js/jquery_cookie.js");

function include(FileDir) {
  var includejs = document.createElement("script");
  includejs.type = "text/javascript";
  includejs.src = FileDir;
  document.head.appendChild(includejs);
}
function validationToken() {
  var expiredTime =
    parseJwt($.cookie("accessToken")).exp - parseInt(Date.now() / 1000);
  var refreshTime =
    parseJwt($.cookie("refreshToken")).exp - parseInt(Date.now() / 1000);
  // console.log(expiredTime);
  // console.log(refreshTime);
  if (expiredTime >= -600 && expiredTime <= 0) {
    $.ajax({
      url: "/oauth",
      method: "GET",
      dataType: "text",
      contentType: "application/json; charset=UTF-8",
      success: function(data) {
        if (data == "Modulation") {
          alert("다시 로그인해 주세요.");
          $(location).attr(
            "href",
            "http://" + $(location).attr("host") + "/erp"
          );
          return false;
        } else if (data == "false") {
          alert("다시 로그인해 주세요.");
          $(location).attr(
            "href",
            "http://" + $(location).attr("host") + "/erp"
          );
          return false;
        } else {
          $.removeCookie("accessToken", { path: "/" });
          $.cookie("accessToken", data, { path: "/" });
          $(location).attr("href", $(location).attr("href"));
        }
      },
      error: function(request, status, error) {
        ajaxError(request, status, error);
      },
      beforeSend: function() {
        loadingDisplayOn();
      },
      complete: function() {
        loadingDisplayOff();
      }
    });
    return true;
  } else if (expiredTime <= -600) {
    $.removeCookie("accessToken", { path: "/" });
    alert("다시 로그인해 주세요.");
    $(location).attr("href", "/erp");
  }
}

function parseJwt(token) {
  var base64Url = token.split(".")[1];
  var base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
  var jsonPayload = decodeURIComponent(
    atob(base64)
      .split("")
      .map(function(c) {
        return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
      })
      .join("")
  );

  return JSON.parse(jsonPayload);
}

function testToken() {
  var expiredTime =
    parseJwt($.cookie("accessToken")).exp - parseInt(Date.now() / 1000);
  var refreshTime =
    parseJwt($.cookie("refreshToken")).exp - parseInt(Date.now() / 1000);
  console.log(expiredTime);
  console.log(refreshTime);
}
function ajaxError(request, status, error) {
  if (request.responseJSON.status == 401) {
    validationToken();
  }
  if (request.responseJSON.status == 400) {
    $.removeCookie("accessToken", { path: "/" });
    alert("다시 로그인해 주세요.");
    $(location).attr("href", "/erp");
  }
}
