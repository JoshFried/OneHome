import { BACKEND_URL } from '../Utils/config';
import { Shelter } from 'types/Shelter';
import { ShelterRequest } from 'components/landing_page/types/requests/ShelterRequest';
import { Reservation } from 'types/Reservation';

export const RegisterShelter = async (
  request: ShelterRequest
): Promise<Shelter> => {
  try {
    const apiRes = await fetch(`${BACKEND_URL}/shelter/admin/create`, {
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
      method: 'POST',
      body: JSON.stringify(request),
    });
    return await apiRes.json();
  } catch (error) {
    throw error;
  }
};

export const reserveSpot = async (id: string): Promise<Reservation> => {
  try {
    const apiRes = await fetch(`${BACKEND_URL}/rsvp/${id}`, {
      credentials: 'include',
    });
    return await apiRes.json();
  } catch (error) {
    throw error;
  }
};
