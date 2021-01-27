export const fieldValidator = <T>(
  entity: T,
  requiredFields: Array<keyof T>
): string[] => {
  return requiredFields
    .map((field) => checkRequiredField(entity[field], field))
    .filter((res) => res !== "");
};

const checkRequiredField = (value: unknown, field: keyof never): string => {
  return !value ? `${String(field)} is required` : "";
};
