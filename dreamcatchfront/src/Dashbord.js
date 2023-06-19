import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import { useNavigate } from 'react-router-dom';

export default function Appbar() {

  const navigate = useNavigate();

  const  handleButton = (item) =>{
    if(item==='Verifica'){
      navigate('Alege');
    }else if(item==='Introdu'){
      navigate('form');
    }
  }

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          </Typography>
          <Button color="inherit" onClick={()=> handleButton('Verifica')}>Verifica Starea somnului</Button>
          <Button color="inherit" onClick={()=> handleButton('Introdu')}>Introdu date</Button>
        </Toolbar>
      </AppBar>
      <h1>Bine ai venit!</h1>
      <p>Din aceasta pagina poti alege ce doresti sa faci!</p>
      <p>Poti introduce date despre calitatea somului la primul buton de sus</p>
      <p>Poti verifica cum este somul tau in zilele salvate la al doile buton de sus</p>
    </Box>

  );
}
