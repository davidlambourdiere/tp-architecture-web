import {HeaterDTO} from './HeaterDTO';
import {ClockDTO} from './ClockDTO';
import {LightDTO} from './LightDTO';
import {ShutterDTO} from './ShutterDTO';
import {StrapDTO} from './StrapDTO';

export class IOTDTO{
  heaters: HeaterDTO[];
  clocks: ClockDTO[];
  lights: LightDTO[];
  shutters: ShutterDTO[];
  straps: StrapDTO[];
}
