import {PersonDTO} from './PersonDTO';

export class ClockDTO{
  id: bigint;
  status: string;
  state: string;
  minvalueref: string;
  suspect: string;
  maxvalueref: string;
  ipadress: string;
  person: PersonDTO;
}
