async function registerForNotifications() {

    Notification.requestPermission()
        .then(function (permission) {
            console.log(permission);

            if (permission === "granted") {
                showNotification();
            } else if (permission === "default") {
                requestAndShowPermission();
            } else {
                console.log("Notification permissions where denied by the user...")
            }

            var title = "JavaScript Jeep";
            icon = 'https://homepages.cae.wisc.edu/~ece533/images/airplane.png';
            var body = "It's Your boarding time";
            var notification = new Notification(title, {body, icon});

            console.log('document.visibilityState', document.visibilityState);

            let showNotification = document.visibilityState !== "visible";
            if (showNotification) {
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

async function checkNotificationStatus() {

    let permission = Notification.permission;
    console.log('Permission', permission);
    console.log('Permission', permission);
    console.log('Permission', permission);
    console.log('Permission', permission);

    if (permission === 'granted') {
        btnRegisterForNotification.style.display = 'none';
    }

    // Notification.requestPermission()
    //     .then(function (permission) {
    //       console.log(permission);
    //
    //       if(permission === "granted") {
    //         // showNotification();
    //       } else if(permission === "default"){
    //         requestAndShowPermission();
    //       } else {
    //         console.log("Notification permissions where denied by the user...")
    //       }
    //     });
}

const vapidPublicKey = "BAOThpyYjPdLt3HMGYr9n5kFQjWMX1IUwxbP0WmkXI93GsbTHgkkdvYUk5tcCERtuiYnQJQauxDjtQdstuUXIHo";

async function initServiceWorker() {
    if ('serviceWorker' in navigator) {
        console.log('serviceworker present in navigator');
    } else {
        console.warn('not present');
        return;
    }

    const swRegistration = await navigator.serviceWorker.register('js/another sw.js');
    console.log('swRegistration', swRegistration);

    const subscription = await swRegistration.pushManager.getSubscription();
    console.log('subscription', subscription);

    if (subscription) {
        console.log('User is already subscribed:', subscription);
        sendSubscriptionToServer(subscription);
    } else {
        const subscription = await swRegistration.pushManager.subscribe({
            userVisibleOnly: true,
            applicationServerKey: vapidPublicKey
        });
        console.log('User subscribed:', subscription);
        sendSubscriptionToServer(subscription);
    }
}

function sendSubscriptionToServer(subscription) {
    console.log('subscription to server...');

    fetch('/subscribe', {
        method: 'post',
        body: JSON.stringify(subscription),
        headers: { 'content-type': 'application/json' }
    });
}

document.addEventListener("DOMContentLoaded", async function (e) {
    console.log('Document ready!');

    initServiceWorker();
    checkNotificationStatus();


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

const changeNavBarCSS = () => {
    // console.log('changeNavBarCSS');

    const navBarElement = document.getElementById('NavBar');
    this.scrollY > 0 ? navBarElement.classList.add('fixed') : navBarElement.classList.remove('fixed');
}

window.addEventListener('scroll', changeNavBarCSS, false);

console.log('timezone', Intl.DateTimeFormat().resolvedOptions().timeZone);
console.log('navigator language', userLang = navigator.language || navigator.userLanguage);