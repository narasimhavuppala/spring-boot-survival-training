import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-rating',
  template: `
  <span  *ngFor="let _ of [].constructor(rate)">&#9733;</span>
  <span   *ngFor="let _ of [].constructor(maxRating - rate)">&#9734;</span>
  <h3>{{name}}</h3>
  <p>{{content}}</p>
  `,
})
export class RatingComponent {

  @Input('name')
  public name: string;

  @Input('content')
  public content: string;

  @Input('rate')
  public rate: number;

  maxRating:Number=5;
}

@Component({
  selector: 'app-average-rating',
  template: `

   <span  *ngFor="let _ of [].constructor(avgValue)">&#9733;</span>
  <span   *ngFor="let _ of [].constructor(5 - avgValue)">&#9734;</span>
  <h3>{{name}}</h3>
  <p>{{content}}</p>
  `,
})
export class AverageRatingComponent implements OnInit {
  @Input('ratings')
  public ratings: {name: string, content: string, rate: number}[];

  avgValue:number=0;
  ngOnInit(){
      let sum= 0;

      for(let k=0; k < this.ratings.length; k++){
          let val = this.ratings[k];
          sum = sum + val.rate;
      }

      this.avgValue= Math.floor(sum/this.ratings.length);


  }
}

@Component({
  selector: 'app-ratings-list',
  template: `

  <app-average-rating  [ratings]="ratings"> </app-average-rating>

  <div  *ngFor="let rt of ratings">
   <app-rating [name]="rt.name" [content]="rt.content" [rate]="rt.rate"> </app-rating>
  </div>
  `,
})
export class RatingsListComponent {
  @Input('ratings')
  public ratings: {name: string, content: string, rate: number}[];
}
