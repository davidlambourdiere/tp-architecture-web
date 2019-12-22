import {PersonDTO} from './PersonDTO';
import {RoomDTO} from './RoomDTO';

export class ClockDTO{
  id: bigint;
  status: string;
  state: string;
  minvalueref: string;
  price: number;
  suspect: string;
  maxvalueref: string;
  ipadress: string;
  person: PersonDTO;
  room: RoomDTO;
}
