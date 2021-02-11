import React, { useState, useEffect, useRef } from 'react';
import FormInput from './FormInput.js';
import { StyledButton } from './StyledButton.js';
import { register } from './AuthenticationService.js';
import ValidateRegistration from './ValidateRegistration.js';
import useFormValidation from './UseFormValidation.js';
import { useHistory } from 'react-router-dom';
import RedirectButton from './RedirectButton.js';
import Stuff from './Stuff.js';
import axios from 'axios';
import config from '../Utils/config';
function RegisterShelterForm() {
  const history = useHistory();
  const [file, setFile] = useState('');
  const [currentPlace, setCurrentPlace] = useState({});
  const [filename, setFilename] = useState('Choose File');
  const [place_id, setPlace_id] = useState('');
  const [latitude, setLatitude] = useState(0);
  const [longitude, setLongitude] = useState(0);
  const [check_in_time, setCheck_in_time] = useState('00:00:00');
  const [check_out_time, setCheck_out_time] = useState('00:00:00');
  const [supper_time, setSupper_time] = useState('00:00:00');
  const [males, setMales] = useState(true);
  const [females, setFemales] = useState(true);
  const [sober, setSober] = useState(true);
  const [pets, setPets] = useState(true);
  const [capacity, setCapacity] = useState(10);
  const [minor, setMinor] = useState(true);
  const [website, setWebsite] = useState('');

  useEffect(() => {
    axios
      .get(
        `https://maps.googleapis.com/maps/api/place/details/json?place_id=${place_id}&fields=name,formatted_address,geometry&key=${config.MAPS_API_KEY}`,
        {}
      )
      .then((response) => {
        setCurrentPlace(response.data.result);
        setLatitude(response.data.result.geometry.location.lat);
        setLongitude(response.data.result.geometry.location.lng);
        console.log(response.data.result);
        console.log(latitude, longitude);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [place_id]);
  const timeRef = useRef();

  const onFileChange = (e) => {
    e.target.files[0]
      ? setFilename(e.target.files[0].name)
      : setFilename('No file chosen.');
  };
  const handleFileSubmit = (e) => {
    e.preventDefault();
  };
  const handlePlaceChange = (e) => {
    setPlace_id(e.target.value);
  };
  const handleWebsiteChange = (e) => {
    setWebsite(e.target.value);
  };
  const handleCheckInChange = (e) => {
    setCheck_in_time(e.target.value);
    console.log(check_in_time);
  };
  const handleCheckOutChange = (e) => {
    setCheck_out_time(e.target.value);
  };
  const handleSupperChange = (e) => {
    setSupper_time(e.target.value);
  };
  const handleMaleChange = (e) => {
    setMales(e.target.value);
  };
  const handleFemaleChange = (e) => {
    setFemales(e.target.value);
  };
  const handleSoberChange = (e) => {
    setSober(e.target.value);
  };
  const handlePetsChange = (e) => {
    setPets(e.target.value);
  };
  const handleCapacityChange = (e) => {
    setCapacity(e.target.value);
  };
  const handleMinorChange = (e) => {
    setMinor(e.target.value);
  };
  const onSubmit = (e) => {
    e.preventDefault();
    let info = {
      name: 'huh',
      location: {
        placeId: place_id,
        longitude: longitude,
        latitude: latitude,
      },
      webSite: website,
      rules: {
        // checkoutTime: String(check_out_time) + ":00",
        // supperTime: String(supper_time) + ":00",
        // checkinTime: String(check_in_time) + ":00",
        capacity: capacity,
        males: males,
        females: females,
        pets: pets,
        sober: sober,
        minor: minor,
      },
    };
    Stuff(info);
  };

  return (
    <div>
      <h1>Verify Shelter</h1>
      <h2>
        Your selected place is{' '}
        {currentPlace
          ? ` the ${currentPlace.name} in ${currentPlace.formatted_address}`
          : 'undefined.'}
      </h2>
      <form onSubmit={onSubmit} className="form-signin">
        <div>Place ID</div>
        <FormInput
          label="place_id"
          name="place_id"
          type="text"
          className={`${'error-input'} ${'form-control'}`}
          value={place_id}
          onChange={handlePlaceChange}
          placeholder="Place ID"
        />
        <br />
        <div>Website</div>
        <FormInput
          label="website"
          name="website"
          type="text"
          className={`${'error-input'} ${'form-control'}`}
          value={website}
          onChange={handleWebsiteChange}
          placeholder="Website"
        />
        <br />
        <div>Check-In Time</div>
        <FormInput
          label="check_in_time"
          name="check_in_time"
          type="time"
          className={`${'error-input'} ${'form-control'}`}
          onChange={handleCheckInChange}
          value={check_in_time}
        />
        <br />
        <div>Dinner Time</div>
        <FormInput
          label="supper_time"
          name="supper_time"
          type="time"
          className={`${'error-input'} ${'form-control'}`}
          onChange={handleSupperChange}
          value={supper_time}
        />
        <br />
        <div>Check-Out Time</div>
        <FormInput
          label="check_out_time"
          name="check_out_time"
          type="time"
          onChange={handleCheckOutChange}
          className={`${'error-input'} ${'form-control'}`}
          value={check_out_time}
        />
        <br />
        <h2>Rules</h2>
        <br />
        <div>Capacity</div>
        <FormInput
          label="capacity"
          name="capacity"
          type="number"
          onChange={handleCapacityChange}
          className={`${'error-input'} ${'form-control'}`}
          value={capacity}
        />
        <br />
        <div>Men Allowed?</div>
        <select onChange={handleMaleChange} defaultValue="TRUE" name="men">
          <option value="true">True</option>
          <option value="false">False</option>
        </select>
        <br />
        <div>Women Allowed?</div>
        <select onChange={handleFemaleChange} defaultValue="TRUE" name="female">
          <option value="true">True</option>
          <option value="false">False</option>
        </select>
        <br />
        <div>Sobriety Required?</div>
        <select onChange={handleSoberChange} defaultValue="TRUE" name="sober">
          <option value="true">True</option>
          <option value="false">False</option>
        </select>
        <br />
        <div>Pets Allowed?</div>
        <select onChange={handlePetsChange} defaultValue="TRUE" name="pets">
          <option value="true">True</option>
          <option value="false">False</option>
        </select>
        <br />
        <div>Minors Allowed?</div>
        <select onChange={handleMinorChange} defaultValue="TRUE" name="minor">
          <option value="true">True</option>
          <option value="false">False</option>
        </select>
        <br />

        <RedirectButton
          link="https://developers.google.com/places/web-service/place-id"
          name="Find your place ID!"
        />

        <br />
        <div>Submit a file with an address for verification</div>
        <FormInput
          type="file"
          onChange={onFileChange}
          onSubmit={handleFileSubmit}
        />
        <br />
        <StyledButton type="submit" label="Submit" className="button" />
      </form>
    </div>
  );
}

export default RegisterShelterForm;
