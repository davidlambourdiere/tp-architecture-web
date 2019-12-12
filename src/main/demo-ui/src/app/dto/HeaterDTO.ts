import {PersonDTO} from './PersonDTO';

export class HeaterDTO{
  id: bigint;
  status: string;
  state: string;
  minvalueref: string;
  suspect: string;
  ipadress: string;
  maxvalueref: string;
  person: PersonDTO;
}

