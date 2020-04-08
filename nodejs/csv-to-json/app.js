// require csvtojson module
const CSVToJSON = require('csvtojson');
const fs = require('fs');

// convert users.csv file to JSON array
CSVToJSON().fromFile('users.csv')
    .then(users => {

        // users is a JSON array
        // log the JSON array
        console.log(users);

        // Write JSON array to a file
        fs.writeFile('users.json', JSON.stringify(users, null, 4), (err) => {
            if (err) {
                throw err;
            }
            console.log("JSON array is saved.");
        });

    }).catch(err => {
        // log error if any
        console.log(err);
    });