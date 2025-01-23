import { Component, Renderer2, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenav, MatSidenavModule } from '@angular/material/sidenav';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatSidenavModule,
  ],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  @ViewChild('sidenav') sidenav!: MatSidenav;
  currentTheme: 'light' | 'dark' = 'light'; // Définir le type du thème

  constructor(private renderer: Renderer2) {
    // Récupérer le thème sauvegardé ou définir le thème par défaut
    const savedTheme = localStorage.getItem('theme') || 'light';
    this.currentTheme = savedTheme as 'light' | 'dark';
    this.applyTheme(this.currentTheme);
  }

  toggleSidenav() {
    this.sidenav.toggle();
    console.log('Sidenav toggled');
  }

  toggleTheme() {
    // Basculer entre les thèmes
    this.currentTheme = this.currentTheme === 'light' ? 'dark' : 'light';
    localStorage.setItem('theme', this.currentTheme); // Sauvegarder le thème
    this.applyTheme(this.currentTheme);
    console.log(`Theme switched to ${this.currentTheme}`);
  }

  private applyTheme(theme: 'light' | 'dark') {
    const htmlElement = document.documentElement;
    this.renderer.removeClass(htmlElement, 'light');
    this.renderer.removeClass(htmlElement, 'dark');
    this.renderer.addClass(htmlElement, theme);
  }

  onLogin() {
    console.log('Login button clicked');
    // Redirection ou ouverture de modale
    // Exemple : this.router.navigate(['/login']);
  }
  
  onRegister() {
    console.log('Register button clicked');
    // Redirection ou ouverture de modale
    // Exemple : this.router.navigate(['/register']);
  }
}
