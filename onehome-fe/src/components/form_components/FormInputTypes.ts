export interface FormInputTypes {
  label?: string;
  name: string;
  type: string;
  placeholder: string;
  onChange?: React.FormEventHandler<HTMLInputElement>;
  className: string;
  value?: string | number;
  error?: string;
  onBlur?: React.FormEventHandler<HTMLInputElement>;
}
