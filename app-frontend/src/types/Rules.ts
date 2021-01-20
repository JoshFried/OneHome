export interface Rules {
  id: number;
  checkoutTime?: TimeRanges;
  supperTime?: TimeRanges;
  checkInTime?: TimeRanges;
  capacity: number;
  males: boolean;
  females: boolean;
  minors: boolean;
  sober: boolean;
  pets: boolean;
}
