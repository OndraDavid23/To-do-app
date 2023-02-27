

function Task({task}){

    const complete = "Done";
    const unComplete = "Not done";

    return(
        <div>
            <h1>{task.name}</h1>
            <p>{task.description}</p>
            {task.complete && complete}
            {!task.complete && unComplete}
        </div>
    )
    
}

export default Task;