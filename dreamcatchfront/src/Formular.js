import * as React from 'react';
import TextField from '@mui/material/TextField';
import { Container } from '@mui/system';
import { Paper } from '@mui/material';
import { useState } from 'react';
import { LocalizationProvider, DateField } from '@mui/x-date-pickers';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import axios from 'axios';

export default function BasicTextFields() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"};
    const [durata, setDurata] = useState('');
    const [stres, setStres] = useState('');
    const [energie, setEnergie] = useState('');
    const [descriere, setDescriere] = useState('');
    const [tag, setTag] = useState('');
    const [data, setData] = useState('');


    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            await axios.post('http://localhost:8080/dream/add', {
                durata: durata,
                stres: stres,
                energie: energie,
                descriere: descriere,
                tag: tag,
                data:data,
                idUser: localStorage.getItem('idUser'),

              });   
              setDurata('');
              setEnergie('');
              setStres('');
              setDescriere('');
              setTag('');
              setData('');       
        } catch (error) {
            console.log(error)
        }
      };


  return (
    <Container>
                <Paper elevation={5} style={paperStyle}>
                    <h1>Introdu date despre somnul tau:</h1>
                    <form onSubmit={handleSubmit}>

      <TextField id="filled-basic" label="Durata" variant="filled"
      fullWidth
      type='number' 
      inputProps={{min:1,max:5}}
      onChange={(e) => setDurata(e.target.value)}
      value={durata}
      autoComplete="off"
      required
      />
      <br></br>
      <br></br>
      <TextField id="filled-basic" label="Stres" variant="filled"
      fullWidth
      type='number' 
      inputProps={{min:1,max:5}}
      onChange={(e) => setStres(e.target.value)}
      value={stres}
      autoComplete="off"
      required
      />
      <br></br>
      <br></br>
      <TextField id="filled-basic" label="Energie" variant="filled"
      fullWidth
      type='number' 
      inputProps={{min:1,max:5}}
      onChange={(e) => setEnergie(e.target.value)}
      value={energie}
      autoComplete="off"
      required
      />
      <br></br>
      <br></br>
      <TextField id="filled-basic" label="Descriere" variant="filled"
      type="text"
      fullWidth 
      onChange={(e) => setDescriere(e.target.value)}
      value={descriere}
      autoComplete="off"
      required
      />
      <br></br>
      <br></br>
      <TextField id="filled-basic" label="Tag" variant="filled"
      type="text"
      fullWidth 
      onChange={(e) => setTag(e.target.value)}
      value={tag}
      autoComplete="off"
      required
      />
      <br></br>
      <br></br>
      {/* <DateField label="Data"
      fullWidth 
      onChange={(e) => setData(e.target.value)}
      value={data}
      required
      format="MM-DD-YYYY"
/> */}
  <LocalizationProvider dateAdapter={AdapterDayjs}>
      <DateField
        label="Select a date"
        variant="filled"
        autoComplete="off"
        required
        value={data}
        onChange={(newValue) => {
          setData(newValue);
        }}
        renderInput={(params) => <TextField {...params} />}
      />
    </LocalizationProvider>
      <br></br>
      <br></br>
      <center><button type="submit">Submit</button></center>

      </form>
</Paper>
</Container>
  );
}
