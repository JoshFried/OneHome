export const g = '';

// let map: google.maps.Map, infoWindow: google.maps.InfoWindow;

// export const handleLocationChange = (
//   event: React.MouseEvent<HTMLButtonElement, MouseEvent>
// ) => {
//   if (navigator.geolocation) {
//     navigator.geolocation.getCurrentPosition(
//       (position: GeolocationPosition) => {
//         const pos = new google.maps.LatLng(
//           position.coords.longitude,
//           position.coords.latitude
//         );
//         infoWindow.setPosition(pos);
//         infoWindow.setContent('Location found.');
//         infoWindow.open(map);
//         map.setCenter(pos);
//       },
//       () => {
//         handleLocationError(true, infoWindow, map.getCenter());
//       }
//     );
//   } else {
//     // Browser doesn't support Geolocation
//     handleLocationError(false, infoWindow, map.getCenter());
//   }
// };

// export const initMap = (): void => {
//   map = new google.maps.Map(document.getElementById('map') as HTMLElement, {
//     center: { lat: -34.397, lng: 150.644 },
//     zoom: 6,
//   });
//   infoWindow = new google.maps.InfoWindow();

//   const locationButton = document.createElement('button');
//   locationButton.textContent = 'Pan to Current Location';
//   locationButton.classList.add('custom-map-control-button');

//   map.controls[google.maps.ControlPosition.TOP_CENTER].push(locationButton);
// };

// function handleLocationError(
//   browserHasGeolocation: boolean,
//   infoWindow: google.maps.InfoWindow,
//   pos: google.maps.LatLng
// ) {
//   infoWindow.setPosition(pos);
//   infoWindow.setContent(
//     browserHasGeolocation
//       ? 'Error: The Geolocation service failed.'
//       : "Error: Your browser doesn't support geolocation."
//   );
//   infoWindow.open(map);
// }
