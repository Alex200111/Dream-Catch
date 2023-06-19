import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './Login';
import Dashboard from './Dashbord';
import Form from './Formular';
import Chart from './Chart';
import Alege from './Alege';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path='/dashbord' element={<Dashboard/>}/>
        <Route path='/dashbord/login' element={<Login/>}/>
        <Route path='/dashbord/form' element={<Form/>}/>
        <Route path='/dashbord/alege' element={<Alege/>}/>
        <Route path='/dashbord/alege/chart' element={<Chart/>}/>
      </Routes>
    </Router>
  );
}

export default App;