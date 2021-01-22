import { Shelter } from 'types/Shelter';
import { BACKEND_URL, MAPS_API_KEY } from '../Utils/config';

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

export const fetchDataToLoadMap = async (
  params: string[]
): Promise<Array<google.maps.places.PlaceResult> | boolean> => {
  try {
    const apiRes = await fetch(
      `${`https://maps.googleapis.com/maps/api/place/nearbysearch/json?input=homeless%20shelter&keyword=homeless%20shelter&inputtype=textquery&fields=photos,geometry,formatted_address,name,photos,opening_hours,rating,formatted_phone_number,website&&radius=100000&location=${params[0]},${params[1]}&key=${MAPS_API_KEY}`}`
    );
    return await apiRes.json();
  } catch (error) {
    return false;
  }
};

export const fetchVerifiedSheltersFromLocation = async (
  longitude: string,
  latitude: string
): Promise<boolean | Shelter> => {
  try {
    const apiRes = await fetch(
      `${BACKEND_URL}/shelter/getShelters?radius=100000&longitude=${longitude}&latitude=${latitude}`
    );
    return await apiRes.json();
  } catch (error) {
    return false;
  }
};

export const fetchShelterForPlaceId = async (
  placeId: string
): Promise<boolean | Shelter> => {
  try {
    const apiRes = await fetch(
      `https://maps.googleapis.com/maps/api/place/details/json?place_id=${placeId}&fields=name,formatted_address,geometry&key=${MAPS_API_KEY}`
    );
    return await apiRes.json();
  } catch (error) {
    return false;
  }
};
