import * as React from 'react';
import TextField from '@mui/material/TextField';
import { Container } from '@mui/system';
import { Paper } from '@mui/material';
import { useState } from 'react';
import { LocalizationProvider, DateField } from '@mui/x-date-pickers';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { FormControl, FormLabel, RadioGroup, FormControlLabel, Radio } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function BasicTextFields() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"};
    const [formData, setFormData] = useState({
        date: null,
        type: "7"
      });
    const navigate = useNavigate();

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {      
            navigate("chart", {state: formData});
        } catch (error) {
            console.log(error)
        }
      };


  return (
    <Container>
                <Paper elevation={5} style={paperStyle}>
                    <h1>Alege perioada</h1>
                    <form onSubmit={handleSubmit}>
  <LocalizationProvider dateAdapter={AdapterDayjs}>
      <DateField
        label="Select a date"
        variant="filled"
        autoComplete="off"
        required
        value={formData.date}
        onChange={(newValue) => {
        setFormData(prevFormData => ({ ...prevFormData, date: newValue }));
        }}
        renderInput={(params) => <TextField {...params} />}
      />
    </LocalizationProvider>
      <br></br>
      <br></br>

      <FormControl>
        <FormLabel id="demo-radio-buttons-group-label">Saptamana/Luna</FormLabel>
        <RadioGroup
            aria-labelledby="demo-radio-buttons-group-label"
            defaultValue="7"
            name="radio-buttons-group"
            value={formData.type}
            onChange={(e) => setFormData({ ...formData, type: e.target.value })}
        >
    <FormControlLabel value="7" control={<Radio />} label="Saptamana" />
    <FormControlLabel value="30" control={<Radio />} label="Luna" />

  </RadioGroup>
</FormControl>
        <br></br>
      <br></br>
      <center><button type="submit">Submit</button></center>

      </form>
</Paper>
</Container>
  );
}
