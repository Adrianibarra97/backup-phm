import { AuthService } from 'src/app/data/services/auth-service/auth.service'
import { Router } from '@angular/router'
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { ReactiveFormsModule } from '@angular/forms'
import { MessagesModule } from 'primeng/messages'
import { CommonModule } from '@angular/common'
import { ButtonModule } from 'primeng/button'
import { Component } from '@angular/core'

@Component({
  selector: 'app-auth-login',
  standalone: true,
  templateUrl: './auth-login.component.html',
  styleUrl: './auth-login.component.css',
  imports: [ReactiveFormsModule, MessagesModule, CommonModule, ButtonModule]
})
export class AuthLoginComponent {
  public user: FormGroup

  constructor(
    private router: Router,
    private biulter: FormBuilder,
    private authService: AuthService
  ) {
    this.user = this.biulter.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  async onSubmit() {
    try {
      parseInt(this.user.value.password)
      await this.authService.login(this.user.value)
      this.router.navigateByUrl('/home')
    } catch (error) {}
  }

  isFormInvalid() {
    return this.user.invalid
  }

  navigateHome() {
    this.router.navigateByUrl('/home')
  }
}
