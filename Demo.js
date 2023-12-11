'use strict';

const express = require('express');
const app = express();
app.use(express.json());

// Your code starts here. Placeholders for .get and .post are provided for
//  your convenience.

const candidates=[];

const ids=new Set();

app.post('/candidates', function(req, res) {
  // ...
  if(!req.body || req.body ==null || !req.body.id || !req.body.name  || ! req.body.skills){
    return res.status(404).send('Need mandatory parameters');
  }
  const value = req.body;

  const id =req.body.id;
  if(!ids.has(id)){
     candidates.push(value);
     ids.add(id);
  }else{
    res.sendStatus(404);
  }
 // console.log(value);
res.setHeader("Content-Type","application/json");
 res.sendStatus(200);
});

app.get('/candidates/search', function(req, res) {
  // ...
  if(!req.query['skills']){
    return res.send(404,"need skills");
  }

  if(candidates.length==0){
    return res.sendStatus(404);
  }
    const skills= req.query['skills'].split(',');

    if(skills.length==0){
      return res,status(404).end();
    }
   // console.log(skills);
    let rest= [];
    for(let i=0; i < skills.length; i++){
      const skill= skills[i];
      for(let j=0; j < candidates.length; j++){
        const cand= candidates[j];
        if(cand['skills'].indexOf(skill)!=-1){
          rest.push(cand);
        }
      }
    }

    if(rest.length==0){
      return res.status(404).end();
    }

    //console.log(candidates);
    return res.status(404).json(rest[0]);
});

app.listen(process.env.HTTP_PORT || 3000);
