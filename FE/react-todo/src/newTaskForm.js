import { useState} from "react";

function NewTaskForm(){

    const onSubmitHandler = event => {
        event.preventDefault()
    }


    const [taskName, setTaskName] = useState()
    const [taskDescription, setTaskDescription] = useState()


    return(

        <form onSubmit={onSubmitHandler}>
          <div class="form-group">
            <label for="exampleInputEmail1">Task name</label>
            <input type="text" class="form-control" value={taskName} onChange={(e => setTaskName(e.target.value))}/>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Task description</label>
            <input type="text" class="form-control" value={taskDescription} onChange={(e => setTaskDescription(e.target.value))}/>
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
      </form>
      )
}

export default NewTaskForm;