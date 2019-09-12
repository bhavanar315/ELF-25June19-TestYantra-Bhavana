
const  userEmail= JSON.parse(window.localStorage.getItem('taskBeans'));
const todo= userEmail.filter(item => item.subject === 'to do')
const INPROGRESS= userEmail.filter(item => item.subject === 'Done')
    


console.log("object", userEmail);
console.log("todo", todo);
const initialData = {

 
    tasks:
    {
        id:1,
        
    },
    
    columns: {
        1: {
            id: 1,
            title: "OPEN",
            taskIds:todo[0].taskId 

        },
        2: {
            id: 2,
            title: "BLOCKED",
            taskIds: INPROGRESS[0].taskId
        },
        3: {
            id: 3,
            title: "IN PROGRESS",
            taskIds: INPROGRESS[0].taskId
        },
       
    },
    columnOrder: [1, 2, 3]
}
const x = {
    "draggableId": 2,
    "type": "DEFAULT",
    "source": {"index": 1, "droppableId": 1},
    "reason": "DROP",
    "mode": "FLUID",
    "destination": {"droppableId": 2, "index": 0},
    "combine": null
}

export default initialData
