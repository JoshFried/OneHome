export interface FormInputTypes {
  label?: string;
  name: string;
  type: string;
  placeholder: string;
  onChange?: React.FormEventHandler<HTMLInputElement>;
  className: string;
  value: string;
  error?: string;
  onBlur?: React.FormEventHandler<HTMLInputElement>;
}
