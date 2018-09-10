import { Injectable } from '@angular/core';
      
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';


@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  private postUrl="http://localhost:8080/employee_management/api/multiRecords";
  private getUrl =  "http://localhost:8080/employee_management/api/getAll";
  constructor( private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  public addToDBI(employees: Employee[]){
    let httpOptions = {
      headers: new HttpHeaders({'button':'true'})
      };
      return this.http.post<Employee[]>(this.postUrl,employees,httpOptions);
    }
    public addToDBII(employees: Employee[]){
      let httpOptions = {
        headers: new HttpHeaders({'button':'false'})
        };
      return this.http.post<Employee[]>(this.postUrl,employees,httpOptions);
    }


    public getEmployees(): Observable<Object>{
          
      return this.http.get(this.getUrl);
    }
}