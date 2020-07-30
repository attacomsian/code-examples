const crypto = require('crypto');
const fs = require('fs');

const algorithm = 'aes-256-ctr';
const secretKey = 'vOVH6sdmpNWjRRIqCc7rdxs01lwHzfr3';
const iv = crypto.randomBytes(16);

// input file
const r = fs.createReadStream('file.txt');

// encrypt content
const encrypt = crypto.createCipheriv(algorithm, secretKey, iv);

// decrypt content
const decrypt = crypto.createDecipheriv(algorithm, secretKey, iv);

// write file
const w = fs.createWriteStream('file.out.txt');

// start pipe
r.pipe(encrypt)
    .pipe(decrypt)
    .pipe(w);