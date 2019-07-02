import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StudentComponent } from './student.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { StudentRoutingModule } from './student.routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { AuthorService } from 'src/app/services/author.service';
import { BookService } from 'src/app/services/book.service';
import { BsModalRef } from 'ngx-bootstrap';
import { StudentService } from 'src/app/services/student.service';

@NgModule({
  declarations: [StudentComponent, StudentDetailsComponent],
  imports: [
    CommonModule,
    StudentRoutingModule,
    FormsModule,
    NgxDatatableModule,
    ReactiveFormsModule
  ],
  providers: [
    AuthorService,
    BookService,
    StudentService,
    BsModalRef
  ]
})
export class StudentModule { }