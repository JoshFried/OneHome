import FormInput from "components/form_components/FormInput";
import { ShelterRequest } from "components/landing_page/types/requests/ShelterRequest";
import useFormValidation from "components/landing_page/validation/UseFormValidation";
import { validateShelter } from "components/landing_page/validation/ValidateShelterRegistration";
import { StyledButton } from "components/styled/StyledButton";
import React from "react";
import { RedirectButton } from "RedirectButton";
import { RegisterShelter } from "services/ShelterService";
import { Shelter } from "types/Shelter";
import { RedirectButtonProps } from "./RedirectButtonProps";

const RegisterShelterForm = (): JSX.Element => {
  const request: ShelterRequest = {
    placeId: "",
    name: "",
    website: "",
    longitude: 0,
    latitude: 0,
    capacity: 0,
  };

  const redirectProps: RedirectButtonProps = {
    url: "https://developers.google.com/places/web-service/place-id",
    name: "Find your place ID!",
  };

  const sendRegistrationRequest = async (
    request: ShelterRequest
  ): Promise<boolean | Shelter> => {
    return await RegisterShelter(request);
  };

  const {
    handleSubmit,
    handleChange,
    handleBlur,
    values,
    errors,
    isSubmitting,
  } = useFormValidation(request, validateShelter, sendRegistrationRequest);

  return (
    <div>
      <h1>Register Shelter</h1>
      <form onSubmit={handleSubmit} className="form-signin">
        <div>Place ID</div>
        <FormInput
          label="place_id"
          name="place_id"
          type="text"
          className={`${errors.placeId}  ${"error-input"}  ${"form-control"}`}
          onBlur={handleBlur}
          value={values.placeId}
          onChange={handleChange}
          placeholder="Place ID"
        />
        <br />
        <div>Website</div>
        <FormInput
          label="website"
          name="website"
          type="text"
          className={`${"form-control"}`}
          onBlur={handleBlur}
          value={values.website}
          onChange={handleChange}
          placeholder="Website"
        />
        <br />
        <div>Capacity</div>
        <FormInput
          label="capacity"
          name="capacity"
          type="number"
          onChange={handleChange}
          className={`${errors.capacity}  ${"error-input"}  ${"form-control"}`}
          onBlur={handleBlur}
          value={values.capacity}
          placeholder="capacity"
        />
        <br />
        <div>Latitude</div>
        <FormInput
          label="latitude"
          name="latitude"
          type="number"
          onChange={handleChange}
          className={`${errors.latitude}  ${"error-input"}  ${"form-control"}`}
          onBlur={handleBlur}
          value={values.latitude}
          placeholder="latitude"
        />
        <br />
        <div>Longitude</div>
        <FormInput
          label="longitude"
          name="capacity"
          type="number"
          onChange={handleChange}
          className={`${errors.longitude}  ${"error-input"}  ${"form-control"}`}
          onBlur={handleBlur}
          value={values.longitude}
          placeholder="longitude"
        />
        <br />
        <RedirectButton name={redirectProps.name} url={redirectProps.url} />
        <StyledButton
          type="submit"
          label="Submit"
          className="button"
          onSubmit={isSubmitting}
        />
      </form>
    </div>
  );
};

export default RegisterShelterForm;
