import {Injectable} from '@angular/core';

//Inside imports of your TS file include
import * as CryptoJS from 'crypto-js';

@Injectable({
  providedIn: 'root'
})
export class SeccryptoService {

  constructor() {
  }

// Declare this key and iv values in declaration
  private key = CryptoJS.enc.Utf8.parse('9749756907777501');
  private iv = CryptoJS.enc.Utf8.parse('1181199311953635');

// Methods for the encrypt and decrypt Using AES
  encryptUsingAES256(encString: string) {
    let encrypted = CryptoJS.AES.encrypt(CryptoJS.enc.Utf8.parse(encString), this.key, {
      keySize: 128 / 8,
      iv: this.iv,
      mode: CryptoJS.mode.CBC,
      padding: CryptoJS.pad.Pkcs7
    });
    // console.log('Encrypted :' + encrypted);
    this.decryptUsingAES256(encrypted);
    return encrypted;
  }

  decryptUsingAES256(decString: string | CryptoJS.lib.CipherParams) {
    let decrypted = CryptoJS.AES.decrypt(decString, this.key, {
      keySize: 128 / 8,
      iv: this.iv,
      mode: CryptoJS.mode.CBC,
      padding: CryptoJS.pad.Pkcs7
    });
    // console.log('Decrypted : ' + decrypted);
    // console.log('utf8 = ' + decrypted.toString(CryptoJS.enc.Utf8));
    return decrypted.toString(CryptoJS.enc.Utf8);
  }


}
