const staticCacheName = 'pwa-workshop-static-v1';
const staticFilesToCache = [
  './svg/logo.svg',
  './server.png'
]

self.addEventListener('install', evt => {
  console.log('[ServiceWorker] Installed Service Worker');

  evt.waitUntil(
    caches.open(staticCacheName).then(cache => {
      console.log('[ServiceWorker] Caching app shell in', staticCacheName);
      // return cache.addAll(staticFilesToCache);
    }).then(() => {
      console.log('[ServiceWorker] Skip waiting on install');
      // return self.skipWaiting();
    })
  );
});


self.addEventListener('activate', evt => {
  console.log('[ServiceWorker] Activate');
});

self.addEventListener('fetch', e => {
  const requestUrl = e.request.url;
  console.log('[ServiceWorker] Fetch', requestUrl);
});

self.addEventListener('push', e => {
  console.log('[ServiceWorker] Push message', e);
  var title = 'Travel Website';
  e.waitUntil(
    self.registration.showNotification(title, {
      body: 'Push notification received' + Math.random(),
      icon: './static/logo.png',
      tag: 'my-tag' + Math.random()
    })
  );
});