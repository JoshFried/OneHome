const ValidateAuthentication = (): string[] => {
  const requiredFields = ['username', 'password'];

  return [...requiredFields.map((field) => checkRequiredField(field))].filter(
    (value) => value != 'true'
  );
};

const checkRequiredField = (field: string): string => {
  if (!field) return `${field} is required`;
  return 'true';
};

export default ValidateAuthentication;
