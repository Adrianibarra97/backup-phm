import { User } from 'src/app/data/models/User'
import { UserService } from './../../../data/services/user-service/user.service'
import { Component, OnInit } from '@angular/core'
import { AuthService } from 'src/app/data/services/auth-service/auth.service'
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms'
import { NgClass } from '@angular/common'
import { Role } from 'src/app/data/models/Role'
import { ToastrService } from 'ngx-toastr'

@Component({
  selector: 'app-user-banner',
  standalone: true,
  imports: [ReactiveFormsModule, NgClass],
  templateUrl: './user-banner.component.html',
  styleUrls: ['./user-banner.component.css']
})
export class UserBannerComponent implements OnInit {
  public user!: User
  public updatedUser!: FormGroup

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private auth: AuthService,
    private toastr: ToastrService
  ) {
    this.user = new User(
      '',
      '',
      '',
      '',
      '',
      new Date(),
      0,
      0,
      new Role('Consumer', false)
    )

    this.updatedUser = this.formBuilder.group({
      name: ['', Validators.required],
      surname: ['', Validators.required],
      dni: [0, Validators.min, Validators.max]
    })
  }

  async ngOnInit(): Promise<void> {
    try {
      this.user = await this.userService.getOneById(
        parseInt(await this.auth.getUserActiveId())
      )

      this.updatedUser = this.formBuilder.group({
        name: [this.user.name, Validators.required],
        surname: [this.user.surname, Validators.required],
        dni: [this.user.dni, Validators.required]
      })
    } catch {}
  }

  async onSubmit() {
    if (this.updatedUser.valid) {
      if (this.detectedChanges()) {
        this.user.name = this.updatedUser.value.name
        this.user.surname = this.updatedUser.value.surname
        this.user.dni = this.updatedUser.value.dni

        this.userService.update(this.user)
        this.toastr.success('El usuario se actualizó con éxito!', 'Exito')
      }
    } else {
      this.toastr.error(
        'No se pueden recibir valores nulos o incorrectos',
        'Error'
      )
    }
  }

  async addCredit() {
    await this.userService.addCreditToUser()
    this.user = await this.userService.getOneById(
      parseInt(await this.auth.getUserActiveId())
    )
  }

  age(): number {
    const ahora = new Date()
    const añoNacimiento = this?.user?.birthOfDate.getFullYear()
    const añoActual = ahora.getFullYear()
    const mesNacimiento = this?.user?.birthOfDate.getMonth()
    const mesActual = ahora.getMonth()

    if (
      mesActual < mesNacimiento ||
      (mesActual === mesNacimiento &&
        ahora.getDate() < this?.user?.birthOfDate.getDate())
    ) {
      return añoActual - añoNacimiento - 1
    }
    return añoActual - añoNacimiento
  }

  detectedChanges(): boolean {
    return (
      this?.user?.name != this.updatedUser.value.name ||
      this?.user?.surname != this.updatedUser.value.surname ||
      this?.user?.dni != this.updatedUser.value.dni
    )
  }

  birthOfDate(): string {
    return (
      this?.user?.birthOfDate.getFullYear() +
      '/' +
      this?.user?.birthOfDate.getMonth() +
      '/' +
      this?.user?.birthOfDate.getDate()
    )
  }
}
