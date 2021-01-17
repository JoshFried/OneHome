const ValidateAuthentication = (values) => {
  const requiredFields = ["username", "password"];

  return [...requiredFields.map((field) => checkRequiredField(field))].filter(
    (value) => value === false
  );
};

const checkRequiredField = (field) => {
  if (!field) return `${field} is required`;
  return true;
};

export default ValidateAuthentication;
