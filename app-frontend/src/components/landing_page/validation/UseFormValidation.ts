import { useEffect, useState } from 'react';
import Values from './RegistrationRequest';

const useFormValidation = (initialState, validate, authenticate) => {
  const [values, setValues] = useState<Values>(initialState);
  const [errors, setErrors] = useState({});
  const [isSubmitting, setSubmitting] = useState(false);

  useEffect(() => {
    if (isSubmitting) {
      if (!errors) {
        (async () => {
          await authenticate(values);
          setSubmitting(false);
        })();
      } else {
        setSubmitting(false);
      }
    }
  }, [errors, values, isSubmitting, authenticate]);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setValues({
      ...values,
      [e.target.name]: e.target.value,
    });
  };

  const handleBlur = () => {
    const validationErrors = validate(values);
    setErrors(validationErrors);
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const validationErrors = validate(values);
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

export default useFormValidation;
