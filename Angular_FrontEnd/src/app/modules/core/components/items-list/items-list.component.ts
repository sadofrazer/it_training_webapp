import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Formation } from 'src/app/entities/Formation/formation';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.scss']
})
export class ItemsListComponent implements OnInit {
  @Input() public formations$: Observable<Formation[]>;
  @Input() public listSize: number = 3;
  public size : number[] = [];
  public tab:Array<Formation[]> =[];
  constructor() { }

  ngOnInit(): void {
    this.size =Array.from(Array(5)).map((x, i) => i )
    this.orderList();
  }
  public orderList(): void{
    let nbre:number=0;
    let cpt:number=0;
    let fs :Formation[]=[];

    this.formations$.subscribe((f: Formation[]) =>{
        nbre=((f.length/this.listSize)|0)+1;
      for(let i:number=0; i<nbre; i++){
        fs=[];
        for(let j:number=0; j<3; j++){
          if (cpt<f.length){
            //console.log(f[cpt])
            fs.push(f[cpt]);
            cpt++;
            //console.log(cpt)
            //console.log(fs)
          }
        }  
        if(fs.length<3 && fs.length==1){
          fs.push(f[0]);
          fs.push(f[1]);
        }else if(fs.length<3 && fs.length==2){
          fs.push(f[0]);
        }
        this.tab.push(fs);
      }
    })
  }
}
