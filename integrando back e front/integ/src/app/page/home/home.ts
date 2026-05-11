import { Component, inject, signal } from '@angular/core';
import { Apiservice } from '../../core/apiservice';
import { Livro } from '../../core/models/livro';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
})
export class Home {
  private service = inject(Apiservice)
  ngOnInit() {
    this.service.listar().subscribe({
      next: response => {
        this.livros.set(response)
      },
      error: err => {
        console.log(err)
      }
    })
  }
  livros = signal<Livro[]>([])
  livroEncontrado = signal<Livro | null>(null)

  buscarId(id: string) {
    const idnew=Number(id)
    this.service.buscarId(idnew).subscribe({
      next: response => {
        console.log(response)
        this.livroEncontrado.set(response)
      },
      error: err => {
        console.log(err)
      }
    })

  }
}
