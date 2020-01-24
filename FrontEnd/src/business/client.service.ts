import { Injectable } from '@angular/core';
import { ClientM } from 'src/model/clientM';
import { ApiRestService } from 'src/service/api-rest.service';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  public clients: ClientM[] = [];

  constructor(private apiRest: ApiRestService) { }

  GetClients() {
    this.apiRest.getClients()
      .subscribe(resp => {
        for (const data of resp.body) {
          this.clients.push(data);
        }
      });
  }
  DeleteClient(idClient: string) {
    this.apiRest.deleteClient(idClient);
    for (let index = 0; index < this.clients.length; index++) {
      if (this.clients[index].idClient == idClient)
        this.clients.splice(index, 1);
    }
  }

  UpdateClient(client: ClientM) {
    this.apiRest.updateClient(client);
    for (let index = 0; index < this.clients.length; index++) {
      if (this.clients[index].idClient == client.idClient)
        this.clients[index] = client;
    }
  }
  AddClient(client: ClientM) {
    this.apiRest.addClient(client);
    this.clients.push(client);
  }
}
