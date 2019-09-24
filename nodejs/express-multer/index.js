const express = require('express');
const multer = require('multer');
const cors = require('cors');
const bodyParser = require('body-parser');
const morgan = require('morgan');

// create express app
const app = express();

// upload file path
const FILE_PATH = 'uploads';

// configure multer
const upload = multer({
    dest: `${FILE_PATH}/`,
    limits: {
        files: 5, // allow up to 5 files per request,
        fieldSize: 2 * 1024 * 1024 // 2 MB (max file size)
    },
    fileFilter: (req, file, cb) => {
        // allow images only
        if (!file.originalname.match(/\.(jpg|jpeg|png|gif)$/)) {
            return cb(new Error('Only image are allowed.'), false);
        }
        cb(null, true);
    }
});

// enable CORS
app.use(cors());

// add other middleware
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(morgan('dev'));

// upload single file
app.post('/upload-avatar', upload.single('avatar'), async (req, res) => {
    try {
        const avatar = req.file;

        // make sure file is available
        if (!avatar) {
            res.status(400).send({
                status: false,
                data: 'No file is selected.'
            });
        } else {
            //send response
            res.send({
                status: true,
                message: 'File is uploaded.',
                data: {
                    name: avatar.originalname,
                    mimetype: avatar.mimetype,
                    size: avatar.size
                }
            });
        }

    } catch (err) {
        res.status(500).send(err);
    }
});

// upload multiple files
app.post('/upload-photos', upload.array('photos', 8), async (req, res) => {
    try {
        const photos = req.files;

        // check if photos are available
        if (!photos) {
            res.status(400).send({
                status: false,
                data: 'No photo is selected.'
            });
        } else {
            let data = [];

            // iterate over all photos
            photos.map(p => data.push({
                name: p.originalname,
                mimetype: p.mimetype,
                size: p.size
            }));

            // send response
            res.send({
                status: true,
                message: 'Photos are uploaded.',
                data: data
            });
        }

    } catch (err) {
        res.status(500).send(err);
    }
});

// start the app 
const port = process.env.PORT || 3000;

app.listen(port, () =>
    console.log(`App is listening on port ${port}.`)
);
