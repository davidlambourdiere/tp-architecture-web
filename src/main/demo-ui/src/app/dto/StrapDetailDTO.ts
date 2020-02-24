import {StrapDTO} from './StrapDTO';
import {StrapHistoricDTO} from "./StrapHistoricDTO";


export class StrapDetailDTO{
  strap: StrapDTO;
  straphistorics: StrapHistoricDTO[];
  percentageOnLastMonth: string;
  usedlastmonth: boolean;
}
