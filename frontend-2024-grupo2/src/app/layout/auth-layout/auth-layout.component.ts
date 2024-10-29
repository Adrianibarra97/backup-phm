import { Component } from '@angular/core'
import { FooterComponent } from '../footer/footer.component'

import { RouterOutlet } from '@angular/router'

@Component({
  selector: 'app-auth-layout',
  standalone: true,
  templateUrl: './auth-layout.component.html',
  styleUrl: './auth-layout.component.css',
  imports: [RouterOutlet, FooterComponent]
})
export class AuthLayoutComponent {}
