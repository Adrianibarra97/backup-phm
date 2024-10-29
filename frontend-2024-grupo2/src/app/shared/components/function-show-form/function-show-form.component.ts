import { Component, EventEmitter, Output } from '@angular/core'
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms'
import { ToastrService } from 'ngx-toastr'
import { ValidationError } from 'src/app/data/models/CustomError'
import { FunctionShow } from 'src/app/data/models/FunctionShow'

@Component({
  selector: 'app-function-show-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './function-show-form.component.html',
  styleUrl: './function-show-form.component.css'
})
export class FunctionShowFormComponent {
  @Output() closeFormEvent: EventEmitter<void> = new EventEmitter<void>()
  @Output() newFunctionShow: EventEmitter<FunctionShow> =
    new EventEmitter<FunctionShow>()
  public newDateToFunctionShow!: FormGroup

  constructor(
    private formBuilder: FormBuilder,
    private toastr: ToastrService
  ) {
    this.newDateToFunctionShow = this.formBuilder.group({
      year: [2024, Validators.min],
      month: 1,
      day: 1,
      hour: 0,
      minutes: 0
    })
  }

  dataIsValid() {
    if (!this.newDateToFunctionShow.valid) {
      throw new ValidationError('Ingreso un dato que no es válido!')
    }
  }

  createDateForFunction(): Date {
    return new Date(
      this.newDateToFunctionShow.value.year,
      this.newDateToFunctionShow.value.month,
      this.newDateToFunctionShow.value.day,
      this.newDateToFunctionShow.value.hour,
      this.newDateToFunctionShow.value.minutes,
      0
    )
  }

  createDatoToStringForFunction(): string {
    return (
      this.newDateToFunctionShow.value.year +
      '-' +
      this.newDateToFunctionShow.value.month +
      '-' +
      this.newDateToFunctionShow.value.day
    )
  }

  createNewFunction(): FunctionShow {
    return new FunctionShow(
      0,
      this.createDatoToStringForFunction(),
      this.createDateForFunction(),
      false,
      []
    )
  }

  async onSubmit() {
    try {
      this.dataIsValid()
      this.newFunctionShow.emit(this.createNewFunction())
      this.closeFormEvent.emit()
    } catch (error) {
      if (error instanceof ValidationError) {
        this.toastr.error(error.message, 'Error')
      }
    }
  }

  closeForm() {
    this.closeFormEvent.emit()
  }
}
