import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Livro } from './models/livro';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Apiservice {
  private readonly http=inject(HttpClient)
  public listar():Observable<Livro[]>{
    return this.http.get<Livro[]>('http://localhost:8080/livraria/listar' ,{
      headers:{'accept': '*/*'}
    })
  }
  public buscarId(id: number):Observable<Livro>{
    return this.http.get<Livro>(`http://localhost:8080/livraria/buscar/${id}` ,{
      headers:{'accept': '*/*'}
    })
  }
}
