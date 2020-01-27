import {PersonDTO} from './PersonDTO';
import {RoomDTO} from "./RoomDTO";

export class LightDTO{
  id: bigint;
  status: string;
  state: string;
  minvalueref: string;
  suspect: string;
  price: number;
  maxvalueref: string;
  ipadress: string;
  percentage: string;
  color: string;
  person: PersonDTO;
  room: RoomDTO;
}

