import {ClockDTO} from './ClockDTO';
import {ClockHistoricDTO} from "./ClockHistoricDTO";

export class ClockDetailDTO{
  clock: ClockDTO;
  clockhistorics: ClockHistoricDTO[];
  percentageOnLastMonth: string;
  usedlastmonth: boolean;
}
