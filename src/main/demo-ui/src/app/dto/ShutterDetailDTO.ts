import {ShutterDTO} from './ShutterDTO';
import {ShutterHistoricDTO} from "./ShutterHistoricDTO";

export class ShutterDetailDTO{
  shutter: ShutterDTO;
  percentageOnLastMonth: string;
  percentage: string;
  shutterhistorics: ShutterHistoricDTO[];
}
