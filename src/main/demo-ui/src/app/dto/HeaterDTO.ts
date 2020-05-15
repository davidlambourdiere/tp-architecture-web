import {PersonDTO} from './PersonDTO';
import {RoomDTO} from "./RoomDTO";

export class HeaterDTO{
  id: bigint;
  breakdownstatus: string;
  state: string;
  minvalueref: string;
  actualval :string;
  price: number;
  suspect: string;
  ipadress: string;
  maxvalueref: string;
  person: PersonDTO;
  room: RoomDTO;
}

