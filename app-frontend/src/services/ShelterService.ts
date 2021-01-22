import { BACKEND_URL } from '../Utils/config';
import { Shelter } from 'types/Shelter';
import { ShelterRequest } from 'components/landing_page/types/requests/ShelterRequest';

const RegisterShelter = async (
  request: ShelterRequest
): Promise<Shelter | boolean> => {
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
    console.log(error);
    return false;
  }
};

export default RegisterShelter;
