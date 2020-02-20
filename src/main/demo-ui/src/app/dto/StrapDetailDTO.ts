import {StrapDTO} from './StrapDTO';
import {StrapHistoricDTO} from "./StrapHistoricDTO";


export class StrapDetailDTO{
  strap: StrapDTO;
  percentageOnLastMonth: string;
  straphistorics: StrapHistoricDTO[];
}
