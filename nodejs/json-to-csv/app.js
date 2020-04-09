// require json-2-csv module
const converter = require('json-2-csv');
const fs = require('fs');

// declare a JSON array
const todos = [
    {
        "id": 1,
        "title": "delectus aut autem",
        "completed": false
    },
    {
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
    },
    {
        "id": 3,
        "title": "fugiat veniam minus",
        "completed": false
    }];

// Convert JSON array to CSV string
converter.json2csv(todos, (err, csv) => {
    if (err) {
        throw err;
    }

    // print CSV string
    console.log(csv);

    // write CSV to a file
    fs.writeFileSync('todos.csv', csv);
    
});