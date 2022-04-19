import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PopularMovieListComponent } from './components/popular-movie-list/popular-movie-list.component';
import { AboutComponent } from './components/views/about/about.component';

const routes: Routes = [
  { path: '', component: PopularMovieListComponent },
  { path: 'about', component: AboutComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
