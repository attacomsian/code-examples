const mongoose = require('mongoose');

// Connect URL
const url = 'mongodb://127.0.0.1:27017/school';

// Connect to MongoDB
(async () => {
    try {
        await mongoose.connect(url, {
            useNewUrlParser: true,
            useUnifiedTopology: true,
            useFindAndModify: false,
            useCreateIndex: true
        });
        console.log(`MongoDB Connected: ${url}`);
    } catch (err) {
        console.error(err);
    }
})();