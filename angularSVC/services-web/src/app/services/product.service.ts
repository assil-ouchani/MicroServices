import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  public host:string="http://localhost:8082"

  constructor(private http:HttpClient) { }

  public getProducts(){
    return this.http.get(this.http+"/products");
  }
}
