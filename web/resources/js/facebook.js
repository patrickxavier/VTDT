/* 
 * Created by Sanchit Chadha on 2014.12.07  * 
 * Copyright © 2014 Sanchit Chadha. All rights reserved. * 
 */

window.fbAsyncInit = function () {
    FB.init({
        appId: '308878139317336',
        xfbml: true,
        cookie: true,
        version: 'v2.1'
    });
    if (typeof(username) === "function") {
        username();
    }
};

(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {
        return;
    }
    js = d.createElement(s);
    js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
