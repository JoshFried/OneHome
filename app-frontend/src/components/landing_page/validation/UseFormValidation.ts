import { useEffect, useState } from 'react';

const useFormValidation = <T, R>(
  request: T,
  validate: (fields: T) => string[],
  sendRequest: (intialState: T) => Promise<boolean | R>
): any => {
  const [values, setValues] = useState(request);
  const [errors, setErrors] = useState({});
  const [isSubmitting, setSubmitting] = useState(false);

  useEffect(() => {
    const authenticateIfNoErrors = async () => {
      if (isSubmitting) {
        if (!errors) await sendRequest(values);
      }
    };
    authenticateIfNoErrors();
  }, [errors, values, isSubmitting, sendRequest]);

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

export default useFormValidation;
