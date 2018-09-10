import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeServiceService } from '../employee-service.service';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-employee-component',
  templateUrl: './employee-component.component.html',
  styleUrls: ['./employee-component.component.css']
})
export class EmployeeComponentComponent implements OnInit {

  employees: Employee[]=[];
  employees_FromDB: Employee[]=[];
   
header: HttpHeaders;
  theEmployee=new Employee;
  
  private postUrl="http://localhost:8080/employee_management/api/multiRecords"
   
  
   httpOptions = {
    headers: new HttpHeaders({'button':'false'})
    };

  
  public addEmployee():void{
     var current: Employee = new Employee;
    current.firstName = this.theEmployee.firstName;
    current.lastName  = this.theEmployee.lastName;
    current.email = this.theEmployee.email;
    current.contact = this.theEmployee.contact;
     this.employees.push(current);
    console.log("---",this.employees[0].firstName);
  }


  public addToDBI():void{
    this.empservice.getEmployees().subscribe((emplist: Employee[]) => this.employees_FromDB=emplist);
    this.empservice.addToDBI(this.employees).subscribe();
    
  }
  public addToDBII():void {
    this.empservice.getEmployees().subscribe((emplist: Employee[]) => this.employees_FromDB=emplist);
    this.empservice.addToDBII(this.employees).subscribe();
  
  }

  constructor(private http:HttpClient, private empservice: EmployeeServiceService) { 

    this.refreshDB();
  }
  

  public refreshDB(){
    this.empservice.getEmployees().subscribe((emplist: Employee[]) => this.employees_FromDB=emplist);
  }

  public ngOnInit(){

  }
}
