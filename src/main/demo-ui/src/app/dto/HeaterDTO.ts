import {PersonDTO} from './PersonDTO';

export class HeaterDTO{
  id: bigint;
  status: string;
  state: string;
  minvalueref: string;
  price: number;
  suspect: string;
  ipadress: string;
  maxvalueref: string;
  person: PersonDTO;
}

