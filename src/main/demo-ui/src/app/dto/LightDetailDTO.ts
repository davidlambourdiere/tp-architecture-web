import {LightDTO} from './LightDTO';
import {LightHistoricDTO} from "./LightHistoricDTO";


export class LightDetailDTO{
  light: LightDTO;
  lightshistoric: LightHistoricDTO[];
  percentageOnLastMonth: string;
}
