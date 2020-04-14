import {StrapDTO} from "./StrapDTO";
import {PersonDTO} from "./PersonDTO";

export class ALertHealthDTO{
  id : number;
  message : string;
  startdate : string;
  enddate : string;
  criticity : string;
  status : string;
  strap: StrapDTO;
  doctor : PersonDTO;

}
