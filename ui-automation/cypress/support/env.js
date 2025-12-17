const fs = require('fs');
const path = require('path');

const ENV = process.env.ENV || 'qa';

const configPath = path.join(
  __dirname,
  '../../../config/env-config.json'
);

const allConfig = JSON.parse(fs.readFileSync(configPath));
module.exports = allConfig[ENV];
