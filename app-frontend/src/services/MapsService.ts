import { MAPS_API_KEY } from '../Utils/config';

export const fetchShelterFromId = async (
  id: string
): Promise<google.maps.places.PlaceSearchRequest | boolean> => {
  try {
    const apiRes: google.maps.places.PlaceSearchRequest = await fetch(
      `${`https://maps.googleapis.com/maps/api/place/details/json?place_id=${id}&fields=name,formatted_address,geometry&key=${MAPS_API_KEY}`}`
    );
    return apiRes;
  } catch (error) {
    return false;
  }
};
