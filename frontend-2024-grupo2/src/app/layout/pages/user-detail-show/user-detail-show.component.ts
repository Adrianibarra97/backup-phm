import { NgClass, NgFor, NgIf } from '@angular/common'
import { Component, OnInit } from '@angular/core'
import { ActivatedRoute, Router, RouterLink } from '@angular/router'
import { ToastrService } from 'ngx-toastr'
import { AdministratorData } from 'src/app/data/models/AdministratorData'
import { BuyTicket } from 'src/app/data/models/BuyTicket'
import { CommentJSON } from 'src/app/data/models/Comment'
import { FunctionShow } from 'src/app/data/models/FunctionShow'
import { Show } from 'src/app/data/models/Show'
import { Ticket } from 'src/app/data/models/Ticket'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'
import { ShowService } from 'src/app/data/services/show-service/show.service'
import { AdminInformationComponent } from 'src/app/shared/components/admin-information/admin-information.component'
import { FunctionShowFormComponent } from 'src/app/shared/components/function-show-form/function-show-form.component'
import { GridCommentComponent } from 'src/app/shared/components/grid-comment/grid-comment.component'
import { TicketsConsumerInformationComponent } from 'src/app/shared/components/tickets-consumer-information/tickets-consumer-information.component'

@Component({
  selector: 'app-user-detail-show',
  standalone: true,
  imports: [
    GridCommentComponent,
    RouterLink,
    NgFor,
    NgClass,
    NgIf,
    TicketsConsumerInformationComponent,
    AdminInformationComponent,
    FunctionShowFormComponent
  ],
  templateUrl: './user-detail-show.component.html',
  styleUrl: './user-detail-show.component.css'
})
export class UserDetailShowComponent implements OnInit {
  public show!: Show
  public buyTicket!: BuyTicket
  public comments: CommentJSON[] = []
  public functionShow!: FunctionShow
  public displayFunctionShowForm: boolean = false
  public ticketList: Ticket[] = []
  public amountTicketToBuy = new Map()
  public administratorData: AdministratorData = new AdministratorData(
    0,
    [],
    0,
    0,
    0,
    0,
    0
  )

  constructor(
    private showService: ShowService,
    private auth: AuthService,
    private route: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService
  ) {}

  isConsumer(): boolean {
    return this.auth.isConsumer()
  }

  isAdministrator(): boolean {
    return this.auth.isAdministrator()
  }

  setFunction(functionShow: FunctionShow) {
    this.functionShow = functionShow
  }

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

  doubleAGradoMinutoSegundo(coordenadaDouble: number): string {
    const grados = Math.floor(coordenadaDouble)
    const minutosDecimal = (coordenadaDouble - grados) * 60
    const minutos = Math.floor(minutosDecimal)
    const segundos = (minutosDecimal - minutos) * 60
    return grados + 'º' + minutos + "'" + Math.round(segundos) + '"'
  }

  cancelFunctionShow() {
    this.router.navigateByUrl('/home')
  }

  openFunctionShowForm() {
    this.displayFunctionShowForm = true
  }

  closeFunctionShowForm() {
    this.displayFunctionShowForm = false
  }

  async createFunctionShow(event: FunctionShow) {
    this.displayFunctionShowForm = false
    if (this.show.id > -1) {
      await this.showService.createFunctionShow(this.show.id, event)
      this.toastr.success('Se creó una nueva función', 'Exito')
    } else {
      this.toastr.error(
        'Debe seleccionar un show antes de crear la función',
        'Error'
      )
    }
  }

  async ngOnInit(): Promise<void> {
    try {
      const showId: number = +this.route.snapshot.params['id']
      this.comments = await this.showService.getCommentsByShow(showId)
      this.show = await this.showService.getOneById(showId)
      this.administratorData =
        await this.showService.getAdministratorData(showId)
    } catch {
      this.comments = []
    }
  }
}
