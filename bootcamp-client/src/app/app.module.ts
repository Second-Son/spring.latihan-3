import { RouterModule, Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HalamanComponent } from './halaman/halaman.component';
import { RegistrasiComponent } from './halaman/registrasi/registrasi.component';
import { JadwalComponent } from './halaman/jadwal/jadwal.component';
import { AdminComponent } from './halaman/admin/admin.component';
import { LoginComponent } from './halaman/login/login.component';

const appRoutes: Routes = [
  { path: 'registrasi', component: RegistrasiComponent },
  { path: 'login', component: LoginComponent },
  { path: 'admin', component: AdminComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HalamanComponent,
    RegistrasiComponent,
    JadwalComponent,
    AdminComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
