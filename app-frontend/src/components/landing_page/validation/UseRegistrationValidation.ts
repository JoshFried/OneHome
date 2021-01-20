import { useEffect, useState } from 'react';
import { User } from '~/types/User';
import RegistrationRequest from '../types/requests/RegistrationRequest';

const registrationValidation = (
  request: RegistrationRequest,
  validate: (fields: RegistrationRequest) => string[],
  authenticate: (intialState: RegistrationRequest) => Promise<boolean | User>
): any => {
  const [values, setValues] = useState(request);
  const [errors, setErrors] = useState({});
  const [isSubmitting, setSubmitting] = useState(false);

  useEffect(() => {
    const authenticateIfNoErrors = async () => {
      if (isSubmitting) {
        if (!errors) await authenticate(values);
      }
    };
    authenticateIfNoErrors();
  }, [errors, values, isSubmitting, authenticate]);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>): void => {
    setValues({
      ...values,
      [e.target.name]: e.target.value,
    });
  };

  const handleBlur = (): void => {
    const validationErrors: string[] = validate(values);
    setErrors(validationErrors);
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>): void => {
    e.preventDefault();
    const validationErrors: string[] = validate(values);
    setErrors(validationErrors);
    setSubmitting(true);
  };

  return {
    handleSubmit,
    handleChange,
    handleBlur,
    values,
    errors,
    isSubmitting,
  };
};

export default loginValidation;
