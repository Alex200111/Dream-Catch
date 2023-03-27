import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container } from '@mui/system';
import { Paper ,Button} from '@mui/material';

export default function BasicTextFields() {
  const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"};

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1 },
      }}
      noValidate
      autoComplete="off"
    >
      <div><h1 style={{color:"blue"}}><u>Introduceti datele de utilizator:</u></h1></div>
      <TextField id="outlined-basic" label="Username" variant="outlined" fullWidth
                type="text"
                autoComplete="off"
                required
                />
      <TextField label="Password" variant="outlined" fullWidth
                    type="password"
                    id="password"
                    required
                />
      <Button variant="contained">Login</Button>
    </Box>
    </Paper>
</Container>
  );
}
