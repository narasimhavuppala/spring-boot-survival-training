'use strict';

const express = require('express');
const app = express();
app.use(express.json());


const apps=[];

app.post('/candidates', function(req, res) {
    const body = req.body;
    if(body && body.name && body.skills && body.id && body.skills.length > 0){
      apps.push(body);
    }
    
    res.sendStatus(201);
});

app.get('/candidates/search', function(req, res) {
    const skills =req.query['skills'];

    if(!skills || skills.length ==0  || apps.length==0){
      res.sendStatus(404);
    }

    let sarra= skills.split(",");

    if(sarra.length==0 || ){
      res.sendStatus(404);
    }
  

  //  let cntr=0;
  //console.log(apps);
  //consol.log(sarra)
  let max=0;
  let obj={};
     for(let i=0; i < apps.length; i++){
      const xx= apps[i];

      //console.log(i +":::::"+ xx['skills'] +":::::"+ sarra.length);

      let count=0;
    // for(let k=0; k < xx.skills.length; k++){
       for(let m=0; m < sarra.length; m++){
         if(xx.skills.indexOf(sarra[m])!=-1){
           count++;
         }
       }
        // count++;
       
    // }
    // console.log(count +":::::"+ obj);
      if(count > max){
        max=count;
        obj=xx;
    
      }

     }

     if(max ==0){
       res.sendStatus(404);
     }
    res.json(obj);
});

app.listen(process.env.HTTP_PORT || 3000);
