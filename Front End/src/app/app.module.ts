import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { EmployeeComponentComponent } from './employee-component/employee-component.component';
import { FormsModule } from '@angular/forms';
 
import { HttpClientModule }    from '@angular/common/http';
import { EmployeeServiceService } from './employee-service.service';

 

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [EmployeeServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
