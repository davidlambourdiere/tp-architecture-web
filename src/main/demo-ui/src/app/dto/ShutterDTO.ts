import {PersonDTO} from './PersonDTO';

export class ShutterDTO{
  id: bigint;
  status: string;
  state: string;
  minvalueref: string;
  suspect: string;
  ipadress: string;
  maxvalueref: string;
  percentage: string;
  person: PersonDTO;
}

