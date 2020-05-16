
export class PersonProfileDTO{


  private _id: number;
  private _nom: string;
  private _prenom: string;
  private _age: bigint;
  private _adress: string;
  private _postal_code: bigint;
  private _adress_email: string;
  private _tel_number: bigint;
  private _chronic_disease: string;
  private _estimated_mobility: bigint;
  private _smoking: boolean;
  private _smoking_time: number;
  private _drinker: boolean;
  private _medical_emergencies: boolean;
  private _hobbies: string;
  private _revenue: number;
  private _profile: string;
  private _priority_coef: number;


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
  }

  get prenom(): string {
    return this._prenom;
  }

  set prenom(value: string) {
    this._prenom = value;
  }

  get age(): bigint {
    return this._age;
  }

  set age(value: bigint) {
    this._age = value;
  }

  get adress(): string {
    return this._adress;
  }

  set adress(value: string) {
    this._adress = value;
  }

  get postal_code(): bigint {
    return this._postal_code;
  }

  set postal_code(value: bigint) {
    this._postal_code = value;
  }

  get adress_email(): string {
    return this._adress_email;
  }

  set adress_email(value: string) {
    this._adress_email = value;
  }

  get tel_number(): bigint {
    return this._tel_number;
  }

  set tel_number(value: bigint) {
    this._tel_number = value;
  }

  get chronic_disease(): string {
    return this._chronic_disease;
  }

  set chronic_disease(value: string) {
    this._chronic_disease = value;
  }

  get estimated_mobility(): bigint {
    return this._estimated_mobility;
  }

  set estimated_mobility(value: bigint) {
    this._estimated_mobility = value;
  }

  get smoking(): boolean {
    return this._smoking;
  }

  set smoking(value: boolean) {
    this._smoking = value;
  }

  get smoking_time(): number {
    return this._smoking_time;
  }

  set smoking_time(value: number) {
    this._smoking_time = value;
  }

  get drinker(): boolean {
    return this._drinker;
  }

  set drinker(value: boolean) {
    this._drinker = value;
  }

  get medical_emergencies(): boolean {
    return this._medical_emergencies;
  }

  set medical_emergencies(value: boolean) {
    this._medical_emergencies = value;
  }

  get hobbies(): string {
    return this._hobbies;
  }

  set hobbies(value: string) {
    this._hobbies = value;
  }

  get revenue(): number {
    return this._revenue;
  }

  set revenue(value: number) {
    this._revenue = value;
  }

  get profile(): string {
    return this._profile;
  }

  set profile(value: string) {
    this._profile = value;
  }

  get priority_coef(): number {
    return this._priority_coef;
  }

  set priority_coef(value: number) {
    this._priority_coef = value;
  }
}
