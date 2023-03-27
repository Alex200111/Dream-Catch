import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import TextField from '@mui/material/TextField';
import { Container } from '@mui/system';
import { Paper } from '@mui/material';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();
  const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
        const response = await axios.post('http://localhost:8080/user/login', {
            username: username,
            password: password
          });          
      localStorage.setItem('idUser', response.data.id);
      navigate('dashbord');
    } catch (error) {
        setPassword('');
        setUsername('');
      console.log(error);
    }
  };

  return (
    <Container>
                <Paper elevation={5} style={paperStyle}>
                <h1 style={{color:"blue"}}><u>Introduceti datele de utilizator:</u></h1>
    <form onSubmit={handleSubmit}>
        <TextField id="outlined-basic" label="Username" variant="outlined" fullWidth
                type="text"
                autoComplete="off"
                onChange={(e) => setUsername(e.target.value)}
                value={username}
                required
                />
                <br></br>
                <br></br>
        <TextField label="Password" variant="outlined" fullWidth
                    type="password"
                    id="password"
                    onChange={(e) => setPassword(e.target.value)}
                    value={password}
                    required
                />
                <br></br>
                <br></br>
      <center><button type="submit">Log in</button></center>
      
    </form>
    </Paper>
    </Container>
  );
}

export default Login;