import {HeaterDTO} from './HeaterDTO';
import {HeaterHistoricDTO} from "./HeaterHistoricDTO";

export class HeaterDetailDTO{
  heater: HeaterDTO;
  heaterhistorics: HeaterHistoricDTO[];
  percentageOnLastMonth: string;
}
