import './App.css';
import Navbar from './components/Navbar';
import {BrowserRouter} from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div>
      <BrowserRouter>
        <Navbar/>
      </BrowserRouter>
    </div>
  );
}

export default App;
