export class QRCode {
  id!: number;
  hashId!: string;
  description!: string;
  url!: string;
  creationDate!: string;
  type!: number;
  userId!: number;


  constructor(id: number, hashId: string, description: string, url: string, creationDate: string, type: number, userId: number) {
    this.id = id;
    this.hashId = hashId;
    this.description = description;
    this.url = url;
    this.creationDate = new Date().toISOString();
    this.type = type;
    this.userId = userId;
  }
}
