// require csvtojson module
const CSVToJSON = require('csvtojson');

// convert users.csv file to JSON array
(async () => {
    try {
        const users = await CSVToJSON().fromFile('users.csv');

        // log the JSON array
        console.log(users);

    } catch (err) {
        console.log(err);
    }
})();