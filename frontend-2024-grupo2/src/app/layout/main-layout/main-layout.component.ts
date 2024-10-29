import { Component } from '@angular/core'
import { HeaderComponent } from '../header/header.component'
import { FooterComponent } from '../footer/footer.component'
import { RouterOutlet } from '@angular/router'

@Component({
  selector: 'app-main-layout',
  standalone: true,
  templateUrl: './main-layout.component.html',
  styleUrl: './main-layout.component.css',
  imports: [RouterOutlet, HeaderComponent, FooterComponent]
})
export class MainLayoutComponent {}
