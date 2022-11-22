const https = require('https');

getBordersInfo("ESP", showErrorOrDensityAverage)
console.log("Peticion realizada");
console.log("---");

function getBordersInfo(code, callback) {
    getCountryInfo(code, function (err, country) {
        if (err) {
            callback(err);
        } else {
            let globalErr = false;
            let borders = [];
            let average;
            for (let code of country.borders) {
                getCountryInfo(code, function (err2, countryBorder) {
                    if (err2) {
                        callback(err2);
                        globalErr = true;
                    } else {
                        if (!globalErr) {
                            borders.push(countryBorder);
                            if (borders.length === country.borders.length) {
                                average=callback(undefined, borders, country);
                            }
                        }
                    }
                });
            }
            console.log(`The average of population of borders countries of ${country.name.official} is ${average} (hab/Km2)`);
        }
    });
}

function getCountryInfo(code, callback) {
    const url = `https://restcountries.com/v3.1/alpha/${code}`;
    console.log(url);
    https
        .get(url, (resp) => {
            let data = '';

            resp.on('data', (chunk) => {
                data += chunk;
            });

            resp.on('end', () => {
                if (resp.statusCode === 404) {
                    callback(new Error("País no encontrado"));
                } else {
                    let country = JSON.parse(data)[0];
                    callback(undefined, country);
                }
            });

        })
        .on("error", (err) => {
            callback(err);
        });
}


function showErrorOrDensityAverage(err, countries, countryOrigin) {
    if (err) {
        return 0;
    } else {
        let average = 0;
        for (let country of countries) {
            average += getDensity(country);
        }
        average=average/countries.length;
        console.log(`The average of population of borders countries of ${countryOrigin.name.common} is ${average} (hab/Km2)`);
        return average;
    }
}

function getDensity(country) {
        const remainder = country.population %  country.area;
        const integer = country.population - remainder;
        const density = integer /  country.area;
        return  density;
}