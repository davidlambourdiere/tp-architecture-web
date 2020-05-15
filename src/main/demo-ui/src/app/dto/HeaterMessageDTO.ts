import {HeaterDetailDTO} from './HeaterDetailDTO';

export class HeaterMessageDTO {
  insertDate: Date;
  invaluerefMessage: string;
  maxvaluerefMessage: string;
  stateMessage: string;
  temperatureMessage: string;
  heater: HeaterDetailDTO;
  breakdown: boolean;
}
