import { Pipe, PipeTransform } from '@angular/core';


@Pipe({name: 'smallest'})
export class SmallestPipe implements PipeTransform{
    
    transform(input: number[]):number {
  
        if(input.length==0){
            return 0;
        }

        let smallest:number=input[0];

        for(let num of input){
            if(num<smallest){
                smallest=num;
            }
        }
        return smallest;

    }

} 