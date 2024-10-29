import { ShowService } from 'src/app/data/services/show-service/show.service'
import { NgFor } from '@angular/common'
import { Component, EventEmitter, OnInit, Output } from '@angular/core'
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms'
import { ToastrService } from 'ngx-toastr'
import { ValidationError } from 'src/app/data/models/CustomError'
import { PlaceOfShow } from 'src/app/data/models/PlaceOfShow'
import { Show } from 'src/app/data/models/Show'
import { StatusShow } from 'src/app/data/models/StatusShow'

@Component({
  selector: 'app-show-form',
  standalone: true,
  imports: [ReactiveFormsModule, NgFor],
  templateUrl: './show-form.component.html',
  styleUrl: './show-form.component.css'
})
export class ShowFormComponent implements OnInit {
  @Output() closeFormEvent: EventEmitter<void> = new EventEmitter<void>()
  @Output() newShowEvent: EventEmitter<Show> = new EventEmitter<Show>()
  public newShow!: FormGroup
  public possiblesPlaceOfShow!: PlaceOfShow[]

  constructor(
    private showService: ShowService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService
  ) {
    this.newShow = this.formBuilder.group({
      bandName: ['', Validators.required],
      nameOfRecital: ['', Validators.required],
      image: ['', Validators.required],
      costBand: [0, Validators.min],
      namePlaceOfShow: ['', Validators.required]
    })
  }

  closeForm() {
    this.closeFormEvent.emit()
  }

  dataIsValid() {
    if (!this.newShow.valid) {
      throw new ValidationError('Ingreso un dato que no es válido!')
    }
  }

  createNewShow(): Show {
    const initialStatus: StatusShow = new StatusShow('Precio Base', 1.8)
    return new Show(
      -1,
      this.newShow.value.bandName,
      this.searchPlaceOfShowByName(this.newShow.value.namePlaceOfShow),
      this.newShow.value.nameOfRecital,
      this.newShow.value.image,
      initialStatus,
      this.newShow.value.costBand,
      [],
      [],
      0,
      0,
      0,
      0,
      false,
      0
    )
  }

  searchPlaceOfShowByName(namePlaceOfShow: string): PlaceOfShow {
    return (
      this.possiblesPlaceOfShow.find(
        (place) => place.name == namePlaceOfShow
      ) || this.possiblesPlaceOfShow[0]
    )
  }

  async onSubmit() {
    try {
      this.dataIsValid()
      this.newShowEvent.emit(this.createNewShow())
      this.closeFormEvent.emit()
    } catch (error) {
      if (error instanceof ValidationError) {
        this.toastr.error(error.message, 'Error')
      }
    }
  }

  async ngOnInit(): Promise<void> {
    try {
      this.possiblesPlaceOfShow = await this.showService.getAllPlacesOfShow()
    } catch {
      this.possiblesPlaceOfShow = []
    }
  }
}
