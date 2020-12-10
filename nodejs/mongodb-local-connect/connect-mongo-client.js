const MongoClient = require('mongodb').MongoClient;

// Connect URL
const url = 'mongodb://127.0.0.1:27017';

// Connec to MongoDB
MongoClient.connect(url, {
    useNewUrlParser: true,
    useUnifiedTopology: true
}, (err, client) => {
    if (err) {
        return console.log(err);
    }

    // Specify database you want to access
    const db = client.db('school');

    console.log(`MongoDB Connected: ${url}`);

    // Create a collection
    const courses = db.collection('courses');

    // Insert single document
    courses.insertOne({ name: 'Web Security' }, (err, result) => { });

    // Insert multiple docoments
    courses.insertMany([
        { name: 'Web Design' },
        { name: 'Distributed Database' },
        { name: 'Artificial Intelligence' }
    ], (err, results) => { });

    // Find all documents
    courses.find().toArray((err, results) => {
        console.log(results);
    });

    // Find single document
    courses.find({ name: 'Web Design' }).toArray((err, result) => {
        console.log(result);
    });

    // Find first document
    courses.findOne({ name: 'Web Design' }, (err, result) => {
        console.log(result);
    });

    // Update a document
    courses.updateOne({ name: 'Web Design' }, { $set: { name: 'Web Analytics' } },
        (err, result) => {
            console.log(result);
        });

    // Delete a document
    courses.deleteOne({ name: 'Distributed Database' }, (err, result) => {
        console.log(result);
    });

    // Close connection
    // client.close();
});