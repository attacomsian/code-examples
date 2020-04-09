// require json-2-csv module
const converter = require('json-2-csv');
const fs = require('fs');

// read JSON from a file
const todos = JSON.parse(fs.readFileSync('todos.json'));

// convert JSON array to CSV string
(async () => {
    try {
        const csv = await converter.json2csvAsync(todos);

        // print CSV string
        console.log(csv);

        // write CSV to a file
        fs.writeFileSync('todos.csv', csv);

    } catch (err) {
        console.log(err);
    }
})();