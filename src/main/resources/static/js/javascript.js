document.addEventListener("DOMContentLoaded", function (e) {
  console.log('Document ready!');

  let subscriptionCode = localStorage.getItem('subscriptionCode');
  let token = localStorage.getItem('token');
  console.log('loaded value for subscription:', subscriptionCode);
  console.log('loaded value for token:', token);

  let inputSubscription = document.getElementById('inputSubscriptionCode');
  inputSubscription.value = subscriptionCode;

  let inputToken = document.getElementById('inputToken');
  inputToken.value = token;

  const interval = setInterval(function () {
    $.get("environments").done(function (data) { // get from controller
      console.log('Refreshing environments');
      $("#environments").replaceWith(data);
    });
  }, 5000);
});

console.log(Intl.DateTimeFormat().resolvedOptions().timeZone);
console.log(userLang = navigator.language || navigator.userLanguage);