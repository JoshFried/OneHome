const ValidateRegistration = (values) => {
   console.log("2112")
  const requiredFields = [
    "username",
    "password",
    "firstName",
    "lastName",
    "email",
  ];

  return [
    ...requiredFields.map((field) => checkRequiredField(field)),
    checkEmail(values.email),
    checkPassword(values.password),
    checkPasswordMatches(values.password, values.matchingPassword),
  ].filter((value) => value !== true);
};

const checkRequiredField = (field) => {
  if (!field) return `${field} is required`;
  return true;
};

const checkPassword = (password) => {
  if (password.length < 6) return "Password must be at least 6 characters";
  return true;
};

const checkEmail = (email) => {
  if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(email))
    return "Invalid email address";
  return true;
};

const checkPasswordMatches = (password, matchingPassword) => {
  return password === matchingPassword;
};

export default ValidateRegistration;
