import {PersonDTO} from './PersonDTO';
import {RoomDTO} from "./RoomDTO";

export class StrapDTO{
  id: bigint;
  breakdownstatus: string;
  state: string;
  minvalueref: string;
  suspect: string;
  price: number;
  ipadress: string;
  maxvalueref: string;
  person: PersonDTO;
  room: RoomDTO;
  minsysto: string;
  maxsysto: string;
  maxdiasto: string;
  minglyc: string;
  maxglyc: string;
  healthstate: string;
  hearthrate : string;
}

