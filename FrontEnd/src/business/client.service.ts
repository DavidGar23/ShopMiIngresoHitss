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
}
