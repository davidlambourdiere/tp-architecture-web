import {PersonDTO} from './PersonDTO';
import {RoomDTO} from "./RoomDTO";

export class ShutterDTO{
  id: bigint;
  status: string;
  state: string;
  minvalueref: string;
  suspect: string;
  price: number;
  ipadress: string;
  maxvalueref: string;
  percentage: string;
  person: PersonDTO;
  room: RoomDTO;
}

