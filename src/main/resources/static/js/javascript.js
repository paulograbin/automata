async function registerForNotifications() {

  Notification.requestPermission().then(function (permission) {
    console.log(permission);

    if(permission === "granted") {
      showNotification();
    } else if(permission === "default"){
      requestAndShowPermission();
    } else {
      alert("Use normal alert");
    }

    var title = "JavaScript Jeep";
    icon = 'https://homepages.cae.wisc.edu/~ece533/images/airplane.png';
    var body = "It's Your boarding time";
    var notification = new Notification(title, { body, icon });

    console.log('document.visibilityState', document.visibilityState);

    let showNotification = document.visibilityState !== "visible";
    if(showNotification) {
      // Notification code
    }
  });


  // if ("serviceWorker" in navigator && "PushManager" in window) {
  //   try {
  //     const swReg = await navigator.serviceWorker.register("/js/sw.js");
  //
  //     const pushSubscription = await swReg.pushManager.subscribe({
  //       userVisibleOnly: true
  //     });
  //
  //     savePushSubscription(pushSubscription);
  //   } catch (error) {
  //     console.error("Error subscribing for push notifications", error);
  //   }
  // } else {
  //   console.error('Push notifications are not supported by the browser');
  // }
}

document.addEventListener("DOMContentLoaded", function (e) {
  console.log('Document ready!');

  registerForNotifications();

  let subscriptionCode = localStorage.getItem('subscriptionCode');
  let token = localStorage.getItem('token');
  console.log('loaded value for subscription:', subscriptionCode);
  console.log('loaded value for token:', token);

  let inputSubscription = document.getElementById('inputSubscriptionCode');
  inputSubscription.value = subscriptionCode;

  let inputToken = document.getElementById('inputToken');
  inputToken.value = token;

  // const interval = setInterval(function () {
  //   $.get("environments").done(function (data) { // get from controller
  //     console.log('Refreshing environments');
  //     $("#environments").replaceWith(data);
  //   });
  // }, 5000);
});

window.addEventListener('scroll', changeNavBarCSS, false);

const changeNavBarCSS = () => {
  // console.log('changeNavBarCSS');

  const navBarElement = document.getElementById('NavBar');
  this.scrollY > 0 ? navBarElement.classList.add('fixed') : navBarElement.classList.remove('fixed');
}

console.log('timezone', Intl.DateTimeFormat().resolvedOptions().timeZone);
console.log('navigator language', userLang = navigator.language || navigator.userLanguage);