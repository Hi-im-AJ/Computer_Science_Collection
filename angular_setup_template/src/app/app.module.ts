import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PopularMovieListComponent } from './components/popular-movie-list/popular-movie-list.component';
import { MovieComponent } from './components/movie/movie.component';
import { AboutComponent } from './components/views/about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PopularMovieListComponent,
    MovieComponent,
    AboutComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: PopularMovieListComponent },
      { path: 'about', component: AboutComponent },
    ]),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
