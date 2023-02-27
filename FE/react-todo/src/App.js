import logo from './logo.svg';
import './App.css';
// import NewTaskForm from './newTaskForm'
import { useEffect, useState } from 'react';
import Task from './task';
import Container from 'react-bootstrap/Container';
import Header from './header';
import Sidebar from './sidebar';
import { Stack } from 'react-bootstrap';

function App() {


const [task, setTask] = useState([]);


useEffect(()=>{
  fetch("http://127.0.0.1:8080/api/v1/toDo")
  .then(response => {
    if (response.ok){
    return response.json()
  }
    throw new Error('Unable to get data: ' +  response.statusText)
  })
  .then(json => setTask(json))
}, []);

useEffect(() => {
  console.log("These are the tasks you have to do: ");
  console.log(task);
}, [task]);


return (
    <Container fluid className="App">
      <Header/>
      <Container>        
      <Stack direction="horizontal">
        <Sidebar/>
        <Container>
          {task.map(item =><Task key={item.id} task = {item}/>)}
        </Container>
      </Stack>
      </Container>
    </Container>

  );
}

export default App;
