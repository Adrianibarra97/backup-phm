import { FunctionShow } from './../../../data/models/FunctionShow'
import { NgClass, NgFor, NgIf } from '@angular/common'
import { Component, OnInit } from '@angular/core'
import { ToastrService } from 'ngx-toastr'
import { AdministratorData } from 'src/app/data/models/AdministratorData'
import { FilterShowJSON, Show } from 'src/app/data/models/Show'
import { ShowService } from 'src/app/data/services/show-service/show.service'
import { FunctionShowFormComponent } from 'src/app/shared/components/function-show-form/function-show-form.component'
import { SearchBarComponent } from 'src/app/shared/components/search-bar/search-bar.component'
import { ShowAdministratorComponent } from 'src/app/shared/components/show-administrator/show-administrator.component'
import { ShowFormComponent } from 'src/app/shared/components/show-form/show-form.component'

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [
    SearchBarComponent,
    NgFor,
    NgClass,
    NgIf,
    ShowAdministratorComponent,
    FunctionShowFormComponent,
    ShowFormComponent
  ],
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.css'
})
export class AdminDashboardComponent implements OnInit {
  public shows: Show[] = []
  public functions: FunctionShow[] = []
  public showIdSelected: number = -1
  public displayFunctionShowForm: boolean = false
  public displayShowForm: boolean = false
  public peopleProfitStyleClass: string = 'profit red'
  public administratorData: AdministratorData = new AdministratorData(
    0,
    [],
    0,
    1,
    0,
    0,
    0
  )
  public filterShowJSON: FilterShowJSON = {
    bandName: '',
    location: '',
    byFriends: false
  }

  constructor(
    private showService: ShowService,
    private toastr: ToastrService
  ) {}

  getDayOfShow(date: Date): string {
    const days = [
      'Lunes',
      'Martes',
      'Miércoles',
      'Jueves',
      'Viernes',
      'Sábado',
      'Domingo'
    ]
    return days[date.getDay()]
  }

  salesProfitStyle(): string {
    if (this.administratorData.totalSales <= 1000000) {
      return 'profit red'
    }
    if (
      this.administratorData.totalSales > 1000000 &&
      this.administratorData.totalSales <= 2000000
    ) {
      return 'profit yellow'
    }
    return 'profit green'
  }

  peopleProfitStyle(minPrice: number): string {
    const value = this.administratorData.amountPeopleWaiting * minPrice
    if (value <= this.administratorData.totalCost) {
      this.peopleProfitStyleClass = 'profit red'
      return 'profit red'
    }
    if (value <= this.administratorData.totalCost * 1.5) {
      this.peopleProfitStyleClass = 'profit yellow'
      return 'profit yellow'
    }
    this.peopleProfitStyleClass = 'profit green'
    return 'profit green'
  }

  profitStyle(): string {
    if (this.administratorData.totalSales <= this.administratorData.totalCost) {
      return 'profit red'
    }
    if (
      this.administratorData.totalSales <=
      this.administratorData.totalCost * 1.5
    ) {
      return 'profit yellow'
    }
    return 'profit green'
  }

  soldOutProfitStyle(): string {
    if (
      this.isSoldOutPercent(50, this.administratorData.amountFunctionsSoldOut)
    ) {
      return 'profit red'
    }
    if (
      this.isSoldOutPercent(75, this.administratorData.amountFunctionsSoldOut)
    ) {
      return 'profit yellow'
    }
    return 'profit green'
  }

  isSoldOutPercent(
    waitingPercent: number,
    amountFunctionsSoldOut: number
  ): boolean {
    return (
      amountFunctionsSoldOut <= this.functions.length * (waitingPercent / 100)
    )
  }

  soldOutStyle(functionShow: FunctionShow): string {
    if (functionShow.isSoldDout) {
      return 'dash__function dash__function--soldout'
    }
    return 'dash__function'
  }

  profit(): number {
    return (
      (this.administratorData.totalSales * 100) /
      this.administratorData.totalCost
    )
  }

  openShowForm() {
    this.displayShowForm = true
  }

  openFunctionShowForm() {
    this.displayFunctionShowForm = true
  }

  closeShowForm() {
    this.displayShowForm = false
  }

  closeFunctionShowForm() {
    this.displayFunctionShowForm = false
  }

  async createShow(event: Show) {
    try {
      await this.showService.create(event)
      this.toastr.success('Se creó un nuevo show', 'Exito')
      this.updateShowList()
    } catch {
      this.toastr.error('Hubo un error al crear un show!', 'Error')
    }
  }

  async createFunctionShow(event: FunctionShow) {
    this.displayFunctionShowForm = false

    if (this.showIdSelected > -1) {
      await this.showService.createFunctionShow(this.showIdSelected, event)
      this.toastr.success('Se creó una nueva función', 'Exito')
      this.updateShowList()
    } else {
      this.toastr.error(
        'Debe seleccionar un show antes de crear la función',
        'Error'
      )
    }
  }

  async selectShow(show: Show) {
    try {
      this.showIdSelected = show.id
      this.functions = show.functionShow
      this.administratorData = await this.showService.getAdministratorData(
        show.id
      )
      this.peopleProfitStyle(show.minPrice)
    } catch {}
  }

  async searchShowsBy(event: FilterShowJSON): Promise<void> {
    try {
      this.filterShowJSON = event
      this.shows = await this.showService.getShowsFilterBy(this.filterShowJSON)
    } catch {
      this.shows = []
    }
  }

  async updateShowList() {
    try {
      this.shows = await this.showService.getAll()
    } catch {
      this.shows = []
    }
  }

  async ngOnInit() {
    try {
      this.shows = await this.showService.getAll()
    } catch {
      this.shows = []
    }
  }
}
