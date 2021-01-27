import { Fragment, useState } from "react";
import { Location } from "types/Location";

import React from "react";
import FormInput from "components/form_components/FormInput";

export const LocationInputs = (): JSX.Element => {
  const [location, setLocation] = useState<Location>();
  setLocation(location);
  return (
    <Fragment>
      <FormInput
        label="placeId"
        name="placeId"
        type="text"
        className={`${"error-input"} ${"form-control"}`}
        value={location?.placeId}
        // onChange={handleChange}
        placeholder="Place ID"
      />
      <br />

      <FormInput
        label="latitude"
        name="latitude"
        type="number"
        className={`${"error-input"} ${"form-control"}`}
        value={location?.latitude}
        // onChange={handleChange}
        placeholder="Place ID"
      />
      <br />

      <FormInput
        label="longitude"
        name="longitude"
        type="number"
        className={`${"error-input"} ${"form-control"}`}
        value={location?.longitude}
        // onChange={handleChange}
        placeholder="Place ID"
      />
      <br />
    </Fragment>
  );
};
